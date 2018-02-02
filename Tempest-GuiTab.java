package oab.gui;

import java.util.ArrayList;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class GuiTab {

	private GuiClient gui;
	
	public ArrayList hacks;
	public String tabName;
	public int selectedItem = 0;
	
	public int menuHeight = 0;
	public int menuWidth = 0;
	
	public GuiTab(GuiClient GUI, String TabName)
	{
		tabName = TabName;
		gui = GUI;
		hacks = new ArrayList();
	}
	
	public void countMenuSize(FontRenderer fr)
	{
		int maxWidth = 0;
		for (int i = 0; i < hacks.size(); i++)
		{
			if (fr.getStringWidth(((ItemHack)hacks.get(i)).text) > maxWidth)
			{
				maxWidth = fr.getStringWidth(((ItemHack)hacks.get(i)).text)+7;
			}
		}
		menuWidth = maxWidth;
		
		menuHeight = hacks.size()*(gui.tabHeight)-1;
	}
	
	public void drawTabMenu(int x, int y, FontRenderer fr)
	{
		countMenuSize(fr);
		
		x = x+2;
		y = y+2;
		
		Gui.drawRect(x-2,y-2,x+menuWidth+2,y+menuHeight+2,gui.colorBorder);
		Gui.drawRect(x,y,x+menuWidth,y+menuHeight,gui.colorBody);
		for (int i = 0; i < hacks.size(); i++)
		{
			fr.drawStringWithShadow((i == gui.selectedItem ? gui.colorHighlight : gui.colorNormal )+((ItemHack)hacks.get(i)).text, x+1, y+gui.tabHeight*i+2, 0xffffff);
			if (hacks.size()-1 != i) Gui.drawRect(x, y+(i+1)*(gui.tabHeight)-1, x+menuWidth, y+(i+1)*gui.tabHeight, gui.colorBorder);
		}
	}
	
}
