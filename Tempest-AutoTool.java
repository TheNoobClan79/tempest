package oab.hacks.automation;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class AutoTool {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean autotool = false;
	
	public static BlockPos blockPos;
	public static EnumFacing enumFacing;
	
	public static EntityPlayer sourceEntity;
	public static Entity targetEntity;

	public static void run(boolean toggled) {
		if(toggled == true) {
			autotool = true;
		} else {
			autotool = false;
		}	
	}
}