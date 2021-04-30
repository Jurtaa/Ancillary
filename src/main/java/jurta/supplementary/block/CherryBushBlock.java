package jurta.supplementary.block;

import jurta.supplementary.init.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;

public class CherryBushBlock extends BushBlock implements IGrowable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape SAPLING_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);

    public CherryBushBlock(AbstractBlock.Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    public ItemStack getCloneItemStack(IBlockReader iBlockReader, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(ModItems.CHERRIES.get());
    }

    public VoxelShape getShape(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos, ISelectionContext iSelectionContext) {
        if (blockState.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        }
        return super.getShape(blockState, iBlockReader, blockPos, iSelectionContext);
    }


    public boolean isRandomlyTicking(BlockState blockState) {
        return blockState.getValue(AGE) < 3;
    }

    public void randomTick(BlockState blockState, ServerWorld serverWorld, BlockPos blockPos, Random random) {
        int i = blockState.getValue(AGE);
        if (i < 3 && serverWorld.getRawBrightness(blockPos.above(), 0) >= 9 && ForgeHooks.onCropsGrowPre(serverWorld, blockPos, blockState, random.nextInt(5) == 0)) {
            serverWorld.setBlock(blockPos, blockState.setValue(AGE, i + 1), 2);
            ForgeHooks.onCropsGrowPost(serverWorld, blockPos, blockState);
        }
    }

    public ActionResultType use(BlockState blockState, World worldIn, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        int i = blockState.getValue(AGE);
        boolean flag = (i == 3);
        if (!flag && playerEntity.getItemInHand(hand).getItem() == Items.BONE_MEAL)
        return ActionResultType.PASS;
        if (i > 1) {
            int j = 1 + worldIn.random.nextInt(2);
            popResource(worldIn, blockPos, new ItemStack(ModItems.CHERRIES.get(), j + (flag ? 1 : 0)));
            worldIn.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
            worldIn.setBlock(blockPos, blockState.setValue(AGE, 1), 2);
            return ActionResultType.sidedSuccess(worldIn.isClientSide);
        }
        return super.use(blockState, worldIn, blockPos, playerEntity, hand, result);
    }


    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> block) {
        block.add(AGE);
    }


    public boolean isValidBonemealTarget(IBlockReader iBlockReader, BlockPos blockPos, BlockState blockState, boolean p_176473_4_) {
        return blockState.getValue(AGE) < 3;
    }


    public boolean isBonemealSuccess(World worldIn, Random random, BlockPos blockPos, BlockState blockState) {
        return true;
    }


    public void performBonemeal(ServerWorld serverWorld, Random random, BlockPos blockPos, BlockState blockState) {
        int i = Math.min(3, blockState.getValue(AGE) + 1);
        serverWorld.setBlock(blockPos, blockState.setValue(AGE, i), 2);
    }
}