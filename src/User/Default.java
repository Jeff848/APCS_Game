package User;
import java.awt.event.KeyEvent;

import GUI.DrawingSurface;
import processing.core.PImage;
/**
 * Represents the default class of user(or plane)
 *
 */
public class Default extends User{

	Element fire, missile, zap, bomb;
	private static final long serialVersionUID = 1L;
	private static final long FireCoolDownPeriod = 10;
	private static final long ZapCoolDownPeriod = 10;
	private static final long BombCoolDownPeriod = 10;
	private static final long MissileCoolDownPeriod = 10;
	/**
	 * Creates the default user 
	 * @param x- x coord
	 * @param y- y coord
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
	/**
	 * Draws the cooldown timers with the plane
	 * @param s- PApplet from processing.core
	 */
	public void draw(DrawingSurface s)
	{
		super.draw(s);
		fire.draw(s);
		zap.draw(s);
		bomb.draw(s);
		missile.draw(s);
		
	}
	/**
	 * Adds the missile if the cooldown is zero. Otherwise add up the cooldown
	 * @param img1- image of missile going right
	 * @param img2- image of missile going left
	 */
	public void ab1(PImage img1, PImage img2){
		if(missile.getTimeRemaining()<0.000000000000001){
			missile.keyPressed();
			super.ab1(img1,img2);
		}
	}
	/**
	 * Adds the bomb if the cooldown is zero. Otherwise add up the cooldown
	 * @param img1- image of bomb
	 */
	public void ab2(PImage img1){
		if(bomb.getTimeRemaining()<0.000000000000001){
			bomb.keyPressed();
			super.ab2(img1);
		}
	}
	/**
	 * Adds the zap if the cooldown is zero. Otherwise add up the cooldown
	 * @param img1- image of zap going right
	 * @param img2- image of zap going left
	 */
	public void ab3(PImage img1, PImage img2){
		if(zap.getTimeRemaining()<0.000000000000001){
			zap.keyPressed();
			super.ab3(img1,img2);
		}
	}
	/**
	 * Adds the fire if the cooldown is zero. Otherwise add up the cooldown
	 * @param img1- image of fire going right
	 * @param img2- image of fire going left
	 */
	public void ab4(PImage img1){
		if(fire.getTimeRemaining()<0.000000000000001){
			fire.keyPressed();
			super.ab4(img1);
		}
	}
	/**
	 * Adds the time lost when the game is paused
	 * @param startPauseTime- the time when the pause button is pressed
	 */
	public void addPauseTime(long startPauseTime)
	{
		fire.addPauseTime(startPauseTime);
		zap.addPauseTime(startPauseTime);
		bomb.addPauseTime(startPauseTime);
		missile.addPauseTime(startPauseTime);
	}

	
	
	
}
