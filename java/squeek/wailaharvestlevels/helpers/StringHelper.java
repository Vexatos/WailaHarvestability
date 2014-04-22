package squeek.wailaharvestlevels.helpers;

import java.util.HashMap;
import squeek.wailaharvestlevels.ModWailaHarvestLevels;
import squeek.wailaharvestlevels.proxy.ProxyIguanaTweaks;
import net.minecraft.util.StatCollector;

public class StringHelper
{

	//private static DecimalFormat df = new DecimalFormat("##.##");

	// Taken from tconstruct.client.gui.ToolStationGui
	public static String getHarvestLevelName(int num)
	{
		if (ModWailaHarvestLevels.hasIguanaTweaks)
			return ProxyIguanaTweaks.getHarvestLevelName(num);
		
		String unlocalized = "gui.partcrafter.mining" + (num + 1);
		String localized = StringHelper.getLocalizedString(unlocalized);
		if (!unlocalized.equals(localized))
			return localized;
		else
			return String.valueOf(num);
	}

	// for TCon version < 1.5.3
	public static HashMap<String, String> localizationAlternatives = new HashMap<String, String>();
	static
	{
		localizationAlternatives.put("gui.partcrafter.mining1", "Stone");
		localizationAlternatives.put("gui.partcrafter.mining2", "Iron");
		localizationAlternatives.put("gui.partcrafter.mining3", "Redstone");
		localizationAlternatives.put("gui.partcrafter.mining4", "Obsidian");
		localizationAlternatives.put("gui.partcrafter.mining5", "Cobalt");
		localizationAlternatives.put("gui.partcrafter.mining6", "Atlarus");
		localizationAlternatives.put("gui.partcrafter.mining7", "7");
		localizationAlternatives.put("gui.partcrafter.mining8", "8");
		localizationAlternatives.put("gui.toolstation15", "Mining Level: ");
	}

	public static String getLocalizedString(String unlocalized)
	{
		if (unlocalized.equals("gui.partcrafter.mining6"))
			return localizationAlternatives.get(unlocalized);
			
		String localized = StatCollector.translateToLocal(unlocalized);
		if (localized.equals(unlocalized))
		{
			localized = localizationAlternatives.get(unlocalized);

			if (localized == null)
				localized = unlocalized;
		}
		return localized;
	}
}