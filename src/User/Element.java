package User;

import java.awt.event.KeyEvent;

import GUI.DrawingSurface;
import processing.core.PImage;

public class Element {

	private static int NUMBER_OF_IMAGES=8;
	private long coolDownTime = 0;
    private long timeWhenPressed = 0;
    private String name;
    int displayPosition;
    String fileName;
    private PImage image = null;
    private static PImage[] numCountDown = new PImage[16];
    public Element(String name, int displayPosition, String fileName){
		this.name = name;
		this.displayPosition = displayPosition;
		this.fileName = fileName;
	}
	public int getTimeRemaining() {
		if ((System.currentTimeMillis()/1000) > coolDownTime) {
			return 0;
		}
		else if(coolDownTime<timeWhenPressed){
			return 0;
		}
		return (int)(coolDownTime - (System.currentTimeMillis()/1000));
	}
	
	public long getCoolDownTime() {
		return coolDownTime;
	}
	public void setCoolDownTime(long coolDownTime) {
		this.coolDownTime = coolDownTime;
	}
	public long getTimeWhenPressed() {
		return timeWhenPressed;
	}
	public void setTimeWhenPressed(long timeWhenPressed) {
		this.timeWhenPressed = timeWhenPressed;
	}
	
	public void keyPressed() {

	    	timeWhenPressed= System.currentTimeMillis()/1000;
	    	if(coolDownTime < timeWhenPressed)
	    	   coolDownTime = timeWhenPressed + 15;
	}
	
	public void draw(DrawingSurface s)
	{

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
		
//		s.rectMode(0);
//		s.rect(xBegin, yBegin, width, height); 
		if (image == null) {
			image = s.loadImage("GUI"+DrawingSurface.fileSeperator+fileName);
			image.resize((int)width,  (int)height);
		}
		if(numCountDown==null || numCountDown[1] == null){
			for(int x = 1; x<16; x++){
				numCountDown[x] = s.loadImage("GUI"+DrawingSurface.fileSeperator+"cooldowns"+DrawingSurface.fileSeperator+x+".png");
				image.resize((int)width, (int)height);
			}
		}
		int remainingTime = getTimeRemaining();
		PImage img = null;
		if(remainingTime > 0){
			img = numCountDown[remainingTime];
		}
		else {
			img = image;
		}	
		s.image(img,(int)xBegin,(int)yBegin,(int)width,(int)height);
		
//		System.out.println(name + ", x=" + xBegin + ", y=" + yBegin + ", w=" + width + ", h=" + height);
		
	}
	
}
