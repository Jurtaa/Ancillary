package jurta.supplementary.data.loot;

import jurta.supplementary.Supplementary;
import jurta.supplementary.block.BroccoliBlock;
import jurta.supplementary.block.CherryBushBlock;
import jurta.supplementary.init.ModBlocks;
import jurta.supplementary.init.ModItems;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarrotBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.stream.Collectors;

public class ModBlockLootTableProvider extends BlockLootTables {
    @Override
    protected void addTables () {
        ILootCondition.IBuilder ilootcondition$ibuilder = BlockStateProperty.hasBlockStateProperties(ModBlocks.BROCCOLI.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BroccoliBlock.AGE, 7));
        this.add(ModBlocks.BROCCOLI.get(), createCropDrops(ModBlocks.BROCCOLI.get(), ModItems.BROCCOLI.get(), ModItems.BROCCOLI_SEEDS.get(), ilootcondition$ibuilder));
        add(ModBlocks.CHERRY_BUSH.get(), (cherryBush) -> {
            return applyExplosionDecay(cherryBush, LootTable.lootTable().withPool(LootPool.lootPool().when(BlockStateProperty.hasBlockStateProperties(ModBlocks.CHERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CherryBushBlock.AGE, 3))).add(ItemLootEntry.lootTableItem(ModItems.CHERRIES.get())).apply(SetCount.setCount(RandomValueRange.between(2.0F, 3.0F))).apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(BlockStateProperty.hasBlockStateProperties(ModBlocks.CHERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CherryBushBlock.AGE, 2))).add(ItemLootEntry.lootTableItem(ModItems.CHERRIES.get())).apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F))).apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
        });
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter(block -> Supplementary.MOD_ID.equals(block.getRegistryName().getNamespace()))
                .collect(Collectors.toSet());
    }
}
