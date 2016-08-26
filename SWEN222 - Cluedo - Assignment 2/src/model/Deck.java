package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Deck {
	
	private ArrayList<Characters> characters = new ArrayList<Characters>();
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private Map<String, Room> rooms = new HashMap<String, Room>();
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Player> finalPlayers = new ArrayList<Player>();
	
	private Set<Card> solution = new HashSet<Card>();
	private Board board;
	private Set<Card> winningCards = new HashSet<>();
	
	public Deck() {
		initializeDeck();
	}

	private void initializeDeck() {
		initCharacters();
		initWeapons();
		initRooms();
		initCards();
		
		Collections.shuffle(cards);
		Collections.shuffle(weapons);
		
		
		
		board = new Board(26, 26, rooms);
	}

	/**
	 * Initialise all the cards of the deck
	 */
	private void initCards() {
		cards.add(new Card("Mrs Peacock", "Character", "mrspeacock.png"));
		cards.add(new Card("Mrs White", "Character", "mrswhite.png"));
		cards.add(new Card("Miss Scarlet", "Character", "missscarlet.png"));
		cards.add(new Card("Professor Plum", "Character", "professorplum.png"));
		cards.add(new Card("Mr Green", "Character", "mrgreen.png"));
		cards.add(new Card("Colonel Mustard", "Character", "colonelmustard.png"));
		
		cards.add(new Card("Candlestick", "Weapon","Candlestick.png"));
		cards.add(new Card("Dagger", "Weapon","Dagger.png"));
		cards.add(new Card("Lead Pipe", "Weapon","Lead Pipe.png"));
		cards.add(new Card("Revolver", "Weapon","Revolver.png"));
		cards.add(new Card("Rope", "Weapon","Rope.png"));
		cards.add(new Card("Spanner", "Weapon","Wrench.png"));

		cards.add(new Card("Kitchen", "Room","Kitchen.png"));
		cards.add(new Card("Study", "Room","Study.png"));
		cards.add(new Card("Lounge", "Room","Lounge.png"));
		cards.add(new Card("Conservatory", "Room","Conservatory"));
		cards.add(new Card("Ball Room", "Room","Ballroom.png"));
		cards.add(new Card("Billiard Room", "Room","Billiard Room.png"));
		cards.add(new Card("Library", "Room","Library.png"));
		cards.add(new Card("Hall", "Room","Hall.png"));
		cards.add(new Card("Dining Room", "Room","Dining Room.png"));
	}

	/**
	 * Initialise all the rooms of the deck - including their connecting rooms
	 */
	private void initRooms() {
		Room kitchen = new Room("Kitchen", 1, "K");
		Room study = new Room("Study", 2, "S");
		Room lounge = new Room("Lounge", 3, "L");
		Room conservatory = new Room("Conservatory", 4, "C");
		Room ballRoom = new Room("Ball Room", 5, "Bi");
		Room billiardRoom = new Room("Billiard Room", 6, "I");
		Room library = new Room("Library", 7, "Y");
		Room hall = new Room("Hall", 8, "H");
		Room diningRoom = new Room("Dining Room", 9, "D");
		
		kitchen.setConnectingRoom(study);
		study.setConnectingRoom(kitchen);
		lounge.setConnectingRoom(conservatory);
		conservatory.setConnectingRoom(lounge);

		// store in data structure
		rooms.put(conservatory.getName(), conservatory);
		rooms.put(lounge.getName(), lounge);
		rooms.put(kitchen.getName(), kitchen);
		rooms.put(study.getName(), study);
		rooms.put(hall.getName(), hall);
		rooms.put(ballRoom.getName(), ballRoom);
		rooms.put(billiardRoom.getName(), billiardRoom);
		rooms.put(library.getName(), library);
		rooms.put(diningRoom.getName(), diningRoom);
	}

	/**
	 * Initilise the weapons of the deck
	 */
	private void initWeapons() {
		weapons.add(new Weapon("Candlestick", "Ca"));
		weapons.add(new Weapon("Dagger", "Da"));
		weapons.add(new Weapon("Lead Pipe", "Lp"));
		weapons.add(new Weapon("Revolver", "Re"));
		weapons.add(new Weapon("Rope", "Ro"));
		weapons.add(new Weapon("Spanner", "Sp"));
	}

	/**
	 * Initialise the characters of the deck
	 */
	private void initCharacters() {
		characters.add(new Characters("Miss Scarlet", "s", 7, 25,"missscarlet.png"));
		characters.add(new Characters("Mrs Peacock", "p", 23, 6,"mrspeacock.png"));
		characters.add(new Characters("Proffesor Plum", "r", 23, 20,"profplum.png"));
		characters.add(new Characters("Colonel Mustard", "m", 0, 18,"mrmustard.png"));
		characters.add(new Characters("Mrs White", "w", 9, 0,"mrswhite.png"));
		characters.add(new Characters("Reverend Green", "g", 14, 0,"reverendgreen.png"));
	}
	
	public Player getPlayer(int index) {
		return players.get(index);
	}
	
	public ArrayList<Characters> getCharacters() {
		return characters;
	}
	
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	
	public Map<String, Room> getRooms() {
		return rooms;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Set<Card> getSolution() {
		return solution;
	}
	
	public ArrayList<Player> getFinalPlayers() {
		return finalPlayers;
	}
	
	public void setFinalPlayers(ArrayList<Player> finalPlayers) {
		this.finalPlayers = finalPlayers;
	}

	public Set<Card> getWinningCards() {
		return winningCards;
	}

	//old code from Assignment 1
/*	public void startGame(Board board) {
		
		// make deck of all cards
		ArrayList<Card> deck = new ArrayList<Card>();
		for (Card card : cards) {
			deck.add(card);
		}

		// get a random solution - one of each card from the deck
		int a = (int) (Math.random() * 6); // playerCard = card 1 to 6
		int b = playerCards.length + (int) (Math.random() * weaponCards.length);
		int c = playerCards.length + weaponCards.length
				+ (int) (Math.random() * roomCards.length);
		
		//to avoid c being greater than 19
		//something wrong with my c calculation above
		if(c >= 19) {
			startGame(board);
		}
		
		
		// make and set the solution consist of these 3 cards
		Card solution[] = {deck.get(a), deck.get(b), deck.get(c)};
		board.setSolution(solution);
		
		// remove the solution cards from the deck
		deck.remove(a);
		deck.remove(b);
		deck.remove(c);

		// shuffle the deck
		Collections.shuffle(deck);

		// deal rest of cards equally to all players
		for (int i = 0; i < deck.size(); i++) {
			board.players[i % board.players.length].addToHand(deck.get(i));
			deck.remove(i);
		}
		
		//show remaining cards
		System.out.println("Cards not given to any of the players:");
		System.out.println("------------------");
		for(Card card : deck) {
			System.out.println(card.toString());
		}
		System.out.println();
		
		PlayingLogic.startGame(board, deck, solution);
	}*/
}
