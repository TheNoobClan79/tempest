package oab.hacks.player;

import net.minecraft.client.Minecraft;

public class Step {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean step = false;


	public static void run(boolean toggled) {
		if(toggled == true) {
			step = true;
		} else {
			step = false;
		}	
	}
}
