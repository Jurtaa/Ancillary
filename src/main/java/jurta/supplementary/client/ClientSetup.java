package jurta.supplementary.client;

import jurta.supplementary.init.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class ClientSetup {
    public static void setupBlockRenderLayers() {
        RenderType renderType = RenderType.cutout();
        RenderTypeLookup.setRenderLayer(ModBlocks.BROCCOLI.get(), renderType);
        RenderTypeLookup.setRenderLayer(ModBlocks.CHERRY_BUSH.get(), renderType);
    }
}
