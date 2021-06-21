package jurta.ancillary.init;

import jurta.ancillary.biome.ModBiomeMaker;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;

public class ModBiomes {
    public static final RegistryObject<Biome> SAKURA_VALLEY = Registration.BIOMES.register("sakura_valley", ModBiomeMaker::sakuraValleyBiome);

    static void register() {}
}
