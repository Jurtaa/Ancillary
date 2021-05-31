package jurta.supplementary.item;

import jurta.supplementary.tileentity.LeatherBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;

public class LeatherBlockItem extends BlockItem implements IDyeableArmorItem {
    public LeatherBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public ActionResultType place(BlockItemUseContext context) {
        ActionResultType result = super.place(context);
        TileEntity tileEntity = context.getLevel().getBlockEntity(context.getClickedPos());
        if (tileEntity instanceof LeatherBlockTileEntity) {
            LeatherBlockTileEntity leatherBlockTileEntity = (LeatherBlockTileEntity)tileEntity;
            leatherBlockTileEntity.color = getColor(context.getItemInHand());
            leatherBlockTileEntity.setChanged();
        }
        return result;
    }
}
