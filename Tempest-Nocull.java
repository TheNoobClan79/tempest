package oab.hacks.render;


import net.minecraft.client.Minecraft;

public class Nocull {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean nocull = false;


	public static void run(boolean toggled) {
		if(toggled == true) {
			nocull = true;
			mc.renderGlobal.loadRenderers();
		} else {
			nocull = false;
			mc.renderGlobal.loadRenderers();
		}	
	}
}
