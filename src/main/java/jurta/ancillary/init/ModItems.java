package jurta.ancillary.init;

import jurta.ancillary.entity.item.ModBoatEntity;
import jurta.ancillary.item.LeatherBlockItem;
import jurta.ancillary.item.ModBoatItem;
import jurta.ancillary.item.ModSignItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    // Block Items
    public static final RegistryObject<LeatherBlockItem> LEATHER_BLOCK = register("leather_block", () ->
            new LeatherBlockItem(ModBlocks.LEATHER_BLOCK.get(), new Item.Properties().tab(ModTabs.ANCILLARY)));
    // Food
    public static final RegistryObject<Item> BROCCOLI = register("broccoli", () ->
            new Item(new Item.Properties().tab(ModTabs.ANCILLARY).food(ModFoods.BROCCOLI)));
    public static final RegistryObject<Item> BROCCOLI_SEEDS = register("broccoli_seeds", () ->
            new BlockNamedItem(ModBlocks.BROCCOLI.get(), new Item.Properties().tab(ModTabs.ANCILLARY)));
    public static final RegistryObject<Item> CHERRIES = register("cherries", () ->
            new BlockNamedItem(ModBlocks.CHERRY_BUSH.get(), new Item.Properties().tab(ModTabs.ANCILLARY).food(ModFoods.CHERRIES)));
    // Signs
    public static final RegistryObject<Item> SAKURA_SIGN = register("sakura_sign", () ->
            new ModSignItem(new Item.Properties().tab(ModTabs.ANCILLARY), ModBlocks.SAKURA_SIGN.get(), ModBlocks.SAKURA_WALL_SIGN.get()));
    // Boats
    public static final RegistryObject<Item> SAKURA_BOAT = register("sakura_boat", () ->
            new ModBoatItem(ModBoatEntity.Type.SAKURA, new Item.Properties().tab(ModTabs.ANCILLARY).stacksTo(1)));

    private static <F extends Item> RegistryObject<F> register(String name, Supplier<F> feature) {
        return Registration.ITEMS.register(name, feature);
    }

    static void register() {}
}
