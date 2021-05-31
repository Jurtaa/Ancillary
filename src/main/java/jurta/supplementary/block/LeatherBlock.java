package jurta.supplementary.block;

import jurta.supplementary.init.ModItems;
import jurta.supplementary.tileentity.LeatherBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class LeatherBlock extends Block {
    public LeatherBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new LeatherBlockTileEntity();
    }

    @Override
    public ItemStack getCloneItemStack(IBlockReader world, BlockPos pos, BlockState state) {
        ItemStack stack = super.getCloneItemStack(world, pos, state);
        int color = LeatherBlockTileEntity.getColor(world, pos);
        if (color != LeatherBlockTileEntity.DEFAULT_COLOR) {
            ModItems.LEATHER_BLOCK.get().setColor(stack, color);
        }
        return stack;
    }
}
