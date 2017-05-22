package User;

import java.util.ArrayList;

import Abilities.Ability;
import Abilities.Bomb;
import Abilities.Fire;
import Abilities.Missile;
import Abilities.Zap;
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
	private ArrayList<Bomb> bb = new ArrayList<>();
	private ArrayList<Zap> zz = new ArrayList<>();
	private ArrayList<Fire> ff = new ArrayList<>();
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
	public ArrayList<Bomb> getBArr(){
		return bb;
	}
	public ArrayList<Zap> getZArr(){
		return zz;
	}
	public ArrayList<Fire> getFArr(){
		return ff;
	}
	public void ab1(DrawingSurface s){
		//System.out.println("arriba");
		mm.add(new Missile((int)(getX()+width), (int)(getY()+0.5*height), (int)width, (int)height, s));		
	}
	public void ab2(DrawingSurface s) {
		// TODO Auto-generated method stub
		bb.add(new Bomb((int)(getX()+width), (int)(getY()+0.5*height), (int)width, (int)height, s));
	}
	public void ab3(DrawingSurface s) {
		zz.add(new Zap((int)(getX()+width), (int)(getY()+0.5*height), (int)width, (int)height, s));
		// TODO Auto-generated method stub
		
	}
	public void ab4(DrawingSurface s) {
		// TODO Auto-generated method stub
		ff.add(new Fire((int)(getX()+width), (int)(getY()+0.5*height), (int)width, (int)height, s));
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
			return false;
		}
	}
	public boolean isHitB(Bomb b, User u){
		if(!isFacingLeft()){
			if(b.getX()>=u.getX()&&b.getX()<=u.getMaxX()&&b.getY()>=u.getY()&&b.getY()<=u.getMaxY()){
				return true;
			}	
			else{
				return false;
			}
		}
		else{
			
			return false;
		}
	}
	public boolean isHitZ(Zap z, User u){
		if(!isFacingLeft()){
			if(z.getX()>=u.getX()&&z.getX()<=u.getMaxX()&&z.getY()>=u.getY()&&z.getY()<=u.getMaxY()){
				return true;
			}	
			else{
				return false;
			}
		}
		else{
			
			return false;
		}
	}
	public boolean isHitF(Fire f, User u){
		if(!isFacingLeft()){
			if(f.getX()>=u.getX()&&f.getX()<=u.getMaxX()&&f.getY()>=u.getY()&&f.getY()<=u.getMaxY()){
				return true;
			}	
			else{
				return false;
			}
		}
		else{
			
			return false;
		}
	}
	public void setHealth(int x){
		health += x;
	}
	public void addPauseTime(long startPauseTime)
	{
		System.out.println("AddPauseTime event is invoked in User object. This is not valid.");
	}	
	public void keyPressed(int vk5) {
		// TODO Auto-generated method stub
		
	}

}