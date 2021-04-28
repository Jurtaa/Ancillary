package jurta.supplementary.data.client;

import jurta.supplementary.Supplementary;
import jurta.supplementary.block.CherryBushBlock;
import jurta.supplementary.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Supplementary.MOD_ID, exFileHelper);
    }

    public ExistingFileHelper getExistingHelper() {
        return models().existingFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        getVariantBuilder(ModBlocks.CHERRY_BUSH.get())
                .partialState().with(CherryBushBlock.AGE, 0).addModels(new ConfiguredModel(models()
                        .withExistingParent("cherry_bush_stage0", modLoc("block/template_bush_sapling"))
                        .texture("plant", modLoc("block/cherry_plant"))
                        .texture("side", modLoc("block/cherry_bush_side_stage1"))
                        .texture("top", modLoc("block/cherry_bush_top_stage1"))))
                .partialState().with(CherryBushBlock.AGE, 1).addModels(new ConfiguredModel(models()
                        .withExistingParent("cherry_bush_stage1", modLoc("block/template_bush"))
                        .texture("plant", modLoc("block/cherry_plant"))
                        .texture("side", modLoc("block/cherry_bush_side_stage1"))
                        .texture("top", modLoc("block/cherry_bush_top_stage1"))))
                .partialState().with(CherryBushBlock.AGE, 2).addModels(new ConfiguredModel(models()
                        .withExistingParent("cherry_bush_stage2", modLoc("block/template_bush"))
                        .texture("plant", modLoc("block/cherry_plant"))
                        .texture("side", modLoc("block/cherry_bush_side_stage2"))
                        .texture("top", modLoc("block/cherry_bush_top_stage2"))))
                .partialState().with(CherryBushBlock.AGE, 3).addModels(new ConfiguredModel(models()
                        .withExistingParent("cherry_bush_stage3", modLoc("block/template_bush"))
                        .texture("plant", modLoc("block/cherry_plant"))
                        .texture("side", modLoc("block/cherry_bush_side_stage3"))
                        .texture("top", modLoc("block/cherry_bush_top_stage3"))));
    }
}
