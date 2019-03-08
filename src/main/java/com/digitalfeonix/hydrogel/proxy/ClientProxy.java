package com.digitalfeonix.hydrogel.proxy;

import com.digitalfeonix.hydrogel.HydroGel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shadows.placebo.client.IHasModel;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onModelRegister(ModelRegistryEvent e) {
		for (Block b : HydroGel.INFO.getBlockList())
			if (b instanceof IHasModel) ((IHasModel) b).initModels(e);
		for (Item i : HydroGel.INFO.getItemList())
			if (i instanceof IHasModel) ((IHasModel) i).initModels(e);
	}
}