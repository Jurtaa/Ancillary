package jurta.ancillary.init;

import jurta.ancillary.biome.ModBiomeMaker;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Supplier;

public class ModBiomes {
    public static final RegistryObject<Biome> SAKURA_VALLEY = register("sakura_valley", ModBiomeMaker::sakuraValleyBiome);

    private static <F extends Biome> RegistryObject<F> register(String name, Supplier<F> feature) {
        return Registration.BIOMES.register(name, feature);
    }

    static void register() {}

    private static <T extends IForgeRegistryEntry<? super T>> RegistryKey<Biome> createKey(RegistryObject<T> key) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, key.get().getRegistryName());
    }

    public static void setupBiomeInfo() {
        BiomeDictionary.addTypes(createKey(SAKURA_VALLEY), BiomeDictionary.Type.FOREST);
    }
}
