package oab.hacks.player;

import net.minecraft.client.Minecraft;

public class Longjump {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean longjump = false;


	public static void run(boolean toggled) {
		if(toggled == true) {
			longjump = true;
		} else {
			longjump = false;
		}	
	}
}
