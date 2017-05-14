package User;

import Abilities.Ability;
import GUI.DrawingSurface;
import processing.core.PImage;

public class User extends MovingImage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	public static final int UP = -1;
	public static final int DOWN = 1;
	public static final int moveAmount = 3;
	private boolean isFacingLeft;
	private int health;
	private int xDirection;
	private int yDirection;
	
	private Ability[] ab = new Ability[4];
	
	
	public User(PImage image, int x, int y, int w, int h, Ability[] a, boolean l) {
		super(image, x, y, w, h);
		ab = a;
		health = 200;
		isFacingLeft = l;
		xDirection = 0;
		yDirection = 0;
		// TODO Auto-generated constructor stub
	}
	public User(int x, int y, int i, int j, Ability[] a, boolean l) {
		super(x,y,i,j);
		ab = a;
		health = 200;
		isFacingLeft = l;
	}
	public void move(int windowWidth, int windowHeight){
		if(xDirection==LEFT)
		{
			moveByAmount(-(int)(moveAmount/500.0 * windowWidth),0);
		}else if(xDirection == RIGHT){
			moveByAmount((int)(moveAmount/500.0 * windowWidth),0);
		}
		if(yDirection == UP){
			moveByAmount(0,-(int)(moveAmount/500.0 * windowWidth));
		}else if(yDirection == DOWN)
		{
			moveByAmount(0,(int)(moveAmount/500.0 * windowWidth));
		}
		
	}
	public void applyWindowLimits(int windowWidth, int windowHeight)
	{
		if(isFacingLeft)
		{
			setX(Math.min(getX(),windowWidth-width));
			setY(Math.min(getY(),windowHeight-height));
			setX(Math.max(windowWidth/2-width,getX()));
			setY(Math.max(0,getY()));
		}else
		{
			setX(Math.min(getX(),windowWidth/2-width));
			setY(Math.min(getY(),windowHeight-height));
			setX(Math.max(0,getX()));
			setY(Math.max(0,getY()));
		}
	}
	public void draw(DrawingSurface s)
	{
		if(isFacingLeft)
		{
			s.pushMatrix();
			s.scale((float) -1.0);
			s.image(getImage(),(int)getX(),(int)getY());
			s.popMatrix();
		} else
		{
			super.draw(s);
		}
	}
	/*
	public abstract void ab1();
	public abstract void ab2();
	public abstract void ab3();
	public abstract void ab4();
	*/
	public int getHealth(){
		return health;
	}
	public boolean isFacingLeft(){
		return isFacingLeft;
	}
	public void ab1() {
		// TODO Auto-generated method stub
		
	}
	public void ab2() {
		// TODO Auto-generated method stub
		
	}
	public void ab3() {
		// TODO Auto-generated method stub
		
	}
	public void ab4() {
		// TODO Auto-generated method stub
		
	}
	public int getXDirection(){
		return xDirection;
	}
	public int getYDirection(){
		return yDirection;
	}
	public void setDirection(int xDir, int yDir){
		xDirection=xDir;
		yDirection=yDir;
	}
	
	
}
