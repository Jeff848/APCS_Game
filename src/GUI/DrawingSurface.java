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



public class DrawingSurface extends PApplet {

	private User p1, p2;
	private PImage img1;
	public static final String fileSeperator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");
	private boolean isPressed;
	private boolean[] isP1Held,isP2Held;
	
	
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
	public void setup() {
		PImage img1 = loadImage("GUI"+fileSeperator+"Plane.gif");
		p1.setImage(img1);
		p2.setImage(img1);
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		if(isPressed){
			background(255);   // Clear the screen with a white background
			fill(255);
			textAlign(CENTER);
			textSize(12);
			p1.move(width, height);
			//p1.applyWindowLimits(width, height);
			p1.draw(this);
			p2.move(width, height);
			//p2.applyWindowLimits(width, height);
			p2.draw(this);
		}
	}
	
	
	public void mousePressed() {
		
	}
	
	public void mouseDragged() {
		
	}
	
	
	



	public void keyReleased(){
		if (keyCode == KeyEvent.VK_W) {
			p1.setDirection(p1.getXDirection(),0);
			if(isP1Held[2])
				p1.setDirection(p1.getXDirection(), User.DOWN);
			isP1Held[0]=false;
		}
		else if (keyCode == KeyEvent.VK_A) {
			p1.setDirection(0,p1.getYDirection());
			if(isP1Held[3])
				p1.setDirection(User.RIGHT, p1.getYDirection());
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
				p2.setDirection(p1.getXDirection(), User.DOWN);
			isP2Held[0]=false;
		}
		else if (keyCode == KeyEvent.VK_LEFT) {
			p2.setDirection(0,p1.getYDirection());
			if(isP2Held[3])
				p2.setDirection(User.RIGHT, p1.getYDirection());
			isP2Held[1]=false;
		}
		else if (keyCode == KeyEvent.VK_DOWN) {
			p2.setDirection(p1.getXDirection(),0);
			if(isP2Held[0])
				p2.setDirection(p1.getXDirection(), User.UP);
			isP2Held[2]=false;
		}
		else if (keyCode == KeyEvent.VK_RIGHT) {
			p2.setDirection(0,p1.getYDirection());
			if(isP2Held[1])
				p2.setDirection(User.LEFT, p1.getYDirection());
			isP2Held[3]=false;
		}
	}

	public void keyPressed() {
		System.out.println("jello");
		isPressed=true;
		
		
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
			p2.setDirection(p1.getXDirection(),User.UP);
			isP2Held[0]=true;
		}
		else if (keyCode == KeyEvent.VK_LEFT) {
			p2.setDirection(User.LEFT,p1.getYDirection());
			isP2Held[1]=true;
		}
		else if (keyCode == KeyEvent.VK_DOWN) {
			p2.setDirection(p1.getXDirection(),User.DOWN);
			isP2Held[2]=true;
		}
		else if (keyCode == KeyEvent.VK_RIGHT) {
			p2.setDirection(User.RIGHT,p1.getYDirection());
			isP2Held[3]=true;
		}
		
		
		
	}
	

	

	
}










