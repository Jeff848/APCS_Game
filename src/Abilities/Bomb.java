package Abilities;
import GUI.DrawingSurface;

import User.Default;
import User.MovingImage;
import User.User;
import processing.core.PImage;
/**
 * Represents a bomb projectile
 *
 */
public class Bomb extends MovingImage {
	private static final long serialVersionUID = 1L;	
	public static final String fileSeperator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");
	private double velocity;
	private PImage img;
	/**
	 * Creates a bomb at the x and y coord with the given width, height, and image
	 * @param x- x coordinate
	 * @param y- y coordinate
	 * @param width- given width
	 * @param height- given height 
	 * @param img- image of the bomb
	 */
	public Bomb(int x, int y, int width, int height, PImage img) {	
		super(x, y, width, height);
		velocity = 15;
		this.img = img;
	}
	/**
	 * Moves the bomb according to the User's direction
	 * @param d- the user
	 */
	public void move(User d){			
		
		if(!d.isFacingLeft()){	
			
				this.moveByAmount(velocity, 0);
				
			
		}
		else{
			
				this.moveByAmount(-velocity, 0);
				
				
			
		}		
	}
	/**
	 * Draws the bomb moving in the direction corresponding to the User's direction
	 * @param s- PApplet from processing.core
	 * @param u- The User
	 */
	public void draw(DrawingSurface s, User u){		
		s.pushMatrix();
		s.noStroke();
		s.image(img, (int)(x), (int)(y), 50, 50);
		move(u);
		s.fill(255);
		s.stroke(0);
		s.popMatrix();		
	}	
}
