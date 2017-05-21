package User;

import java.util.ArrayList;

import Abilities.Ability;
import Abilities.Missile;
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
	private ArrayList<Missile> mm = new ArrayList<>();
	
	/** 
	 * Makes a plane with the parameters
	 * @param image- PImage of plane
	 * @param x- x coord
	 * @param y- y coord
	 * @param w- width
	 * @param h- height
	 * @param a- ability list
	 * @param l- dictates which side the plane is on
	 */
	public User(PImage image, int x, int y, int w, int h, Ability[] a, boolean l) {
		super(image, x, y, w, h);
		health = 200;
		isFacingLeft = l;
		xDirection = 0;
		yDirection = 0;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Makes a plane with the parameters (null img)
	 * @param x- x coord
	 * @param y- y coord
	 * @param w- width
	 * @param h- height
	 * @param a- ability list
	 * @param l- dictates which side the plane is on
	 */
	public User(int x, int y, int i, int j, Ability[] a, boolean l) {
		super(x,y,i,j);
		health = 200;
		isFacingLeft = l;
	}
	/**
	 * Moves in the x direction and the y direction- scales with the window size
	 * @param windowWidth- window width
	 * @param windowHeight- window height
	 */
	public void move(int windowWidth, int windowHeight, int xDir, int yDir){
		if(xDir==LEFT)
		{
			moveByAmount(-(int)(moveAmount/500.0 * windowWidth),0);
		}else if(xDir == RIGHT){
			moveByAmount((int)(moveAmount/500.0 * windowWidth),0);
		}
		
		if(yDir == UP){
			moveByAmount(0,-(int)(moveAmount/500.0 * windowWidth));
		}else if(yDir == DOWN)
		{
			moveByAmount(0,(int)(moveAmount/500.0 * windowWidth));
		}
		
	}
	/**
	 * Makes sure the plane is within its bounds on either side
	 * @param windowWidth- window Width
	 * @param windowHeight- window Height
	 */
	public void applyWindowLimits(int windowWidth, int windowHeight)
	{
		if(isFacingLeft)
		{
			setX(Math.min(getX(),windowWidth-width));
			setY(Math.min(getY(),windowHeight-height));
			setX(Math.max(windowWidth/2,getX()));
			setY(Math.max(0,getY()));
		}else
		{
			setX(Math.min(getX(),windowWidth/2-width));
			setY(Math.min(getY(),windowHeight-height));
			setX(Math.max(0,getX()));
			setY(Math.max(0,getY()));
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
	public ArrayList<Missile> getArr(){
		return mm;
	}
	public void ab1(DrawingSurface s){
		mm.add(new Missile((int)(getX()+width), (int)(getY()+0.5*height), (int)width, (int)height));		
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
	public void draw(DrawingSurface s)
	{
		if(isFacingLeft)
		{	
			s.image(getImage(), (int)(x+width), (int)y, -(int)getWidth(), (int)getHeight());
		}else
		{
			super.draw(s);
		}
	}
	public String getName(){
		return "";
	}
	
	public boolean isHit(Missile m, User u){
		if(!isFacingLeft()){
			if(m.getX()>=u.getX()&&m.getX()<=u.getMaxX()&&m.getY()>=u.getY()&&m.getY()<=u.getMaxY()){
				return true;
			}	
			else{
				return false;
			}
		}
		else{
			/*if(m.getX()<=getX()&&m.getY()>=getY()&&m.getY()<=getMaxY()){
				return true;
			}
			else{
				return false;
			}*/
			return false;
		}
	}
	public void setHealth(int x){
		health += x;
	}
	public void keyPressed(int vk5) {
		// TODO Auto-generated method stub
		
	}

}