package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import model.Board;
import model.Card;
import model.Deck;
import model.Player;
import model.Room;
import model.Square;
import model.Weapon;
import view.GameFrame;

public class GraphicalGameController {

	static boolean gameWon = false;
	ArrayList<Player> playerList;
	Board BOARD;
	Deck deck;
	Square[][] squares;
	
	int playerCount;

	/**
	 * Constructor
	 * 
	 * @param charNameList List of character names
	 * @param playerNameList List of player names
	 */
	public GraphicalGameController(ArrayList<String> charNameList,
			ArrayList<String> playerNameList) {
		
		ArrayList<Player> gamePlayers = makePlayers(charNameList, playerNameList);
		playerList = sortPlayerOrder(gamePlayers);
		
		deck = new Deck();
		deck.setFinalPlayers(playerList);
		deck.setPlayers(playerList);
		BOARD = deck.getBoard();
		
		squares = BOARD.getSquares();
		
		new MovementController(BOARD);
		
		GameFrame display = new GameFrame(this);
		display.repaint();
		initGame(gamePlayers);
	}

	/**
	 * Initialise the game
	 * @param gamePlayers List of players
	 */
	private void initGame(ArrayList<Player> gamePlayers) {
		playerCount = gamePlayers.size();
		initPlayers(gamePlayers);
		
		makeSolution();
		dealCards();
		distributeWeapons();
	}

	/**
	 * Distribute the weapons to all the rooms
	 */
	private void distributeWeapons() {
		ArrayList<Weapon> remainingWeapons = new ArrayList<Weapon>();

		remainingWeapons.addAll(deck.getWeapons());

		ArrayList<HashMap.Entry<String, Room>> list = new ArrayList<>(deck.getRooms().entrySet());
		Collections.shuffle(list);
		for (HashMap.Entry<String, Room> room : list) {
			if (remainingWeapons.isEmpty())
				break;
			if (!room.getKey().equals("Pool")) {
				room.getValue().addWeaponToAvailableSquare(deck.getBoard().getSquares(), remainingWeapons.get(0));
				remainingWeapons.remove(0);
			}
		}
	}

	/**
	 * Deal the cards to all the players
	 */
	private void dealCards() {
		int size = deck.getCards().size();
		
		for(Player p : deck.getPlayers()) {
			int count = 0;
			Set<Card> cardsDealt = new HashSet<>();
			for(Card c : deck.getCards()) {
				if(count >= size / playerCount) {
					break;
				}
				p.getCards().add(c);
				cardsDealt.add(c);
				count++;
			}
			deck.getCards().removeAll(cardsDealt);
		}
	}

	/**
	 * Make a random solution with one card from each of the type (Room, Character, Weapon)
	 */
	private void makeSolution() {
		boolean room = false;
		boolean character = false;
		boolean weapon = false;

		// Randomly select cards from the collection of cards until we have a
		// valid solution
		for (Card card : deck.getCards()) {
			if (!room && card.getType().equals("Room")) {
				deck.getWinningCards().add(card);
				room = true;
			} else if (!character && card.getType().equals("Character")) {
				deck.getWinningCards().add(card);
				character = true;
			} else if (!weapon && card.getType().equals("Weapon")) {
				deck.getWinningCards().add(card);
				weapon = true;
			}
		}

		// remove the solution cards from the collection of cards, so that
		// they're not dealt to players
		deck.getCards().removeAll(deck.getWinningCards());
	}

	/**
	 * Initialise the players
	 * @param gamePlayers list of players
	 */
	private void initPlayers(ArrayList<Player> gamePlayers) {
		deck.setPlayers(gamePlayers);
		deck.setFinalPlayers(gamePlayers);
		
		for(int i = 0; i < squares.length; i++) {
			for(int j = 0; j < squares[0].length; j++) {
				for(Player p : gamePlayers) {
					if(p.getxPos() == i && p.getyPos() == j) {
						squares[i][j].setPlayer(p);
					}
				}
			}
		}
	}

	/**
	 * Sort players such that Miss Scarlet is always first
	 * @param gamePlayers list of players
	 * @return
	 */
	private ArrayList<Player> sortPlayerOrder(ArrayList<Player> gamePlayers) {
		Player missScarlet = null;
		
		for (Player p : gamePlayers) {
			if (p.getName().equals("Miss Scarlet")) {
				missScarlet = p;
			}
		}
		if (missScarlet != null) {
			gamePlayers.add(0, missScarlet);
		}
		return gamePlayers;
	}

	/**
	 * Makes the players of the game
	 * @param charNameList list of characters
	 * @param playerNameList list of players
	 * @return
	 */
	private ArrayList<Player> makePlayers(ArrayList<String> charNameList,
			ArrayList<String> playerNameList) {
		Player p;
		ArrayList<Player> players = new ArrayList<Player>();
		for (int i = 0; i < charNameList.size(); i++) {
			if (charNameList.get(i).equalsIgnoreCase("miss scarlet")) {
				p = new Player(charNameList.get(i), playerNameList.get(i), "s", 7, 25, "missscarlet.png");
			} else if (charNameList.get(i).equalsIgnoreCase("mrs peacock")) {
				p = new Player(charNameList.get(i), playerNameList.get(i), "p", 23, 6, "mrspeacock.png");
			} else if (charNameList.get(i).equalsIgnoreCase("mrs white")) {
				p = new Player(charNameList.get(i), playerNameList.get(i), "w", 9, 0, "mrswhite.png");
			} else if (charNameList.get(i).equalsIgnoreCase("colonel mustard")) {
				p = new Player(charNameList.get(i), playerNameList.get(i), "m", 0, 18, "mrmustard.png");
			} else if (charNameList.get(i).equalsIgnoreCase("reverend green")) {
				p = new Player(charNameList.get(i), playerNameList.get(i), "g", 14, 0, "reverendgreen.png");
			} else if (charNameList.get(i).equalsIgnoreCase("professor plum")) {
				p = new Player(charNameList.get(i), playerNameList.get(i), "r", 23, 20, "profplum.png");
			} else {
				p = null;
				System.out.println("ERROR MAKING PLAYERS: " + charNameList.get(i));
				throw new RuntimeException();
			}

			players.add(p);
		}
		return players;
	}


	/**
	 * Rolls a artificial dice which uses Math.random() to get a random integer
	 * between 1 and 6
	 * 
	 * @return integer between 1 and 6
	 */
	public static int rollDice() {
		return 1 + (int) (Math.random() * 6); // random number between 1 and 6
	}
	
	public Deck getDeck() {
		return this.deck;
	}
	
	public Square[][] getSquares() {
		return this.squares;
	}
	
	public ArrayList<Player> getPlayerList() {
		return this.playerList;
	}
}
