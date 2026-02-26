package com.pumpkinuniverse.renegadelegends.item;

import com.pumpkinuniverse.renegadelegends.RenegadeLegends;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    //DO FIRST
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RenegadeLegends.MOD_ID);

    //ADD ITEMS
    public static final DeferredItem<Item> UNDEAD_CORE = ITEMS.register("undead_core",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UNDEAD_VIAL = ITEMS.register("undead_vial",
            () -> new Item(new Item.Properties()));


    //DO LAST
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
