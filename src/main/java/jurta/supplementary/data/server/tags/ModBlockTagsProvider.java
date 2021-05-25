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
        tag(BlockTags.LOGS_THAT_BURN).addTag(ModTags.Blocks.SAKURA_LOGS);
        tag(BlockTags.STANDING_SIGNS).add(ModBlocks.SAKURA_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(ModBlocks.SAKURA_WALL_SIGN.get());
        tag(BlockTags.WOODEN_DOORS).add(ModBlocks.SAKURA_DOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.SAKURA_TRAPDOOR.get());
        tag(BlockTags.PLANKS).add(ModBlocks.SAKURA_PLANKS.get());
        tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.SAKURA_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS).add(ModBlocks.SAKURA_SLAB.get());
        tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.SAKURA_BUTTON.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.SAKURA_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_FENCES).add(ModBlocks.SAKURA_FENCE.get(), ModBlocks.SAKURA_FENCE_GATE.get());
        // Forge Tags
        tag(Tags.Blocks.STONE).add(ModBlocks.LUSH_STONE.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_ROCK).add(ModBlocks.ROCK_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_ROCK);
        // Supplementary Tags
        tag(ModTags.Blocks.SAKURA_LOGS).add(ModBlocks.SAKURA_LOG.get(), ModBlocks.SAKURA_WOOD.get(), ModBlocks.STRIPPED_SAKURA_LOG.get(), ModBlocks.STRIPPED_SAKURA_WOOD.get());
    }
}
