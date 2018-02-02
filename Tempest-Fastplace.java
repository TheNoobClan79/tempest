package oab.hacks.world;

import net.minecraft.client.Minecraft;

public class Fastplace {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean fastplace = false;

	public static void run(boolean toggled) {
		if(toggled == true) {
			fastplace = true;
		} else {
			fastplace = false;
		}	
	}
}