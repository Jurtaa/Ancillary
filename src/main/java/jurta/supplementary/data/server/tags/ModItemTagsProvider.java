package jurta.supplementary.data.server.tags;

import jurta.supplementary.Supplementary;
import jurta.supplementary.init.ModBlocks;
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
        // Forge Tags
        tag(Tags.Items.STONE).add(ModBlocks.LUSH_STONE.get().asItem());
    }
}
