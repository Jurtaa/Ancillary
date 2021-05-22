package jurta.supplementary.data.client;

import jurta.supplementary.Supplementary;
import jurta.supplementary.block.BroccoliBlock;
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
        // Rocks
        simpleBlock(ModBlocks.PEBBLES.get(), models().withExistingParent("pebbles", modLoc("block/template_pebbles"))
                .texture("pebbles", modLoc("block/rock_block")));
        simpleBlock(ModBlocks.ROCK.get(), models().withExistingParent("rock", modLoc("block/template_rock"))
                .texture("rock", modLoc("block/rock_block")));
        simpleBlock(ModBlocks.ROCK_BLOCK.get());
        simpleBlock(ModBlocks.LUSH_STONE.get(), models().cubeBottomTop("lush_stone", modLoc("block/lush_stone_side"), mcLoc("block/stone"), modLoc("block/lush_stone_top")));
        // Leaves
        simpleBlock(ModBlocks.SAKURA_LEAVES.get());
        // Sapling
        simpleBlock(ModBlocks.SAKURA_SAPLING.get(), models().cross("sakura_sapling", modLoc("block/sakura_sapling")));
        // Pillars
        axisBlock(ModBlocks.IRON_PILLAR.get());
        axisBlock(ModBlocks.GOLD_PILLAR.get());
        axisBlock(ModBlocks.DIAMOND_PILLAR.get());
        axisBlock(ModBlocks.EMERALD_PILLAR.get());
        axisBlock(ModBlocks.NETHERITE_PILLAR.get());
        // Vegetation
        getVariantBuilder(ModBlocks.CHERRY_BUSH.get())
                .partialState().with(CherryBushBlock.AGE, 0).addModels(new ConfiguredModel(models()
                        .cross("cherry_bush_stage0", modLoc("block/cherry_bush_sapling"))))
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
        getVariantBuilder(ModBlocks.BROCCOLI.get())
                .partialState().with(BroccoliBlock.AGE, 0).addModels(new ConfiguredModel(models()
                        .withExistingParent("broccoli_stage0", mcLoc("block/crop"))
                        .texture("crop", modLoc("block/broccoli_stage0"))))
                .partialState().with(BroccoliBlock.AGE, 1).addModels(new ConfiguredModel(models()
                        .withExistingParent("broccoli_stage0", mcLoc("block/crop"))
                        .texture("crop", modLoc("block/broccoli_stage0"))))
                .partialState().with(BroccoliBlock.AGE, 2).addModels(new ConfiguredModel(models()
                        .withExistingParent("broccoli_stage1", mcLoc("block/crop"))
                        .texture("crop", modLoc("block/broccoli_stage1"))))
                .partialState().with(BroccoliBlock.AGE, 3).addModels(new ConfiguredModel(models()
                        .withExistingParent("broccoli_stage1", mcLoc("block/crop"))
                        .texture("crop", modLoc("block/broccoli_stage1"))))
                .partialState().with(BroccoliBlock.AGE, 4).addModels(new ConfiguredModel(models()
                        .withExistingParent("broccoli_stage2", mcLoc("block/crop"))
                        .texture("crop", modLoc("block/broccoli_stage2"))))
                .partialState().with(BroccoliBlock.AGE, 5).addModels(new ConfiguredModel(models()
                        .withExistingParent("broccoli_stage2", mcLoc("block/crop"))
                        .texture("crop", modLoc("block/broccoli_stage2"))))
                .partialState().with(BroccoliBlock.AGE, 6).addModels(new ConfiguredModel(models()
                        .withExistingParent("broccoli_stage2", mcLoc("block/crop"))
                        .texture("crop", modLoc("block/broccoli_stage2"))))
                .partialState().with(BroccoliBlock.AGE, 7).addModels(new ConfiguredModel(models()
                        .withExistingParent("broccoli_stage3", mcLoc("block/crop"))
                        .texture("crop", modLoc("block/broccoli_stage3"))));
    }
}
