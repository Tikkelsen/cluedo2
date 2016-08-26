package controller;

import java.util.ArrayList;

import model.Board;
import model.Move;
import model.Player;
import model.Room;
import model.Square;

public class MovementController {

	Board board;
	Square[][] squares;
	
	/**
	 * Constructor
	 * @param board board to be used for the game
	 */
	public MovementController(Board board) {
		this.board = board;
		this.squares = board.getSquares();
	}
	
	/**
	 * Check if it is a valid move
	 * @param move move being done (x, y)
	 * @param player player doing the move
	 * @param roll roll from the dice
	 * @return true if it is a valid move, false if not
	 */
	public boolean isValidMove(Move move, Player player, int roll) {
		if(player.isInRoom()) {
			Room room = player.getRoom();
			ArrayList<Square> exits = room.getDoors();
			for(Square exit : exits) {
				if(isValidDistance(move, exit, roll)) {
					if(!isSquareOccupied(move)) {
						if(pathSearch(move, exit, roll)) {
							return true;
						}
					}
				}
			}
			return false;
		}
		else {
			if(isValidDistance(move, squares[player.getxPos()][player.getyPos()], roll)) {
				if(!isSquareOccupied(move)) {
					return pathSearch(move, squares[player.getxPos()][player.getyPos()], roll);
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
	}
	
	/**
	 * Checks if the square being moved to is occupied
	 * @param target square being moved to
	 * @return
	 */
	private boolean isSquareOccupied(Move target) {
		if(target.getX() < 24 && target.getX() > 0 && target.getX() < 25 && target.getY() > 0) {
			Square square = squares[target.getX()][target.getY()];
			return square.isOccupied() || square.isBoundary();
		}
		return true;
	}
	
	/**
	 * Checks if the distance being moved is valid depending on what the dice rolled
	 * @param move move being done
	 * @param pSquare square being moved to
	 * @param roll roll from the dice
	 * @return true if it is a valid distance, false if not
	 */
	private boolean isValidDistance(Move move, Square pSquare, int roll) {
		int changeX = Math.abs(move.getX() - pSquare.getY());
		int changeY = Math.abs(move.getY() - pSquare.getX());
		
		return (changeX + changeY) >= roll;
	}
	
	/**
	 * Checks if it is a valid path
	 * @param target move being moved to
	 * @param currentSquare current square the player is on
	 * @param remaining number of moves remaining
	 * @return true if it is a valid path, false if not
	 */
	private boolean pathSearch(Move target, Square currentSquare, int remaining) {
		if(currentSquare.isRoomSquare()) {
			if(currentSquare.isWallSquare()) {
				return false;
			}
		}
		
		if(target.getX() == currentSquare.getY() && target.getY() == currentSquare.getX()) {
			return true;
		}
		
		if(remaining == 0) {
			return false;
		}
		
		int currentX = currentSquare.getY();
		int currentY = currentSquare.getX();
		
        if (currentX > 1) if(pathSearch(target, squares[currentX - 1][currentY], remaining - 1)) return true;
        if (currentY > 1) if(pathSearch(target, squares[currentX][currentY - 1], remaining - 1)) return true;
        if (currentX < 23) if(pathSearch(target, squares[currentX + 1][currentY], remaining - 1)) return true;
        if (currentY < 24) if(pathSearch(target, squares[currentX][currentY + 1], remaining - 1)) return true;

        return false;
	}
}
