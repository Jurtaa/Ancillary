package jurta.supplementary.init;

import jurta.supplementary.tileentity.ModSignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntities {
    public static RegistryObject<TileEntityType<ModSignTileEntity>> SIGN_TILE_ENTITIES = Registration.TILE_ENTITIES.register("sakura_sign", () ->
            TileEntityType.Builder
                    .of(ModSignTileEntity::new, ModBlocks.SAKURA_SIGN.get(), ModBlocks.SAKURA_WALL_SIGN.get())
                    .build(null));

    static void register() {}
}
