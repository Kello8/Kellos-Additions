package net.kello.kelloadditions.event;

import net.kello.kelloadditions.KelloMod;
import net.kello.kelloadditions.entity.ModEntities;
import net.kello.kelloadditions.entity.custom.RatEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = KelloMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RAT.get(), RatEntity.setAttributes());
    }
}