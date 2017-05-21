package GUI;

import processing.core.PApplet;
import processing.core.PConstants;

public class Star extends Particle{

	public Star(int width, int height, DrawingSurface s, boolean l, boolean rando) {
		super(width, height, s, l, rando);
	}
	public void draw(DrawingSurface s){
		s.pushMatrix();
		s.fill(155,178,255);
		s.noStroke();
		move(s);
		
		if(getDirection()){
			if(x>=s.width/2+width){
				star(s,(int)(x-width), (int)(y), (int)(width), (int)(height),2);
			} else if(x>=s.width/2){
				star(s,(int)Math.max(x, s.width/2), (int)(y), (int)(s.width/2-x), (int)(height),2);
			}
		}else{
			if(x<=s.width/2)
				star(s,(int)Math.min(x, s.width/2), (int)(y), (int)Math.min(s.width/2-x, this.width), (int)(height),2);
		
		}
		//System.out.println((x-s.width/2) + ", " + (s.width/2-x));
		//System.out.println(x+""+y);
		s.popMatrix();
	}
	public void star(DrawingSurface s, float x, float y, float radius1, float radius2, int npoints) {
		  float angle = PConstants.TWO_PI / npoints;
		  float halfAngle = (float) (angle/2.0);
		  s.beginShape();
		  for (float a = 0; a < PConstants.TWO_PI; a += angle) {
		    float sx = x + PApplet.cos(a) * radius2;
		    float sy = y + PApplet.sin(a) * radius2;
		    s.vertex(sx, sy);
		    sx = x + PApplet.cos(a+halfAngle) * radius1;
		    sy = y + PApplet.sin(a+halfAngle) * radius1;
		    s.vertex(sx, sy);
		  }
		  s.endShape(PConstants.CLOSE);
	}

}
