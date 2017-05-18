package Abilities;

import GUI.DrawingSurface;
import User.MovingImage;

/**
 * Dictates what an ability of a plane has to do
 *
 */
public interface Ability {

	void use();
	void checkCollision(MovingImage m);
	void draw(DrawingSurface s);
}
