package com.pumpkinuniverse.renegadelegends.block;

import com.pumpkinuniverse.renegadelegends.RenegadeLegends;
import com.pumpkinuniverse.renegadelegends.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {

    //DO FIRST
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RenegadeLegends.MOD_ID);

    public static final List<DeferredBlock<? extends Block>> BLOCK_LIST = new ArrayList<>();
    //REGISTER BLOCK AS BLOCK
    private static <T extends Block> DeferredBlock<T> registerBlock (String name, Supplier<T> supplier) {
        DeferredBlock<T> block = BLOCKS.register(name, supplier);
        registerBlockItem(name,block);
        BLOCK_LIST.add(block);
        return block;
    }

    //ADD BLOCKS
    public static final DeferredBlock<Block> DUNGEON_BRICKS = registerBlock("dungeon_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE_BRICKS)
                    .strength(-1,3600000)
            ));
    public static final DeferredBlock<Block> CRACKED_DUNGEON_BRICKS = registerBlock("cracked_dungeon_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE_BRICKS)
                    .strength(-1,3600000)
            ));
    public static final DeferredBlock<Block> DREADSHALE = registerBlock("dreadshale",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()
                    .strength(2,10)
                    .lightLevel(p_50872_ -> 5)
            ));
    public static final DeferredBlock<Block> NEXUS_STONE_ORE = registerBlock("nexus_stone_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()
                    .strength(2,10)
                    .lightLevel(p_50872_ -> 7)
            ));
    public static final DeferredBlock<Block> NEXUS_DREADSHALE_ORE = registerBlock("nexus_dreadshale_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()
                    .strength(2,10)
                    .lightLevel(p_50872_ -> 7)
            ));
    public static final DeferredBlock<Block> NEXUS_DEEPSLATE_ORE = registerBlock("nexus_deepslate_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()
                    .strength(2,10)
                    .lightLevel(p_50872_ -> 7)
            ));
    public static final DeferredBlock<Block> NEXUS_STONE = registerBlock("nexus_stone",
            () -> new NexusStone(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .strength(-1,3600000)));

    //REGISTER BLOCKS AS ITEMS
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    //DO LAST
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
