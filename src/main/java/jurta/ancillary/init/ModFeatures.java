package jurta.ancillary.init;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import jurta.ancillary.block.CherryBushBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

public class ModFeatures {
    public static final ConfiguredFeature<?, ?> PATCH_CHERRY_BUSH = register("patch_cherry_bush", Feature.RANDOM_PATCH.configured(Configs.CHERRY_BUSH_CONFIG));
    public static final ConfiguredFeature<?, ?> PATCH_CHERRY_SPARSE = register("patch_cherry_sparse", PATCH_CHERRY_BUSH.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE));
    public static final ConfiguredFeature<?, ?> PATCH_CHERRY_DECORATED = register("patch_cherry_decorated", PATCH_CHERRY_BUSH.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).chance(12));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SAKURA = register("sakura", Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SAKURA_LOG), new SimpleBlockStateProvider(States.SAKURA_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_SAKURA = register("fancy_sakura", Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.SAKURA_LOG), new SimpleBlockStateProvider(States.SAKURA_LEAVES), new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SAKURA_BEES_0002 = register("sakura_bees_0002", Feature.TREE.configured(SAKURA.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SAKURA_BEES_002 = register("sakura_bees_002", Feature.TREE.configured(SAKURA.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SAKURA_BEES_005 = register("sakura_bees_005", Feature.TREE.configured(SAKURA.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_SAKURA_BEES_0002 = register("fancy_sakura_bees_0002", Feature.TREE.configured(FANCY_SAKURA.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_SAKURA_BEES_002 = register("fancy_sakura_bees_002", Feature.TREE.configured(FANCY_SAKURA.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_SAKURA_BEES_005 = register("fancy_sakura_bees_005", Feature.TREE.configured(FANCY_SAKURA.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));
    public static final ConfiguredFeature<?, ?> SAKURA_PLAIN_VEGETATION = register("sakura_plain_vegetation", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(FANCY_SAKURA_BEES_005.weighted(0.33333334F)), SAKURA_BEES_005)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));
    public static final ConfiguredFeature<?, ?> DISK_LUSH_STONE = register("disk_lush_stone", ModFeature.LUSH_STONE_PATCH.get().configured(new SphereReplaceConfig(States.LUSH_STONE, FeatureSpread.of(3, 1), 1, ImmutableList.of(States.STONE))).decorated(Features.Placements.TOP_SOLID_HEIGHTMAP_SQUARE));
    public static final ConfiguredFeature<?, ?> PATCH_ROCK = register("rock", Feature.RANDOM_PATCH.configured(Configs.ROCK_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(8));
    public static final ConfiguredFeature<?, ?> PATCH_PEBBLES = register("pebbles", Feature.RANDOM_PATCH.configured(Configs.PEBBLES_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(14));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, configuredFeature);
    }

    public static final class Configs {
        public static final BlockClusterFeatureConfig CHERRY_BUSH_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.CHERRY_BUSH), SimpleBlockPlacer.INSTANCE).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).noProjection().build();
        public static final BlockClusterFeatureConfig ROCK_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.ROCK), SimpleBlockPlacer.INSTANCE).tries(32).whitelist(ImmutableSet.of(Blocks.STONE.getBlock(), Blocks.ANDESITE.getBlock(), Blocks.DIORITE.getBlock(), Blocks.GRANITE.getBlock())).noProjection().build();
        public static final BlockClusterFeatureConfig PEBBLES_CONFIG = new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.PEBBLES), SimpleBlockPlacer.INSTANCE).tries(64).whitelist(ImmutableSet.of(Blocks.STONE.getBlock(), Blocks.ANDESITE.getBlock(), Blocks.DIORITE.getBlock(), Blocks.GRANITE.getBlock())).noProjection().build();
    }

    public static final class Placements {}

    public static final class States {
        protected static final BlockState CHERRY_BUSH = ModBlocks.CHERRY_BUSH.get().defaultBlockState().setValue(CherryBushBlock.AGE, 3);
        protected static final BlockState SAKURA_LOG = ModBlocks.SAKURA_LOG.get().defaultBlockState();
        protected static final BlockState SAKURA_LEAVES = ModBlocks.SAKURA_LEAVES.get().defaultBlockState();
        protected static final BlockState LUSH_STONE = ModBlocks.LUSH_STONE.get().defaultBlockState();
        protected static final BlockState STONE = Blocks.STONE.defaultBlockState();
        protected static final BlockState ROCK = ModBlocks.ROCK.get().defaultBlockState();
        protected static final BlockState PEBBLES = ModBlocks.PEBBLES.get().defaultBlockState();
    }
}
