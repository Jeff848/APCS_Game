package GUI;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Abilities.Bomb;
import Abilities.Fire;
import Abilities.Missile;
import Abilities.Zap;
import User.Default;
import User.User;
import processing.core.PImage;

public class Game {
	private PImage img1, img2;
	private User p1, p2;
	public static final String fileSeperator = System.getProperty("file.separator");
	private ArrayList<Particle> particles1, particles2;
	private int background;
	PImage explosion;
	
	public Game(User p1, User p2){
		img1 = null;
		img2 = null;
		this.p1=p1;
		this.p2=p2;

		particles1 = new ArrayList<Particle>();
		particles2 = new ArrayList<Particle>();
		background = 1;
	}
	public Game() {
		img1 = null;
		img2 = null;
		this.p1=null;
		this.p2=null;

		particles1 = new ArrayList<Particle>();
		particles2 = new ArrayList<Particle>();
		background = 0;
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
				
				if(s.isPressed(KeyEvent.VK_1))
				{
					p1.ab1(s.getProjectiles()[0],s.getProjectiles()[1]);
				}
				if(s.isPressed(KeyEvent.VK_2))
				{
					p1.ab2(s.getProjectiles()[4]);
				}
				if(s.isPressed(KeyEvent.VK_3))
				{
					p1.ab3(s.getProjectiles()[2],s.getProjectiles()[3]);
				}
				if(s.isPressed(KeyEvent.VK_4))
				{
					p1.ab4(s.getProjectiles()[5]);
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
				
				if(s.isPressed(KeyEvent.VK_7))
				{
					p2.ab1(s.getProjectiles()[0],s.getProjectiles()[1]);
					
				}
				if(s.isPressed(KeyEvent.VK_8))
				{
					p2.ab2(s.getProjectiles()[4]);
				}
				if(s.isPressed(KeyEvent.VK_9))
				{
					p2.ab3(s.getProjectiles()[2],s.getProjectiles()[3]);
				}
				if(s.isPressed(KeyEvent.VK_0))
				{
					p2.ab4(s.getProjectiles()[5]);
				}
				
				p1.applyWindowLimits(s.width-40,s.height);
				p2.applyWindowLimits(s.width+40,s.height);
				p1.draw(s);
				p2.draw(s);
				s.noStroke();
				s.fill(0,120,255,155);
				s.rect(s.width/2-20,0,40,s.height);
				s.stroke(0);
				s.fill(255,0,0);
				s.rect(0,0,500,10);
				if(p1.getHealth()>0){
					s.fill(0,255,0);
					s.rect(0,0,p1.getHealth(),10);
				} else{
					//VICTORY SCREEN
					s.setState(s.MENU_STATE);
				}
				s.fill(255,0,0);
				s.rect(s.width-500,0,500,10);
				if(p2.getHealth()>0){
					s.fill(0,255,0);
					s.rect(s.width-p2.getHealth(),0,p2.getHealth(),10);
				} else{
					//VICTORY SCREEN
					s.setState(s.MENU_STATE);
				}
				ArrayList<Missile> m = p1.getArr();
				for(int i = 0; i<m.size(); i++){	
					m.get(i).move(p1);						
					m.get(i).draw(s, p1);
					if(p1.isHit(m.get(i), p2)){
						
						p2.setHealth(-10);
						s.image(explosion, (float)m.get(i).getX(), (float)m.get(i).getY());
						m.remove(i);
						i--;
					}
					
				}
				
				ArrayList<Bomb> b1 = p1.getBArr();
				for(int i = 0; i<b1.size(); i++){	
					b1.get(i).move(p1);						
					b1.get(i).draw(s, p1);
					if(p1.isHitB(b1.get(i), p2)){						
						p2.setHealth(-20);
						PImage explosion = s.loadImage("GUI"+fileSeperator+"explosion.png");
						s.image(explosion, (float)b1.get(i).getX(), (float)b1.get(i).getY());
						b1.remove(i);
						i--;
					}
					
				}
				
				ArrayList<Zap> z1 = p1.getZArr();
				for(int i = 0; i<z1.size(); i++){	
					z1.get(i).move(p1);						
					z1.get(i).draw(s, p1);
					if(p1.isHitZ(z1.get(i), p2)){
	
						p2.setHealth(-20);
						PImage explosion = s.loadImage("GUI"+fileSeperator+"explosion.png");
						s.image(explosion, (float)z1.get(i).getX(), (float)z1.get(i).getY());					
						z1.remove(i);
						i--;
					}
					
				}
				
				ArrayList<Fire> f1 = p1.getFArr();
				for(int i = 0; i<f1.size(); i++){	
					f1.get(i).move(p1);						
					f1.get(i).draw(s, p1);
					if(p1.isHitF(f1.get(i), p2)){
					
						p2.setHealth(-20);
						PImage explosion = s.loadImage("GUI"+fileSeperator+"explosion.png");
						s.image(explosion, (float)f1.get(i).getX(), (float)f1.get(i).getY());					
						f1.remove(i);
						i--;
					}
					
				}
				ArrayList<Missile> m1 = p2.getArr();
				for(int i = 0; i<m1.size(); i++){	
					m1.get(i).move(p2);						
					m1.get(i).draw(s, p2);
					if(p2.isHit(m1.get(i), p1)){
						p1.setHealth(-10);
						PImage explosion = s.loadImage("GUI"+fileSeperator+"explosion.png");
						s.image(explosion, (float)m1.get(i).getX(), (float)m1.get(i).getY());
						
						m1.remove(i);
						i--;
					}
					
				}
				
				ArrayList<Bomb> b = p2.getBArr();
				for(int i = 0; i<b.size(); i++){	
					b.get(i).move(p2);						
					b.get(i).draw(s, p2);
					if(p2.isHitB(b.get(i), p1)){
						
						p1.setHealth(-20);
						PImage explosion = s.loadImage("GUI"+fileSeperator+"explosion.png");
						s.image(explosion, (float)b.get(i).getX(), (float)b.get(i).getY());
						b.remove(i);
						i--;
					}
					
				}
				
				ArrayList<Zap> z = p2.getZArr();
				for(int i = 0; i<z.size(); i++){	
					z.get(i).move(p2);						
					z.get(i).draw(s, p2);
					if(p2.isHitZ(z.get(i), p1)){
	
						p1.setHealth(-20);
						PImage explosion = s.loadImage("GUI"+fileSeperator+"explosion.png");
						s.image(explosion, (float)z.get(i).getX(), (float)z.get(i).getY());					
						z.remove(i);
						i--;
					}
					
				}
				
				ArrayList<Fire> f = p2.getFArr();
				for(int i = 0; i<f.size(); i++){	
					f.get(i).move(p2);						
					f.get(i).draw(s, p2);
					if(p2.isHitF(f.get(i), p1)){
						
						p1.setHealth(-20);
						s.image(explosion, (float)f.get(i).getX(), (float)f.get(i).getY());					
						f.remove(i);
						i--;
					}
					
				}
				
			}
			
	}

	public void setGameUp(User default1, User default2, PImage i1, PImage i2, DrawingSurface s) {
		p1=default1;
		p2=default2;
		
		img1 = i1;
		img2 = i2;
		p1.setImage(img1);
		p2.setImage(img2);
		
		explosion = s.loadImage("GUI"+DrawingSurface.fileSeperator+"explosion.png");
		
	}
	public User getPlane1(){
		return p1;
	}
	public User getPlane2(){
		return p2;
	}
	public void setBackground(int i){
		background = i;
	}
}