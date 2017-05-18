package GUI;

import User.MovingImage;

public class Particle extends MovingImage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isPointingLeft;
	private int velocity;

	public Particle(int width, int height, DrawingSurface s, boolean l) {
		super(0,0, 200, 100);
		isPointingLeft=l;
		velocity = 100;
		if(l)
			setX(s.width/40*(int)(Math.random()*20+1)+s.width/2);
		else
			setX(s.width/40*(int)(Math.random()*20+1));
		setY(s.height/5*(int)(Math.random()*5+0.5));
		System.out.println(x+""+y+" "+s.width + " " + s.height);

	}
	public void draw(DrawingSurface s) {
		s.pushMatrix();
		s.noStroke();
		move(s);
		s.fill(0);
		s.rect((int)x, (int)y, (int)width, (int)height);
		System.out.println(x+""+y);
		s.popMatrix();
	}
	public void move(DrawingSurface s){
		if(isPointingLeft){
			if(x+this.width/2>=s.width/2&&x-this.width<=s.width){
					moveByAmount(velocity,0);
			} else {
					moveToLocation((int)(s.width/2+this.width),s.height/5*(int)(Math.random()*5+1));
			}
		}else{
			if(x+this.width>=0&&x-this.width<=s.width/2){
					moveByAmount(-velocity,0);
			} else {
					
					moveToLocation((int)(s.width/2-this.width),s.height/5*(int)(Math.random()*5+1));
			}
		}
	}
}
