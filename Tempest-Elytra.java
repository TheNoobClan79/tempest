package oab.hacks.player;

import net.minecraft.client.Minecraft;

public class Elytra {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean fly = false;

	public static void run(boolean toggled) {
		if(toggled == true) {
			fly = true;
		} else {
			fly = false;
		}	
	}
}