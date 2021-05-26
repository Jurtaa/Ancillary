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
        withExistingParent("rock_block", modLoc("block/rock_block"));
        withExistingParent("lush_stone", modLoc("block/lush_stone"));
        // Leaves
        withExistingParent("sakura_leaves", modLoc("block/sakura_leaves"));
        // Logs
        withExistingParent("sakura_log", modLoc("block/sakura_log"));
        withExistingParent("stripped_sakura_log", modLoc("block/stripped_sakura_log"));
        // Wood
        withExistingParent("sakura_wood", modLoc("block/sakura_wood"));
        withExistingParent("stripped_sakura_wood", modLoc("block/stripped_sakura_wood"));
        // Planks
        withExistingParent("sakura_planks", modLoc("block/sakura_planks"));
        // Stairs
        withExistingParent("sakura_stairs", modLoc("block/sakura_stairs"));
        // Slabs
        withExistingParent("sakura_slab", modLoc("block/sakura_slab"));
        // Buttons
        withExistingParent("sakura_button", modLoc("block/sakura_button_inventory"));
        // Pressure Plates
        withExistingParent("sakura_pressure_plate", modLoc("block/sakura_pressure_plate"));
        // Trapdoors
        withExistingParent("sakura_trapdoor", modLoc("block/sakura_trapdoor_bottom"));
        // Fences
        fenceInventory("sakura_fence", modLoc("block/sakura_planks"));
        // Fence Gates
        withExistingParent("sakura_fence_gate", modLoc("block/sakura_fence_gate"));
        // Pillars
        withExistingParent("iron_pillar", modLoc("block/iron_pillar"));
        withExistingParent("gold_pillar", modLoc("block/gold_pillar"));
        withExistingParent("diamond_pillar", modLoc("block/diamond_pillar"));
        withExistingParent("emerald_pillar", modLoc("block/emerald_pillar"));
        withExistingParent("netherite_pillar", modLoc("block/netherite_pillar"));
        // Items
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        builder(itemGenerated, "pebbles");
        builder(itemGenerated, "rock");
        builder(itemGenerated, "cherries");
        builder(itemGenerated, "broccoli");
        builder(itemGenerated, "broccoli_seeds");
        builder(itemGenerated, "sakura_sign");
        builder(itemGenerated, "sakura_door");
        builder(itemGenerated, "sakura_sapling", "block/sakura_sapling");
        builder(itemGenerated, "sakura_boat");

    }

    private ItemModelBuilder builder(ModelFile model, String name) {
        return getBuilder(name).parent(model).texture("layer0", modLoc("item/" + name));
    }

    private ItemModelBuilder builder(ModelFile model, String name, String texture) {
        return getBuilder(name).parent(model).texture("layer0", modLoc(texture));
    }
}
