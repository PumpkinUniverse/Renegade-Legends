package com.pumpkinuniverse.renegadelegends.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class NexusStone extends Block {
    public NexusStone(Properties properties) {
        super(properties);
    }

    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos blockPos, Player player, BlockHitResult hitResult){

        player.teleportTo(0,0,0);

        return InteractionResult.SUCCESS;
    }
}
