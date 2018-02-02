package oab.gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class GuiClient {

	public String clientName = "Tempest";
	public String clientVersion = "ITS A BETA TEST DAMNIT!";
	
	public String colorNormal = "\247f";
	public String colorHighlight = "\247a";
	
	public int colorBorder = 0x20FFFFFF;
	public int colorBody = 0x99000000;
	
	public int guiWidth = 150;
	public int guiHeight = 0;
	public int tabHeight = 12;
	
	public int selectedTab = 0;
	public int selectedItem = 0;
	public boolean mainMenu = true;
	
	public ArrayList tabsList;
	private Minecraft mc;
	public ClientHacks ch;
	
	public GuiClient(ClientHacks ch, Minecraft minecraft)
	{
		mc = minecraft;
		this.ch=ch;
		tabsList = new ArrayList();
		
		// Player Tab
		GuiTab tabPlayer = new GuiTab(this,"Player");
		tabPlayer.hacks.add(new ItemHack("Sprint","sprint",true,ch));
		tabPlayer.hacks.add(new ItemHack("Step","step",true,ch));
		tabPlayer.hacks.add(new ItemHack("Speed","speed",true,ch));
		tabPlayer.hacks.add(new ItemHack("Fly","fly",true,ch));
		tabPlayer.hacks.add(new ItemHack("Jesus","jesus",true,ch));
		tabPlayer.hacks.add(new ItemHack("Nofall","nofall",true,ch));
		tabPlayer.hacks.add(new ItemHack("Sneak","sneak",true,ch));
		tabPlayer.hacks.add(new ItemHack("Longjump","longjump",true,ch));
		tabPlayer.hacks.add(new ItemHack("Elytra Fly","elytra",true,ch));
		
		tabsList.add(tabPlayer);
		
		// Render Tab
		GuiTab tabRender = new GuiTab(this,"Render");
		tabRender.hacks.add(new ItemHack("Fullbright","fullbright",true,ch));
		tabRender.hacks.add(new ItemHack("X-Ray","xray",true,ch));
		tabRender.hacks.add(new ItemHack("ESP (Players)","esp",true,ch));
		tabRender.hacks.add(new ItemHack("ESP (Mobs)","espmobs",true,ch));
		tabRender.hacks.add(new ItemHack("No-Hand","nohand",true,ch));
		
		tabsList.add(tabRender);
		
		// World Tab
		GuiTab tabWorld = new GuiTab(this,"World");
		tabWorld.hacks.add(new ItemHack("Fastplace","fastplace",true,ch));
		tabWorld.hacks.add(new ItemHack("Nuker","nuker",true,ch));
		
		tabsList.add(tabWorld);
		
		// Automation Tab
		GuiTab tabAuto = new GuiTab(this,"Automation");
		tabAuto.hacks.add(new ItemHack("AutoSwim", "autoswim", true, ch));
		tabAuto.hacks.add(new ItemHack("AutoFish", "autofish", true, ch));
		tabAuto.hacks.add(new ItemHack("AutoTool", "autotool", true, ch));
		
		tabsList.add(tabAuto);

		// Client Tab
		GuiTab tabClient = new GuiTab(this,"Client");
		tabClient.hacks.add(new ItemHack("Disable All", "disableAll", false, ch));
		
		tabsList.add(tabClient);
		
		
		guiHeight = tabHeight+tabsList.size()*tabHeight;
	}
	
	public void drawGui(FontRenderer fr)
	{
		int x = 4;
		int y = 4;
		
		Gui.drawRect(x-2, y-2, x+guiWidth+2, y+guiHeight+2, colorBorder);
		Gui.drawRect(x, y, x+guiWidth, y+guiHeight, colorBody);
		fr.drawStringWithShadow(colorHighlight + clientName + " " + colorNormal+clientVersion, x+2, y+2, 0xffffff);
		Gui.drawRect(x, y+11, x+guiWidth, y+13, colorBorder);
		int yOff = y+14;
		
		for (int i = 0; i < tabsList.size(); i++)
		{
			fr.drawStringWithShadow((i == selectedTab ? colorHighlight : colorNormal) + ((GuiTab)tabsList.get(i)).tabName, x+2, yOff+1, 0xffffff);
			fr.drawStringWithShadow((i == selectedTab ? colorHighlight+(mainMenu ? ">>" : "<<") : colorNormal+">>"), x+guiWidth-12, yOff+1, 0xffffff);
			if (tabsList.size()-1 != i) Gui.drawRect(x, yOff+10, x+guiWidth, yOff+11, colorBorder);
			if (i == selectedTab && !mainMenu) {((GuiTab)(tabsList.get(i))).drawTabMenu(x+guiWidth+2, yOff-2, fr);}
			yOff+=tabHeight;
		}
	}
	
	public void drawEnabled(FontRenderer fr) {
		ScaledResolution res = new ScaledResolution(mc);
		
		int yOff = 4;
		int x = res.getScaledWidth() - 154;
		
		if (ch.enabledHacks.size()<1) return;
		
		int aListHeight = ch.enabledHacks.size()*tabHeight;
		
		Gui.drawRect(x-2, yOff-2, x+guiWidth+2, yOff+aListHeight+2, colorBorder);
		Gui.drawRect(x, yOff, x+guiWidth, yOff+aListHeight, colorBody);
		
		for (int i = 0; i < ch.enabledHacks.size(); i++)
		{
			fr.drawStringWithShadow(colorNormal + ch.enabledHacks.get(i), x+2, yOff+2, 0xffffff);
			if (ch.enabledHacks.size()-1 != i) Gui.drawRect(x, yOff+11, x+guiWidth, yOff+12, colorBorder);
			yOff+=tabHeight;
		}
	}
	
	public void parseKeyUp()
	{
		if (mainMenu)
		{
			selectedTab--;
			if (selectedTab < 0)
			{
				selectedTab = tabsList.size()-1;
			}
		}
		else
		{
			selectedItem--;
			if (selectedItem<0)
			{
				selectedItem = ((GuiTab)tabsList.get(selectedTab)).hacks.size()-1;
			}
		}
	}
	
	public void parseKeyDown()
	{
		if (mainMenu)
		{
			selectedTab++;
			if (selectedTab > tabsList.size()-1)
			{
				selectedTab = 0;
			}
		}
		else
		{
			selectedItem++;
			if (selectedItem>((GuiTab)tabsList.get(selectedTab)).hacks.size()-1)
			{
				selectedItem = 0;
			}
				
		}
	}
	
	public void parseKeyLeft()
	{
		if (!mainMenu) {mainMenu=true;}
	}
	
	public void parseKeyRight()
	{
		if (mainMenu) {mainMenu=false; selectedItem = 0;}
	}
	
	public void parseKeyToggle()
	{
		if (!mainMenu)
		{
			int sel = selectedItem;
			((ItemHack)((GuiTab)tabsList.get(selectedTab)).hacks.get(sel)).exeHack();
		}
	}
}
