package jurta.supplementary.data.server.tags;

import jurta.supplementary.Supplementary;
import jurta.supplementary.init.ModBlocks;
import jurta.supplementary.init.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, Supplementary.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Block Tags: " + modId;
    }

    @Override
    protected void addTags() {
        // Minecraft Tags
        tag(BlockTags.LEAVES).add(ModBlocks.SAKURA_LEAVES.get());
        tag(BlockTags.SAPLINGS).add(ModBlocks.SAKURA_SAPLING.get());
        tag(BlockTags.BASE_STONE_OVERWORLD).add(ModBlocks.LUSH_STONE.get());
        tag(BlockTags.CROPS).add(ModBlocks.BROCCOLI.get());
        // Forge Tags
        tag(Tags.Blocks.STONE).add(ModBlocks.LUSH_STONE.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_ROCK).add(ModBlocks.ROCK_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_ROCK);
    }
}
