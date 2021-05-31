package jurta.supplementary.tileentity;

import jurta.supplementary.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class LeatherBlockTileEntity extends TileEntity {
    public static final int DEFAULT_COLOR = 0xA06540;
    public int color = DEFAULT_COLOR;

    public LeatherBlockTileEntity() {
        super(ModTileEntities.LEATHER_BLOCK.get());
    }

    @Override
    public void load(BlockState state, CompoundNBT tag) {
        color = tag.getInt("Color");
        super.load(state, tag);
    }

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        tag.putInt("Color", color);
        return super.save(tag);
    }

    public static int getColor(IBlockReader world, BlockPos pos) {
        if (world == null) {
            return DEFAULT_COLOR;
        }
        TileEntity tileEntity = world.getBlockEntity(pos);
        if (tileEntity instanceof LeatherBlockTileEntity) {
            LeatherBlockTileEntity leatherBlockTileEntity = (LeatherBlockTileEntity)tileEntity;
            return leatherBlockTileEntity.color;
        } else {
            return DEFAULT_COLOR;
        }
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(worldPosition, 0, getUpdateTag());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return save(new CompoundNBT());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        load(getBlockState(), packet.getTag());
    }
}
