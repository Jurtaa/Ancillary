package jurta.supplementary.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ModTags {
    public static class Blocks {
        public static final Tags.IOptionalNamedTag<Block> SAKURA_LOGS = modTag("sakura_logs");
        public static final Tags.IOptionalNamedTag<Block> STORAGE_BLOCKS_ROCK = tag("storage_blocks/rock");

        private static Tags.IOptionalNamedTag<Block> tag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }

        private static Tags.IOptionalNamedTag<Block> modTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("supplementary", name));
        }
    }

    public static class Items {
        public static final Tags.IOptionalNamedTag<Item> SAKURA_LOGS = modTag("sakura_logs");
        public static final Tags.IOptionalNamedTag<Item> CROPS_BROCCOLI = tag("crops/broccoli");
        public static final Tags.IOptionalNamedTag<Item> STORAGE_BLOCKS_ROCK = tag("storage_blocks/rock");

        private static Tags.IOptionalNamedTag<Item> tag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }

        private static Tags.IOptionalNamedTag<Item> modTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("supplementary", name));
        }
    }
}
