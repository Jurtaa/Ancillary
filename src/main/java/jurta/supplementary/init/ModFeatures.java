package jurta.supplementary.init;

import com.google.common.collect.ImmutableSet;
import jurta.supplementary.block.CherryBushBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;

public class ModFeatures {
    public static final ConfiguredFeature<?, ?> PATCH_CHERRY_BUSH = register("patch_cherry_bush", Feature.RANDOM_PATCH.configured(Configs.CHERRY_BUSH_CONFIG));
    public static final ConfiguredFeature<?, ?> PATCH_CHERRY_SPARSE = register("patch_cherry_sparse", PATCH_CHERRY_BUSH.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
    public static final ConfiguredFeature<?, ?> PATCH_CHERRY_DECORATED = register("patch_cherry_decorated", PATCH_CHERRY_BUSH.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).chance(12));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String string, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, string, configuredFeature);
    }

    public static final class Configs {
        public static final BlockClusterFeatureConfig CHERRY_BUSH_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModFeatures.States.CHERRY_BUSH), SimpleBlockPlacer.INSTANCE).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).noProjection().build();
    }

    public static final class Placements {}

    public static final class States {
        protected static final BlockState CHERRY_BUSH = ModBlocks.CHERRY_BUSH.get().defaultBlockState().setValue(CherryBushBlock.AGE, 3);
    }
}
