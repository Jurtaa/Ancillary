package jurta.supplementary.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import jurta.supplementary.Supplementary;
import jurta.supplementary.entity.item.ModBoatEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BoatModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class ModBoatRenderer extends EntityRenderer<ModBoatEntity> {
    private static final ResourceLocation[] BOAT_TEXTURE_LOCATIONS = new ResourceLocation[]{new ResourceLocation(Supplementary.MOD_ID, "textures/entity/boat/sakura.png")};
    protected final BoatModel model = new BoatModel();

    public ModBoatRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn);
        this.shadowRadius = 0.8F;
    }

    public void render(ModBoatEntity entity, float v, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int uv) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, 0.375D, 0.0D);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - v));
        float f = (float)entity.getHurtTime() - partialTicks;
        float f1 = entity.getDamage() - partialTicks;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f > 0.0F) {
            matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(MathHelper.sin(f) * f * f1 / 10.0F * (float)entity.getHurtDir()));
        }

        float f2 = entity.getBubbleAngle(partialTicks);
        if (!MathHelper.equal(f2, 0.0F)) {
            matrixStackIn.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), entity.getBubbleAngle(partialTicks), true));
        }

        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        this.model.setupAnim(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.model.renderType(this.getTextureLocation(entity)));
        this.model.renderToBuffer(matrixStackIn, ivertexbuilder, uv, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!entity.isUnderWater()) {
            IVertexBuilder ivertexbuilder1 = bufferIn.getBuffer(RenderType.waterMask());
            this.model.waterPatch().render(matrixStackIn, ivertexbuilder1, uv, OverlayTexture.NO_OVERLAY);
        }

        matrixStackIn.popPose();
        super.render(entity, v, partialTicks, matrixStackIn, bufferIn, uv);
    }

    public ResourceLocation getTextureLocation(ModBoatEntity entity) {
        return BOAT_TEXTURE_LOCATIONS[entity.getBoatType().ordinal()];
    }
}
