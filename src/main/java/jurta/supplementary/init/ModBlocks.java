package jurta.supplementary.init;

import jurta.supplementary.block.CherryBushBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // Vegetation
    public static final RegistryObject<CherryBushBlock> CHERRY_BUSH = registerNoItem("cherry_bush", () ->
            new CherryBushBlock(AbstractBlock.Properties.of(Material.PLANT).noOcclusion().randomTicks().sound(SoundType.SWEET_BERRY_BUSH)));

    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ModTabs.SUPPLEMENTARY)));
        return ret;
    }
}
