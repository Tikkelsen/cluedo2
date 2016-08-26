package model;

/**
 * Class representing a boundary square - non-walkable square
 * @author Tobias
 *
 */
public class BoundarySquare extends Square {

	public BoundarySquare(int row, int col, Room room, boolean isWall,
			boolean isDoor, String name) {
		super(row, col, room, isWall, isDoor, name);
		super.isBoundary = true;
	}

}
