package com.digitalfeonix.hydrogel.compat;

import java.util.List;

import com.digitalfeonix.hydrogel.HydroGel;
import com.digitalfeonix.hydrogel.block.HydroGelBlock;

import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.IDataAccessor;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import mcp.mobius.waila.api.WailaPlugin;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

@WailaPlugin
public class HwylaSux implements IWailaPlugin {

	@Override
	public void register(IRegistrar reg) {
		reg.registerComponentProvider(new Provider(), TooltipPosition.HEAD, HydroGelBlock.class);
	}

	private static class Provider implements IComponentProvider {

		@Override
		public void appendHead(List<ITextComponent> tip, IDataAccessor accessor, IPluginConfig config) {
			tip.add(new TranslationTextComponent(HydroGel.HYDROGEL.getTranslationKey()).formatted(TextFormatting.WHITE));
		}
	}

}
