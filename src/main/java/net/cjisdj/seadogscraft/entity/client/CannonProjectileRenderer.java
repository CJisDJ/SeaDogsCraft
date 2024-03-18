package net.cjisdj.seadogscraft.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.entity.custom.CannonProjectileEntity;
import net.cjisdj.seadogscraft.entity.custom.MagicProjectileEntity;
import net.cjisdj.seadogscraft.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CannonProjectileRenderer extends EntityRenderer<CannonProjectileEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(SeaDogsCraft.MOD_ID, "textures/entity/cannonball.png");
    protected CannonProjectileModel model;

    public CannonProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new CannonProjectileModel(pContext.bakeLayer(ModModelLayers.CANNON_PROJECTILE_LAYER));
        this.shadowRadius = 0.5f;
    }

    public void render(CannonProjectileEntity entity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, entity.yRotO, entity.getYRot()) - 90.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTick, entity.xRotO, entity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(entity)), false, false);

        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1f, 0f, 0f, 1f);
        pPoseStack.popPose();
        super.render(entity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }


    @Override
    public ResourceLocation getTextureLocation(CannonProjectileEntity pEntity) {
        return TEXTURE;
    }
}