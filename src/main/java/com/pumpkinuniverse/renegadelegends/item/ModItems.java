package com.pumpkinuniverse.renegadelegends.item;

import com.pumpkinuniverse.renegadelegends.RenegadeLegends;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModItems {

    //DO FIRST
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RenegadeLegends.MOD_ID);

    public static final List<DeferredItem<? extends Item>> ITEM_LIST = new ArrayList<>();

    private static <T extends Item> DeferredItem<T> registerItem(String name, Supplier<T> supplier)
    {
        DeferredItem<T> item = ITEMS.register(name,supplier);
        ITEM_LIST.add(item);
        return item;
    }

    //ADD ITEMS
    public static final DeferredItem<Item> UNDEAD_CORE = registerItem("undead_core",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UNDEAD_VIAL = registerItem("undead_vial",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPIRIT_VIAL = registerItem("spirit_vial",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CORE_FRAME = registerItem("core_frame",
            () -> new Item(new Item.Properties()));


    //DO LAST
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
