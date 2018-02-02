package oab.hacks.render;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAir;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;

public class Nohand {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean nohand = false;

	public static void run(boolean toggled) {
		if(toggled == true) {
			nohand = true;
		} else {
			nohand = false;
		}	
	}
}