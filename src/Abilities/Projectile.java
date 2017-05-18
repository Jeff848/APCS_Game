package Abilities;

import User.MovingImage;
import processing.core.PImage;

public class Projectile extends MovingImage implements Ability{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creates a projectile that can move
	 * @param img- PImage of projectile
	 * @param x- x coord
	 * @param y- y coord
	 * @param w- width of projectile
	 * @param h- height of projectile
	 */
	public Projectile(PImage img, int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void checkCollision(MovingImage m) {
		// TODO Auto-generated method stub
		
	}


}
