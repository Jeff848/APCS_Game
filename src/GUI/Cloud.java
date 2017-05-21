package GUI;


public class Cloud extends Particle{
	int r,g,b;
	public Cloud(int width, int height, DrawingSurface s, boolean l, int r, int g, int b, boolean rando) {
		super(width, height, s, l,rando);
		this.r=r;
		this.g=g;
		this.b=b;
		// TODO Auto-generated constructor stub
	}
	public void draw(DrawingSurface s){
		s.pushMatrix();
		s.fill(r,g,b);
		s.noStroke();
		move(s);
		if(getDirection()){
			if(x>=s.width/2+width){
				s.rect((int)(x-width), (int)(y), (int)(width), (int)(height),(int)height/4);
			} else if(x>=s.width/2){
				s.rect((int)Math.max(x, s.width/2), (int)(y), (int)(s.width/2-x), (int)(height),(int)height/4);
			}
		}else{
			if(x<=s.width/2)
				s.rect((int)Math.min(x, s.width/2), (int)(y), (int)Math.min(s.width/2-x, this.width), (int)(height),(int)height/4);
		
		}
		//System.out.println((x-s.width/2) + ", " + (s.width/2-x));
		//System.out.println(x+""+y);
		s.stroke(0);
		s.popMatrix();
	}
	
}
