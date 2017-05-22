package Abilities;
import GUI.DrawingSurface;
import User.Default;
import User.MovingImage;
import User.User;
import processing.core.PImage;

public class Zap extends MovingImage{
	private static final long serialVersionUID = 1L;	
	public static final String fileSeperator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");
	private double velocity;
	private PImage img;
	public Zap(int x, int y, int width, int height, DrawingSurface s) {	
		super(x, y, width, height);
		velocity = 10;
		img = s.loadImage("GUI"+fileSeperator+"Zap.jpg");
	}
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
	public void draw(DrawingSurface s, User u){		
		s.pushMatrix();
		s.noStroke();
		s.image(img, (int)(x), (int)(y));
		move(u);
		s.fill(255);
		s.stroke(0);
		s.popMatrix();		
	}	
}
