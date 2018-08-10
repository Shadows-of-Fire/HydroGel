package com.digitalfeonix.hydrogel.compat;

import java.util.List;

import com.digitalfeonix.hydrogel.HydroGel;
import com.digitalfeonix.hydrogel.block.BlockHydroGel;
import com.digitalfeonix.hydrogel.init.ModRegistry;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.api.WailaPlugin;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import shadows.placebo.Placebo;

@WailaPlugin
public class HwylaSux implements IWailaPlugin {

	@Override
	public void register(IWailaRegistrar reg) {
		reg.registerBodyProvider(new Provider(), BlockHydroGel.class);
	}
	
	private static class Provider implements IWailaDataProvider {
		
		@Override
		public List<String> getWailaBody(ItemStack stack, List<String> tip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
			tip.add(TextFormatting.WHITE + Placebo.PROXY.translate(ModRegistry.HYDROGEL.getTranslationKey() + ".name"));
			tip.add(TextFormatting.BLUE + TextFormatting.ITALIC.toString() + HydroGel.MODNAME);
			return tip;
		}
	}

}
