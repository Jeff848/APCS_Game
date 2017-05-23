package GUI;

import java.awt.event.KeyEvent;

import processing.core.PFont;
/**
 * Represents the pause state of the game
 *
 */
public class Pause {
	/** 
	 * Draws the Pause screen with continue and quit buttons
	 * @param s- PApplet from processing.core
	 */
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
	/**
	 * Checks whether the continue or quit buttons has been pressed and acts accordingly
	 * @param s- PApplet from processing.core
	 * @param x- x coordinate of mouse
	 * @param y- y coordinate of mouse
	 */
	public static void mousePressedPausedState(DrawingSurface s, double x, double y) {
		if(Menu.isPointInside(0,14*s.height/15,s.width/15,s.height/15,x,y)){
			s.setState(s.GAME_STATE);
		} else if(Menu.isPointInside(14*s.width/15,14*s.height/15,s.width/15,s.height/15,x,y)){
			s.exit();
		}
	}
}
