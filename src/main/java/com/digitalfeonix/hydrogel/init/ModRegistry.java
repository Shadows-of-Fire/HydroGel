package com.digitalfeonix.hydrogel.init;

import com.digitalfeonix.hydrogel.HydroGel;
import com.digitalfeonix.hydrogel.block.BlockHydroGel;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModRegistry {

	public static final BlockHydroGel HYDROGEL = new BlockHydroGel();
	
	@SubscribeEvent
	public void onBlockRegister(Register<Block> event) {
		event.getRegistry().registerAll(HydroGel.INFO.getBlockList().toArray(new Block[0]));
	}

	@SubscribeEvent
	public void onItemRegister(Register<Item> event) {
		event.getRegistry().registerAll(HydroGel.INFO.getItemList().toArray(new Item[0]));
	}

	@SubscribeEvent
	public void onRecipeRegister(Register<IRecipe> event) {
		HydroGel.HELPER.addShaped(HYDROGEL, 3, 3, Blocks.IRON_BARS, Items.SLIME_BALL, Blocks.IRON_BARS, Items.SLIME_BALL, Items.WATER_BUCKET, Items.SLIME_BALL, Blocks.IRON_BARS, Items.SLIME_BALL, Blocks.IRON_BARS);
		event.getRegistry().registerAll(HydroGel.INFO.getRecipeList().toArray(new IRecipe[0]));
	}

	@SubscribeEvent
	public void onBucketUse(FillBucketEvent event) {
		if (event.getTarget() != null && event.getTarget().typeOfHit == RayTraceResult.Type.BLOCK && event.getWorld().getBlockState(event.getTarget().getBlockPos()).getBlock() instanceof BlockHydroGel) event.setCanceled(true);
	}
}
