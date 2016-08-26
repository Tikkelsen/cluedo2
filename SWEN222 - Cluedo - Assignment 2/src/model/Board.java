package model;

import java.util.Map;

public class Board {

	int maxX = 26;
	int maxY = 27;
	
	
private int map[][] = { {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
			{99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 42, 99, 99, 99, 99, 42, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
			{99, 21, 21, 21, 21, 21, 21, 99, 00, 00, 00, 22, 22, 22, 22, 00, 00, 00, 99, 23, 23, 23, 23, 23, 23, 99},
			{99, 21, 11, 11, 11, 11, 21, 00, 00, 22, 22, 12, 12, 12, 12, 22, 22, 00, 00, 23, 13, 13, 13, 13, 23, 99},
			{99, 21, 11, 11, 11, 11, 21, 00, 00, 22, 12, 12, 12, 12, 12, 12, 22, 00, 00, 23, 13, 13, 13, 13, 23, 99},
			{99, 21, 11, 11, 11, 11, 21, 00, 00, 22, 12, 12, 12, 12, 12, 12, 22, 00, 00, 333 , 13, 13, 13, 13, 23, 99},
			{99, 21, 11, 11, 11, 11, 21, 00, 00, 222 , 12, 12, 12, 12, 12, 12, 222 , 00, 00, 00, 23, 23, 23, 23, 99, 99},
			{99, 99, 21, 21, 21, 111 , 21, 00, 00, 22, 12, 12, 12, 12, 12, 12, 22, 00, 00, 00, 00, 00, 00, 00, 42, 99},
			{99, 00, 00, 00, 00, 00, 00, 00, 00, 22, 2 , 22, 22, 22, 22, 2 , 22, 00, 00, 00, 00, 00, 00, 00, 99, 99},
			{99, 99, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00 ,00, 24, 24, 24, 24, 24, 24, 99},
			{99, 25, 25, 25, 25, 25, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 444 , 14, 14, 14, 14, 24, 99},
			{99, 25, 15, 15, 15, 25, 25, 25, 25, 00, 00, 99, 99, 99, 99, 99, 00, 00, 00, 24, 14, 14, 14, 14, 24, 99},
			{99, 25, 15, 15, 15, 15, 15, 15, 25, 00, 00, 99, 99, 99, 99, 99, 00, 00, 00, 24, 14, 14, 14, 14, 24, 99},
			{99, 25, 15, 15, 15, 15, 15, 15, 555 , 00, 00, 99, 99, 99, 99, 99, 00, 00, 00, 24, 24, 24, 24, 444 , 24, 99},
			{99, 25, 15, 15, 15, 15, 15, 15, 25, 00, 00, 99, 99, 99, 99, 99, 00, 00, 00, 00, 00, 00, 00, 00, 99, 99},
			{99, 25, 15, 15, 15, 15, 15, 15, 25, 00, 00, 99, 99, 99, 99, 99, 00, 00, 00, 26, 26, 666 , 26, 26, 99, 99},
			{99, 25, 25, 25, 25, 25, 25, 555 , 25, 00, 00, 99, 99, 99, 99, 99, 00, 00, 16, 26, 16, 16, 16, 16, 26, 99},
			{99, 99, 00, 00, 00, 00, 00, 00, 00, 00, 00, 99, 99, 99, 99, 99, 00, 00, 666 , 26, 16, 16, 16, 16, 26, 99},
			{99, 42, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 16, 26, 16, 16, 16, 16, 26, 99},
			{99, 99, 00, 00, 00, 00, 00, 00, 00, 00, 27, 27, 777 , 777 , 27, 27, 00, 00, 00, 26, 26, 26, 26, 26, 99, 99},
			{99, 28, 28, 28, 28, 28,  888, 28, 00, 00, 27, 17, 17, 17, 17, 27, 00, 00, 00, 00, 00, 00, 00, 00, 42, 99},
			{99, 28, 18, 18, 18, 18, 18, 28, 00, 00, 27, 17, 17, 17, 17, 777 , 00, 00, 00, 00, 00, 00, 00, 00, 99, 99},
			{99, 28, 18, 18, 18, 18, 18, 28, 00, 00, 27, 17, 17, 17, 17, 27, 00, 00, 29, 999, 29, 29, 29, 29, 29, 99},
			{99, 28, 18, 18, 18, 18, 18, 28, 00, 00, 27, 17, 17, 17, 17, 27, 00, 00, 29, 19, 19, 19, 19, 19, 29, 99},
			{99, 28, 18, 18, 18, 18, 18, 28, 00, 00, 27, 17, 17, 17, 17, 27, 00, 00, 29, 19, 19, 19, 19, 19, 29, 99},
			{99, 28, 28, 28, 28, 28, 28, 99, 42, 99, 99, 17, 17, 17, 17, 99, 99, 00, 99, 29, 29, 29, 29, 29, 29, 99},
			{99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99}};
	
	public Player[] players;
	public Square[][] squares;
	private Card[] solution;
	private Map<String, Room> rooms;
	
	@SuppressWarnings("unused")
	private int height;
	@SuppressWarnings("unused")
	private int width;

	/**
	 * Constructor
	 * @param width width of the board
	 * @param height height of the board
	 * @param rooms rooms of the board
	 */
	public Board(int width, int height, Map<String, Room> rooms) {
		this.width = width;
		this.height = height;
		this.rooms = rooms;
		squares = new Square[width][height];
		createBoard();
	}

	/**
	 * Create the board from the map 2D array
	 */
	private void createBoard() {
		
		for(int y = 0; y < map.length -1; y++) {
			for(int x = 0; x < map[0].length; x++) {
				if(map[x][y] == 99) {
					squares[x][y] = new BoundarySquare(x, y, null, false, false, "Boundary");
				}
				
				else if(map[x][y] == 42) {
					squares[x][y] = new Square(x, y, null, false, false, "Starting Square");
				}
				
				else if(map[x][y] == 11) {
					squares[x][y] = new Square(x, y, rooms.get("Kitchen"), true, "Kitchen");
					rooms.get("Kitchen").getSquares().add(squares[x][y]);
				}
				else if(map[x][y] == 21) {
					squares[x][y] = new Square(x, y, rooms.get("Kitchen"), false, "Kitchen Wall");
				}
				else if(map[x][y] == 111 ) {
					squares[x][y] = new Square(x, y, rooms.get("Kitchen"), false, true, "Kitchen Door");
					rooms.get("Kitchen").getSquares().add(squares[x][y]);
					rooms.get("Kitchen").getDoors().add(squares[x][y]);
				}
				
				else if(map[x][y] == 12) {
					squares[x][y] = new Square(x, y, rooms.get("Ball Room"), true, "Ball Room");
					rooms.get("Ball Room").getSquares().add(squares[x][y]);
				}
				else if(map[x][y] == 22) {
					squares[x][y] = new Square(x, y, rooms.get("Ball Room"), false, "Ball Room Wall");
				}
				else if(map[x][y] == 222 ) {
					squares[x][y] = new Square(x, y, rooms.get("Ball Room"), false, true, "Ball Room Door");
					rooms.get("Ball Room").getSquares().add(squares[x][y]);
					rooms.get("Ball Room").getDoors().add(squares[x][y]);
				}
				
				else if(map[x][y] == 13) {
					squares[x][y] = new Square(x, y, rooms.get("Conservatory"), true, "Conservatory");
					rooms.get("Conservatory").getSquares().add(squares[x][y]);
				}
				else if(map[x][y] == 23) {
					squares[x][y] = new Square(x, y, rooms.get("Conservatory"), false, "Conservatory Wall");
				}
				else if(map[x][y] == 333 ) {
					squares[x][y] = new Square(x, y, rooms.get("Conservatory"), false, true, "Conservatory Door");
					rooms.get("Conservatory").getSquares().add(squares[x][y]);
					rooms.get("Conservatory").getDoors().add(squares[x][y]);
				}
				
				else if(map[x][y] == 14) {
					squares[x][y] = new Square(x, y, rooms.get("Billiard Room"), true, "Billiard Room");
					rooms.get("Billiard Room").getSquares().add(squares[x][y]);
				}
				else if(map[x][y] == 24) {
					squares[x][y] = new Square(x, y, rooms.get("Billiard Room"), false, "Billiard Room Wall");
				}
				else if(map[x][y] == 444) {
					squares[x][y] = new Square(x, y, rooms.get("Billiard Room"), false, true, "Billiard Room Door");
					rooms.get("Billiard Room").getSquares().add(squares[x][y]);
					rooms.get("Billiard Room").getDoors().add(squares[x][y]);
				}
				
				else if(map[x][y] == 15) {
					squares[x][y] = new Square(x, y, rooms.get("Dining Room"), true, "Dining Room");
					rooms.get("Dining Room").getSquares().add(squares[x][y]);
				}
				else if(map[x][y] == 25) {
					squares[x][y] = new Square(x, y, rooms.get("Dining Room"), false, "Dining Room Wall");
				}
				else if(map[x][y] == 555) {
					squares[x][y] = new Square(x, y, rooms.get("Dining Room"), false, true, "Dining Room Door");
					rooms.get("Dining Room").getSquares().add(squares[x][y]);
					rooms.get("Dining Room").getDoors().add(squares[x][y]);
				}
				
				else if(map[x][y] == 16) {
					squares[x][y] = new Square(x, y, rooms.get("Library"), true, "Library");
					rooms.get("Library").getSquares().add(squares[x][y]);
				}
				else if(map[x][y] == 26) {
					squares[x][y] = new Square(x, y, rooms.get("Library"), false, "Library Wall");
				}
				else if(map[x][y] == 666) {
					squares[x][y] = new Square(x, y, rooms.get("Library"), false, true, "Library Door");
					rooms.get("Library").getSquares().add(squares[x][y]);
					rooms.get("Library").getDoors().add(squares[x][y]);
				}
				
				else if(map[x][y] == 17) {
					squares[x][y] = new Square(x, y, rooms.get("Hall"), true, "Hall");
					rooms.get("Hall").getSquares().add(squares[x][y]);
				}
				else if(map[x][y] == 27) {
					squares[x][y] = new Square(x, y, rooms.get("Hall"), false, "Hall Wall");
				}
				else if(map[x][y] == 777) {
					squares[x][y] = new Square(x, y, rooms.get("Hall"), false, true, "Hall Door");
					rooms.get("Hall").getSquares().add(squares[x][y]);
					rooms.get("Hall").getDoors().add(squares[x][y]);
				}
				
				else if(map[x][y] == 18) {
					squares[x][y] = new Square(x, y, rooms.get("Lounge"), true, "Lounge");
					rooms.get("Lounge").getSquares().add(squares[x][y]);
				}
				else if(map[x][y] == 28) {
					squares[x][y] = new Square(x, y, rooms.get("Lounge"), false, "Lounge Wall");
				}
				else if(map[x][y] == 888) {
					squares[x][y] = new Square(x, y, rooms.get("Lounge"), false, true, "Lounge Door");
					rooms.get("Lounge").getSquares().add(squares[x][y]);
					rooms.get("Lounge").getDoors().add(squares[x][y]);
				}
				
				else if(map[x][y] == 19) {
					squares[x][y] = new Square(x, y, rooms.get("Study"), true, "Study");
					rooms.get("Study").getSquares().add(squares[x][y]);
				}
				else if(map[x][y] == 29) {
					squares[x][y] = new Square(x, y, rooms.get("Study"), false, "Study Wall");
				}
				else if(map[x][y] == 999) {
					squares[x][y] = new Square(x, y, rooms.get("Study"), false, true, "Study Door");
					rooms.get("Study").getSquares().add(squares[x][y]);
					rooms.get("Study").getDoors().add(squares[x][y]);
				}
				
				else {
					squares[x][y] = new Square(x, y, null, false, "Walkable");
				}
			}
		}
	}
	
	public Square[][] getSquares() {
		return squares;
	}


	
	public Card[] getSolution() {
		return this.solution;
	}

	public void setSolution(Card[] solution) {
		this.solution = solution;
	}
	
	public int[][] getMap() {
		return this.map;
	}
	
	public int getHeight() {
		return maxY;
	}
	
	public int getWidth() {
		return maxX;
	}
	
	public Player[] getPlayers() {
		return players;
	}
}
