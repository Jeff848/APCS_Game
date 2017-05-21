package User;

import java.awt.event.KeyEvent;

import Abilities.Ability;
import GUI.DrawingSurface;

public class Corgi extends User{
	Element fire, shield, zap, bomb;
	public Corgi(int x, int y, Ability[] a, boolean l){
		super(x, y, 128, 64, a, l);
		if (isFacingLeft()) {
			fire = new Element("fire", 2, "Fire.png");
			zap = new Element("zap", 4, "Zap.png");
			bomb = new Element("bomb",6, "Bomb.png");
			shield = new Element("shield", 8, "Shield.png");
		}
		else {
			fire = new Element("fire", 10, "Fire.png");
			zap = new Element("zap", 12, "Zap.png");
			bomb = new Element("bomb",14, "Bomb.png" );
			shield = new Element("shield", 16, "Shield.png");
		}
	}
	public String getName()
	{
		return "corgi";
	}
	
	public void keyPressed(int key) {

//	    int key = e.getKeyCode();

	    if (key == KeyEvent.VK_1 || key==KeyEvent.VK_5) {
	    	 fire.keyPressed();
	    }

	    if (key == KeyEvent.VK_2 || key==KeyEvent.VK_6) {
	    	zap.keyPressed();
	    }

	    if (key == KeyEvent.VK_3 || key==KeyEvent.VK_7) {
	    	bomb.keyPressed();
	    }

	    if (key == KeyEvent.VK_4 || key==KeyEvent.VK_8) {
	    	shield.keyPressed();
	    }
	}
	public void draw(DrawingSurface s)
	{
		super.draw(s);
		fire.draw(s);
		zap.draw(s);
		bomb.draw(s);
		shield.draw(s);
		
	}


}
