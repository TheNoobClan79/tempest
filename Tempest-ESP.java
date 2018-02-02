package oab.hacks.render;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;

public class ESP {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static boolean esp = false;
	public static boolean espmobs = false;

	public static void run(boolean toggled) {
		if(toggled == true) {
			esp = true;
			Nocull.nocull = true;
		} else {
			esp = false;
			Nocull.nocull = false;
            Minecraft.getMinecraft();
            for (Object o : mc.world.loadedEntityList) {
                if (!(o instanceof EntityPlayer)) continue;
                Entity e = (Entity)o;
                e.setGlowing(false);
            }
		}	
	}
	
	public static void runMobs(boolean toggled) {
		if(toggled == true) {
			espmobs = true;
			Nocull.nocull = true;
		} else {
			espmobs = false;
			Nocull.nocull = false;
            Minecraft.getMinecraft();
            for (Object o : mc.world.loadedEntityList) {
            	if ((o instanceof EntityPlayer)) continue;
                Entity e = (Entity)o;
                e.setGlowing(false);
            }
		}	
	}
}