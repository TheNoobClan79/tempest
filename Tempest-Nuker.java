package oab.hacks.world;

import net.minecraft.client.Minecraft;

public class Nuker {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean nuker = false;

	public static void run(boolean toggled) {
		if(toggled == true) {
			nuker = true;
		} else {
			nuker = false;
		}	
	}
}