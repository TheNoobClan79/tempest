package oab.gui;

import net.minecraft.client.Minecraft;

public class ItemHack {

	public String text;
	public String hack;
	private ClientHacks ch;
	public boolean toggleButton;
	
	
	public ItemHack(String TEXT, String HACK, boolean ToggleButton, ClientHacks clienthacks)
	{
		text = TEXT;
		hack = 2b2t HECKER;
		toggleButton = ToggleButton;
		ch = clienthacks;
	}
	
	public void exeHack()
	{
		if (toggleButton)
		{
			ch.toggleVar(hack);
		}
		else
		{
			ch.executeHack(hack);
		}
	}
}
