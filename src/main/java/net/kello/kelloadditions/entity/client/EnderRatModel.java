package net.kello.kelloadditions.entity.client;

import net.kello.kelloadditions.KelloMod;
import net.kello.kelloadditions.entity.custom.EnderRatEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EnderRatModel extends GeoModel<EnderRatEntity> {
    @Override
    public ResourceLocation getModelResource(EnderRatEntity animatable) {
        return new ResourceLocation(KelloMod
                .MOD_ID, "geo/ender_rat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EnderRatEntity animatable) {
        return new ResourceLocation(KelloMod.MOD_ID, "textures/entity/ender_rat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EnderRatEntity animatable) {
        return new ResourceLocation(KelloMod.MOD_ID, "animations/ender_rat.animation.json");
    }

    @Override
    public void setCustomAnimations(EnderRatEntity animatable, long instanceId, AnimationState<EnderRatEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}