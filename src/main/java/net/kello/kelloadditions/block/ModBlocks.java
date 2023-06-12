package net.kello.kelloadditions.block;

import net.kello.kelloadditions.KelloMod;
import net.kello.kelloadditions.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, KelloMod.MOD_ID);

    public static final RegistryObject<Block> CHISELED_DARK_PRISMARINE_BRICKS = registerBlock("chiseled_dark_prismarine_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.0f).explosionResistance(30).lightLevel((state) -> 15).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DARK_PRISMARINE_PILLAR = registerBlock("dark_prismarine_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.7f).explosionResistance(30).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DARK_PRISMARINE_BRICKS = registerBlock("dark_prismarine_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.7f).explosionResistance(30).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DARK_PRISMARINE_BRICK_STAIRS = registerBlock("dark_prismarine_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.DARK_PRISMARINE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(1.7f).explosionResistance(30).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DARK_PRISMARINE_BRICK_SLAB = registerBlock("dark_prismarine_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.7f).explosionResistance(30).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
