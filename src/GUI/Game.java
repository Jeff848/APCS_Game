package GUI;

import java.awt.event.KeyEvent;

import User.User;
import processing.core.PImage;

public class Game {
	private PImage img1, img2;
	private User p1, p2;
	private String p1Name, p2Name;
	public Game(User p1, User p2)
	{
		img1 = null;
		img2 = null;
		this.p1=p1;
		this.p2=p2;
		p1Name = p1.getName();
		p2Name = p2.getName();
	}
	public void drawGameState(DrawingSurface s) {
			if(s.isPressed(KeyEvent.VK_SPACE))
			{
				s.setState(s.PAUSE_STATE);
				s.getKeys().clear();
			}else
			{
				s.background(255);   // Clear the screen with a white background
				s.fill(255);
				s.textAlign(s.CENTER);
				s.textSize(12);
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
					
				}
				if(s.isPressed(KeyEvent.VK_2))
				{
					
				}
				if(s.isPressed(KeyEvent.VK_3))
				{
					
				}
				if(s.isPressed(KeyEvent.VK_4))
				{
					
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
					
				}
				if(s.isPressed(KeyEvent.VK_8))
				{
					
				}
				if(s.isPressed(KeyEvent.VK_9))
				{
					
				}
				if(s.isPressed(KeyEvent.VK_0))
				{
					
				}
				
				p1.applyWindowLimits(s.width,s.height);
				p2.applyWindowLimits(s.width,s.height);
				p1.draw(s);
				p2.draw(s);
				s.line(s.width/2,0,s.width/2,s.height);
				s.fill(255,0,0);
				s.rect(0,0,200,10);
				s.fill(0,255,0);
				s.rect(0,0,p1.getHealth(),10);
				s.fill(255,0,0);
				s.rect(s.width-200,0,200,10);
				s.fill(0,255,0);
				s.rect(s.width-200,0,p2.getHealth(),10);
				
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
