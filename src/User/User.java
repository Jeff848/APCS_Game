package User;

import java.util.ArrayList;

import Abilities.Bomb;
import Abilities.Fire;
import Abilities.Missile;
import Abilities.Zap;
import GUI.DrawingSurface;
import processing.core.PImage;
/**
 * Represents the plane of the user
 *
 */
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
	public User(PImage image, int x, int y, int w, int h, boolean l) {
		super(image, x, y, w, h);
		health = 500;
		isFacingLeft = l;
		xDirection = 0;
		yDirection = 0;		
		
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
	public User(int x, int y, int i, int j, boolean l) {
		super(x,y,i,j);
		health = 500;
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
	/**
	 * Adds a missile with the image depending on direction
	 * @param img1- img of missile going right
	 * @param img2- img of missile going left
	 */
	public void ab1(PImage img1, PImage img2){
		if(!isFacingLeft)
			mm.add(new Missile((int)(getX()+width), (int)(getY()+0.5*height), (int)width, (int)height, img1));
		else
			mm.add(new Missile((int)(getX()), (int)(getY()+0.5*height), (int)width, (int)height, img2));
	}
	/**
	 * Adds a bomb with its corresponding image
	 * @param img- img of bomb
	 */
	public void ab2(PImage img) {
		// TODO Auto-generated method stub
		if(!isFacingLeft)
			bb.add(new Bomb((int)(getX()+width), (int)(getY()+0.5*height), (int)width, (int)height, img));
		else 
			bb.add(new Bomb((int)(getX()), (int)(getY()+0.5*height), (int)width, (int)height, img));
	}
	/**
	 * Adds a zap with the image depending on direction
	 * @param img1- img of zap going right
	 * @param img2- img of zap going left
	 */
	public void ab3(PImage img1, PImage img2) {
		if(!isFacingLeft)
			zz.add(new Zap((int)(getX()+width), (int)(getY()+0.5*height), (int)width, (int)height, img1));
		else
			zz.add(new Zap((int)(getX()), (int)(getY()+0.5*height), (int)width, (int)height, img2));
		
		
	}
	/**
	 * Adds a fire with its corresponding image
	 * @param img- img of bomb
	 */
	public void ab4(PImage img) {
		// TODO Auto-generated method stub
		if(!isFacingLeft)
			ff.add(new Fire((int)(getX()+width), (int)(getY()+0.5*height), (int)width, (int)height, img));
		else
			ff.add(new Fire((int)(getX()), (int)(getY()+0.5*height), (int)width, (int)height, img));
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
	/**
	 * Draws the plane depending 
	 * @param s- PApplet from processing.core
	 */
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
	/**
	 * Checks to see if the other user is hit by the missile
	 * @param m- missile given
	 * @param u- other user
	 * @return boolean value if the missile is touching the other user
	 */
	public boolean isHit(Missile m, User u){		
			if(m.getX()>=u.getX()&&m.getX()<=u.getX()+u.getWidth()&&m.getY()>=u.getY()&&m.getY()<=u.getY()+u.getHeight()){
				return true;
			}	
			else{
				return false;
			}
		
	}
	/**
	 * Checks to see if the other user is hit by the bomb
	 * @param b- bomb given
	 * @param u- other user
	 * @return boolean value if the bomb is touching the other user
	 */
	public boolean isHitB(Bomb b, User u){	
		if(b.getX()>=u.getX()&&b.getX()<=u.getX()+u.getWidth()&&b.getY()>=u.getY()&&b.getY()<=u.getY()+u.getHeight()){
			return true;
		}	
		else{
			return false;
		}
	}
	/**
	 * Checks to see if the other user is hit by the zap
	 * @param z- zap given
	 * @param u- other user
	 * @return boolean value if the zap is touching the other user
	 */
	public boolean isHitZ(Zap z, User u){		
		if(z.getX()>=u.getX()&&z.getX()<=u.getX()+u.getWidth()&&z.getY()>=u.getY()&&z.getY()<=u.getY()+u.getHeight()){
			return true;
		}	
		else{
			return false;
		}
	}
	/**
	 * Checks to see if the other user is hit by the fire
	 * @param f- fire given
	 * @param u- other user
	 * @return boolean value if the fire is touching the other user
	 */
	public boolean isHitF(Fire f, User u){
		if(f.getX()>=u.getX()&&f.getX()<=u.getX()+u.getWidth()&&f.getY()>=u.getY()&&f.getY()<=u.getY()+u.getHeight()){
			return true;
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