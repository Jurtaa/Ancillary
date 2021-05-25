package jurta.supplementary.init;

import jurta.supplementary.item.ModSignItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    // Food
    public static final RegistryObject<Item> BROCCOLI = Registration.ITEMS.register("broccoli", () ->
            new Item(new Item.Properties().tab(ModTabs.SUPPLEMENTARY).food(ModFoods.BROCCOLI)));
    public static final RegistryObject<Item> BROCCOLI_SEEDS = Registration.ITEMS.register("broccoli_seeds", () ->
            new BlockNamedItem(ModBlocks.BROCCOLI.get(), new Item.Properties().tab(ModTabs.SUPPLEMENTARY)));
    public static final RegistryObject<Item> CHERRIES = Registration.ITEMS.register("cherries", () ->
            new BlockNamedItem(ModBlocks.CHERRY_BUSH.get(), new Item.Properties().tab(ModTabs.SUPPLEMENTARY).food(ModFoods.CHERRIES)));
    // Signs
    public static final RegistryObject<Item> SAKURA_SIGN = Registration.ITEMS.register("sakura_sign", () ->
            new ModSignItem(new Item.Properties().tab(ModTabs.SUPPLEMENTARY), ModBlocks.SAKURA_SIGN.get(), ModBlocks.SAKURA_WALL_SIGN.get()));
    // Boats
    // public static final RegistryObject<Item> SAKURA_BOAT = Registration.ITEMS.register("sakura_boat", () ->
    //         new BoatItem(BoatEntity.Type.OAK, new Item.Properties().tab(ModTabs.SUPPLEMENTARY)));

    static void register() {}
}
