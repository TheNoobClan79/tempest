package oab.hacks.player;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketPlayer;

public class Fly {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean fly = false;


	public static void run(boolean toggled) {
		if(toggled == true) {
			double startX = mc.player.posX;
			double startY = mc.player.posY;
			double startZ = mc.player.posZ;
			
			for(int i = 0; i < 4; i++)
			{
				mc.player.connection.sendPacket(new CPacketPlayer.Position(startX,
					startY + 1.01, startZ, false));
				mc.player.connection.sendPacket(
					new CPacketPlayer.Position(startX, startY, startZ, false));
			}
			
			fly = true;
		} else {
			fly = false;
		}	
	}
}
