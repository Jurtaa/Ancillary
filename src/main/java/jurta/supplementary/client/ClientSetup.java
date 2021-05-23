package jurta.supplementary.client;

import jurta.supplementary.init.ModBlocks;
import jurta.supplementary.init.ModTileEntities;
import jurta.supplementary.init.ModWoodType;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientSetup {
    public static void setupBlockRenderLayers() {
        RenderType renderType = RenderType.cutout();
        RenderTypeLookup.setRenderLayer(ModBlocks.BROCCOLI.get(), renderType);
        RenderTypeLookup.setRenderLayer(ModBlocks.CHERRY_BUSH.get(), renderType);
        RenderTypeLookup.setRenderLayer(ModBlocks.SAKURA_SAPLING.get(), renderType);
    }

    public static void setupAtlases() {
        Atlases.addWoodType(ModWoodType.SAKURA);
    }

    public static void setupTileEntityRenderers() {
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.SIGN_TILE_ENTITIES.get(), SignTileEntityRenderer::new);
    }
}
