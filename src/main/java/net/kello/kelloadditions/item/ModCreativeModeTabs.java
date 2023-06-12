package net.kello.kelloadditions.item;

import net.kello.kelloadditions.KelloMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = KelloMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab KELLO_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        KELLO_TAB = event.registerCreativeModeTab(new ResourceLocation(KelloMod.MOD_ID, "kellos_additions_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.AMETHYST_CLOCK.get()))
                        .title(Component.translatable("creativemodetab.kellos_additions_tab")));
    }
}