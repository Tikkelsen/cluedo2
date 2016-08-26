package model;


public class Square {

	private int x;
	private int y;
	private String name;
	private Room room;
	private boolean isWall;
	private boolean isDoor;
	private Player player;
	private Weapon weapon;
	
	boolean isBoundary;
	
	/**
	 * Constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param room the room
	 * @param isWall is the square a wall
	 * @param isDoor is the square a door
	 * @param name name of the square
	 */
	public Square(int x, int y, Room room, boolean isWall, boolean isDoor, String name) {
		this.x = x;
		this.y = y;
		this.room = room;
		this.isWall = isWall;
		this.isDoor = isDoor;
		this.name = name;
		this.isBoundary = false;
	}
	
	/**
	 * Alternative constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param room the room
	 * @param isWall is the square a wall
	 * @param name name of the square
	 */
	public Square(int x, int y, Room room, boolean isWall, String name) {
		this.x = x;
		this.y = y;
		this.room = room;
		this.isWall = isWall;
		this.name = name;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return ("Row: " +getX()+ ", Col: " +getY()+ ", isWall: " +isWall+ ", room: " +room);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public boolean isDoor() {
		return isDoor;
	}

	public boolean isWallSquare() {
		return isWall;
	}

	public boolean isRoomSquare() {
		return room != null;
	}

	public boolean isOccupied() {
		return player != null || weapon != null;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public boolean isBoundary() {
		return isBoundary;
	}

	public Room getRoom() {
		return room;
	}
}
