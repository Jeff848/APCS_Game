


import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import processing.core.PApplet;



public class DrawingSurface extends PApplet {

	private Plane p1, p2;

	
	public DrawingSurface() {		
		runSketch();
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {

	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		fill(255);
		textAlign(CENTER);
		textSize(12);
		
		
		
		
	}
	
	
	public void mousePressed() {
		if (mouseButton == LEFT) {
			
		} 
	}
	
	public void mouseDragged() {
		if (mouseButton == LEFT) {
			
		} 
	}
	
	
	public void keyPressed() {
		if (keyCode == KeyEvent.VK_SPACE) {
		
		}
	}

	
}










