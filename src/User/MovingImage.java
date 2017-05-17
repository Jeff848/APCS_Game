package User;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;

import javax.swing.*;

import GUI.DrawingSurface;
import processing.core.PImage;

/*
 * Represents a moving image.
 *
 * by: Shelby
 * on: 5/3/13
 */
 
public class MovingImage extends Rectangle2D.Double {
	
	// FIELDS
	private PImage image;
	
	// CONSTRUCTORS
	public MovingImage(String filename, DrawingSurface s, int x, int y, int w, int h) {
		this(x,y,w,h);	
		image = s.loadImage(filename);
	}
	
	public MovingImage(PImage img, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
	}
	
	public MovingImage(int x, int y, int w, int h) {
		super(x,y,w,h);
		image = null;
	}
	
	
	// METHODS	
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	
	public void draw(DrawingSurface s) {
		
		s.image(image,(int)x,(int)y,(int)width,(int)height);
	}
	public PImage getImage()
	{
		return image;
	}
	
	public double getWidth(){
		return width;
	}
	public double getHeight(){
		return height;
	}
	public void setX(double i){
		x = i;
	}
	public void setY(double i){
		y = i;
	}
	public void setWidth(double i){
		width = i;
	}
	public void setHeight(double i){
		height = i;
	}
	public void setImage(PImage image){
		this.image=image;
	}
	
	
}










