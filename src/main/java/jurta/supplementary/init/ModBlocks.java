package jurta.supplementary.init;

import jurta.supplementary.block.BroccoliBlock;
import jurta.supplementary.block.CherryBushBlock;
import jurta.supplementary.block.trees.SakuraTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // Leaves
    public static final RegistryObject<LeavesBlock> SAKURA_LEAVES = register("sakura_leaves", () ->
            new LeavesBlock(AbstractBlock.Properties.copy(Blocks.OAK_LEAVES)));
    // Saplings
    public static final RegistryObject<SaplingBlock> SAKURA_SAPLING = register("sakura_sapling", () ->
            new SaplingBlock(new SakuraTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    // Pillars
    public static final RegistryObject<RotatedPillarBlock> IRON_PILLAR = register("iron_pillar", () ->
            new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<RotatedPillarBlock> GOLD_PILLAR = register("gold_pillar", () ->
            new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.GOLD_BLOCK)));
    public static final RegistryObject<RotatedPillarBlock> DIAMOND_PILLAR = register("diamond_pillar", () ->
            new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<RotatedPillarBlock> EMERALD_PILLAR = register("emerald_pillar", () ->
            new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<RotatedPillarBlock> NETHERITE_PILLAR = register("netherite_pillar", () ->
            new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.NETHERITE_BLOCK)));
    // Vegetation
    public static final RegistryObject<BroccoliBlock> BROCCOLI = registerNoItem("broccoli", () ->
            new BroccoliBlock(AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<CherryBushBlock> CHERRY_BUSH = registerNoItem("cherry_bush", () ->
            new CherryBushBlock(AbstractBlock.Properties.of(Material.PLANT).noOcclusion().randomTicks().instabreak().sound(SoundType.SWEET_BERRY_BUSH)));

    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ModTabs.SUPPLEMENTARY)));
        return ret;
    }
}
