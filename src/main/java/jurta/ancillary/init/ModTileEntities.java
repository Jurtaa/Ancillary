package jurta.ancillary.init;

import jurta.ancillary.tileentity.LeatherBlockTileEntity;
import jurta.ancillary.tileentity.ModSignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModTileEntities {
    public static RegistryObject<TileEntityType<ModSignTileEntity>> SIGN_TILE_ENTITIES = register("sign", () ->
            TileEntityType.Builder
                    .of(ModSignTileEntity::new, ModBlocks.SAKURA_SIGN.get(), ModBlocks.SAKURA_WALL_SIGN.get())
                    .build(null));
    public static RegistryObject<TileEntityType<LeatherBlockTileEntity>> LEATHER_BLOCK = register("leather_block", () ->
            TileEntityType.Builder
                    .of(LeatherBlockTileEntity::new, ModBlocks.LEATHER_BLOCK.get())
                    .build(null));

    private static <F extends TileEntityType<?>> RegistryObject<F> register(String name, Supplier<F> feature) {
        return Registration.TILE_ENTITIES.register(name, feature);
    }

    static void register() {}
}
