package jurta.ancillary.client;

import jurta.ancillary.client.renderer.entity.ModBoatRenderer;
import jurta.ancillary.init.ModBlocks;
import jurta.ancillary.init.ModEntities;
import jurta.ancillary.init.ModTileEntities;
import jurta.ancillary.init.ModWoodType;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientSetup {
    public static void setupBlockRenderLayers() {
        RenderType cutout = RenderType.cutout();
        RenderTypeLookup.setRenderLayer(ModBlocks.BROCCOLI.get(), cutout);
        RenderTypeLookup.setRenderLayer(ModBlocks.CHERRY_BUSH.get(), cutout);
        RenderTypeLookup.setRenderLayer(ModBlocks.SAKURA_SAPLING.get(), cutout);
        RenderTypeLookup.setRenderLayer(ModBlocks.SAKURA_DOOR.get(), cutout);
        RenderTypeLookup.setRenderLayer(ModBlocks.SAKURA_TRAPDOOR.get(), cutout);
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_SAKURA_SAPLING.get(), cutout);
    }

    public static void setupAtlases() {
        Atlases.addWoodType(ModWoodType.SAKURA);
    }

    public static void setupTileEntityRenderers() {
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.SIGN_TILE_ENTITIES.get(), SignTileEntityRenderer::new);
    }

    public static void setupEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MOD_BOAT.get(), ModBoatRenderer::new);
    }
}
