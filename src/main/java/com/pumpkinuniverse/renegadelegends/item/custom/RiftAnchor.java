package com.pumpkinuniverse.renegadelegends.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;


public class RiftAnchor extends Item {
    public RiftAnchor(Properties properties) {
        super(properties);
    }

    public Map<ResourceLocation,BlockPos> dimensionalCoordinates = new HashMap<>();

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                dimensionalCoordinates.put(level.dimension().location(),hitResult.getBlockPos());

            }
            else if (player.isCrouching() && dimensionalCoordinates.containsKey(level.dimension().location())) {
                dimensionalCoordinates.remove(level.dimension().location());
            }
            else if (dimensionalCoordinates.containsKey(level.dimension().location())) {

                player.teleportTo(dimensionalCoordinates.get(level.dimension().location()).getX(),
                        dimensionalCoordinates.get(level.dimension().location()).getY() + 1,dimensionalCoordinates.get(level.dimension().location()).getZ());
                dimensionalCoordinates.remove(level.dimension().location());
                //player.sendSystemMessage(Component.literal(dimensionalCoordinates.toString()));
            }

        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

}
