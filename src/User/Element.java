package User;

import java.awt.event.KeyEvent;

import GUI.DrawingSurface;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PShapeSVG.Font;

public class Element {
// updated by: Yash
	
	//private static int NUMBER_OF_IMAGES=8;
	private long coolDownTime = 0;
    // private long timeWhenPressed = 0;
    private String name;
    int displayPosition;
    String fileName;
    private PImage image = null;
    private long coolDownPeriod;
  //  private static PImage[] numCountDown = new PImage[16];
    public Element(String name, int displayPosition, String fileName, long coolDownPeriod){
		this.name = name;
		this.displayPosition = displayPosition;
		this.fileName = fileName;
		this.coolDownPeriod = coolDownPeriod;
	}
	public double getTimeRemaining() {
		return (coolDownTime - (System.currentTimeMillis()/1000.0));
	}
	
	public long getCoolDownTime() {
		return coolDownTime;
	}
	public void setCoolDownTime(long coolDownTime) {
		this.coolDownTime = coolDownTime;
	}
	/*
	public long getTimeWhenPressed() {
		return timeWhenPressed;
	}
	public void setTimeWhenPressed(long timeWhenPressed) {
		this.timeWhenPressed = timeWhenPressed;
	}
	*/
	public void keyPressed() {

	    	long timeWhenPressed= System.currentTimeMillis()/1000;
	    	if(coolDownTime < timeWhenPressed)
	    	   coolDownTime = timeWhenPressed + coolDownPeriod;
	}
	
	public void draw(DrawingSurface s)
	{
		if(image == null)
			image = s.loadImage("GUI"+DrawingSurface.fileSeperator+fileName);
//		System.out.println("width = " + s.width);
//		System.out.println("height = " + s.height);
//		System.out.println("disp pos = " + displayPosition);
//		System.out.println("aspace = " + spaceBetweenImages);

		double spaceBetweenImage = (double)s.width/17; 
		float xBegin =  (float)Math.ceil(spaceBetweenImage*(displayPosition - 1));
		float yBegin = (float)Math.ceil((double)s.height*7/8 + (double)s.height/64);
		float width = (float)Math.ceil((double)s.width/17);
		float height = (float)Math.ceil((double)s.height/8 + (double)s.height*3/32);

		if (height > width) {
			height = width;
		}
		else if (height < width) {
			width = height;
		}
		
		

		int remainingTime = (int)getTimeRemaining();
		if(remainingTime > 0){
			s.fill(0,0,0,155);
			s.rectMode(0);
			s.rect(xBegin, yBegin, width, height); 
			s.fill(255);
			PFont myFont = s.createFont("Georgia", 64);
			s.textFont(myFont);
			s.text(remainingTime, xBegin+width/2, yBegin+height/2);
			s.fill(0);
		}
		else {
			s.image(image, xBegin, yBegin, width, height);
		}
		
		
//		System.out.println(name + ", x=" + xBegin + ", y=" + yBegin + ", w=" + width + ", h=" + height);
		
	}
	
	public void addPauseTime(long pauseStartTime)
	{
		long time = (System.currentTimeMillis() - pauseStartTime)/1000;
		coolDownTime+= time;
		// timeWhenPressed += time;
	
	}
	
}




	