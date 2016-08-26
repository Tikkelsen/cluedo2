package model;

/**
 * Class representing a move being made
 * Only has the x and y position of the next move
 * @author Tobias
 *
 */
public class Move {
	
	int x;
	int y;
	
	public Move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Move getMove() {
		return this;
	}
}
