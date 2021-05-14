package jurta.supplementary;

import jurta.supplementary.client.ClientSetup;
import jurta.supplementary.config.ConfigManager;
import jurta.supplementary.config.ConfigScreen;
import jurta.supplementary.data.client.ModBlockStateProvider;
import jurta.supplementary.data.client.ModItemModelProvider;
import jurta.supplementary.data.client.ModLanguageProvider;
import jurta.supplementary.data.server.ModRecipeProvider;
import jurta.supplementary.data.server.loot.ModLootTableProvider;
import jurta.supplementary.data.server.tags.ModBlockTagsProvider;
import jurta.supplementary.data.server.tags.ModItemTagsProvider;
import jurta.supplementary.init.ModFeatures;
import jurta.supplementary.init.Registration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Supplementary.MOD_ID)
public class Supplementary {
    public static final String MOD_ID = "supplementary";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Supplementary() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventBus = MinecraftForge.EVENT_BUS;

        // Register the setup method for modloading
        modBus.addListener(this::setup);
        modBus.addListener(this::gatherData);
        // Register the enqueueIMC method for modloading
        modBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        modBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        modBus.addListener(this::doClientStuff);

        // Register the configuration GUI factory
        ModLoadingContext.get().registerExtensionPoint(
                ExtensionPoint.CONFIGGUIFACTORY,
                () -> (mc, screen) -> new ConfigScreen(screen)
        );

        // Register ourselves for server and other game events we are interested in
        eventBus.register(this);
        eventBus.addListener(this::biomeLoading);

        Registration.init();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ClientSetup.setupBlockRenderLayers();
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }

    private void biomeLoading(BiomeLoadingEvent event) {
        RegistryKey<Biome> biome = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
        ConfigManager config = ConfigManager.getInstance();
        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)) {
            if (config.allowVegetalGeneration()) {
                event.getGeneration().addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.PATCH_CHERRY_SPARSE);
                event.getGeneration().addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.PATCH_CHERRY_DECORATED);
            } if (config.allowTreeGeneration()) {
                event.getGeneration().addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.SAKURA_PLAIN_VEGETATION);
            }
        } if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD)) {
            //event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ModFeatures.DISK_LUSH_STONE);
        }
    }

    /* Registers the locales for the language provider */
    private static final String[] LOCALE_CODES = new String[] {
            "en_au",
            "en_ca",
            "en_gb",
            "en_nz",
            "en_us"
    };

    private void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper efh = event.getExistingFileHelper();
        ModBlockStateProvider blockstates = new ModBlockStateProvider(gen, efh);
        ModBlockTagsProvider blocktags = new ModBlockTagsProvider(gen, efh);

        if (event.includeClient()) {
            gen.addProvider(blockstates);
            gen.addProvider(new ModItemModelProvider(gen, blockstates.getExistingHelper()));
            for(String locale : LOCALE_CODES) {
                gen.addProvider(new ModLanguageProvider(gen, locale));
            }
        } if (event.includeServer()) {
            gen.addProvider(new ModLootTableProvider(gen));
            gen.addProvider(new ModRecipeProvider(gen));
            gen.addProvider(blocktags);
            gen.addProvider(new ModItemTagsProvider(gen, blocktags, efh));
        }
    }
}
