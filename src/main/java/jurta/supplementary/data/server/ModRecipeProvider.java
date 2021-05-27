package jurta.supplementary.data.server;

import jurta.supplementary.Supplementary;
import jurta.supplementary.init.ModBlocks;
import jurta.supplementary.init.ModItems;
import jurta.supplementary.init.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;
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
    }

    public ResourceLocation modLoc(String name) {
        return new ResourceLocation(Supplementary.MOD_ID, name);
    }
}
