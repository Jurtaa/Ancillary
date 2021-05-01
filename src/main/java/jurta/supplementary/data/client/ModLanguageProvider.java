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
            case "en_us":
            case "en_gb":
                add("itemGroup.supplementary", "Supplementary");
                add("supplementary.configGui.title", "Supplementary Configuration");
                add("supplementary.configGui.allowVegetalGeneration.title", "Vegetal Generation");
                add("supplementary.configGui.allowVegetalGeneration.tooltip",
                        "Determines if vegetation should generate within worlds./n" +
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
