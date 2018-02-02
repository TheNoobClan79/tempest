package com.darkcart.xdolf.mods.aura;

import org.lwjgl.input.Keyboard;

import com.darkcart.xdolf.Module;
import com.darkcart.xdolf.util.Category;

public class AuraPlayer extends Module
{
	public AuraPlayer()
	{
		super("Players", "This one is boring, it just hits players nothing else", Keyboard.KEYBOARD_SIZE, Category.COMBAT);
		setState(true);
	}
}
