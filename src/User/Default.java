package User;
import java.awt.event.KeyEvent;

import Abilities.Ability;
import GUI.DrawingSurface;
import processing.core.PImage;

public class Default extends User{

	Element fire, shield, zap, bomb;
	private static final long serialVersionUID = 1L;
	private static final long FireCoolDownPeriod = 10;
	private static final long ZapCoolDownPeriod = 1;
	private static final long BombCoolDownPeriod = 1;
	private static final long ShieldCoolDownPeriod = 1;
	/**
	 * 
	 * @param x- x coord
	 * @param y- y coord
	 * @param a- ability list
	 * @param l- boolean that dictates which side the plane is on
	 */
	public Default(int x, int y, Ability[] a, boolean l) {
		super(x, y, 128, 64, a, l);
		if (isFacingLeft()) {
			fire = new Element("fire", 10, "Fire.png",FireCoolDownPeriod);
			zap = new Element("zap", 12, "Zap.png",ZapCoolDownPeriod);
			bomb = new Element("bomb",14, "Bomb.png",BombCoolDownPeriod);
			shield = new Element("shield", 16, "Shield.png",ShieldCoolDownPeriod);
		}
		else {
			fire = new Element("fire", 2, "Fire.png",FireCoolDownPeriod);
			zap = new Element("zap", 4, "Zap.png",ZapCoolDownPeriod);
			bomb = new Element("bomb",6, "Bomb.png",BombCoolDownPeriod );
			shield = new Element("shield", 8, "Shield.png",ShieldCoolDownPeriod);
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
		shield.draw(s);
		
	}
	public void ab1(DrawingSurface s){
		System.out.println(fire.getTimeRemaining());
		if(fire.getTimeRemaining()<0.000000000000001){
			super.ab1(s);
			fire.keyPressed();
			
			
		}
	}
	public void ab2(DrawingSurface s){
		if(zap.getTimeRemaining()<Math.E){
			zap.keyPressed();
			super.ab2(s);
		}
	}
	public void ab3(DrawingSurface s){
		if(bomb.getTimeRemaining()<Math.E){
			bomb.keyPressed();
			super.ab3(s);
		}
	}
	public void ab4(DrawingSurface s){
		if(shield.getTimeRemaining()<Math.E){
			shield.keyPressed();
			super.ab4(s);
		}
	}

	public void addPauseTime(long startPauseTime)
	{
		fire.addPauseTime(startPauseTime);
		zap.addPauseTime(startPauseTime);
		bomb.addPauseTime(startPauseTime);
		shield.addPauseTime(startPauseTime);
	}

	
	
	
}
