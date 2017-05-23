package Abilities;

import GUI.DrawingSurface;
import User.Default;
import User.MovingImage;
import User.User;
import processing.core.PImage;
/**
 * Represents a missile projectile
 *
 */
public class Missile extends MovingImage{
	private static final long serialVersionUID = 1L;	
	public static final String fileSeperator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");
	private double velocity;
	private PImage img;
	/**
	 * Creates a missile at the x and y coord with the given width, height, and image
	 * @param x- x coordinate
	 * @param y- y coordinate
	 * @param width- given width
	 * @param height- given height 
	 * @param img- image of the missile
	 */
	public Missile(int x, int y, int width, int height, PImage img1) {	
		super(x, y, width, height);
		velocity = 10;
		img = img1;
	}
	/**
	 * Moves the missile according to the User's direction
	 * @param d- the user
	 */
	public void move(User d){			
		//this.setX(d.getX());
		if(!d.isFacingLeft()){	
			//while(this.getX()>1475){
				this.moveByAmount(velocity, 0);
				
				//System.out.println(this.getX());
			//}
		}
		else{
			//while(this.getX()>0){
				this.moveByAmount(-velocity, 0);
				
				
			//}
		}		
	}
	/**
	 * Draws the missile moving in the direction corresponding to the User's direction
	 * @param s- PApplet from processing.core
	 * @param u- The User
	 */
	public void draw(DrawingSurface s, User u){		
		s.pushMatrix();
		s.noStroke();
		s.image(img, (int)(x), (int)(y), 100, 50);
		move(u);
		s.fill(255);
		s.stroke(0);
		s.popMatrix();		
	}	
}