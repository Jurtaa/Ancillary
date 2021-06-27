package jurta.ancillary.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SphereReplaceConfig;

import java.util.Random;

public class StonePatchFeature extends Feature<SphereReplaceConfig> {
    public StonePatchFeature(Codec<SphereReplaceConfig> config) {
        super(config);
    }

    public boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, SphereReplaceConfig config) {
        int i = 0;
        int radius = rand.nextInt(config.radius.sample(rand));

        for (int x = pos.getX() - radius; x <= pos.getX() + radius; x++) {
            for (int z = pos.getZ() - radius; z <= pos.getZ() + radius; z++) {
                int radiusXDistance = x - pos.getX();
                int radiusZDistance = z - pos.getZ();
                int distance = radiusXDistance * radiusXDistance + radiusZDistance * radiusZDistance;
                if (distance <= radius * radius) {
                    for (int y = pos.getY() - config.halfHeight; y <= pos.getY() + config.halfHeight; y++) {
                        BlockPos blockpos = new BlockPos(x, y, z);
                        BlockState blockstate = world.getBlockState(blockpos);
                        BlockState blockstate1 = world.getBlockState(blockpos.above());

                        for (BlockState blockstate2 : config.targets) {
                            if (blockstate2.getBlock() == blockstate.getBlock() && (distance != radius * radius || rand.nextFloat() < 0.5F)) {
                                if (blockstate1.isAir(world, blockpos)) {
                                    world.setBlock(blockpos, config.state, 2);
                                }
                                i++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return i > 0;
    }
}
