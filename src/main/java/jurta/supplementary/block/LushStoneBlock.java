package jurta.supplementary.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class LushStoneBlock extends Block {
    public LushStoneBlock(Properties properties) {
        super(properties);
    }

    private static boolean canBeLushStone(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = worldReader.getBlockState(blockpos);
        int i = LightEngine.getLightBlockInto(worldReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(worldReader, blockpos));
        return i < worldReader.getMaxLightLevel();
    }

    @Override
    public void randomTick(BlockState state, ServerWorld serverWorld, BlockPos pos, Random random) {
        if (!canBeLushStone(state, serverWorld, pos)) {
            serverWorld.setBlockAndUpdate(pos, Blocks.STONE.defaultBlockState());
        }
    }
}
