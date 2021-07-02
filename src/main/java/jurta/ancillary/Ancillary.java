package jurta.ancillary;

import com.google.common.collect.ImmutableList;
import jurta.ancillary.client.ClientSetup;
import jurta.ancillary.client.particle.CherryBlossomParticle;
import jurta.ancillary.config.ConfigManager;
import jurta.ancillary.config.ConfigScreen;
import jurta.ancillary.data.client.ModBlockStateProvider;
import jurta.ancillary.data.client.ModItemModelProvider;
import jurta.ancillary.data.client.ModLanguageProvider;
import jurta.ancillary.data.server.ModRecipeProvider;
import jurta.ancillary.data.server.loot.ModLootTableProvider;
import jurta.ancillary.data.server.tags.ModBlockTagsProvider;
import jurta.ancillary.data.server.tags.ModItemTagsProvider;
import jurta.ancillary.init.*;
import jurta.ancillary.tileentity.LeatherBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.StructureProcessorList;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Ancillary.MOD_ID)
public class Ancillary {
    public static final String MOD_ID = "ancillary";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Ancillary() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventBus = MinecraftForge.EVENT_BUS;

        modBus.addListener(this::commonSetup);
        modBus.addListener(this::gatherData);
        modBus.addListener(this::enqueueIMC);
        modBus.addListener(this::processIMC);
        modBus.addListener(this::clientSetup);

        // Register the configuration GUI factory
        ModLoadingContext.get().registerExtensionPoint(
                ExtensionPoint.CONFIGGUIFACTORY,
                () -> (mc, screen) -> new ConfigScreen(screen)
        );

        // Register ourselves for server and other game events we are interested in
        eventBus.register(this);
        eventBus.addListener(this::onBiomeLoad);
        eventBus.addListener(this::stripBlock);
        eventBus.addListener(this::addNewVillageCrop);
        modBus.addListener(this::registerParticles);
        modBus.addListener(this::setupBlockColors);
        modBus.addListener(this::setupItemColors);

        Registration.init(modBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        FlowerPotBlock pot = (FlowerPotBlock)Blocks.FLOWER_POT;
        ConfigManager config = ConfigManager.getInstance();
        event.enqueueWork(() -> {
            ModConfiguredFeatures.registerConfiguredFeatures();
            ModBiomes.setupBiomeInfo();
            pot.addPlant(new ResourceLocation(MOD_ID, "sakura_sapling"), ModBlocks.POTTED_SAKURA_SAPLING);
            if (config.allowBiomeGeneration()) {
                BiomeManager.addAdditionalOverworldBiomes(RegistryKey.create(Registry.BIOME_REGISTRY, ModBiomes.SAKURA_VALLEY.get().getRegistryName()));
            }
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ClientSetup.setupBlockRenderLayers();
        ClientSetup.setupAtlases();
        ClientSetup.setupTileEntityRenderers();
        ClientSetup.setupEntityRenderers();
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

    private void onBiomeLoad(BiomeLoadingEvent event) {
        RegistryKey<Biome> biome = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
        ConfigManager config = ConfigManager.getInstance();
        BiomeGenerationSettingsBuilder gen = event.getGeneration();
        if (event.getName().equals(new ResourceLocation("minecraft", "plains"))) {
            if (config.allowVegetalGeneration()) {
                gen.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.PATCH_CHERRY_SPARSE);
                gen.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.PATCH_CHERRY_DECORATED);
            } if (config.allowTreeGeneration()) {
                gen.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.SAKURA_PLAIN_VEGETATION);
            }
        } if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD)) {
            if (config.allowLushStoneGeneration()) {
                gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.DISK_LUSH_STONE);
            } if (config.allowRockGeneration()) {
                gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.PATCH_ROCK);
                gen.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.PATCH_PEBBLES);
            }
        }
        // Modded Biome Features
        if (event.getName().equals(new ResourceLocation(Ancillary.MOD_ID, "sakura_valley"))) {
            gen.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.SAKURA_VALLEY_VEGETATION);
        }
    }

    // Registers the locales for the language provider
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

    private void stripBlock(BlockEvent.BlockToolInteractEvent event){
        if (event.getToolType() == ToolType.AXE) {
            if (event.getState().is(ModBlocks.SAKURA_LOG.get())) {
                event.setFinalState(ModBlocks.STRIPPED_SAKURA_LOG.get().defaultBlockState()
                        .setValue(BlockStateProperties.AXIS, event.getState().getValue(BlockStateProperties.AXIS)));
            } if (event.getState().is(ModBlocks.SAKURA_WOOD.get())) {
                event.setFinalState(ModBlocks.STRIPPED_SAKURA_WOOD.get().defaultBlockState()
                        .setValue(BlockStateProperties.AXIS, event.getState().getValue(BlockStateProperties.AXIS)));
            }
        }
    }

    /**
     * Appends the given processor to the end of the targeted pieces in the targeted pools.
     * We will call this in addNewVillageCrop method further down to add to every village farm pool entry.
     * Note: This is an additive operation which means multiple mods can do this and they stack with each other safely.
     */
    private static void addCropToPoolElement(MutableRegistry<JigsawPattern> templatePoolRegistry, ResourceLocation poolRL, List<ResourceLocation> nbtPieceRLList) {
        JigsawPattern pool = templatePoolRegistry.get(poolRL);
        ConfigManager config = ConfigManager.getInstance();
        if (pool == null) return;

        // AccessTransformer to make JigsawPattern's templates field public for us to see.
        // public net.minecraft.world.gen.feature.jigsaw.JigsawPattern field_214953_e #templates
        pool.templates.forEach(entry -> {
            if (entry instanceof SingleJigsawPiece) {
                SingleJigsawPiece jigsawPiece = (SingleJigsawPiece) entry;

                // AccessTransformer to make SingleJigsawPiece's template field public for us to see.
                // public net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece field_236839_c_ #template
                if (jigsawPiece.template.left().isPresent()) {

                    // Found the piece entry we want to modify.
                    ResourceLocation currentNBTPiece = jigsawPiece.template.left().get();
                    if (nbtPieceRLList.stream().anyMatch(currentNBTPiece::equals)) {

                        // AccessTransformer to make SingleJigsawPiece's processors field public and non-final for us to see and swap out.
                        // public-f net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece field_214862_b #processors
                        StructureProcessorList originalStructureProcessorList = jigsawPiece.processors.get();

                        // Make a mutable list as this is an immutable list originally
                        List<StructureProcessor> mutableProcessorList = new ArrayList<>(originalStructureProcessorList.list());

                        // Add our processor to the end so it runs after everything else
                        if (config.allowCropGeneration()) {
                            mutableProcessorList.add(ModProcessors.MODDED_CROP_PROCESSOR);
                        }
                        StructureProcessorList newStructureProcessorList = new StructureProcessorList(mutableProcessorList);

                        // Override the original field with our new instance. This is an additive operation and safe to stack with other mods
                        jigsawPiece.processors = () -> newStructureProcessorList;
                    }
                }
            }
        });
    }

    /**
     * We use FMLServerAboutToStartEvent as the dynamic registry exists now and all JSON worldgen files were parsed.
     * Mod compat is best done here.
     */
    public void addNewVillageCrop(final FMLServerAboutToStartEvent event) {
        MutableRegistry<JigsawPattern> templatePoolRegistry = event.getServer().registryAccess().registry(Registry.TEMPLATE_POOL_REGISTRY).get();

        // Adds the crop processor to all vanilla farm village pieces
        addCropToPoolElement(templatePoolRegistry, new ResourceLocation("minecraft:village/plains/houses"), ImmutableList.of(
                new ResourceLocation("minecraft:village/plains/houses/plains_large_farm_1"),
                new ResourceLocation("minecraft:village/plains/houses/plains_small_farm_1")
        ));
        addCropToPoolElement(templatePoolRegistry, new ResourceLocation("minecraft:village/plains/zombie/houses"), ImmutableList.of(
                new ResourceLocation("minecraft:village/plains/houses/plains_large_farm_1"),
                new ResourceLocation("minecraft:village/plains/houses/plains_small_farm_1")
        ));

        addCropToPoolElement(templatePoolRegistry, new ResourceLocation("minecraft:village/snowy/houses"), ImmutableList.of(
                new ResourceLocation("minecraft:village/snowy/houses/snowy_farm_1"),
                new ResourceLocation("minecraft:village/snowy/houses/snowy_farm_2")
        ));
        addCropToPoolElement(templatePoolRegistry, new ResourceLocation("minecraft:village/snowy/zombie/houses"), ImmutableList.of(
                new ResourceLocation("minecraft:village/snowy/houses/snowy_farm_1"),
                new ResourceLocation("minecraft:village/snowy/houses/snowy_farm_2")
        ));
        addCropToPoolElement(templatePoolRegistry, new ResourceLocation("minecraft:village/savanna/houses"), ImmutableList.of(
                new ResourceLocation("minecraft:village/savanna/houses/savanna_large_farm_1"),
                new ResourceLocation("minecraft:village/savanna/houses/savanna_large_farm_2"),
                new ResourceLocation("minecraft:village/savanna/houses/savanna_small_farm")
        ));
        addCropToPoolElement(templatePoolRegistry, new ResourceLocation("minecraft:village/savanna/zombie/houses"), ImmutableList.of(
                new ResourceLocation("minecraft:village/savanna/houses/savanna_large_farm_1"),
                new ResourceLocation("minecraft:village/savanna/zombie/houses/savanna_large_farm_2"),
                new ResourceLocation("minecraft:village/savanna/houses/savanna_small_farm")
        ));
        addCropToPoolElement(templatePoolRegistry, new ResourceLocation("minecraft:village/taiga/houses"), ImmutableList.of(
                new ResourceLocation("minecraft:village/taiga/houses/taiga_large_farm_1"),
                new ResourceLocation("minecraft:village/taiga/houses/taiga_large_farm_2"),
                new ResourceLocation("minecraft:village/taiga/houses/taiga_small_farm_1")
        ));
        addCropToPoolElement(templatePoolRegistry, new ResourceLocation("minecraft:village/taiga/zombie/houses"), ImmutableList.of(
                new ResourceLocation("minecraft:village/taiga/houses/taiga_large_farm_1"),
                new ResourceLocation("minecraft:village/taiga/zombie/houses/taiga_large_farm_2"),
                new ResourceLocation("minecraft:village/taiga/houses/taiga_small_farm_1")
        ));
        addCropToPoolElement(templatePoolRegistry, new ResourceLocation("minecraft:village/desert/houses"), ImmutableList.of(
                new ResourceLocation("minecraft:village/desert/houses/desert_large_farm_1"),
                new ResourceLocation("minecraft:village/desert/houses/desert_farm_1"),
                new ResourceLocation("minecraft:village/desert/houses/desert_farm_2")
        ));
        addCropToPoolElement(templatePoolRegistry, new ResourceLocation("minecraft:village/desert/zombie/houses"), ImmutableList.of(
                new ResourceLocation("minecraft:village/desert/houses/desert_large_farm_1"),
                new ResourceLocation("minecraft:village/desert/houses/desert_farm_1"),
                new ResourceLocation("minecraft:village/desert/houses/desert_farm_2")
        ));
    }

    private void registerParticles(ParticleFactoryRegisterEvent event) {
        ParticleManager engine = Minecraft.getInstance().particleEngine;
        engine.register(ModParticleTypes.CHERRY_BLOSSOM.get(), CherryBlossomParticle.Factory::new);
    }

    private void setupBlockColors(ColorHandlerEvent.Block event) {
        BlockColors blockcolors = event.getBlockColors();
        blockcolors.register((state, world, pos, tintindex) ->
                        world != null && pos != null && tintindex > 0 ? -1 : LeatherBlockTileEntity.getColor(world, pos),
                ModBlocks.LEATHER_BLOCK.get());
    }

    private void setupItemColors(ColorHandlerEvent.Item event) {
        ItemColors itemcolors = event.getItemColors();
        itemcolors.register((stack, tintindex) ->
                        tintindex > 0 ? -1 : ((IDyeableArmorItem)stack.getItem()).getColor(stack),
                ModItems.LEATHER_BLOCK.get());
    }
}
