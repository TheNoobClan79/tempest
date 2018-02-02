package oab.hacks.player;

import net.minecraft.client.Minecraft;

public class Sprint {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean sprint = false;


	public static void run(boolean toggled) {
		if(toggled == true) {
			sprint = true;
		} else {
			sprint = false;
		}	
	}
}
