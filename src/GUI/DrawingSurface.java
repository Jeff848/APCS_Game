package GUI;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import User.Default;
import User.HarryPotter;
import User.MovingImage;
import User.User;
import Abilities.Ability;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PSurfaceNone.AnimationThread;

/**
 * Draws all the images and updates movement
 */
public class DrawingSurface extends PApplet {

	
	public static final String fileSeperator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");
	private ArrayList<Integer> keys;
	public final int GAME_STATE = 0;
	public final int PAUSE_STATE = 1;
	public final int MENU_STATE = 3;
	private int state;
	private User user1, user2;
	private Game game;
	private Menu menu;
	private Pause pause;
	private PImage[] planes;
	
	/**
	 * Constructs a screen with two planes
	 */
	public DrawingSurface() {	
		menu = new Menu();
		game = new Game();
		keys = new ArrayList<Integer>();
		state=MENU_STATE;
		planes = new PImage[6];
		runSketch();
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	/**
	 * Uploads the images to the planes
	 */
	public void setup() {
		planes[0] = loadImage("GUI"+fileSeperator+"HarryPotter.jpg");
		planes[1] = loadImage("GUI"+fileSeperator+"corgi.png");
		game.setGameUp(new Default(0,0,null,false),new Default(0,0,null,true), planes[0],planes[1],this);
	}
	
	public void settings() {
		size(displayWidth,displayHeight);
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	/**
	 * Updates the screen with the movements of the plane
	 */
	public void draw() { 
		if(state==MENU_STATE){
			menu.drawMenuState(this);
		} else if(state==GAME_STATE){
			game.drawGameState(this);
		} else if(state == PAUSE_STATE){
			Pause.drawPausedState(this);
		} 
	}
	

	
	public void mousePressed() {
		if(state==MENU_STATE){
			menu.mousePressedMenuState(this,mouseX,mouseY);
		} else if(state==PAUSE_STATE){
			Pause.mousePressedPausedState(mouseX,mouseY);
		}
	}
	
	public void mouseDragged() {
		
	}
	
	public void keyPressed() {
		if (!keys.contains(keyCode))
			keys.add(keyCode);
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	public void setState(int state)
	{
		this.state=state;
	}
	public ArrayList<Integer> getKeys()
	{
		return keys;
	}
	
}
