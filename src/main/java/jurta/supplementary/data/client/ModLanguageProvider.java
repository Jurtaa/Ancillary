package jurta.supplementary.data.client;

import jurta.supplementary.Supplementary;
import jurta.supplementary.init.ModBlocks;
import jurta.supplementary.init.ModEntities;
import jurta.supplementary.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    private final String locale;

    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, Supplementary.MOD_ID, locale);
        this.locale = locale;
    }

    @Override
    public String getName() {
        return "Languages: " + Supplementary.MOD_ID + ": " + this.locale;
    }

    @Override
    protected void addTranslations() {
        switch(locale) {
            case "en_au":
            case "en_ca":
            case "en_gb":
            case "en_nz":
            case "en_us":
                add("itemGroup.supplementary", "Supplementary");
                add("config.supplementary.title", "Supplementary Config");
                add("config.supplementary.generation", "Generation");
                add("config.supplementary.generation.tooltip", "Settings for generation relating to the mod.");
                add("config.supplementary.generation.title", "Supplementary Generation Config");
                add("config.supplementary.allowVegetalGeneration.title", "Vegetation");
                add("config.supplementary.allowVegetalGeneration.tooltip",
                        "Determines if vegetation should generate within worlds.\n" +
                        "\u00A77Default: ON");
                add("config.supplementary.allowTreeGeneration.title", "Trees");
                add("config.supplementary.allowTreeGeneration.tooltip",
                        "Determines if trees should generate within worlds.\n" +
                                "\u00A77Default: ON");
                add("config.supplementary.allowRockGeneration.title", "Rocks");
                add("config.supplementary.allowRockGeneration.tooltip",
                        "Determines if rocks should generate within worlds.\n" +
                                "\u00A77Default: ON");
                add("config.supplementary.allowLushStoneGeneration.title", "Lush Stone");
                add("config.supplementary.allowLushStoneGeneration.tooltip",
                        "Determines if lush stone should generate within worlds.\n" +
                        "\u00A74WARNING: Doesn't generate as intended.\n" +
                                "\u00A7r\u00A77Default: OFF");
                addBlock(ModBlocks.LEATHER_BLOCK, "Leather Block");
                addBlock(ModBlocks.ROCK_BLOCK, "Rock Block");
                addBlock(ModBlocks.POLISHED_ROCK_BLOCK, "Polished Rock Block");
                addBlock(ModBlocks.LUSH_STONE, "Lush Stone");
                addBlock(ModBlocks.ROCK_BRICKS, "Rock Bricks");
                addBlock(ModBlocks.CRACKED_ROCK_BRICKS, "Cracked Rock Bricks");
                addBlock(ModBlocks.BROCCOLI, "Broccoli");
                addBlock(ModBlocks.CHERRY_BUSH, "Cherry Bush");
                addBlock(ModBlocks.PEBBLES, "Pebbles");
                addBlock(ModBlocks.ROCK, "Rock");
                addBlock(ModBlocks.IRON_PILLAR, "Iron Pillar");
                addBlock(ModBlocks.GOLD_PILLAR, "Gold Pillar");
                addBlock(ModBlocks.DIAMOND_PILLAR, "Diamond Pillar");
                addBlock(ModBlocks.EMERALD_PILLAR, "Emerald Pillar");
                addBlock(ModBlocks.NETHERITE_PILLAR, "Netherite Pillar");
                addBlock(ModBlocks.SAKURA_LEAVES, "Sakura Leaves");
                addBlock(ModBlocks.SAKURA_SAPLING, "Sakura Sapling");
                addBlock(ModBlocks.SAKURA_LOG, "Sakura Log");
                addBlock(ModBlocks.SAKURA_WOOD, "Sakura Wood");
                addBlock(ModBlocks.STRIPPED_SAKURA_LOG, "Stripped Sakura Log");
                addBlock(ModBlocks.STRIPPED_SAKURA_WOOD, "Stripped Sakura Wood");
                addBlock(ModBlocks.SAKURA_PLANKS, "Sakura Planks");
                addBlock(ModBlocks.ROCK_STAIRS, "Rock Stairs");
                addBlock(ModBlocks.POLISHED_ROCK_STAIRS, "Polished Rock Stairs");
                addBlock(ModBlocks.ROCK_BRICK_STAIRS, "Rock Brick Stairs");
                addBlock(ModBlocks.SAKURA_STAIRS, "Sakura Stairs");
                addBlock(ModBlocks.ROCK_SLAB, "Rock Slab");
                addBlock(ModBlocks.POLISHED_ROCK_SLAB, "Polished Rock Slab");
                addBlock(ModBlocks.ROCK_BRICK_SLAB, "Rock Brick Slab");
                addBlock(ModBlocks.SAKURA_SLAB, "Sakura Slab");
                addBlock(ModBlocks.SAKURA_SIGN, "Sakura Sign");
                add("block.supplementary.sakura_wall_sign", "Sakura Wall Sign");
                addBlock(ModBlocks.POLISHED_ROCK_PRESSURE_PLATE, "Polished Rock Pressure Plate");
                addBlock(ModBlocks.SAKURA_PRESSURE_PLATE, "Sakura Pressure Plate");
                addBlock(ModBlocks.POLISHED_ROCK_BUTTON, "Polished Rock Button");
                addBlock(ModBlocks.SAKURA_BUTTON, "Sakura Button");
                addBlock(ModBlocks.SAKURA_DOOR, "Sakura Door");
                addBlock(ModBlocks.SAKURA_TRAPDOOR, "Sakura Trapdoor");
                addBlock(ModBlocks.SAKURA_FENCE, "Sakura Fence");
                addBlock(ModBlocks.SAKURA_FENCE_GATE, "Sakura Fence Gate");
                addBlock(ModBlocks.ROCK_WALL, "Rock Wall");
                addBlock(ModBlocks.POLISHED_ROCK_WALL, "Polished Rock Wall");
                addBlock(ModBlocks.ROCK_BRICK_WALL, "Rock Brick Wall");
                addItem(ModItems.BROCCOLI, "Broccoli");
                addItem(ModItems.BROCCOLI_SEEDS, "Broccoli Seeds");
                addItem(ModItems.CHERRIES, "Cherries");
                addItem(ModItems.SAKURA_BOAT, "Sakura Boat");
                addItem(ModItems.SAKURA_SIGN, "Sakura Sign");
                addEntityType(ModEntities.MOD_BOAT, "Boat");
                break;
        }
    }
}
