package model;

public class Card {
	
	private String name;
	private String type;
	private String image;
	
	/**
	 * Constructor
	 * @param name name of the card
	 * @param type type of card
	 * @param image image name of the card
	 */
	public Card(String name, String type, String image) {
		this.name = name;
		this.type = type;
		this.image = image;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return name;
	}
	
	public boolean equals(Card card) {
		if(this.name == card.getName()) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getImage() {
		return this.image;
	}
}
