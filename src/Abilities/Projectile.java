package Abilities;

import User.MovingImage;
import processing.core.PImage;

public class Projectile extends MovingImage implements Ability{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Projectile(PImage img, int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void checkCollision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putOnCoolDown() {
		// TODO Auto-generated method stub
		
	}


}
