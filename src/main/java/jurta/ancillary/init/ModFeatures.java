package jurta.ancillary.init;

import jurta.ancillary.world.gen.feature.StonePatchFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModFeatures {
    public static final RegistryObject<Feature<SphereReplaceConfig>> LUSH_STONE_PATCH = register("lush_stone_patch", () ->
            new StonePatchFeature(SphereReplaceConfig.CODEC));

    private static <F extends Feature<?>> RegistryObject<F> register(String name, Supplier<F> feature) {
        return Registration.FEATURES.register(name, feature);
    }

    static void register() {}
}
