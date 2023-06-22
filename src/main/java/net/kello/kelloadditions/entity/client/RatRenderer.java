package net.kello.kelloadditions.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kello.kelloadditions.KelloMod;
import net.kello.kelloadditions.entity.custom.RatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RatRenderer extends GeoEntityRenderer<RatEntity> {
    public RatRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RatModel());
    }

    @Override
    public ResourceLocation getTextureLocation(RatEntity animatable) {
        return new ResourceLocation(KelloMod.MOD_ID, "textures/entity/rat.png");
    }

    @Override
    public void render(RatEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}