package jurta.supplementary.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.AbstractSphereReplaceConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;

import java.util.Random;

public class LushStonePatchFeature extends AbstractSphereReplaceConfig {
    public LushStonePatchFeature(Codec<SphereReplaceConfig> codec) {
        super(codec);
    }

    public boolean place(ISeedReader reader, ChunkGenerator generator, Random random, BlockPos pos, SphereReplaceConfig config) {
        for(BlockState blockstate : config.targets) {
            if (!reader.getBlockState(pos.above(1)).isAir()) {
                reader.setBlock(pos, Blocks.STONE.defaultBlockState(), 2);
                break;
            }
        }
        return !reader.getBlockState(pos).isAir() ? false : super.place(reader, generator, random, pos, config);
    }
}
