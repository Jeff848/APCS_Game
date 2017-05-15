package Abilities;
/**
 * Dictates what an ability of a plane has to do
 *
 */
public interface Ability {

	void use();
	void putOnCoolDown();
	void checkCollision();
}
