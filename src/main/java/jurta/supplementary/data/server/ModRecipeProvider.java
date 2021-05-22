package jurta.supplementary.data.server;

import jurta.supplementary.Supplementary;
import jurta.supplementary.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;

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
        ShapelessRecipeBuilder.shapeless(ModBlocks.ROCK.get())
                .requires(ModBlocks.PEBBLES.get(), 4)
                .unlockedBy("has_rock", has(ModBlocks.ROCK.get()))
                .unlockedBy("has_pebbles", has(ModBlocks.PEBBLES.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PEBBLES.get(), 4)
                .requires(ModBlocks.ROCK.get())
                .unlockedBy("has_rock", has(ModBlocks.ROCK.get()))
                .unlockedBy("has_pebbles", has(ModBlocks.PEBBLES.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ROCK_BLOCK.get())
                .requires(ModBlocks.ROCK.get(), 9)
                .unlockedBy("has_rock", has(ModBlocks.ROCK.get()))
                .unlockedBy("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.ROCK.get(), 9)
                .requires(ModBlocks.ROCK_BLOCK.get())
                .unlockedBy("has_rock", has(ModBlocks.ROCK.get()))
                .unlockedBy("has_rock_block", has(ModBlocks.ROCK_BLOCK.get()))
                .save(consumer, "rock_from_rock_block");
    }
}
