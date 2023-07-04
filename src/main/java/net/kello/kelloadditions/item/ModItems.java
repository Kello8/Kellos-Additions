package net.kello.kelloadditions.item;

import net.kello.kelloadditions.KelloMod;
import net.kello.kelloadditions.block.ModBlocks;
import net.kello.kelloadditions.block.custom.QuickSandBlock;
import net.kello.kelloadditions.entity.ModEntities;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KelloMod.MOD_ID);

    public static final RegistryObject<Item> AMETHYST_CLOCK = ITEMS.register("amethyst_clock",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_BRUSH = ITEMS.register("diamond_brush",
            () -> new BrushItem(new Item.Properties().durability(512)));

    public static final RegistryObject<Item> RAT = ITEMS.register("rat",
            () -> new ForgeSpawnEggItem(ModEntities.RAT, 0x614023, 0x8f5d31,
                        new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ENDER_RAT = ITEMS.register("ender_rat",
            () -> new ForgeSpawnEggItem(ModEntities.ENDER_RAT, 0x614023, 0x8f5d31,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> RAT_TAIL = ITEMS.register("rat_tail",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAT_FUR = ITEMS.register("rat_fur",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SHULKER_SHARD = ITEMS.register("shulker_shard",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}