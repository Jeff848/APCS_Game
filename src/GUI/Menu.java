package GUI;

import User.Corgi;
import User.Default;
import User.HarryPotter;
import User.User;
import processing.core.PImage;
/**
 * Represents the menu of the game
 *
 */
public class Menu {
	
	private int state;
	private User p1, p2;
	private PImage u1,u2,u3,u4,u5,u6;
	private int[] selections;
	private PImage logo, test;
	/**
	 * Creates a menu at the starting menu
	 */
	public Menu(){
		state = 0;
		selections = new int[3];
		u1=null;
		u2=null;
		u3=null;
		u4=null;
		u5=null;
		u6=null;
	}
	/**
	 * Draws the menu according to which menu state it is in
	 * @param s- PApplet from processing.core
	 */
	public void drawMenuState(DrawingSurface s) {
		if(state == 0){
			s.background(135,206,235);   // Clear the screen with a white background
			s.fill(0);
			s.textAlign(s.CENTER);
			s.textSize(24);
			s.stroke(0);
			s.noFill();
			s.textAlign(s.CENTER);
			s.textSize(24);
			s.image(logo, s.width/2-200, s.height/4-200,400,400);
			s.image(u1, (s.frameCount*10)%(s.width+128)-128,s.height/4+400,128,64);
			s.image(u2, (s.frameCount*10+256)%(s.width+128)-128,s.height/4+400,128,64);
			s.image(u3, (s.frameCount*10-256)%(s.width+128)-128,s.height/4+400,128,64);
			s.fill(255);
			if(isPointInside(s.width/2-s.width/10, s.height/2, s.width/5, 50,s.mouseX,s.mouseY)){
				s.fill(0,255,0);
				s.rect(s.width/2-s.width/10, s.height/2, s.width/5, 50);
				s.fill(255);
			} else {
				s.rect(s.width/2-s.width/10, s.height/2, s.width/5, 50);
				s.fill(0);
				s.text("PLAY", s.width/2, s.height/2+25);
				s.fill(255);
			}
			if (isPointInside(s.width/2-s.width/10, s.height/2+50, s.width/5, 50,s.mouseX,s.mouseY)){
				s.fill(0,255,0);
				s.rect(s.width/2-s.width/10, s.height/2+50, s.width/5, 50);
				s.fill(255);
			} else {
				s.rect(s.width/2-s.width/10, s.height/2+50, s.width/5, 50);
				s.fill(0);
				s.text("OPTIONS", s.width/2, s.height/2+75);
				s.fill(255);
			}
			if (isPointInside(s.width/2-s.width/10, s.height/2+100, s.width/5, 50,s.mouseX,s.mouseY)) {
				s.fill(0,255,0);
				s.rect(s.width/2-s.width/10, s.height/2+100, s.width/5, 50);
				s.fill(255);
			} else {
				s.rect(s.width/2-s.width/10, s.height/2+100, s.width/5, 50);
				s.fill(0);
				s.text("QUIT", s.width/2, s.height/2+125);
				s.fill(255);
			}
		} else if(state == 1){
			s.background(255);
			s.textAlign(s.CENTER);
			s.fill(0);
			s.textFont(s.createFont("Arial", 48));
			s.text("Character Select",s.width/2,32);
			s.stroke(0);
			s.noFill();
			s.textFont(s.createFont("Helvetica", 24));
			s.text("Player 1",s.width/2,s.height/10-12);
			s.rect(0, s.height/10, s.width/3, s.height/5);
			s.rect(s.width/3, s.height/10, s.width/3, s.height/5);
			s.rect(2*s.width/3, s.height/10, s.width/3, s.height/5);
			s.text("Player 2",s.width/2,s.height/4+s.height/10-12);
			s.rect(0, s.height/4+s.height/10, s.width/3, s.height/5);
			s.rect(s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
			s.rect(2*s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
			s.text("Background",s.width/2,s.height/2+s.height/10-12);
			s.rect(0, s.height/2+s.height/10, s.width/3, s.height/5);
			s.rect(s.width/3, s.height/2+s.height/10, s.width/3, s.height/5);
			s.rect(2*s.width/3, s.height/2+s.height/10, s.width/3, s.height/5);
			if(selections[0]==0){
				s.image(u1,0, s.height/10, s.width/3, s.height/5);
				s.image(u2,s.width/3, s.height/10, s.width/3, s.height/5);
				s.image(u3,2*s.width/3, s.height/10, s.width/3, s.height/5);
			}else if(selections[0]==1){
				s.tint(173,255,47,126);
				s.image(u1,0, s.height/10, s.width/3, s.height/5);
				s.noTint();
				s.image(u2,s.width/3, s.height/10, s.width/3, s.height/5);
				s.image(u3,2*s.width/3, s.height/10, s.width/3, s.height/5);
			}else if(selections[0]==2){
				s.image(u1,0, s.height/10, s.width/3, s.height/5);
				s.tint(173,255,47,126);
				s.image(u2,s.width/3, s.height/10, s.width/3, s.height/5);
				s.noTint();
				s.image(u3,2*s.width/3, s.height/10, s.width/3, s.height/5);
			} else{
				s.image(u1,0, s.height/10, s.width/3, s.height/5);
				s.image(u2,s.width/3, s.height/10, s.width/3, s.height/5);
				s.tint(173,255,47,126);
				s.image(u3,2*s.width/3, s.height/10, s.width/3, s.height/5);
				s.noTint();
			}
			if(selections[1]==0){
				s.image(u4,0, s.height/4+s.height/10, s.width/3, s.height/5);
				s.image(u5,s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
				s.image(u6,2*s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
			}else if(selections[1]==1){
				s.tint(173,255,47,126);
				s.image(u4,0, s.height/4+s.height/10, s.width/3, s.height/5);
				s.noTint();
				s.image(u5,s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
				s.image(u6,2*s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
			}else if(selections[1]==2){
				s.image(u4,0, s.height/4+s.height/10, s.width/3, s.height/5);
				s.tint(173,255,47,126);
				s.image(u5,s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
				s.noTint();
				s.image(u6,2*s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
			} else{
				s.image(u4,0, s.height/4+s.height/10, s.width/3, s.height/5);
				s.image(u5,s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
				s.tint(173,255,47,126);
				s.image(u6,2*s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
				s.noTint();
			}
			if(selections[2]==0){
				s.fill(135,206,235);
				s.rect(0, s.height/2+s.height/10, s.width/3, s.height/5);
				s.fill(19,24,98);
				s.rect(s.width/3, s.height/2+s.height/10, s.width/3, s.height/5);
				s.fill(200,24,98);
				s.rect(2*s.width/3, s.height/2+s.height/10, s.width/3, s.height/10);
				s.fill(254,91,53);
				s.rect(2*s.width/3, s.height/2+s.height/5, s.width/3, s.height/10);
				s.fill(0);
			}else if(selections[2]==1){
				s.fill(135,206,235,155);
				s.rect(0, s.height/2+s.height/10, s.width/3, s.height/5);
				s.fill(19,24,98);
				s.rect(s.width/3, s.height/2+s.height/10, s.width/3, s.height/5);
				s.fill(200,24,98);
				s.rect(2*s.width/3, s.height/2+s.height/10, s.width/3, s.height/10);
				s.fill(254,91,53);
				s.rect(2*s.width/3, s.height/2+s.height/5, s.width/3, s.height/10);
				s.fill(0);
			}else if(selections[2]==2){
				s.fill(135,206,235);
				s.rect(0, s.height/2+s.height/10, s.width/3, s.height/5);
				s.fill(19,24,98,155);
				s.rect(s.width/3, s.height/2+s.height/10, s.width/3, s.height/5);
				s.fill(200,24,98);
				s.rect(2*s.width/3, s.height/2+s.height/10, s.width/3, s.height/10);
				s.fill(254,91,53);
				s.rect(2*s.width/3, s.height/2+s.height/5, s.width/3, s.height/10);
				s.fill(0);
			} else{
				s.fill(135,206,235);
				s.rect(0, s.height/2+s.height/10, s.width/3, s.height/5);
				s.fill(19,24,98);
				s.rect(s.width/3, s.height/2+s.height/10, s.width/3, s.height/5);
				s.fill(200,24,98,155);
				s.rect(2*s.width/3, s.height/2+s.height/10, s.width/3, s.height/10);
				s.fill(254,91,53,155);
				s.rect(2*s.width/3, s.height/2+s.height/5, s.width/3, s.height/10);
				s.fill(0);
			}
			
			s.text("START", s.width/2, s.height/2+s.height/3+25);
			s.rect(s.width/2-50, s.height/2+s.height/3, 100, 50);
			
		} else if(state == 2){
			s.background(135,206,235);   // Clear the screen with a white background
			s.fill(0);
			s.textAlign(s.CENTER);
			s.textSize(48);
			s.text("Controls",s.width/15+10, s.height/10);
			s.text("Movement",s.width/15+30,s.height/10+58);
			s.text("P1: Press WASD to move. P2: Press ↑←↓→ to move", s.width/15+s.width/3+10, 3*s.height/10);
			s.text("Abilities",s.width/15+5,4*s.height/10+58);
			s.text("P1: Press 1234 to fire an ability. P2: Press 7890 to fire an ability", s.width/8+s.width/3, 6*s.height/10);
			s.text("Press SPACE to pause", s.width/15+s.width/4, 7*s.height/10);
			s.image(u1,(int)(Math.sin(Math.toRadians(s.frameCount))*500)+s.width/2,s.height/10+58,128,64);
			s.image(test, (s.frameCount*10)%(3*s.width/4)+s.width/4, 4*s.height/5,128,64);
			s.fill(255);
			s.rect(0, s.height-100, 250,100 );
			s.fill(0);
			s.text("Main Menu", 125, s.height-50);
		}
				
		
		
	
		
	}
	public void mousePressedMenuState(DrawingSurface s, double x, double y) {
		if(state == 0){
			if(isPointInside(s.width/2-s.width/10, s.height/2+50, s.width/5, 50,x,y)){
				state=2;
			} else if(isPointInside(s.width/2-s.width/10, s.height/2, s.width/5, 50,x,y)){
				state =1;
			} else if(isPointInside(s.width/2-s.width/10, s.height/2+100, s.width/5, 50,x,y)){
				s.exit();
			}
		} else if(state == 1){
			if(isPointInside(s.width/2-50, s.height/2+s.height/3, 100, 50,x,y)){
					if(p1!=null && p2!=null){
						s.getGame().setGameUp(p1, p2, p1.getImage(), p2.getImage(), s);
						s.setState(s.GAME_STATE);
					}
						//throw new RuntimeException("No plane selected");
			} else if(isPointInside(0, s.height/10, s.width/3, s.height/5,x,y)){
				p1= new Default(0,0,false);
				selections[0]=1;
				p1.setImage(u1);
			} else if(isPointInside(s.width/3, s.height/10, s.width/3, s.height/5,x,y)){
				p1= new Corgi(0,0,false);
				selections[0]=2;
				p1.setImage(u2);
			} else if(isPointInside(2*s.width/3, s.height/10, s.width/3, s.height/5,x,y)){
				p1= new HarryPotter(0,0,false);
				selections[0]=3;
				p1.setImage(u3);
			} else if(isPointInside(0, s.height/4+s.height/10, s.width/3, s.height/5,x,y)){
				p2= new Default(0,0,true);
				selections[1]=1;
				p2.setImage(u4);
			} else if(isPointInside(s.width/3, s.height/4+s.height/10, s.width/3, s.height/5,x,y)){
				p2= new Corgi(0,0,true);
				selections[1]=2;
				p2.setImage(u5);
			} else if(isPointInside(2*s.width/3, s.height/4+s.height/10, s.width/3, s.height/5,x,y)){
				p2= new HarryPotter(0,0,true);
				selections[1]=3;
				p2.setImage(u6);
			} else if(isPointInside(0, s.height/2+s.height/10, s.width/3, s.height/5,x,y)){
				s.getGame().setBackground(0);
				selections[2]=1;
			} else if(isPointInside(s.width/3, s.height/2+s.height/10, s.width/3, s.height/5,x,y)){
				s.getGame().setBackground(1);
				selections[2]=2;
			} else if(isPointInside(2*s.width/3, s.height/2+s.height/10, s.width/3, s.height/5,x,y)){
				s.getGame().setBackground(2);
				selections[2]=3;
			} 
		} else {
			if(isPointInside(0, s.height-100, 250,100 ,x,y)){
				state=0;
			}
		}
	}
	/**
	 * Returns whether the point with coordinates otherX and otherY is within the rectangle with the rest of the parameters
	 * @param x- x coordinate of the rectangle
	 * @param y- y coordinate of the rectangle
	 * @param width- width of the rectangle
	 * @param height- height of the rectangle 
	 * @param otherX- x coordinate of the given point
	 * @param otherY- y coordinate of the given point
	 * @return
	 */
	public static boolean isPointInside(double x, double y, double width, double height, double otherX, double otherY) {
		return (x <= otherX && y <= otherY && x + width >= otherX && y + height >= otherY);
	}
	/**
	 * Sets the menu up with the correct images
	 * @param images- images of the plane
	 * @param s- PApplet from processing.core
	 */
	public void setMenuUp(PImage[] images, DrawingSurface s){
		u1=images[0];
		u2=images[1];
		u3=images[2];
		u4=images[3];
		u5=images[4];
		u6=images[5];
		logo = s.loadImage("GUI"+DrawingSurface.fileSeperator+"Logo.png");
		test = s.loadImage("GUI"+DrawingSurface.fileSeperator+"Missile.png");
		
	}
}
