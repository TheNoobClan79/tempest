package oab.gui;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;

public class GuiHandler {

	private Minecraft mc;
	private boolean keyStates[];
	public GuiClient gui;
	
	
	public GuiHandler(Minecraft minecraft, ClientHacks ch)
	{
		keyStates = new boolean[256];
		mc = minecraft;
		gui = new GuiClient(ch,mc);
	}
	
    public boolean checkKey(int i)
    {
	    if(mc.currentScreen != null)
	    {
	    	return false;
	    }
	    if(Keyboard.isKeyDown(i) != keyStates[i])
	    {
	    	return keyStates[i] = !keyStates[i];
	    }else
	    {
	    	return false;
	    }
    }
    
    public void checkKeys()
    {
    	if (checkKey(Keyboard.KEY_UP))    {gui.parseKeyUp();}
    	if (checkKey(Keyboard.KEY_DOWN))  {gui.parseKeyDown();}
    	if (checkKey(Keyboard.KEY_LEFT))  {gui.parseKeyLeft();}
    	if (checkKey(Keyboard.KEY_RIGHT)) {gui.parseKeyRight();}
    	if (checkKey(Keyboard.KEY_RETURN)) {gui.parseKeyToggle();}
    }
}
