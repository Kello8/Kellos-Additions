package net.kello.kelloadditions.item;

import net.kello.kelloadditions.KelloMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KelloMod.MOD_ID);
    public static RegistryObject<CreativeModeTab> KELLO_TAB = CREATIVE_MODE_TABS.register("kello_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AMETHYST_CLOCK.get()))
                    .title(Component.translatable("creativemodetab.kello_tab")).build());

        public static void register(IEventBus eventBus) {
            CREATIVE_MODE_TABS.register(eventBus);
    }
}