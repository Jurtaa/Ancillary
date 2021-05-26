package jurta.supplementary.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import jurta.supplementary.tileentity.ModSignTileEntity;
import net.minecraft.block.*;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class SignRenderer extends TileEntityRenderer<ModSignTileEntity> {
    /**
     * The ModelSign instance for use in this renderer
     */
    private final SignModel model = new SignModel();

    public SignRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(ModSignTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        BlockState blockstate = tileEntityIn.getBlockState();
        matrixStackIn.pushPose();
        float f = 0.6666667F;
        if (blockstate.getBlock() instanceof StandingSignBlock) {
            matrixStackIn.translate(0.5D, 0.5D, 0.5D);
            float f1 = -((float) (blockstate.getValue(StandingSignBlock.ROTATION) * 360) / 16.0F);
            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(f1));
            this.model.stick.visible = true;
        } else {
            matrixStackIn.translate(0.5D, 0.5D, 0.5D);
            float f4 = -blockstate.getValue(WallSignBlock.FACING).toYRot();
            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(f4));
            matrixStackIn.translate(0.0D, -0.3125D, -0.4375D);
            this.model.stick.visible = false;
        }

        matrixStackIn.pushPose();
        matrixStackIn.scale(0.6666667F, -0.6666667F, -0.6666667F);
        RenderMaterial rendermaterial = getMaterial(blockstate.getBlock());
        IVertexBuilder ivertexbuilder = rendermaterial.buffer(bufferIn, this.model::renderType);
        this.model.sign.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
        this.model.stick.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
        matrixStackIn.popPose();
        FontRenderer fontrenderer = this.renderer.getFont();
        float f2 = 0.010416667F;
        matrixStackIn.translate(0.0D, (double) 0.33333334F, (double) 0.046666667F);
        matrixStackIn.scale(0.010416667F, -0.010416667F, 0.010416667F);
        int i = tileEntityIn.getColor().getTextColor();
        double d0 = 0.4D;
        int j = (int) ((double) NativeImage.getR(i) * 0.4D);
        int k = (int) ((double) NativeImage.getG(i) * 0.4D);
        int l = (int) ((double) NativeImage.getB(i) * 0.4D);
        int i1 = NativeImage.combine(0, l, k, j);
        int j1 = 20;

        for (int k1 = 0; k1 < 4; ++k1) {
            IReorderingProcessor ireorderingprocessor = tileEntityIn.getRenderMessage(k1, (p_243502_1_) -> {
                List<IReorderingProcessor> list = fontrenderer.split(p_243502_1_, 90);
                return list.isEmpty() ? IReorderingProcessor.EMPTY : list.get(0);
            });
            if (ireorderingprocessor != null) {
                float f3 = (float) (-fontrenderer.width(ireorderingprocessor) / 2);
                fontrenderer.drawInBatch(ireorderingprocessor, f3, (float) (k1 * 10 - 20), i1, false, matrixStackIn.last().pose(), bufferIn, false, 0, combinedLightIn);
            }
        }

        matrixStackIn.popPose();
    }

    public static RenderMaterial getMaterial(Block blockIn) {
        WoodType woodtype;
        if (blockIn instanceof AbstractSignBlock) {
            woodtype = ((AbstractSignBlock) blockIn).type();
        } else {
            woodtype = WoodType.OAK;
        }
        return Atlases.signTexture(woodtype);
    }

    @OnlyIn(Dist.CLIENT)
    public static final class SignModel extends Model {
        public final ModelRenderer sign = new ModelRenderer(64, 32, 0, 0);
        public final ModelRenderer stick;

        public SignModel() {
            super(RenderType::entityCutoutNoCull);
            this.sign.addBox(-12.0F, -14.0F, -1.0F, 24.0F, 12.0F, 2.0F, 0.0F);
            this.stick = new ModelRenderer(64, 32, 0, 14);
            this.stick.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 14.0F, 2.0F, 0.0F);
        }

        public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
            this.sign.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            this.stick.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
    }
}
