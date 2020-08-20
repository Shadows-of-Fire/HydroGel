package com.digitalfeonix.hydrogel.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.PushReaction;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;

public class HydroGelBlock extends Block {

	public static final IntegerProperty LEVEL = FlowingFluidBlock.LEVEL;

	public HydroGelBlock() {
		super(Block.Properties.create(Material.WATER).hardnessAndResistance(1).sound(SoundType.SLIME));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(LEVEL);
	}

	@Override
	public boolean isReplaceable(BlockState state, BlockItemUseContext ctx) {
		return false;
	}

	@Override
	public PushReaction getPushReaction(BlockState state) {
		return PushReaction.NORMAL;
	}

	@Override
	public FluidState getFluidState(BlockState p_204507_1_) {
		return Fluids.WATER.getDefaultState();
	}

}
