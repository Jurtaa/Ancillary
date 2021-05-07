package jurta.supplementary.data.server.tags;

import jurta.supplementary.Supplementary;
import jurta.supplementary.init.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, Supplementary.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.LEAVES).add(ModBlocks.SAKURA_LEAVES.get());
        tag(BlockTags.SAPLINGS).add(ModBlocks.SAKURA_SAPLING.get());
    }
}
