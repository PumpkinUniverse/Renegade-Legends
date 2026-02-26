package com.pumpkinuniverse.renegadelegends.block;

import com.pumpkinuniverse.renegadelegends.RenegadeLegends;
import com.pumpkinuniverse.renegadelegends.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {

    //DO FIRST
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RenegadeLegends.MOD_ID);

    //ADD BLOCKS
    public static final DeferredBlock<Block> DUNGEON_BRICKS = registerBlock("dungeon_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE_BRICKS)));
    public static final DeferredBlock<Block> CRACKED_DUNGEON_BRICKS = registerBlock("cracked_dungeon_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE_BRICKS)));
    public static final DeferredBlock<Block> DREADSHALE = registerBlock("dreadshale",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE)));

    //REGISTER BLOCK AS BLOCK
    private static <T extends Block> DeferredBlock<T> registerBlock (String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    //REGISTER BLOCKS AS ITEMS
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    //DO LAST
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
