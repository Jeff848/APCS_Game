package GUI;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Abilities.Missile;
import User.User;
import processing.core.PImage;

public class Game {
	
	private User p1, p2;
	private String p1Name, p2Name;
	private ArrayList<Particle> particles1, particles2;
	private int background;
	public Game()
	{
		this.p1=null;
		this.p2=null;
		p1Name = null;
		p2Name = null;
		particles1 = new ArrayList<Particle>();
		particles2 = new ArrayList<Particle>();
		background = 3;
	}
	public void drawGameState(DrawingSurface s) {
			if(s.isPressed(KeyEvent.VK_SPACE))
			{
				s.setState(s.PAUSE_STATE);
				s.getKeys().clear();
			}else
			{
				if(background == 0){
					if(s.frameCount<2){
						for(int i = 0; i<10; i++){
							if(i%2==0)
								particles1.add(new Cloud(200,100,s,false, 255, 255, 255,true));
							else
								particles1.add(new Cloud(200,100,s,true, 255, 255, 255,true));
						}
					} else if(s.frameCount%8==0){
						particles1.add(new Cloud(200,100,s,false, 255, 255, 255,false));
						particles1.add(new Cloud(200,100,s,true, 255, 255, 255,false));
					}
					s.background(135,206,235);   
				}else if(background ==1){
					if(s.frameCount<2){
						for(int i = 0; i<10; i++){
							if(i%2==0){
								particles1.add(new Cloud(200,100,s,false, 184,184,181,true));
							}else{
								particles1.add(new Cloud(200,100,s,true, 184,184,181,true));
							}
						}
					} else if(s.frameCount%8==0){
						particles1.add(new Cloud(200,100,s,false, 184,184,181,false));
						particles1.add(new Cloud(200,100,s,true, 184,184,181,false));
						if(s.frameCount%64==0){
							particles2.add(new Star(10,25,s,false,true));
							particles2.add(new Star(10,25,s,true,true));
						}
					}
					s.background(19,24,98);   
					
				}else {
					
					if(s.frameCount<2){
						for(int i = 0; i<10; i++){
							if(i%2==0){
								particles1.add(new Cloud(200,100,s,false, 184,184,181,true));
							}else{
								particles1.add(new Cloud(200,100,s,true, 184,184,181,true));
							}
							
						}
					} else if(s.frameCount%8==0){
						particles1.add(new Cloud(200,100,s,false, 184,184,181,false));
						particles1.add(new Cloud(200,100,s,true, 184,184,181,false));
					}
					s.background(200,24,98); 
					s.fill(254,91,53);
					s.noStroke();
					s.rect(0,s.height/2,s.width,s.height/2);
					
				}	
					
				for(int i = 0; i<particles2.size();i++){
					if(particles2.get(i).getX()<=-particles2.get(i).getWidth()-50||particles2.get(i).getX()>=s.width+particles2.get(i).getWidth()+50){
						particles2.remove(i);
					}
					particles2.get(i).draw(s);
				}
				for(int i = 0; i<particles1.size();i++){
					if(particles1.get(i).getX()<=-particles1.get(i).getWidth()-50||particles1.get(i).getX()>=s.width+particles1.get(i).getWidth()+50){
						particles1.remove(i);
					}
					particles1.get(i).draw(s);
				}
				
				if(s.isPressed(KeyEvent.VK_W))
				{
					if(s.getKeys().indexOf(KeyEvent.VK_W)>s.getKeys().indexOf(KeyEvent.VK_S))
						p1.move(s.width,s.height,0,-1);
					else
						p1.move(s.width,s.height,0,1);
				}
				else if(s.isPressed(KeyEvent.VK_S))
				{
					p1.move(s.width,s.height,0,1);
				}
				
				if(s.isPressed(KeyEvent.VK_A))
				{
					if(s.getKeys().indexOf(KeyEvent.VK_A)>s.getKeys().indexOf(KeyEvent.VK_D))
						p1.move(s.width,s.height,-1,0);
					else
						p1.move(s.width,s.height,1,0);
				}
				else if(s.isPressed(KeyEvent.VK_D))
				{
					p1.move(s.width,s.height,1,0);
				}
				
				if(s.isPressed(KeyEvent.VK_UP))
				{
					if(s.getKeys().indexOf(KeyEvent.VK_UP)>s.getKeys().indexOf(KeyEvent.VK_DOWN))
						p2.move(s.width,s.height,0,-1);
					else
						p2.move(s.width,s.height,0,1);
				}
				else if(s.isPressed(KeyEvent.VK_DOWN))
				{
					p2.move(s.width,s.height,0,1);
				}
				
				if(s.isPressed(KeyEvent.VK_LEFT))
				{
					if(s.getKeys().indexOf(KeyEvent.VK_LEFT)>s.getKeys().indexOf(KeyEvent.VK_RIGHT))
						p2.move(s.width,s.height,-1,0);
					else
						p2.move(s.width,s.height,1,0);
				}
				else if(s.isPressed(KeyEvent.VK_RIGHT))
				{
					p2.move(s.width,s.height,1,0);
				}

				if(s.isPressed(KeyEvent.VK_1))
				{
					p2.keyPressed(KeyEvent.VK_1);
					ArrayList<Missile> m = p1.getArr();
					for(int i = 1; i<m.size(); i++){	
						m.get(i).move(p1);						
						m.get(i).draw(s, p1);
						if(p1.isHit(m.get(i), p2)){
							System.out.println("hit");
							p2.setHealth(-10);
						}
						
					}
				}
				else if(s.isPressed(KeyEvent.VK_2))
				{
					p2.keyPressed(KeyEvent.VK_2);
				}
				else if(s.isPressed(KeyEvent.VK_3))
				{
					p2.keyPressed(KeyEvent.VK_3);
				}
				else if(s.isPressed(KeyEvent.VK_4))
				{
					p2.keyPressed(KeyEvent.VK_4);
				}
				else if(s.isPressed(KeyEvent.VK_7))
				{
					p1.keyPressed(KeyEvent.VK_5);
				}
				else if(s.isPressed(KeyEvent.VK_8))
				{
					p1.keyPressed(KeyEvent.VK_6);
				}
				else if(s.isPressed(KeyEvent.VK_9))
				{
					p1.keyPressed(KeyEvent.VK_7);
				}
				if(s.isPressed(KeyEvent.VK_0))
				{
					p1.keyPressed(KeyEvent.VK_8);
				}
				
				p1.applyWindowLimits(s.width-40,s.height-(s.height/7));
				p2.applyWindowLimits(s.width+40,s.height-(s.height/7));
				p1.draw(s);
				p2.draw(s);
				s.pushMatrix();
				s.noStroke();
				s.fill(0,120,255,155);
				s.rect(s.width/2-20,0,40,s.height);
				//s.line(s.width/2+200,0, s.width/2+200, s.height);
				//s.line(s.width/2-200,0, s.width/2-200, s.height);
				s.fill(255);
				s.textAlign(s.CENTER);
				s.textSize(12);
				s.fill(255,0,0);
				s.rect(0,0,200,10);
				s.fill(0,255,0);
				s.rect(0,0,p1.getHealth(),10);
				s.fill(255,0,0);
				s.rect(s.width-200,0,200,10);
				s.fill(0,255,0);
				s.rect(s.width-200,0,p2.getHealth(),10);
				s.popMatrix();
				// starting to add ability boxes
				//double bottomRestriction = s.height*7/8;
				//s.rect((float)(s.width*(1/17)), (float)((s.height*7/8.0) + (s.height*(1.0/64.0))),  (float)(s.width/17.0), (float)((s.height*7/8.0) + (s.height*3/32.0)));
			}
	}
	public void setGameUp(User p1, User p2, PImage img1, PImage img2) {
		this.p1=p1;
		this.p2=p2;
		p1.setImage(img1);
		p2.setImage(img2);
	}
	
	
	
}
