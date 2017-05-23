package GUI;

import java.awt.event.KeyEvent;

import processing.core.PFont;

public class Pause {
	private PFont font;
	
	public static void drawPausedState(DrawingSurface s) {
		s.background(255);   // Clear the screen with a white background
		s.fill(0,0,0);
		s.textAlign(s.CENTER);
		s.textSize(48);
		s.text("PAUSE", s.width/2, s.height/2);
		s.textSize(12);
		s.noFill();
		s.stroke(0);
		s.rect(0,14*s.height/15,s.width/15,s.height/15);
		s.rect(14*s.width/15,14*s.height/15,s.width/15,s.height/15);
		s.text("CONTINUE",0+s.width/30,14*s.height/15+s.height/30);
		s.text("QUIT",14*s.width/15+s.width/30,14*s.height/15+s.height/30);
		
	}
	public static void mousePressedPausedState(DrawingSurface s, double x, double y) {
		if(Menu.isPointInside(0,14*s.height/15,s.width/15,s.height/15,x,y)){
			s.setState(s.GAME_STATE);
		} else if(Menu.isPointInside(14*s.width/15,14*s.height/15,s.width/15,s.height/15,x,y)){
			s.exit();
		}
	}
}
