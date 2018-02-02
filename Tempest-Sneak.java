package oab.hacks.player;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketEntityAction.Action;

public class Sneak {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean sneak = false;


	public static void run(boolean toggled) {
		if(toggled == true) {
			sneak = true;
		} else {
			sneak = false;
    		mc.player.connection.sendPacket(new CPacketEntityAction(
    				mc.player, Action.STOP_SNEAKING));
		}	
	}
}
