package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Player extends Characters {

	String charName;
	ArrayList<Card> hand;
	boolean isPlaying;
	public String image;
	
	String name;
	String ID;
	
	Characters character;
	Room room;
	ArrayList<Card> cards;
	int playerNumber;
	Set<Card> suggestion;
	boolean isAPlayer;
	
	/**
	 * Consutrctor
	 * @param playerName name of the player
	 * @param name name of the character
	 * @param ch id of the player
	 * @param x x position of the player
	 * @param y y position of the player
	 * @param image image name of the player
	 */
	public Player(String playerName, String name, String ch, int x, int y, String image) {
		super(playerName, ch, x, y, image);
		this.cards = new ArrayList<>();
		this.suggestion = new HashSet<>();
		this.name = name;
		character = new Characters(playerName, ch, x, y, image);
	}

	/**
	 * Prints the cards in the players hands with commas inbetween each of them
	 */
	public void showHand() {
		String seperator = "";
		for (Card card : hand) {
			System.out.print(seperator + card.toString());
			seperator = ", ";
		}
		System.out.println();
	}
	
	public String getImageName() {
		return image;
	}

	public void setHand(Card[] hand) {
		for (Card card : hand) {
			this.hand.add(card);
		}
	}

	public void addToHand(Card card) {
		this.hand.add(card);
	}

	public Card getCard(int index) {
		return this.hand.get(index);
	}

	public void playerLost() {
		this.isPlaying = false;
		System.out.println("The player " + this.charName
				+ " has lost the game.");
	}

	public int sizeOfHand() {
		return this.hand.size();
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getCharacterName() {
		return charName;
	}
	
	public String toString() {
		return this.charName;
	}
	
	public Characters getCharacter() {
		return this.character;
	}

	public ArrayList<Card> getCards() {
		return this.cards;
	}

	public boolean isInRoom() {
		return this.room != null;
	}

	public Room getRoom() {
		return this.room;
	}
}
