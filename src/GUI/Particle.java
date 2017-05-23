package GUI;

import User.MovingImage;
/**
 * Represents a particle effect in the background of the game
 *
 */
public class Particle extends MovingImage{

	private static final long serialVersionUID = 1L;
	private boolean isPointingLeft;
	private int velocity;
	/**
	 * Creates the particle with the given width and height at a random location or at the middle of the screen on the left or right of the screen
	 * @param width- given width of particle
	 * @param height- given height of particle
	 * @param s- PApplet from processing.core
	 * @param l- boolean value of if it is on the right side
	 * @param rando- boolean value of if it should be initialized randomly
	 */
	public Particle(int width, int height, DrawingSurface s, boolean l, boolean rando) {
		super(0,0, width, height);
		isPointingLeft=l;
		velocity = 10;
		if(l){
			if(rando)
				setX(s.width/40 * (int)(Math.random()*20)-width);
			else
				setX(s.width/2-width);
		}else{
			if(rando)
				setX(s.width/40 * (int)(Math.random()*20)+s.width/2-width);
			else
				setX(s.width/2+width);
		}
		setY(s.height*7/8*1/200*(int)(Math.random()*200+0.5));
	}
	public Particle(int width, int height, boolean l) {
		super(0,0,200,100);
		isPointingLeft=l;
		velocity = 10;
	}
	/**
	 * Draws the particle moving towards the edge of the screen
	 * @param s- PApplet from processing.core
	 */
	public void draw(DrawingSurface s) {
		s.pushMatrix();
		s.noStroke();
		move();
		s.fill(255);
		if(getDirection()){
			if(x>=s.width/2+width){
				s.rect((int)(x-width), (int)(y), (int)(width), (int)(height));
			} else if(x>=s.width/2){
				s.rect((int)Math.max(x, s.width/2), (int)(y), (int)(s.width/2-x), (int)(height));
			} 
		}else{
			if(x<=s.width/2)
				s.rect((int)Math.min(x, s.width/2), (int)(y), (int)Math.min(s.width/2-x, this.width), (int)(height));
		
		}
		System.out.println(x+""+y);
		s.stroke(0);
		s.popMatrix();
	}
	/**
	 * Moves to the right or left according to which side its on
	 */
	public void move(){
		if(isPointingLeft){
			moveByAmount(velocity,0);
		}else{
			moveByAmount(-velocity,0);
		}
	}
	public boolean getDirection(){
		return isPointingLeft;
	}
	public void setVelocity(int v){
		velocity = v;
	}
	public int getVelocity() {
		return velocity;
	}
	
}
