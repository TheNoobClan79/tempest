package oab.hacks.player;

import net.minecraft.client.Minecraft;

public class Nofall {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean nofall = false;


	public static void run(boolean toggled) {
		if(toggled == true) {
			nofall = true;
		} else {
			nofall = false;
		}	
	}
}
