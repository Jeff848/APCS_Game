
public abstract class User extends MovingImage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;
	private static final int moveAmount = 20;
	
	private Ability[] ab = new Ability[4];
	
	
	public User(String filename, int x, int y, int w, int h, Ability[] a) {
		super(filename, x, y, w, h);
		ab = a;
		// TODO Auto-generated constructor stub
	}
	public void move(int dir){
		if(dir==LEFT)
		{
			moveByAmount(-moveAmount,0);
		}else if(dir == RIGHT){
			moveByAmount(moveAmount,0);
		}else if(dir == UP){
			moveByAmount(0,-moveAmount);
		}else if(dir == DOWN)
		{
			moveByAmount(0,moveAmount);
		}
		else 
		{
			throw new IllegalArgumentException("Not a valid movement");
		}
	}
	
	public abstract void ab1();
	public abstract void ab2();
	public abstract void ab3();
	public abstract void ab4();
	
	
}
