package jurta.supplementary.data.client;

import jurta.supplementary.Supplementary;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Supplementary.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        // Rocks
        withExistingParent("lush_stone", modLoc("block/lush_stone"));
        // Leaves
        withExistingParent("sakura_leaves", modLoc("block/sakura_leaves"));
        // Pillars
        withExistingParent("iron_pillar", modLoc("block/iron_pillar"));
        withExistingParent("gold_pillar", modLoc("block/gold_pillar"));
        withExistingParent("diamond_pillar", modLoc("block/diamond_pillar"));
        withExistingParent("emerald_pillar", modLoc("block/emerald_pillar"));
        withExistingParent("netherite_pillar", modLoc("block/netherite_pillar"));
        // Items
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        builder(itemGenerated, "cherries");
        builder(itemGenerated, "broccoli");
        builder(itemGenerated, "broccoli_seeds");
        builder(itemGenerated, "sakura_sapling", "block/sakura_sapling");

    }

    private ItemModelBuilder builder(ModelFile model, String name) {
        return getBuilder(name).parent(model).texture("layer0", modLoc("item/" + name));
    }

    private ItemModelBuilder builder(ModelFile model, String name, String texture) {
        return getBuilder(name).parent(model).texture("layer0", modLoc(texture));
    }
}
