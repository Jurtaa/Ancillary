package jurta.supplementary.init;

import jurta.supplementary.block.*;
import jurta.supplementary.block.trees.SakuraTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // Rocks
    public static final RegistryObject<PebblesBlock> PEBBLES = register("pebbles", () ->
            new PebblesBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).instabreak().noOcclusion()));
    public static final RegistryObject<RockBlock> ROCK = register("rock", () ->
            new RockBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.0F, 4.0F).noOcclusion()));
    public static final RegistryObject<Block> ROCK_BLOCK = register("rock_block", () ->
            new Block(AbstractBlock.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<LushStoneBlock> LUSH_STONE = registerNoItem("lush_stone", () ->
            new LushStoneBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().randomTicks().strength(1.5F, 6.0F).sound(ModSoundType.LUSH_STONE)));
    // Leaves
    public static final RegistryObject<LeavesBlock> SAKURA_LEAVES = register("sakura_leaves", () ->
            new LeavesBlock(AbstractBlock.Properties.copy(Blocks.OAK_LEAVES)));
    // Logs
    public static final RegistryObject<RotatedPillarBlock> SAKURA_LOG = register("sakura_log", () ->
            log(MaterialColor.TERRACOTTA_PINK, MaterialColor.COLOR_BROWN));
    // Wood
    public static final RegistryObject<RotatedPillarBlock> SAKURA_WOOD = register("sakura_wood", () ->
            new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD)));
    // Stripped Logs
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SAKURA_LOG = register("stripped_sakura_log", () ->
            log(MaterialColor.TERRACOTTA_PINK, MaterialColor.TERRACOTTA_PINK));
    // Stripped Wood
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SAKURA_WOOD = register("stripped_sakura_wood", () ->
            new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).strength(2.0F).sound(SoundType.WOOD)));
    // Saplings
    public static final RegistryObject<SaplingBlock> SAKURA_SAPLING = register("sakura_sapling", () ->
            new SaplingBlock(new SakuraTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    // Signs
    public static final RegistryObject<StandingSignBlock> SAKURA_SIGN = registerNoItem("sakura_sign", () ->
            new ModStandingSignBlock(AbstractBlock.Properties.of(Material.WOOD).noCollission()
                    .strength(1.0F).sound(SoundType.WOOD), ModWoodType.SAKURA));
    public static final RegistryObject<WallSignBlock> SAKURA_WALL_SIGN = registerNoItem("sakura_wall_sign", () ->
            new ModWallSignBlock(AbstractBlock.Properties.of(Material.WOOD).noCollission()
                    .strength(1.0F).sound(SoundType.WOOD).lootFrom(ModBlocks.SAKURA_SIGN), ModWoodType.SAKURA));
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

    private static RotatedPillarBlock log(MaterialColor top, MaterialColor side) {
        return new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, (log) ->
                log.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? top : side)
                .strength(2.0F).sound(SoundType.WOOD));
    }
}
