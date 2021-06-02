package jurta.ancillary.init;

import jurta.ancillary.entity.item.ModBoatEntity;
import jurta.ancillary.item.LeatherBlockItem;
import jurta.ancillary.item.ModBoatItem;
import jurta.ancillary.item.ModSignItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    // Block Items
    public static final RegistryObject<LeatherBlockItem> LEATHER_BLOCK = Registration.ITEMS.register("leather_block", () ->
            new LeatherBlockItem(ModBlocks.LEATHER_BLOCK.get(), new Item.Properties().tab(ModTabs.ANCILLARY)));
    // Food
    public static final RegistryObject<Item> BROCCOLI = Registration.ITEMS.register("broccoli", () ->
            new Item(new Item.Properties().tab(ModTabs.ANCILLARY).food(ModFoods.BROCCOLI)));
    public static final RegistryObject<Item> BROCCOLI_SEEDS = Registration.ITEMS.register("broccoli_seeds", () ->
            new BlockNamedItem(ModBlocks.BROCCOLI.get(), new Item.Properties().tab(ModTabs.ANCILLARY)));
    public static final RegistryObject<Item> CHERRIES = Registration.ITEMS.register("cherries", () ->
            new BlockNamedItem(ModBlocks.CHERRY_BUSH.get(), new Item.Properties().tab(ModTabs.ANCILLARY).food(ModFoods.CHERRIES)));
    // Signs
    public static final RegistryObject<Item> SAKURA_SIGN = Registration.ITEMS.register("sakura_sign", () ->
            new ModSignItem(new Item.Properties().tab(ModTabs.ANCILLARY), ModBlocks.SAKURA_SIGN.get(), ModBlocks.SAKURA_WALL_SIGN.get()));
    // Boats
    public static final RegistryObject<Item> SAKURA_BOAT = Registration.ITEMS.register("sakura_boat", () ->
            new ModBoatItem(ModBoatEntity.Type.SAKURA, new Item.Properties().tab(ModTabs.ANCILLARY).stacksTo(1)));

    static void register() {}
}
