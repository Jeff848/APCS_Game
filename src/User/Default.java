package User;
import java.awt.event.KeyEvent;

import GUI.DrawingSurface;
import processing.core.PImage;

public class Default extends User{

	Element fire, missile, zap, bomb;
	private static final long serialVersionUID = 1L;
	private static final long FireCoolDownPeriod = 10;
	private static final long ZapCoolDownPeriod = 10;
	private static final long BombCoolDownPeriod = 10;
	private static final long MissileCoolDownPeriod = 10;
	/**
	 * 
	 * @param x- x coord
	 * @param y- y coord
	 * @param a- ability list
	 * @param l- boolean that dictates which side the plane is on
	 */
	public Default(int x, int y, boolean l) {
		super(x, y, 128, 64, l);
		if (isFacingLeft()) {
			missile = new Element("missile", 10, "Missile.png",MissileCoolDownPeriod);
			bomb = new Element("bomb", 12, "Bomb.png",BombCoolDownPeriod);
			zap = new Element("zap",14, "Zap.png",ZapCoolDownPeriod);
			fire = new Element("fire", 16, "Fire.png",FireCoolDownPeriod);
		}
		else {
			missile = new Element("missile", 2, "Missile.png",MissileCoolDownPeriod);
			bomb = new Element("bomb", 4, "Bomb.png",BombCoolDownPeriod);
			zap = new Element("zap",6, "Zap.png",ZapCoolDownPeriod );
			fire = new Element("fire", 8, "Fire.png",FireCoolDownPeriod);
		}
	}
	public String getName()
	{
		return "PlaneR";
	}
	
	public void keyPressed(int key) {

	    
	}
	public void draw(DrawingSurface s)
	{
		super.draw(s);
		fire.draw(s);
		zap.draw(s);
		bomb.draw(s);
		missile.draw(s);
		
	}
	public void ab1(PImage img1, PImage img2){
		if(missile.getTimeRemaining()<0.000000000000001){
			missile.keyPressed();
			super.ab1(img1,img2);
		}
	}
	public void ab2(PImage img1){
		if(bomb.getTimeRemaining()<0.000000000000001){
			bomb.keyPressed();
			super.ab2(img1);
		}
	}
	public void ab3(PImage img1, PImage img2){
		if(zap.getTimeRemaining()<0.000000000000001){
			zap.keyPressed();
			super.ab3(img1,img2);
		}
	}
	public void ab4(PImage img1){
		if(fire.getTimeRemaining()<0.000000000000001){
			fire.keyPressed();
			super.ab4(img1);
		}
	}

	public void addPauseTime(long startPauseTime)
	{
		fire.addPauseTime(startPauseTime);
		zap.addPauseTime(startPauseTime);
		bomb.addPauseTime(startPauseTime);
		missile.addPauseTime(startPauseTime);
	}

	
	
	
}
