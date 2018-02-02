package oab.hacks.player;

import net.minecraft.client.Minecraft;

public class Jesus {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean jesus = false;


	public static void run(boolean toggled) {
		if(toggled == true) {
			jesus = true;
		} else {
			jesus = false;
		}	
	}
}
