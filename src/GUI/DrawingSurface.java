package GUI;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import User.Default;
import User.MovingImage;
import User.User;
import Abilities.Ability;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Draws all the images and updates movement
 */
public class DrawingSurface extends PApplet {

	private User p1, p2;
	private PImage img1;
	public static final String fileSeperator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");
	private boolean isPressed;
	private boolean[] isP1Held,isP2Held;
	
	/**
	 * Constructs a screen with two planes
	 */
	public DrawingSurface() {	
		
		p1 = new Default(0,0,null,false);
		p2 = new Default(width,0,null,true);
		isPressed=true;
		isP1Held = new boolean[4];
		isP2Held = new boolean[4];
		runSketch();
		
		
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	/**
	 * Uploads the images to the planes
	 */
	public void setup() {
		PImage img1 = loadImage("GUI"+fileSeperator+"PlaneR.gif");
		p1.setImage(img1);
		
		int t = millis();

		PImage flipped1 = createImage(img1.width,img1.height,RGB);//create a new image with the same dimensions
		for(int i = 0 ; i < flipped1.pixels.length; i++){       //loop through each pixel
		  int srcX = i % flipped1.width;                        //calculate source(original) x position
		  int dstX = flipped1.width-srcX-1;                     //calculate destination(flipped) x position = (maximum-x-1)
		  int y    = i / flipped1.width;                        //calculate y coordinate
		  flipped1.pixels[y*flipped1.width+dstX] =  img1.pixels[i];//write the destination(x flipped) pixel based on the current pixel  
		 
		}
		//y*width+x is to convert from x,y to pixel array index

		println("done in " + (millis()-t) + "ms");

		p2.setImage(flipped1);
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	/**
	 * Updates the screen with the movements of the plane
	 */
	public void draw() { 
		if(isP1Held[0]||isP1Held[1]||isP1Held[2]||isP1Held[3]||isP2Held[0]||isP2Held[1]||isP2Held[2]||isP2Held[3]||isPressed){
			background(255);   // Clear the screen with a white background
			fill(255);
			textAlign(CENTER);
			textSize(12);
			p1.move(width, height);
			p1.applyWindowLimits(width, height);
			p1.draw(this);
			p2.move(width, height);
			p2.applyWindowLimits(width, height);
			p2.draw(this);
			line(width/2,0,width/2,height);
			fill(255,0,0);
			rect(0,0,200,10);
			fill(0,255,0);
			rect(0,0,p1.getHealth(),10);
			
		
		}
	}
	
	
	public void mousePressed() {
		
	}
	
	public void mouseDragged() {
		
	}
	
	
	

	
	/**
	 * Checks if the plane has stopped moving in a certain direction
	 */
	public void keyReleased(){
		if (keyCode == KeyEvent.VK_W) {
			p1.setDirection(p1.getXDirection(),0);
			if(isP1Held[2])
				p1.setDirection(p1.getXDirection(), User.DOWN);
			isP1Held[0]=false;
		}
		else if (keyCode == KeyEvent.VK_A) {
			p1.setDirection(0,p1.getYDirection());
			if(isP1Held[3]){
				p1.setDirection(User.RIGHT, p1.getYDirection());
			}
			isP1Held[1]=false;
			
		}
		else if (keyCode == KeyEvent.VK_S) {
			p1.setDirection(p1.getXDirection(),0);
			if(isP1Held[0])
				p1.setDirection(p1.getXDirection(), User.UP);
			isP1Held[2]=false;
			
		}
		else if (keyCode == KeyEvent.VK_D) {
			p1.setDirection(0,p1.getYDirection());
			if(isP1Held[1])
				p1.setDirection(User.LEFT, p1.getYDirection());
			isP1Held[3]=false;
		}
		
		if (keyCode == KeyEvent.VK_UP) {
			p2.setDirection(p1.getXDirection(),0);
			if(isP2Held[2])
				p2.setDirection(p2.getXDirection(), User.DOWN);
			isP2Held[0]=false;
		}
		else if (keyCode == KeyEvent.VK_LEFT) {
			p2.setDirection(0,p2.getYDirection());
			if(isP2Held[3])
				p2.setDirection(User.RIGHT, p2.getYDirection());
			isP2Held[1]=false;
		}
		else if (keyCode == KeyEvent.VK_DOWN) {
			p2.setDirection(p2.getXDirection(),0);
			if(isP2Held[0])
				p2.setDirection(p2.getXDirection(), User.UP);
			isP2Held[2]=false;
		}
		else if (keyCode == KeyEvent.VK_RIGHT) {
			p2.setDirection(0,p2.getYDirection());
			if(isP2Held[1])
				p2.setDirection(User.LEFT, p2.getYDirection());
			isP2Held[3]=false;
		}
		
		isPressed=false;
	}
	
	/** 
	 * Checks if a movement or ability button has been pressed
	 */
	public void keyPressed() {

		
		
		if (keyCode == KeyEvent.VK_1) {
			p1.ab1();
		}
		else if (keyCode == KeyEvent.VK_2) {
			p1.ab2();	
		}
		else if (keyCode == KeyEvent.VK_3) {
			p1.ab3();
		}
		else if (keyCode == KeyEvent.VK_4) {
			p1.ab4();
		}
		else if (keyCode == KeyEvent.VK_W) {
			p1.setDirection(p1.getXDirection(),User.UP);
			isP1Held[0]=true;
		}
		else if (keyCode == KeyEvent.VK_A) {
			p1.setDirection(User.LEFT,p1.getYDirection());
			isP1Held[1]=true;
			
		}
		else if (keyCode == KeyEvent.VK_S) {
			p1.setDirection(p1.getXDirection(),User.DOWN);
			isP2Held[2]=true;
			
		}
		else if (keyCode == KeyEvent.VK_D) {
			p1.setDirection(User.RIGHT,p1.getYDirection());
			isP2Held[3]=true;
		}
		
		
		
		
		if (keyCode == KeyEvent.VK_7) {
			p2.ab1();
		}
		else if (keyCode == KeyEvent.VK_8) {
			p2.ab2();	
		}
		else if (keyCode == KeyEvent.VK_9) {
			p2.ab3();
		}
		else if (keyCode == KeyEvent.VK_5) {
			p2.ab4();
		}
		else if (keyCode == KeyEvent.VK_UP) {
			p2.setDirection(p2.getXDirection(),User.UP);
			isP2Held[0]=true;
		}
		else if (keyCode == KeyEvent.VK_LEFT) {
			p2.setDirection(User.LEFT,p2.getYDirection());
			isP2Held[1]=true;
		}
		else if (keyCode == KeyEvent.VK_DOWN) {
			p2.setDirection(p2.getXDirection(),User.DOWN);
			isP2Held[2]=true;
		}
		else if (keyCode == KeyEvent.VK_RIGHT) {
			p2.setDirection(User.RIGHT,p2.getYDirection());
			isP2Held[3]=true;
		}
		isPressed=true;
		
		
	}
	

	

	
}










