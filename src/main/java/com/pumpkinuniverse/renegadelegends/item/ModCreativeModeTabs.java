package com.pumpkinuniverse.renegadelegends.item;

import com.pumpkinuniverse.renegadelegends.RenegadeLegends;
import com.pumpkinuniverse.renegadelegends.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RenegadeLegends.MOD_ID);


    public static final Supplier<CreativeModeTab> RENEGADE_LEGENDS_TAB = CREATIVE_MODE_TAB.register("renegade_legends_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.DUNGEON_BRICKS))
                    .title(Component.translatable("creativetab.renegadelegends.renegade_legends"))
                    .displayItems((itemDisplayParameters, output) ->
                    {
                        for (var item : ModItems.ITEM_LIST)
                        {
                            output.accept(item);
                        }
                        for (var block : ModBlocks.BLOCK_LIST)
                        {
                            output.accept(block);
                        }
                        ModItems.ITEM_LIST.clear();
                        ModBlocks.BLOCK_LIST.clear();
                    })

                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
