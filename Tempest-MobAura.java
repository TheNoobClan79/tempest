package com.darkcart.xdolf.mods.aura;

import org.lwjgl.input.Keyboard;

import com.darkcart.xdolf.Module;
import com.darkcart.xdolf.util.Category;

public class AuraMob extends Module
{
	public AuraMob()
	{
		super("Mobs", "This one only hits mobs, still boring.", Keyboard.KEYBOARD_SIZE, Category.COMBAT);
	}
}