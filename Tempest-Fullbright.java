package oab.hacks.render;

import net.minecraft.client.Minecraft;

public class Fullbright {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	public static boolean fullbright = false;

	public static void run(boolean toggled) {
		if(toggled == true) {
			fullbright = true;
			if (mc.gameSettings.gammaSetting <= 16F)
			{
				mc.gameSettings.gammaSetting = 16F;
			}
		} else {
			fullbright = false;
			if (mc.gameSettings.gammaSetting >= 0.7F)
			{
				mc.gameSettings.gammaSetting = 0.7F;
			}
		}	
	}
}
