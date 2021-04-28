package jurta.supplementary.init;

import cpw.mods.modlauncher.LaunchPluginHandler;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> CHERRIES = Registration.ITEMS.register("cherries", () ->
            new BlockNamedItem(ModBlocks.CHERRY_BUSH.get(), new Item.Properties().tab(ModTabs.SUPPLEMENTARY).food(ModFoods.CHERRIES)));

    static void register() {}
}
