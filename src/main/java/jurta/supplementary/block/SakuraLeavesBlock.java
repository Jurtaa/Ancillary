package jurta.supplementary.block;

import jurta.supplementary.init.ModParticleTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class SakuraLeavesBlock extends LeavesBlock {
    public SakuraLeavesBlock(Properties properties) {
        super(properties);
    }

    public static boolean isFree(BlockState state) {
        Material material = state.getMaterial();
        return state.isAir() || state.is(BlockTags.FIRE) || material.isLiquid() || material.isReplaceable();
    }

    public void animateTick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if (random.nextInt(16) == 0) {
            BlockPos blockpos = pos.below();
            if (worldIn.isEmptyBlock(blockpos) || isFree(worldIn.getBlockState(blockpos))) {
                double d0 = (double)pos.getX() + random.nextDouble();
                double d1 = (double)pos.getY() - 0.05D;
                double d2 = (double)pos.getZ() + random.nextDouble();
                worldIn.addParticle(ModParticleTypes.CHERRY_BLOSSOM.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
