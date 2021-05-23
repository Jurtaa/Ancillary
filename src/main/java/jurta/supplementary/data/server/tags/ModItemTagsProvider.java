package jurta.supplementary.data.server.tags;

import jurta.supplementary.Supplementary;
import jurta.supplementary.init.ModBlocks;
import jurta.supplementary.init.ModItems;
import jurta.supplementary.init.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator gen, BlockTagsProvider blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, blockTags, Supplementary.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Item Tags: " + modId;
    }

    @Override
    protected void addTags() {
        // Minecraft Tags
        tag(ItemTags.LEAVES).add(ModBlocks.SAKURA_LEAVES.get().asItem());
        tag(ItemTags.SAPLINGS).add(ModBlocks.SAKURA_SAPLING.get().asItem());
        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(ModBlocks.ROCK_BLOCK.get().asItem());
        tag(ItemTags.STONE_TOOL_MATERIALS).add(ModBlocks.ROCK_BLOCK.get().asItem());
        tag(ItemTags.LOGS_THAT_BURN).addTag(ModTags.Items.SAKURA_LOGS);
        tag(ItemTags.SIGNS).add(ModItems.SAKURA_SIGN.get());
        // Forge Tags
        tag(Tags.Items.STONE).add(ModBlocks.LUSH_STONE.get().asItem());
        tag(ModTags.Items.CROPS_BROCCOLI).add(ModItems.BROCCOLI.get().asItem());
        tag(Tags.Items.CROPS).addTag(ModTags.Items.CROPS_BROCCOLI);
        tag(ModTags.Items.STORAGE_BLOCKS_ROCK).add(ModBlocks.ROCK_BLOCK.get().asItem());
        tag(Tags.Items.STORAGE_BLOCKS).addTag(ModTags.Items.STORAGE_BLOCKS_ROCK);
        // Supplementary Tags
        tag(ModTags.Items.SAKURA_LOGS).add(ModBlocks.SAKURA_LOG.get().asItem(), ModBlocks.SAKURA_WOOD.get().asItem(), ModBlocks.STRIPPED_SAKURA_LOG.get().asItem(), ModBlocks.STRIPPED_SAKURA_WOOD.get().asItem());
    }
}
