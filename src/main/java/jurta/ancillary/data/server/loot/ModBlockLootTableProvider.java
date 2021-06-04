package jurta.ancillary.data.server.loot;

import jurta.ancillary.Ancillary;
import jurta.ancillary.block.BroccoliBlock;
import jurta.ancillary.block.CherryBushBlock;
import jurta.ancillary.init.ModBlocks;
import jurta.ancillary.init.ModItems;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.conditions.TableBonus;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.CopyNbt;
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
        // Material Blocks
        add(ModBlocks.LEATHER_BLOCK.get(), (leatherBlock) -> LootTable.lootTable().withPool(applyExplosionCondition(leatherBlock, LootPool.lootPool().setRolls(ConstantRange.exactly(1)).add(ItemLootEntry.lootTableItem(leatherBlock).apply(CopyNbt.copyData(CopyNbt.Source.BLOCK_ENTITY).copy("Color", "display.color"))))));
        // Rocks
        dropSelf(ModBlocks.PEBBLES.get());
        dropSelf(ModBlocks.ROCK.get());
        dropSelf(ModBlocks.ROCK_BLOCK.get());
        add(ModBlocks.LUSH_STONE.get(), (lushStone) -> createSingleItemTableWithSilkTouch(lushStone, Blocks.COBBLESTONE));
        // Polished Blocks
        dropSelf(ModBlocks.POLISHED_ROCK_BLOCK.get());
        // Bricks
        dropSelf(ModBlocks.ROCK_BRICKS.get());
        dropSelf(ModBlocks.CRACKED_ROCK_BRICKS.get());
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
        // Planks
        dropSelf(ModBlocks.SAKURA_PLANKS.get());
        // Stairs
        dropSelf(ModBlocks.ROCK_STAIRS.get());
        dropSelf(ModBlocks.POLISHED_ROCK_STAIRS.get());
        dropSelf(ModBlocks.ROCK_BRICK_STAIRS.get());
        dropSelf(ModBlocks.SAKURA_STAIRS.get());
        // Slabs
        dropSlab(ModBlocks.ROCK_SLAB.get());
        dropSlab(ModBlocks.POLISHED_ROCK_SLAB.get());
        dropSlab(ModBlocks.ROCK_BRICK_SLAB.get());
        dropSlab(ModBlocks.SAKURA_SLAB.get());
        // Buttons
        dropSelf(ModBlocks.POLISHED_ROCK_BUTTON.get());
        dropSelf(ModBlocks.SAKURA_BUTTON.get());
        // Pressure Plates
        dropSelf(ModBlocks.POLISHED_ROCK_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.SAKURA_PRESSURE_PLATE.get());
        // Signs
        dropSelf(ModBlocks.SAKURA_SIGN.get());
        // Doors
        dropDoor(ModBlocks.SAKURA_DOOR.get());
        // Trapdoors
        dropSelf(ModBlocks.SAKURA_TRAPDOOR.get());
        // Fences
        dropSelf(ModBlocks.SAKURA_FENCE.get());
        // Fence Gates
        dropSelf(ModBlocks.SAKURA_FENCE_GATE.get());
        // Walls
        dropSelf(ModBlocks.ROCK_WALL.get());
        dropSelf(ModBlocks.POLISHED_ROCK_WALL.get());
        dropSelf(ModBlocks.ROCK_BRICK_WALL.get());
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
        // Flower Pots
        add(ModBlocks.POTTED_SAKURA_SAPLING.get(), createPotFlowerItemTable(ModBlocks.SAKURA_SAPLING.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter(block -> Ancillary.MOD_ID.equals(block.getRegistryName().getNamespace()))
                .collect(Collectors.toSet());
    }

    public void dropSlab(SlabBlock block) {
        add(block, createSlabItemTable(block));
    }

    public void dropDoor(DoorBlock block) {
        add(block, createDoorTable(block));
    }
}
