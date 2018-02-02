package oab.hacks.render;


import net.minecraft.client.Minecraft;

public class Xray {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean xray = false;


	public static void run(boolean toggled) {
		if(toggled == true) {
			xray = true;
			Nocull.nocull = true;
			mc.renderGlobal.loadRenderers();
			mc.gameSettings.gammaSetting = 16F;
		} else {
			xray = false;
			Nocull.nocull = false;
			mc.renderGlobal.loadRenderers();
			
			if(!Fullbright.fullbright) {
				mc.gameSettings.gammaSetting = 0.7F;
			}
			
		}	
	}
}
