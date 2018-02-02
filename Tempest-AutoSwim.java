package oab.hacks.automation;


import net.minecraft.client.Minecraft;

public class AutoSwim {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean autoswim = false;

	public static void run(boolean toggled) {
		if(toggled == true) {
			autoswim = true;
		} else {
			autoswim = false;
		}	
	}
}