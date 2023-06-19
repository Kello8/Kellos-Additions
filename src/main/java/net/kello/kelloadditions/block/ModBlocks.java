package net.kello.kelloadditions.block;

import net.kello.kelloadditions.KelloMod;
import net.kello.kelloadditions.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, KelloMod.MOD_ID);

    public static final RegistryObject<Block> CHISELED_DARK_PRISMARINE_BRICKS = registerBlock("chiseled_dark_prismarine_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_PRISMARINE)
                    .strength(2.0f).explosionResistance(30).lightLevel((state) -> 15).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DARK_PRISMARINE_PILLAR = registerBlock("dark_prismarine_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DARK_PRISMARINE)
                    .strength(1.7f).explosionResistance(30).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DARK_PRISMARINE_BRICKS = registerBlock("dark_prismarine_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_PRISMARINE)
                    .strength(1.7f).explosionResistance(30).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DARK_PRISMARINE_BRICK_STAIRS = registerBlock("dark_prismarine_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.DARK_PRISMARINE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DARK_PRISMARINE).strength(1.7f).explosionResistance(30).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DARK_PRISMARINE_BRICK_SLAB = registerBlock("dark_prismarine_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DARK_PRISMARINE)
                    .strength(1.7f).explosionResistance(30).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SUSPICIOUS_END_STONE = registerBlock("suspicious_end_stone",
            () -> new BrushableBlock(Blocks.END_STONE, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).strength(3F, 9F).sound(SoundType.STONE).pushReaction(PushReaction.DESTROY), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));

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
