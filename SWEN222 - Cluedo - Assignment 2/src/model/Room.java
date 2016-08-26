package model;

import java.util.ArrayList;

public class Room {

	private ArrayList<Square> squares;
	private ArrayList<Square> doors;
	private Room connectingRoom;

	private String name;
	private int roomNumber;
	private String ID;

	/**
	 * Constructor
	 * @param name name of the room
	 * @param roomNumber room number
	 * @param ID id of the room
	 */
	public Room(String name, int roomNumber, String ID) {
		this.name = name;
		this.roomNumber = roomNumber;
		this.ID = ID;

		this.squares = new ArrayList<Square>();
		this.doors = new ArrayList<Square>();
	}
	
	public String toString() {
		return name;
	}

	/**
	 * Add a weapon to a room
	 * @param boardSquares the board squares
	 * @param weapon the weapon being added
	 */
	public void addWeapon(Square[][] boardSquares, Weapon weapon) {
		//check if there is a weapon on any square
		for (Square squ : squares) {
			if (squ.getWeapon() != null) {
				//if that weapon is the weapon being added, then just return
				if (squ.getWeapon().equals(weapon)) {
					return;
				}
			}
		}
		
		for (Square[] squa : boardSquares) {
			for (Square square : squa) {
				if (square.getWeapon() != null) {
					if (square.getWeapon().equals(weapon)) {
						square.setWeapon(null);
					}
				}
			}
		}

		for (Square square : squares) {
			if (!square.isDoor() && !square.isWallSquare()
					&& square.isRoomSquare() && square.isOccupied()) {
				square.setWeapon(weapon);
				break;
			}
		}
	}

	/**
	 * Add a player to a square
	 * @param boardSquares the board square
	 * @param player the player being added
	 */
	public void addPlayer(Square[][] boardSquares, Player player) {
		//same as for addWeapon method
		for (Square squ : squares) {
			if (squ.getPlayer() != null) {
				if (squ.getPlayer().equals(player)) {
					return;
				}
			}
		}

		for (Square[] squa : boardSquares) {
			for (Square square : squa) {
				if (square.getPlayer() != null) {
					if (square.getPlayer().equals(player)) {
						square.setPlayer(null);
					}
				}
			}
		}

		for (Square square : squares) {
			if (!square.isDoor() && !square.isWallSquare()
					&& square.isRoomSquare() && square.isOccupied()) {
				square.setPlayer(player);
				player.setxPos(square.getX());
				player.setyPos(square.getY());
				player.setRoom(square.getRoom());
				break;
			}
		}
	}

	public ArrayList<Square> getSquares() {
		return squares;
	}

	public Room getConnectingRoom() {
		return connectingRoom;
	}

	public void setConnectingRoom(Room room) {
		this.connectingRoom = room;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Square> getDoors() {
		return doors;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public String getID() {
		return ID;
	}

	/**
	 * Add a weapon to an avaliable square
	 * @param allSquares all the board squares
	 * @param weapon weapon being added
	 */
	public void addWeaponToAvailableSquare(Square[][] allSquares, Weapon weapon) {
		// Checks if the weapon is already on the same tile
		for (Square square : squares) {
			if (square.getWeapon() != null) {
				if (square.getWeapon().equals(weapon)) {
					return;
				}
			}
		}

		// Removes any instance of the weapon on the board
		for (Square[] squareColec : allSquares) {
			for (Square square : squareColec) {
				if(square != null) {
					if (square.getWeapon() != null) {
						System.out.println("it's not null");
						if (square.getWeapon().equals(weapon)) {
							square.setWeapon(null);
						}
					}
				}
			}
		}

		// Adds the tile to an available tile in the room
		for (Square square : squares) {
			if (!square.isDoor() && !square.isWallSquare() && square.isRoomSquare()
					&& !square.isOccupied()) {
				square.setWeapon(weapon);
				break;
			}
		}
	}
	
	/**
	 * Add a player to an avaliable square
	 * @param allSquares all the board squares
	 * @param player the player being added
	 */
	public void addPlayerToAvailableSquare(Square[][] allSquares, Player player) {
		// Checks if the weapon is already on the same tile
		for (Square square : squares) {
			if (square.getPlayer() != null) {
				if (square.getPlayer().equals(player)) {
					return;
				}
			}
		}

		// Removes any instance of the weapon on the board
		for (Square[] squareCollection : allSquares) {
			for (Square square : squareCollection) {
				if (square.getPlayer() != null) {
					if (square.getPlayer().equals(player)) {
						square.setPlayer(null);
					}
				}
			}
		}

		// Adds the tile to an available tile in the room
		for (Square square : squares) {
			if (!square.isDoor() && !square.isWallSquare() && square.isRoomSquare() && !square.isOccupied()) {
				square.setPlayer(player);
				player.setxPos(square.getX());
				player.setyPos(square.getY());
				player.setRoom(square.getRoom());
				break;
			}
		}
	}
}
