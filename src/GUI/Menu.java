package GUI;

import java.awt.event.KeyEvent;

public class Menu {
	
	private int state;
	public Menu(){
		state = 0;
	}
	public void drawMenuState(DrawingSurface s) {
		if(state == 0){
		
			s.background(255);
			s.textAlign(s.CENTER);
			s.textSize(24);
			s.fill(255,255,255);
			// s.text("TEMP MENU",s.width/2,s.height/2);
			s.fill(0,0,0);
			if(isPointInside(s.width/2-100,s.height/2-25,200,50,s.mouseX,s.mouseY)){
				s.fill(0,255,0);
				s.rect(s.width/2-100, s.height/2-25, 200, 50);
				s.fill(0,0,0);
			} else {
				s.rect(s.width/2-100, s.height/2-25, 200, 50);
			}
			if (isPointInside(s.width/2-100,s.height/4-25,200,50,s.mouseX,s.mouseY)){
				s.fill(0,255,0);
				s.rect(s.width/2-100, s.height/4-25, 200, 50);
				s.fill(0,0,0);
			} else {
				s.rect(s.width/2-100, s.height/4-25, 200, 50);
			}
			if (isPointInside(s.width/2-100,3*s.height/4-25,200,50,s.mouseX,s.mouseY)) {
				s.fill(0,255,0);
				s.rect(s.width/2-100, 3*s.height/4-25, 200, 50);
				s.fill(0,0,0);
			} else {
				s.rect(s.width/2-100, 3*s.height/4-25, 200, 50);
			}
		} else if(state == 1){
			
		} else if(state == 2){
			
		}else{
			
		}
				
		
		
	
		
	}
	public void mousePressedMenuState(DrawingSurface s, double x, double y) {
		if(state == 0){
			if(isPointInside(s.width/2-100,s.height/2-25,200,50,x,y)){
				//options
			} else if(isPointInside(s.width/2-100,s.height/4-25,200,50,x,y)){
				//game
				s.setState(s.GAME_STATE);
			} else if(isPointInside(3*s.width/2-100,s.height/4-25,200,50,x,y)){
				//something else
			}
		}
	}
	public static boolean isPointInside(double x, double y, double width, double height, double otherX, double otherY) {
		return (x <= otherX && y <= otherY && x + width >= otherX && y + height >= otherY);
	}
}
