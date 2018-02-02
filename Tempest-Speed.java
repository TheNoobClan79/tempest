package oab.hacks.player;

import net.minecraft.client.Minecraft;

public class Speed {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean speed = false;


	public static void run(boolean toggled) {
		if(toggled == true) {
			speed = true;
		} else {
			speed = false;
		}	
	}
}
