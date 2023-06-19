package net.kello.kelloadditions.item;

import net.kello.kelloadditions.KelloMod;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
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


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}