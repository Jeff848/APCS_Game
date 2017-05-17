package GUI;

import java.awt.event.KeyEvent;

public class Menu {
	
	
	public static void drawMenuState(DrawingSurface s) {
		s.background(255);
		s.fill(0,0,0);
		s.textAlign(s.CENTER);
		s.textSize(24);
		s.text("TEMP MENU",s.width/2,s.height/2);
		if(s.isPressed(KeyEvent.VK_SPACE))
		{
			s.setState(s.GAME_STATE);
			s.getKeys().clear();
		}
	}
	public void mouseDraggedMenuState() {
		
	}
	public void mousePressedMenuState() {
		
	}
}
