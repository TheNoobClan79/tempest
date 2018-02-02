package oab.gui;

import java.lang.reflect.Method;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import oab.hacks.automation.AutoFish;
import oab.hacks.automation.AutoSwim;
import oab.hacks.automation.AutoTool;
import oab.hacks.player.Elytra;
import oab.hacks.player.Fly;
import oab.hacks.player.Jesus;
import oab.hacks.player.Longjump;
import oab.hacks.player.Nofall;
import oab.hacks.player.Sneak;
import oab.hacks.player.Speed;
import oab.hacks.player.Sprint;
import oab.hacks.player.Step;
import oab.hacks.render.ESP;
import oab.hacks.render.Fullbright;
import oab.hacks.render.Nocull;
import oab.hacks.render.Nohand;
import oab.hacks.render.Xray;
import oab.hacks.world.Fastplace;
import oab.hacks.world.Nuker;

public class ClientHacks {

	public boolean[] var;
	public ArrayList hackNames;
	public ArrayList enabledHacks;
	public GuiHandler handler;
	public Minecraft mc;
	
	public ClientHacks(Minecraft mc)
	{
		handler = new GuiHandler(mc, this);
		
		hackNames = new ArrayList();
		hackNames.add("fullbright");
		hackNames.add("xray");
		hackNames.add("nocull");
		hackNames.add("disableAll");
		hackNames.add("esp");
		hackNames.add("espmobs");
		hackNames.add("nohand");
		hackNames.add("sprint");
		hackNames.add("step");
		hackNames.add("speed");
		hackNames.add("fly");
		hackNames.add("jesus");
		hackNames.add("nofall");
		hackNames.add("sneak");
		hackNames.add("longjump");
		hackNames.add("autoswim");
		hackNames.add("autofish");
		hackNames.add("autotool");
		hackNames.add("fastplace");
		hackNames.add("nuker");
		hackNames.add("elytra");
		
		var = new boolean[256];
		
		for (int i = 0; i < hackNames.size(); i++)
		{
			var[i]=false;
		}
		
		enabledHacks = new ArrayList();
	}
	
	public void runHack(String hack, Boolean toggled) {
		switch (hack) {
		  case "fullbright": Fullbright.run(toggled); break;
		  case "xray": Xray.run(toggled); break;
		  case "nocull": Nocull.run(toggled); break;
		  case "esp": ESP.run(toggled); break;
		  case "espmobs": ESP.runMobs(toggled); break;
		  case "nohand": Nohand.run(toggled); break;
		  case "sprint": Sprint.run(toggled); break;
		  case "step": Step.run(toggled); break;
		  case "speed": Speed.run(toggled); break;
		  case "fly": Fly.run(toggled); break;
		  case "jesus": Jesus.run(toggled); break;
		  case "nofall": Nofall.run(toggled); break;
		  case "sneak": Sneak.run(toggled); break;
		  case "longjump": Longjump.run(toggled); break;
		  case "autoswim": AutoSwim.run(toggled); break;
		  case "autofish": AutoFish.run(toggled); break;
		  case "autotool": AutoTool.run(toggled); break;
		  case "fastplace": Fastplace.run(toggled); break;
		  case "nuker": Nuker.run(toggled); break;
		  case "elytra": Elytra.run(toggled); break;
		  default: break;
		}
	}
	
	public void drawGui(FontRenderer fr)
	{
		handler.gui.drawGui(fr);
	}
	
	public void drawEnabled(FontRenderer fr)
	{
		handler.gui.drawEnabled(fr);
	}
	
	private boolean isOn(String hack)
	{
		for (int i = 0; i < hackNames.size(); i++)
		{
			if (hackNames.get(i).equals(hack))
			{
				return var[i];
			}
		}
		System.out.println("The hack \""+hack+"\" does not exist.");
		return false;
	}

	public void toggleVar(String hack)
	{
		for (int i = 0; i < hackNames.size(); i++)
		{
			if (hackNames.get(i).equals(hack))
			{
				var[i]=!var[i];
				if(var[i] == true){
					runHack(hack, true);
				} else if (var[i] == false) {
					runHack(hack, false);
				}
				relistEnabled();
				return;
			}
		}
		System.out.println("The hack \""+hack+"\" does not exist.");
	}
	

	public void executeHack(String hack)
	{
		if (hack.equals("disableAll"))
		{
			for (int i = 0; i < hackNames.size(); i++)
			{
				var[i]=false;
				runHack((String)hackNames.get(i), false);
			}
			relistEnabled();
		}
	}
	
	public void relistEnabled()
	{
		enabledHacks.clear();
		for (int i = 0; i < hackNames.size(); i++)
		{
			String name = (String)hackNames.get(i);
			ArrayList tabsList = handler.gui.tabsList;
			for (int i2 = 0; i2 < tabsList.size(); i2++)
			{
				GuiTab tab = (GuiTab)tabsList.get(i2);
				for (int i3 = 0; i3 < tab.hacks.size(); i3++)
				{
					ItemHack item = (ItemHack)tab.hacks.get(i3);
					if (isOn(item.hack))
					{
						if (!enabledHacks.contains(item.text)) enabledHacks.add(item.text);
					}
				}
			}
		}
	}
	
	
}
