package jurta.supplementary.data.client;

import jurta.supplementary.Supplementary;
import jurta.supplementary.block.BroccoliBlock;
import jurta.supplementary.block.CherryBushBlock;
import jurta.supplementary.init.ModBlocks;
import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
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
        // Polished Blocks
        simpleBlock(ModBlocks.POLISHED_ROCK_BLOCK.get());
        // Leaves
        simpleBlock(ModBlocks.SAKURA_LEAVES.get());
        // Sapling
        simpleBlock(ModBlocks.SAKURA_SAPLING.get(), models().cross("sakura_sapling", modLoc("block/sakura_sapling")));
        // Logs
        logBlock(ModBlocks.SAKURA_LOG.get());
        logBlock(ModBlocks.STRIPPED_SAKURA_LOG.get());
        // Wood
        axisBlock(ModBlocks.SAKURA_WOOD.get(), modLoc("block/sakura_log"), modLoc("block/sakura_log"));
        axisBlock(ModBlocks.STRIPPED_SAKURA_WOOD.get(), modLoc("block/stripped_sakura_log"), modLoc("block/stripped_sakura_log"));
        // Planks
        simpleBlock(ModBlocks.SAKURA_PLANKS.get());
        // Stairs
        stairsBlock(ModBlocks.ROCK_STAIRS.get(), modLoc("block/rock_block"));
        stairsBlock(ModBlocks.POLISHED_ROCK_STAIRS.get(), modLoc("block/polished_rock_block"));
        stairsBlock(ModBlocks.SAKURA_STAIRS.get(), modLoc("block/sakura_planks"));
        // Slabs
        slabBlock(ModBlocks.ROCK_SLAB.get(), modLoc("block/rock_block"), modLoc("block/rock_block"));
        slabBlock(ModBlocks.POLISHED_ROCK_SLAB.get(), modLoc("block/polished_rock_block"), modLoc("block/polished_rock_block"));
        slabBlock(ModBlocks.SAKURA_SLAB.get(), modLoc("block/sakura_planks"), modLoc("block/sakura_planks"));
        // Buttons
        buttonBlock(ModBlocks.POLISHED_ROCK_BUTTON.get(), modLoc("block/polished_rock_block"));
        buttonBlock(ModBlocks.SAKURA_BUTTON.get(), modLoc("block/sakura_planks"));
        // Pressure Plates
        pressurePlateBlock(ModBlocks.POLISHED_ROCK_PRESSURE_PLATE.get(), modLoc("block/polished_rock_block"));
        pressurePlateBlock(ModBlocks.SAKURA_PRESSURE_PLATE.get(), modLoc("block/sakura_planks"));
        // Signs
        simpleBlock(ModBlocks.SAKURA_SIGN.get(), models().withExistingParent("sakura_sign", mcLoc("block/block")).texture("particle", modLoc("block/sakura_planks")));
        simpleBlock(ModBlocks.SAKURA_WALL_SIGN.get(), models().withExistingParent("sakura_sign", mcLoc("block/block")).texture("particle", modLoc("block/sakura_planks")));
        // Doors
        doorBlock(ModBlocks.SAKURA_DOOR.get(), modLoc("block/sakura_door_bottom"), modLoc("block/sakura_door_top"));
        // Trapdoors
        trapdoorBlock(ModBlocks.SAKURA_TRAPDOOR.get(), modLoc("block/sakura_trapdoor"), true);
        // Fences
        fenceBlock(ModBlocks.SAKURA_FENCE.get(), modLoc("block/sakura_planks"));
        // Fence Gates
        fenceGateBlock(ModBlocks.SAKURA_FENCE_GATE.get(), modLoc("block/sakura_planks"));
        // Walls
        wallBlock(ModBlocks.POLISHED_ROCK_WALL.get(), modLoc("block/polished_rock_block"));
        wallBlock(ModBlocks.ROCK_WALL.get(), modLoc("block/rock_block"));
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

    public void pressurePlateBlock(PressurePlateBlock block, ResourceLocation texture) {
        String name = block.getRegistryName().getPath();
        getVariantBuilder(block).forAllStates(state -> {
            boolean isPowered = state.getValue(BlockStateProperties.POWERED);
            return ConfiguredModel.builder().modelFile(models().withExistingParent(
                    isPowered ? name + "_down" : name,
                    isPowered ? "block/pressure_plate_down" : "block/pressure_plate_up")
                    .texture("texture", texture))
                    .build();
        });
    }

    public void buttonBlock(AbstractButtonBlock block, ResourceLocation texture) {
        String name = block.getRegistryName().getPath();
        getVariantBuilder(block).forAllStates(state -> {
            boolean isPowered = state.getValue(BlockStateProperties.POWERED);
            Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            AttachFace face = state.getValue(BlockStateProperties.ATTACH_FACE);
            return ConfiguredModel.builder().modelFile(models().withExistingParent(
                    isPowered ? name + "_pressed" : name,
                    isPowered ? "block/button_pressed" : "block/button")
                    .texture("texture", texture))
                    .rotationX(face.ordinal() * 90)
                    .rotationY((((int) dir.toYRot() + 180) + (face == AttachFace.CEILING ? 180 : 0)) % 360)
                    .uvLock(face == AttachFace.WALL)
                    .build();
        });
        models().withExistingParent(
                name + "_inventory",
                mcLoc("block/button_inventory"))
                .texture("texture", texture);
    }
}
