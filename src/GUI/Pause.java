package GUI;

import java.awt.event.KeyEvent;

import processing.core.PFont;

public class Pause {
	private PFont font;
	
	public static void drawPausedState(DrawingSurface s) {
		s.background(255);   // Clear the screen with a white background
		s.fill(0,0,0);
		s.textAlign(s.CENTER);
		s.textSize(24);
		s.text("PAUSE", s.width/2, s.height/2);
		if(s.isPressed(KeyEvent.VK_SPACE))
		{
			s.setState(s.GAME_STATE);
			s.getKeys().clear();
		}
	}
	public static void mousePressedPausedState(double x, double y) {
		
	}
}
