package GUI;

import User.MovingImage;

public class Particle extends MovingImage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isPointingLeft;
	private int velocity;

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
	public void draw(DrawingSurface s) {
		s.pushMatrix();
		s.noStroke();
		move(s);
		s.fill(255);
		if(isPointingLeft){
			s.rect((int)x, (int)y, (int)width+(int)Math.min(0, x-s.width/2), (int)height);
		}else{
			s.rect((int)x, (int)y, (int)Math.min(s.width/2-x, this.width), (int)height);
		}
		System.out.println(x+""+y);
		s.stroke(0);
		s.popMatrix();
	}
	public void move(DrawingSurface s){
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
