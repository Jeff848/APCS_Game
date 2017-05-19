package GUI;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import User.User;
import processing.core.PImage;

public class Game {
	private PImage img1, img2;
	private User p1, p2;
	private String p1Name, p2Name;
	private ArrayList<Particle> particles;
	private int i;
	public Game(User p1, User p2)
	{
		img1 = null;
		img2 = null;
		this.p1=p1;
		this.p2=p2;
		p1Name = p1.getName();
		p2Name = p2.getName();
		particles = new ArrayList<Particle>();
		
		i=0;
	}
	public void drawGameState(DrawingSurface s) {
			if(s.isPressed(KeyEvent.VK_SPACE))
			{
				s.setState(s.PAUSE_STATE);
				s.getKeys().clear();
			}else
			{
				
				if(i<2){
					for(int i = 0; i<10; i++){
						if(i%2==0)
							particles.add(new Cloud(200,100,s,false, 255, 255, 255,true));
						else
							particles.add(new Cloud(200,100,s,true, 255, 255, 255,true));
					}
				} else if(i%4==0){
					particles.add(new Cloud(200,100,s,false, 255, 255, 255,false));
					particles.add(new Cloud(200,100,s,true, 255, 255, 255,false));
				}
			
					
				
				
				s.background(135,206,235);   // Clear the screen with a white background
				s.fill(255);
				s.textAlign(s.CENTER);
				s.textSize(12);
				for(int i = 0; i<particles.size();i++){
					particles.get(i).draw(s);
					if(particles.get(i).getX()<=-particles.get(i).getWidth()-10||particles.get(i).getX()>=s.width+particles.get(i).getWidth()+10){
						particles.remove(i);
					}
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
				
				p1.applyWindowLimits(s.width,s.height-(s.height/7));
				p2.applyWindowLimits(s.width,s.height-(s.height/7));
				p1.draw(s);
				p2.draw(s);
				s.line(s.width/2,0,s.width/2,s.height);
				s.line(s.width/2+200,0, s.width/2+200, s.height);
				s.line(s.width/2-200,0, s.width/2-200, s.height);
				s.fill(255,0,0);
				s.rect(0,0,200,10);
				s.fill(0,255,0);
				s.rect(0,0,p1.getHealth(),10);
				s.fill(255,0,0);
				s.rect(s.width-200,0,200,10);
				s.fill(0,255,0);
				s.rect(s.width-200,0,p2.getHealth(),10);
				
				// starting to add ability boxes
				//double bottomRestriction = s.height*7/8;
				//s.rect((float)(s.width*(1/17)), (float)((s.height*7/8.0) + (s.height*(1.0/64.0))),  (float)(s.width/17.0), (float)((s.height*7/8.0) + (s.height*3/32.0)));
				i++;
			}
	}
	public void setGameUp(DrawingSurface s) {
		// TODO Auto-generated method stub
		img1 = s.loadImage("GUI"+DrawingSurface.fileSeperator+p1Name+".gif");
		img2 = s.loadImage("GUI"+DrawingSurface.fileSeperator+p2Name+".gif");
		p1.setImage(img1);
		p2.setImage(img2);
	}
	
}
