package GUI;


import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import processing.core.PApplet;



public class DrawingSurface extends PApplet {

	private User p1, p2;

	
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
		
	}
	
	public void mouseDragged() {
		
	}
	
	
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
			p1.move(UP);
		}
		else if (keyCode == KeyEvent.VK_A) {
			p1.move(LEFT);
		}
		else if (keyCode == KeyEvent.VK_S) {
			p1.move(DOWN);
		}
		else if (keyCode == KeyEvent.VK_D) {
			p1.move(RIGHT);
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
		else if (keyCode == KeyEvent.VK_LEFT) {
			p2.move(LEFT);
		}
		else if (keyCode == KeyEvent.VK_DOWN) {
			p2.move(DOWN);
		}
		else if (keyCode == KeyEvent.VK_RIGHT) {
			p2.move(RIGHT);
		}
		else if (keyCode == KeyEvent.VK_UP) {
			p2.move(UP);
		}
	}

	
}










