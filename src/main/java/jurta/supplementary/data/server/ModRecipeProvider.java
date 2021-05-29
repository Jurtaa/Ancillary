package jurta.supplementary.data.server;

import jurta.supplementary.Supplementary;
import jurta.supplementary.init.ModBlocks;
import jurta.supplementary.init.ModItems;
import jurta.supplementary.init.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    public String getName() {
        return "Recipes: " + Supplementary.MOD_ID;
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        // Crafting Table
        ShapedRecipeBuilder.shaped(ModBlocks.IRON_PILLAR.get(), 2)
                .define('#', Blocks.IRON_BLOCK)
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_iron_block", has(Blocks.IRON_BLOCK))
                .unlockedBy("has_iron_pillar", has(ModBlocks.IRON_PILLAR.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GOLD_PILLAR.get(), 2)
                .define('#', Blocks.GOLD_BLOCK)
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_gold_block", has(Blocks.GOLD_BLOCK))
                .unlockedBy("has_gold_pillar", has(ModBlocks.GOLD_PILLAR.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.DIAMOND_PILLAR.get(), 2)
                .define('#', Blocks.DIAMOND_BLOCK)
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_diamond_block", has(Blocks.DIAMOND_BLOCK))
                .unlockedBy("has_diamond_pillar", has(ModBlocks.DIAMOND_PILLAR.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.EMERALD_PILLAR.get(), 2)
                .define('#', Blocks.EMERALD_BLOCK)
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_emerald_block", has(Blocks.EMERALD_BLOCK))
                .unlockedBy("has_emerald_pillar", has(ModBlocks.EMERALD_PILLAR.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.NETHERITE_PILLAR.get(), 2)
                .define('#', Blocks.NETHERITE_BLOCK)
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_netherite_block", has(Blocks.NETHERITE_BLOCK))
                .unlockedBy("has_netherite_pillar", has(ModBlocks.NETHERITE_PILLAR.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ROCK.get())
                .define('#', ModBlocks.PEBBLES.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_rock", has(ModBlocks.ROCK.get()))
                .unlockedBy("has_pebbles", has(ModBlocks.PEBBLES.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PEBBLES.get(), 4)
                .requires(ModBlocks.ROCK.get())
                .unlockedBy("has_rock", has(ModBlocks.ROCK.get()))
                .unlockedBy("has_pebbles", has(ModBlocks.PEBBLES.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ROCK_BLOCK.get())
                .define('#', ModBlocks.ROCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_rock", has(ModBlocks.ROCK.get()))
                .unlockedBy("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ROCK.get(), 9)
                .requires(ModBlocks.ROCK_BLOCK.get())
                .unlockedBy("has_rock", has(ModBlocks.ROCK.get()))
                .unlockedBy("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .save(consumer, modLoc("rock_from_rock_block"));
        ShapelessRecipeBuilder.shapeless(ModBlocks.SAKURA_PLANKS.get(), 4)
                .requires(ModTags.Items.SAKURA_LOGS)
                .unlockedBy("has_sakura_logs", has(ModTags.Items.SAKURA_LOGS))
                .unlockedBy("has_sakura_planks", has(ModBlocks.SAKURA_PLANKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SAKURA_SIGN.get(), 3)
                .define('#', ModBlocks.SAKURA_PLANKS.get())
                .define('X', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" X ")
                .unlockedBy("has_sakura_planks", has(ModBlocks.SAKURA_PLANKS.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sakura_sign", has(ModBlocks.SAKURA_SIGN.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SAKURA_DOOR.get(), 3)
                .define('#', ModBlocks.SAKURA_PLANKS.get())
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_sakura_planks", has(ModBlocks.SAKURA_PLANKS.get()))
                .unlockedBy("has_sakura_door", has(ModBlocks.SAKURA_DOOR.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SAKURA_TRAPDOOR.get(), 2)
                .define('#', ModBlocks.SAKURA_PLANKS.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_sakura_planks", has(ModBlocks.SAKURA_PLANKS.get()))
                .unlockedBy("has_sakura_trapdoor", has(ModBlocks.SAKURA_TRAPDOOR.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SAKURA_SLAB.get(), 6)
                .define('#', ModBlocks.SAKURA_PLANKS.get())
                .pattern("###")
                .unlockedBy("has_sakura_planks", has(ModBlocks.SAKURA_PLANKS.get()))
                .unlockedBy("has_sakura_slab", has(ModBlocks.SAKURA_SLAB.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SAKURA_STAIRS.get(), 4)
                .define('#', ModBlocks.SAKURA_PLANKS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_sakura_planks", has(ModBlocks.SAKURA_PLANKS.get()))
                .unlockedBy("has_sakura_stairs", has(ModBlocks.SAKURA_STAIRS.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.SAKURA_BUTTON.get())
                .requires(ModBlocks.SAKURA_PLANKS.get())
                .unlockedBy("has_sakura_planks", has(ModBlocks.SAKURA_PLANKS.get()))
                .unlockedBy("has_sakura_button", has(ModBlocks.SAKURA_BUTTON.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SAKURA_PRESSURE_PLATE.get())
                .define('#', ModBlocks.SAKURA_PLANKS.get())
                .pattern("##")
                .unlockedBy("has_sakura_planks", has(ModBlocks.SAKURA_PLANKS.get()))
                .unlockedBy("has_sakura_pressure_plate", has(ModBlocks.SAKURA_PRESSURE_PLATE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SAKURA_FENCE.get(), 3)
                .define('#', ModBlocks.SAKURA_PLANKS.get())
                .define('X', Items.STICK)
                .pattern("#X#")
                .pattern("#X#")
                .unlockedBy("has_sakura_planks", has(ModBlocks.SAKURA_PLANKS.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sakura_fence", has(ModBlocks.SAKURA_FENCE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SAKURA_FENCE_GATE.get())
                .define('#', ModBlocks.SAKURA_PLANKS.get())
                .define('X', Items.STICK)
                .pattern("X#X")
                .pattern("X#X")
                .unlockedBy("has_sakura_planks", has(ModBlocks.SAKURA_PLANKS.get()))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_sakura_fence", has(ModBlocks.SAKURA_FENCE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.SAKURA_BOAT.get())
                .define('#', ModBlocks.SAKURA_PLANKS.get())
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_sakura_planks", has(ModBlocks.SAKURA_PLANKS.get()))
                .unlockedBy("has_sakura_boat", has(ModItems.SAKURA_BOAT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SAKURA_WOOD.get(), 3)
                .define('#', ModBlocks.SAKURA_LOG.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_sakura_log", has(ModBlocks.SAKURA_LOG.get()))
                .unlockedBy("has_sakura_wood", has(ModBlocks.SAKURA_WOOD.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.STRIPPED_SAKURA_WOOD.get(), 3)
                .define('#', ModBlocks.STRIPPED_SAKURA_LOG.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_stripped_sakura_log", has(ModBlocks.STRIPPED_SAKURA_LOG.get()))
                .unlockedBy("has_stripped_sakura_wood", has(ModBlocks.STRIPPED_SAKURA_WOOD.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ROCK_WALL.get(), 6)
                .define('#', ModBlocks.ROCK_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .unlockedBy("has_rock_wall", has(ModBlocks.ROCK_WALL.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ROCK_SLAB.get(), 6)
                .define('#', ModBlocks.ROCK_BLOCK.get())
                .pattern("###")
                .unlockedBy("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .unlockedBy("has_rock_slab", has(ModBlocks.ROCK_SLAB.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ROCK_STAIRS.get(), 4)
                .define('#', ModBlocks.ROCK_BLOCK.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .unlockedBy("has_rock_stairs", has(ModBlocks.ROCK_STAIRS.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.POLISHED_ROCK_BUTTON.get())
                .requires(ModBlocks.ROCK_BLOCK.get())
                .unlockedBy("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .unlockedBy("has_polished_rock_button", has(ModBlocks.POLISHED_ROCK_BUTTON.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.POLISHED_ROCK_PRESSURE_PLATE.get())
                .define('#', ModBlocks.ROCK_BLOCK.get())
                .pattern("##")
                .unlockedBy("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .unlockedBy("has_polished_rock_pressure_plate", has(ModBlocks.POLISHED_ROCK_PRESSURE_PLATE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.POLISHED_ROCK_BLOCK.get(), 4)
                .define('#', ModBlocks.ROCK_BLOCK.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .unlockedBy("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.POLISHED_ROCK_WALL.get(), 6)
                .define('#', ModBlocks.POLISHED_ROCK_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .unlockedBy("has_polished_rock_wall", has(ModBlocks.POLISHED_ROCK_WALL.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.POLISHED_ROCK_SLAB.get(), 6)
                .define('#', ModBlocks.POLISHED_ROCK_BLOCK.get())
                .pattern("###")
                .unlockedBy("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .unlockedBy("has_polished_rock_slab", has(ModBlocks.POLISHED_ROCK_SLAB.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.POLISHED_ROCK_STAIRS.get(), 4)
                .define('#', ModBlocks.POLISHED_ROCK_BLOCK.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .unlockedBy("has_polished_rock_stairs", has(ModBlocks.POLISHED_ROCK_STAIRS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ROCK_BRICKS.get(), 4)
                .define('#', ModBlocks.POLISHED_ROCK_BLOCK.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .unlockedBy("has_rock_bricks", has(ModBlocks.ROCK_BRICKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ROCK_BRICK_WALL.get(), 6)
                .define('#', ModBlocks.ROCK_BRICKS.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_rock_bricks", has(ModBlocks.ROCK_BRICKS.get()))
                .unlockedBy("has_rock_brick_wall", has(ModBlocks.ROCK_BRICK_WALL.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ROCK_BRICK_SLAB.get(), 6)
                .define('#', ModBlocks.ROCK_BRICKS.get())
                .pattern("###")
                .unlockedBy("has_rock_bricks", has(ModBlocks.ROCK_BRICKS.get()))
                .unlockedBy("has_rock_brick_slab", has(ModBlocks.ROCK_BRICK_SLAB.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.ROCK_BRICK_STAIRS.get(), 4)
                .define('#', ModBlocks.ROCK_BRICKS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_rock_bricks", has(ModBlocks.ROCK_BRICKS.get()))
                .unlockedBy("has_rock_brick_stairs", has(ModBlocks.ROCK_BRICK_STAIRS.get()))
                .save(consumer);
        // Stonecutter
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.ROCK_BLOCK.get()), ModBlocks.ROCK_STAIRS.get())
                .unlocks("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .save(consumer, modLoc("rock_stairs_from_rock_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.ROCK_BLOCK.get()), ModBlocks.ROCK_SLAB.get(), 2)
                .unlocks("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .save(consumer, modLoc("rock_slab_from_rock_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.ROCK_BLOCK.get()), ModBlocks.ROCK_WALL.get())
                .unlocks("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .save(consumer, modLoc("rock_wall_from_rock_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_ROCK_BLOCK.get()), ModBlocks.POLISHED_ROCK_STAIRS.get())
                .unlocks("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .save(consumer, modLoc("polished_rock_stairs_from_polished_rock_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_ROCK_BLOCK.get()), ModBlocks.POLISHED_ROCK_SLAB.get(), 2)
                .unlocks("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .save(consumer, modLoc("polished_rock_slab_from_polished_rock_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_ROCK_BLOCK.get()), ModBlocks.POLISHED_ROCK_WALL.get())
                .unlocks("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .save(consumer, modLoc("polished_rock_wall_from_polished_rock_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.ROCK_BRICKS.get()), ModBlocks.ROCK_BRICK_STAIRS.get())
                .unlocks("has_rock_bricks", has(ModBlocks.ROCK_BRICKS.get()))
                .save(consumer, modLoc("rock_brick_stairs_from_rock_bricks_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.ROCK_BRICKS.get()), ModBlocks.ROCK_BRICK_SLAB.get(), 2)
                .unlocks("has_rock_bricks", has(ModBlocks.ROCK_BRICKS.get()))
                .save(consumer, modLoc("rock_brick_slab_from_rock_bricks_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.ROCK_BRICKS.get()), ModBlocks.ROCK_BRICK_WALL.get())
                .unlocks("has_rock_bricks", has(ModBlocks.ROCK_BRICKS.get()))
                .save(consumer, modLoc("rock_brick_wall_from_rock_bricks_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_ROCK_BLOCK.get()), ModBlocks.ROCK_BRICKS.get())
                .unlocks("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .save(consumer, modLoc("rock_bricks_from_polished_rock_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_ROCK_BLOCK.get()), ModBlocks.ROCK_BRICK_STAIRS.get())
                .unlocks("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .save(consumer, modLoc("rock_brick_stairs_from_polished_rock_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_ROCK_BLOCK.get()), ModBlocks.ROCK_BRICK_SLAB.get(), 2)
                .unlocks("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .save(consumer, modLoc("rock_brick_slab_from_polished_rock_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_ROCK_BLOCK.get()), ModBlocks.ROCK_BRICK_WALL.get())
                .unlocks("has_polished_rock_block", has(ModBlocks.POLISHED_ROCK_BLOCK.get()))
                .save(consumer, modLoc("rock_brick_wall_from_polished_rock_block_stonecutting"));
        // Furnace
        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ROCK_BRICKS.get()), ModBlocks.CRACKED_ROCK_BRICKS.get(), 0.1F, 200)
                .unlockedBy("has_rock_bricks", has(ModBlocks.ROCK_BRICKS.get()))
                .save(consumer);
    }

    public ResourceLocation modLoc(String name) {
        return new ResourceLocation(Supplementary.MOD_ID, name);
    }
}
