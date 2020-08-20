package com.digitalfeonix.hydrogel;

import com.digitalfeonix.hydrogel.block.HydroGelBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;
import shadows.placebo.recipe.RecipeHelper;

@Mod(HydroGel.MODID)
public class HydroGel {

	public static final String MODID = "hydrogel";

	@ObjectHolder("hydrogel:hydrogel")
	public static final Block HYDROGEL = null;

	public HydroGel() {
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
		MinecraftForge.EVENT_BUS.addListener(this::onBucketUse);
	}

	@SubscribeEvent
	public void registerBlocks(Register<Block> e) {
		e.getRegistry().register(new HydroGelBlock().setRegistryName("hydrogel"));
	}

	@SubscribeEvent
	public void registerItem(Register<Item> e) {
		e.getRegistry().register(new BlockItem(HYDROGEL, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName("hydrogel"));
	}

	public void onBucketUse(FillBucketEvent event) {
		if (event.getTarget() instanceof BlockRayTraceResult && event.getWorld().getBlockState(((BlockRayTraceResult) event.getTarget()).getPos()).getBlock() == HYDROGEL) event.setCanceled(true);
	}

	@SubscribeEvent
	public void setup(FMLCommonSetupEvent e) {
		new RecipeHelper(MODID).addShaped(HYDROGEL, 3, 3, Blocks.IRON_BARS, Items.SLIME_BALL, Blocks.IRON_BARS, Items.SLIME_BALL, Items.WATER_BUCKET, Items.SLIME_BALL, Blocks.IRON_BARS, Items.SLIME_BALL, Blocks.IRON_BARS);
	}
}
