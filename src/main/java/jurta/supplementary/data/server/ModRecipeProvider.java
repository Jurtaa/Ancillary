package jurta.supplementary.data.server;

import jurta.supplementary.Supplementary;
import jurta.supplementary.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;

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
    }
}
