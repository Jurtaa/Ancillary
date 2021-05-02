package jurta.supplementary.data.client;

import jurta.supplementary.Supplementary;
import jurta.supplementary.init.ModBlocks;
import jurta.supplementary.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, Supplementary.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        String locale = this.getName().replace("Languages: ", "");
        switch(locale) {
            case "en_au":
            case "en_ca":
            case "en_gb":
            case "en_nz":
            case "en_us":
                add("itemGroup.supplementary", "Supplementary");
                add("supplementary.configGui.title", "Supplementary Config");
                add("supplementary.configGui.generation", "Generation");
                add("supplementary.configGui.generation.tooltip", "Settings for generation relating to the mod.");
                add("supplementary.configGui.generation.title", "Supplementary Generation Config");
                add("supplementary.configGui.allowVegetalGeneration.title", "Vegetation");
                add("supplementary.configGui.allowVegetalGeneration.tooltip",
                        "Determines if vegetation should generate within worlds.\n" +
                        "\u00A77Default: ON");
                addBlock(ModBlocks.BROCCOLI, "Broccoli");
                addBlock(ModBlocks.CHERRY_BUSH, "Cherry Bush");
                addItem(ModItems.BROCCOLI, "Broccoli");
                addItem(ModItems.BROCCOLI_SEEDS, "Broccoli Seeds");
                addItem(ModItems.CHERRIES, "Cherries");
                break;
        }
    }
}
