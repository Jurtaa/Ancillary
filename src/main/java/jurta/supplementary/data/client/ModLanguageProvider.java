package jurta.supplementary.data.client;

import jurta.supplementary.Supplementary;
import jurta.supplementary.init.ModBlocks;
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
                addBlock(ModBlocks.BROCCOLI, "Broccoli");
                addBlock(ModBlocks.CHERRY_BUSH, "Cherry Bush");
                addBlock(ModBlocks.DIAMOND_PILLAR, "Diamond Pillar");
                addBlock(ModBlocks.NETHERITE_PILLAR, "Netherite Pillar");
                addBlock(ModBlocks.SAKURA_LEAVES, "Sakura Leaves");
                addBlock(ModBlocks.SAKURA_SAPLING, "Sakura Sapling");
                addItem(ModItems.BROCCOLI, "Broccoli");
                addItem(ModItems.BROCCOLI_SEEDS, "Broccoli Seeds");
                addItem(ModItems.CHERRIES, "Cherries");
                break;
        }
    }
}
