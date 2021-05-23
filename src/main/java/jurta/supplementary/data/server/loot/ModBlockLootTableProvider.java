package jurta.supplementary.data.server.loot;

import jurta.supplementary.Supplementary;
import jurta.supplementary.block.BroccoliBlock;
import jurta.supplementary.block.CherryBushBlock;
import jurta.supplementary.init.ModBlocks;
import jurta.supplementary.init.ModItems;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.conditions.TableBonus;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.stream.Collectors;

public class ModBlockLootTableProvider extends BlockLootTables {
    private static final ILootCondition.IBuilder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))));
    private static final ILootCondition.IBuilder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    private static final ILootCondition.IBuilder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final ILootCondition.IBuilder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final ILootCondition.IBuilder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    @Override
    protected void addTables() {
        // Rocks
        dropSelf(ModBlocks.PEBBLES.get());
        dropSelf(ModBlocks.ROCK.get());
        dropSelf(ModBlocks.ROCK_BLOCK.get());
        add(ModBlocks.LUSH_STONE.get(), (lushStone) -> createSingleItemTableWithSilkTouch(lushStone, Blocks.COBBLESTONE));
        // Leaves
        add(ModBlocks.SAKURA_LEAVES.get(), (sakuraLeaves) -> createLeavesDrops(sakuraLeaves, ModBlocks.SAKURA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES).withPool(LootPool.lootPool().setRolls(ConstantRange.exactly(1)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(applyExplosionCondition(sakuraLeaves, ItemLootEntry.lootTableItem(ModItems.CHERRIES.get())).when(TableBonus.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F)))));
        // Sapling
        dropSelf(ModBlocks.SAKURA_SAPLING.get());
        // Logs
        dropSelf(ModBlocks.SAKURA_LOG.get());
        dropSelf(ModBlocks.STRIPPED_SAKURA_LOG.get());
        // Wood
        dropSelf(ModBlocks.SAKURA_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_SAKURA_WOOD.get());
        // Signs
        dropSelf(ModBlocks.SAKURA_SIGN.get());
        // Pillars
        dropSelf(ModBlocks.IRON_PILLAR.get());
        dropSelf(ModBlocks.GOLD_PILLAR.get());
        dropSelf(ModBlocks.DIAMOND_PILLAR.get());
        dropSelf(ModBlocks.EMERALD_PILLAR.get());
        dropSelf(ModBlocks.NETHERITE_PILLAR.get());
        // Vegetation
        ILootCondition.IBuilder ilootcondition$ibuilder = BlockStateProperty.hasBlockStateProperties(ModBlocks.BROCCOLI.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BroccoliBlock.AGE, 7));
        add(ModBlocks.BROCCOLI.get(), createCropDrops(ModBlocks.BROCCOLI.get(), ModItems.BROCCOLI.get(), ModItems.BROCCOLI_SEEDS.get(), ilootcondition$ibuilder));
        add(ModBlocks.CHERRY_BUSH.get(), (cherryBush) -> applyExplosionDecay(cherryBush, LootTable.lootTable().withPool(LootPool.lootPool().when(BlockStateProperty.hasBlockStateProperties(ModBlocks.CHERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CherryBushBlock.AGE, 3))).add(ItemLootEntry.lootTableItem(ModItems.CHERRIES.get())).apply(SetCount.setCount(RandomValueRange.between(2.0F, 3.0F))).apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(BlockStateProperty.hasBlockStateProperties(ModBlocks.CHERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CherryBushBlock.AGE, 2))).add(ItemLootEntry.lootTableItem(ModItems.CHERRIES.get())).apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F))).apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter(block -> Supplementary.MOD_ID.equals(block.getRegistryName().getNamespace()))
                .collect(Collectors.toSet());
    }
}
