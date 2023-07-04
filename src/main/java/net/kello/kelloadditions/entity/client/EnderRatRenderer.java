package net.kello.kelloadditions.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kello.kelloadditions.KelloMod;
import net.kello.kelloadditions.entity.custom.EnderRatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EnderRatRenderer extends GeoEntityRenderer<EnderRatEntity> {
    public EnderRatRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EnderRatModel());
    }

    @Override
    public ResourceLocation getTextureLocation(EnderRatEntity animatable) {
        return new ResourceLocation(KelloMod.MOD_ID, "textures/entity/ender_rat.png");
    }

    @Override
    public void render(EnderRatEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}