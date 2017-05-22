package GUI;

import java.awt.event.KeyEvent;

import User.Corgi;
import User.Default;
import User.HarryPotter;
import User.User;

public class Menu {
	
	private int state;
	private User p1, p2;
	private int[] selections;
	public Menu(){
		state = 0;
	}
	public void drawMenuState(DrawingSurface s) {
		if(state == 0){
		
			s.background(255);
			s.textAlign(s.CENTER);
			s.fill(255,255,255);
			s.textFont(s.createFont("Arial", 48));
			s.text("TEMP MENU",10,10);
			s.stroke(0);
			s.noFill();
			if(isPointInside(s.width/2-100,s.height/2-25,200,50,s.mouseX,s.mouseY)){
				s.fill(0,255,0);
				s.rect(s.width/2-100, s.height/2-25, 200, 50);
				s.fill(255);
			} else {
				s.rect(s.width/2-100, s.height/2-25, 200, 50);
				s.text("Play", s.width/2-100, s.height/2-25);
			}
			if (isPointInside(s.width/2-100,s.height/4-25,200,50,s.mouseX,s.mouseY)){
				s.fill(0,255,0);
				s.rect(s.width/2-100, s.height/4-25, 200, 50);
				s.fill(255);
			} else {
				s.rect(s.width/2-100, s.height/4-25, 200, 50);
			}
			if (isPointInside(s.width/2-100,3*s.height/4-25,200,50,s.mouseX,s.mouseY)) {
				s.fill(0,255,0);
				s.rect(s.width/2-100, 3*s.height/4-25, 200, 50);
				s.fill(255);
			} else {
				s.rect(s.width/2-100, 3*s.height/4-25, 200, 50);
			}
		} else if(state == 1){
			s.background(255);
			s.textAlign(s.CENTER);
			s.fill(255,255,255);
			s.textFont(s.createFont("Arial", 48));
			s.text("TEMP MENU",10,10);
			s.stroke(0);
			s.noFill();
			s.rect(0, s.height/10, s.width/3, s.height/5);
			s.rect(s.width/3, s.height/10, s.width/3, s.height/5);
			s.rect(2*s.width/3, s.height/10, s.width/3, s.height/5);
			
			s.rect(0, s.height/4+s.height/10, s.width/3, s.height/5);
			s.rect(s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
			s.rect(2*s.width/3, s.height/4+s.height/10, s.width/3, s.height/5);
			
			s.rect(0, s.height/2+s.height/10, s.width/3, s.height/5);
			s.rect(s.width/3, s.height/2+s.height/10, s.width/3, s.height/5);
			s.rect(2*s.width/3, s.height/2+s.height/10, s.width/3, s.height/5);
			
			s.rect(s.width/2-50, s.height/2+s.height/3, 100, 50);
		} else if(state == 2){
			s.background(255);
			s.text("OPTIONS",s.width/2, s.height/2);
					
		}
				
		
		
	
		
	}
	public void mousePressedMenuState(DrawingSurface s, double x, double y) {
		if(state == 0){
			if(isPointInside(s.width/2-100,s.height/2-25,200,50,x,y)){
				state=2;
			} else if(isPointInside(s.width/2-100,s.height/4-25,200,50,x,y)){
				state =1;
			} else if(isPointInside(s.width/2-100,3*s.height/4-25,200,50,x,y)){
				state=0;
			}
		} else if(state == 1){
			if(isPointInside(s.width/2-50, s.height/2+s.height/3, 100, 50,x,y)){

					if(p1!=null && p2!=null){
						s.getGame().setGameUp(p1, p2, s.getImage(p1), s.getImage(p2), s);
						s.setState(s.GAME_STATE);
					}
						
						//throw new RuntimeException("No plane selected");
			
			} else if(isPointInside(0, s.height/10, s.width/3, s.height,x,y)){
				p1= new Default(0,0,null,false);
			} else if(isPointInside(s.width/3, s.height/10, s.width/3, s.height/5,x,y)){
				p1= new Corgi(0,0,null,false);
			} else if(isPointInside(2*s.width/3, s.height/10, s.width/3, s.height/5,x,y)){
				p1= new HarryPotter(0,0,null,false);
			} else if(isPointInside(0, s.height/4+s.height/10, s.width/3, s.height/5,x,y)){
				p2= new Default(0,0,null,true);
			} else if(isPointInside(s.width/3, s.height/4+s.height/10, s.width/3, s.height/5,x,y)){
				p2= new Corgi(0,0,null,true);
			} else if(isPointInside(2*s.width/3, s.height/4+s.height/10, s.width/3, s.height/5,x,y)){
				p2= new HarryPotter(0,0,null,true);
			} else if(isPointInside(0, s.height/2+s.height/10, s.width/3, s.height/5,x,y)){
				s.getGame().setBackground(0);
			} else if(isPointInside(s.width/3, s.height/2+s.height/10, s.width/3, s.height/5,x,y)){
				s.getGame().setBackground(1);
			} else if(isPointInside(2*s.width/3, s.height/2+s.height/10, s.width/3, s.height/5,x,y)){
				s.getGame().setBackground(2);
			}
		}
	}
	public static boolean isPointInside(double x, double y, double width, double height, double otherX, double otherY) {
		return (x <= otherX && y <= otherY && x + width >= otherX && y + height >= otherY);
	}
}
