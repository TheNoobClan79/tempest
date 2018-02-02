package oab.hacks.automation;


import net.minecraft.client.Minecraft;

public class AutoFish {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean autofish = false;

	public static void run(boolean toggled) {
		if(toggled == true) {
			autofish = true;
		} else {
			autofish = false;
		}	
	}
}