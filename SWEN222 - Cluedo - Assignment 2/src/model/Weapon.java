package model;

/**
 * Class to represent a weapon in the game
 * @author Tobias
 *
 */
public class Weapon {

	private String name;
	private String ID;
	
	/**
	 * Constructor
	 * @param name name of the weapon
	 * @param ID id of the weapon
	 */
	public Weapon(String name, String ID) {
		this.name = name;
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public String getID() {
		return ID;
	}
}
