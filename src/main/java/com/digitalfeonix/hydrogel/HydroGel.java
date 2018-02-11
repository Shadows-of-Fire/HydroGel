package com.digitalfeonix.hydrogel;

import com.digitalfeonix.hydrogel.init.ModRegistry;
import com.digitalfeonix.hydrogel.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import shadows.placebo.registry.RegistryInformation;
import shadows.placebo.util.RecipeHelper;

@Mod(modid = HydroGel.MODID, version = HydroGel.VERSION, name = HydroGel.MODNAME, dependencies = "required-after:placebo@[1.1.2,)")
public class HydroGel {
	public static final String MODID = "hydrogel";
	public static final String MODNAME = "HydroGel";
	public static final String VERSION = "1.1.0";

	@SidedProxy(serverSide = "com.digitalfeonix.hydrogel.proxy.CommonProxy", clientSide = "com.digitalfeonix.hydrogel.proxy.ClientProxy")
	public static CommonProxy proxy;

	public static final RegistryInformation INFO = new RegistryInformation(MODID, CreativeTabs.BUILDING_BLOCKS);
	public static final RecipeHelper HELPER = new RecipeHelper(MODID, MODNAME, INFO.getRecipeList());

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(new ModRegistry());
		proxy.preInit(e);
	}
}
