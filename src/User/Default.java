package User;
import Abilities.Ability;
import processing.core.PImage;

public class Default extends User{


	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param x- x coord
	 * @param y- y coord
	 * @param a- ability list
	 * @param l- boolean that dictates which side the plane is on
	 */
	public Default(int x, int y, Ability[] a, boolean l) {
		super(x, y, 128, 64, a, l);
	}

	
	
	
}
