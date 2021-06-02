package jurta.ancillary.init;

import jurta.ancillary.tileentity.LeatherBlockTileEntity;
import jurta.ancillary.tileentity.ModSignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntities {
    public static RegistryObject<TileEntityType<ModSignTileEntity>> SIGN_TILE_ENTITIES = Registration.TILE_ENTITIES.register("sign", () ->
            TileEntityType.Builder
                    .of(ModSignTileEntity::new, ModBlocks.SAKURA_SIGN.get(), ModBlocks.SAKURA_WALL_SIGN.get())
                    .build(null));
    public static RegistryObject<TileEntityType<LeatherBlockTileEntity>> LEATHER_BLOCK = Registration.TILE_ENTITIES.register("leather_block", () ->
            TileEntityType.Builder
                    .of(LeatherBlockTileEntity::new, ModBlocks.LEATHER_BLOCK.get())
                    .build(null));

    static void register() {}
}
