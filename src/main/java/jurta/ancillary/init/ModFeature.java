package jurta.ancillary.init;

import jurta.ancillary.world.gen.feature.LushStonePatchFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraftforge.fml.RegistryObject;

public class ModFeature {
    public static final RegistryObject<Feature<SphereReplaceConfig>> LUSH_STONE_PATCH = Registration.FEATURES.register("lush_stone_patch", () ->
            new LushStonePatchFeature(SphereReplaceConfig.CODEC));

    static void register() {}
}
