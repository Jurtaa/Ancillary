package jurta.ancillary.block.trees;

import jurta.ancillary.init.ModFeatures;
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
            return hasBees ? ModFeatures.FANCY_SAKURA_BEES_005 : ModFeatures.FANCY_SAKURA;
        } else {
            return hasBees ? ModFeatures.SAKURA_BEES_005 : ModFeatures.SAKURA;
        }
    }
}