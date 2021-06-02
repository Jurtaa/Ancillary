package jurta.ancillary.data.server.tags;

import jurta.ancillary.Ancillary;
import jurta.ancillary.init.ModBlocks;
import jurta.ancillary.init.ModItems;
import jurta.ancillary.init.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator gen, BlockTagsProvider blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, blockTags, Ancillary.MOD_ID, existingFileHelper);
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
        tag(ItemTags.WOODEN_DOORS).add(ModBlocks.SAKURA_DOOR.get().asItem());
        tag(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.SAKURA_TRAPDOOR.get().asItem());
        tag(ItemTags.PLANKS).add(ModBlocks.SAKURA_PLANKS.get().asItem());
        tag(ItemTags.WOODEN_STAIRS).add(ModBlocks.SAKURA_STAIRS.get().asItem());
        tag(ItemTags.STAIRS).add(ModBlocks.ROCK_STAIRS.get().asItem(),
                ModBlocks.POLISHED_ROCK_STAIRS.get().asItem(),
                ModBlocks.ROCK_BRICK_STAIRS.get().asItem());
        tag(ItemTags.WOODEN_SLABS).add(ModBlocks.SAKURA_SLAB.get().asItem());
        tag(ItemTags.SLABS).add(ModBlocks.ROCK_SLAB.get().asItem(),
                ModBlocks.POLISHED_ROCK_SLAB.get().asItem(),
                ModBlocks.ROCK_BRICK_SLAB.get().asItem());
        tag(ItemTags.WOODEN_BUTTONS).add(ModBlocks.SAKURA_BUTTON.get().asItem());
        tag(ItemTags.BUTTONS).add(ModBlocks.POLISHED_ROCK_BUTTON.get().asItem());
        tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.SAKURA_PRESSURE_PLATE.get().asItem());
        tag(ItemTags.WOODEN_FENCES).add(ModBlocks.SAKURA_FENCE.get().asItem(),
                ModBlocks.SAKURA_FENCE_GATE.get().asItem());
        tag(ItemTags.WALLS).add(ModBlocks.ROCK_WALL.get().asItem(),
                ModBlocks.POLISHED_ROCK_WALL.get().asItem(),
                ModBlocks.ROCK_BRICK_WALL.get().asItem());
        tag(ItemTags.BOATS).add(ModItems.SAKURA_BOAT.get());
        // Forge Tags
        tag(Tags.Items.STONE).add(ModBlocks.LUSH_STONE.get().asItem());
        tag(ModTags.Items.CROPS_BROCCOLI).add(ModItems.BROCCOLI.get().asItem());
        tag(Tags.Items.CROPS).addTag(ModTags.Items.CROPS_BROCCOLI);
        tag(ModTags.Items.STORAGE_BLOCKS_ROCK).add(ModBlocks.ROCK_BLOCK.get().asItem());
        tag(Tags.Items.STORAGE_BLOCKS).addTag(ModTags.Items.STORAGE_BLOCKS_ROCK);
        // Ancillary Tags
        tag(ModTags.Items.SAKURA_LOGS).add(ModBlocks.SAKURA_LOG.get().asItem(),
                ModBlocks.SAKURA_WOOD.get().asItem(),
                ModBlocks.STRIPPED_SAKURA_LOG.get().asItem(),
                ModBlocks.STRIPPED_SAKURA_WOOD.get().asItem());
    }
}
