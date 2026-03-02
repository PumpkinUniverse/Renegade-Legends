package com.pumpkinuniverse.renegadelegends;

import com.pumpkinuniverse.renegadelegends.block.ModBlocks;
import com.pumpkinuniverse.renegadelegends.item.ModCreativeModeTabs;
import com.pumpkinuniverse.renegadelegends.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(RenegadeLegends.MOD_ID)
public class RenegadeLegends {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "renegadelegends";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public RenegadeLegends(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (RenegadeLegends) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        //NeoForge.EVENT_BUS.register(this);

        //Register Mod Items
        ModItems.register(modEventBus);
        //Register Mod Blocks
        ModBlocks.register(modEventBus);
        //Register Creative Mode Tab
        ModCreativeModeTabs.register(modEventBus);

        LOGGER.info("Larry Watches");
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    /*
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }
    */
}
