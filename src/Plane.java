
public abstract class Plane extends MovingImage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Ability ab1;
	private Ability ab2;
	private Ability ab3;
	private Ability ab4;
	
	
	public Plane(String filename, int x, int y, int w, int h) {
		super(filename, x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void move(int dir){
		
	}
	
	public abstract void ab1();
	public abstract void ab2();
	public abstract void ab3();
	public abstract void ab4();
}
