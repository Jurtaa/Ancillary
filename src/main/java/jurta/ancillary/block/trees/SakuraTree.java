package jurta.ancillary.block.trees;

import jurta.ancillary.init.ModConfiguredFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class SakuraTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random random, boolean hasBees) {
        if (random.nextInt(10) == 0) {
            return hasBees ? ModConfiguredFeatures.FANCY_SAKURA_BEES_005 : ModConfiguredFeatures.FANCY_SAKURA;
        } else {
            return hasBees ? ModConfiguredFeatures.SAKURA_BEES_005 : ModConfiguredFeatures.SAKURA;
        }
    }
}