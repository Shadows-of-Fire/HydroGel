package com.digitalfeonix.hydrogel;

import com.digitalfeonix.hydrogel.block.BlockHydroGel;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import shadows.placebo.Placebo;
import shadows.placebo.item.ItemBlockBase;
import shadows.placebo.util.PlaceboUtil;
import shadows.placebo.util.RecipeHelper;

@Mod(modid = HydroGel.MODID, version = HydroGel.VERSION, name = HydroGel.MODNAME, dependencies = "required-after:placebo@[2.0.0,)")
public class HydroGel extends RecipeHelper {

	public static final String MODID = "hydrogel";
	public static final String MODNAME = "HydroGel";
	public static final String VERSION = "2.0.0";

	@ObjectHolder("hydrogel:hydrogel")
	public static final BlockHydroGel HYDROGEL = new BlockHydroGel();

	public HydroGel() {
		super(MODID, MODNAME);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void blocks(Register<Block> e) {
		e.getRegistry().register(PlaceboUtil.initBlock(HYDROGEL, MODID, "hydrogel", 1, 1));
	}

	@SubscribeEvent
	public void items(Register<Item> e) {
		e.getRegistry().register(new ItemBlockBase(HYDROGEL));
	}

	@Override
	public void addRecipes() {
		addShaped(HYDROGEL, 3, 3, Blocks.IRON_BARS, Items.SLIME_BALL, Blocks.IRON_BARS, Items.SLIME_BALL, Items.WATER_BUCKET, Items.SLIME_BALL, Blocks.IRON_BARS, Items.SLIME_BALL, Blocks.IRON_BARS);
	}

	@SubscribeEvent
	public void onBucketUse(FillBucketEvent event) {
		if (event.getTarget() != null && event.getTarget().typeOfHit == RayTraceResult.Type.BLOCK && event.getWorld().getBlockState(event.getTarget().getBlockPos()).getBlock() instanceof BlockHydroGel) event.setCanceled(true);
	}

	@SubscribeEvent
	public void models(ModelRegistryEvent e) {
		Placebo.PROXY.useRenamedMapper(HYDROGEL, "hydrogel", "", "normal");
		PlaceboUtil.sMRL(HYDROGEL, 0, "normal");
	}
}
