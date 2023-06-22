package net.kello.kelloadditions.entity;

import net.kello.kelloadditions.KelloMod;
import net.kello.kelloadditions.entity.custom.RatEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, KelloMod.MOD_ID);

    public static final RegistryObject<EntityType<RatEntity>> RAT =
            ENTITY_TYPES.register("rat",
                    () -> EntityType.Builder.of(RatEntity::new, MobCategory.CREATURE)
                            .sized(0.6f, 0.3f)
                            .build(new ResourceLocation(KelloMod.MOD_ID, "rat").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}