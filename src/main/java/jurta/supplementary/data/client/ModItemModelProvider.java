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
        // Polished Blocks
        withExistingParent("polished_rock_block", modLoc("block/polished_rock_block"));
        // Bricks
        withExistingParent("rock_bricks", modLoc("block/rock_bricks"));
        withExistingParent("cracked_rock_bricks", modLoc("block/cracked_rock_bricks"));
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
        withExistingParent("rock_stairs", modLoc("block/rock_stairs"));
        withExistingParent("polished_rock_stairs", modLoc("block/polished_rock_stairs"));
        withExistingParent("rock_brick_stairs", modLoc("block/rock_brick_stairs"));
        withExistingParent("sakura_stairs", modLoc("block/sakura_stairs"));
        // Slabs
        withExistingParent("rock_slab", modLoc("block/rock_slab"));
        withExistingParent("polished_rock_slab", modLoc("block/polished_rock_slab"));
        withExistingParent("rock_brick_slab", modLoc("block/rock_brick_slab"));
        withExistingParent("sakura_slab", modLoc("block/sakura_slab"));
        // Buttons
        withExistingParent("polished_rock_button", modLoc("block/polished_rock_button_inventory"));
        withExistingParent("sakura_button", modLoc("block/sakura_button_inventory"));
        // Pressure Plates
        withExistingParent("polished_rock_pressure_plate", modLoc("block/polished_rock_pressure_plate"));
        withExistingParent("sakura_pressure_plate", modLoc("block/sakura_pressure_plate"));
        // Trapdoors
        withExistingParent("sakura_trapdoor", modLoc("block/sakura_trapdoor_bottom"));
        // Fences
        fenceInventory("sakura_fence", modLoc("block/sakura_planks"));
        // Fence Gates
        withExistingParent("sakura_fence_gate", modLoc("block/sakura_fence_gate"));
        // Walls
        wallInventory("rock_wall", modLoc("block/rock_block"));
        wallInventory("polished_rock_wall", modLoc("block/polished_rock_block"));
        wallInventory("rock_brick_wall", modLoc("block/rock_bricks"));
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
        return builder(model, name, "item/" + name);
    }

    private ItemModelBuilder builder(ModelFile model, String name, String texture) {
        return getBuilder(name).parent(model).texture("layer0", modLoc(texture));
    }
}
