
public class Projectile extends MovingImage implements Ability{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Projectile(String filename, int x, int y, int w, int h) {
		super(filename, x, y, w, h);
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCoolDown() {
		// TODO Auto-generated method stub
		return 0;
	}

}
