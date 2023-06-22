package net.kello.kelloadditions;

import com.mojang.logging.LogUtils;
import net.kello.kelloadditions.block.ModBlocks;
import net.kello.kelloadditions.entity.ModEntities;
import net.kello.kelloadditions.entity.client.RatRenderer;
import net.kello.kelloadditions.event.ModEvents;
import net.kello.kelloadditions.item.ModCreativeModeTabs;
import net.kello.kelloadditions.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.util.datafix.fixes.EntityRedundantChanceTagsFix;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(KelloMod.MOD_ID)
public class KelloMod {
    public static final String MOD_ID = "kellomod";
    private static final Logger LOGGER = LogUtils.getLogger();
     public KelloMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

         ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == ModCreativeModeTabs.KELLO_TAB.get()) {
            event.accept(ModItems.RAT);
            event.accept(ModItems.DIAMOND_BRUSH);

            event.accept(ModBlocks.QUICK_SAND);
            event.accept(ModBlocks.SUSPICIOUS_END_STONE);
            event.accept(ModBlocks.CHISELED_DARK_PRISMARINE_BRICKS);
            event.accept(ModBlocks.DARK_PRISMARINE_PILLAR);
            event.accept(ModBlocks.DARK_PRISMARINE_BRICKS);
            event.accept(ModBlocks.DARK_PRISMARINE_BRICK_STAIRS);
            event.accept(ModBlocks.DARK_PRISMARINE_BRICK_SLAB);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.RAT.get(), RatRenderer::new);
            
        }
    }
}
