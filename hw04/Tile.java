package hw04;

/**
 * @author Juan Tiguila
 * 
 *         This class organizes a tile set into a two dimensional array of
 *         characters. Each instance of this class has a row, column, and a
 *         corresponding color at the given row and column.
 */

public class Tile {
	
	/** The color of a coordinate. */
	private char color;
	
	/** Row of of the current color in tile. */
	private int row;
	
	/** Column the color is located at in a tile. */
	private int col;
	
	/** Creates an object at its given coordinates and color. */
	public Tile(int row, int col, char colors){
		this.row = row;
		this.col = col;
		this.color = colors;
	}

	/** Accessors for color, row, and column. */
	public char getColor() {
		return color;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	
	
	/** Mutators for color, row, and column. */
	public void setColor(char color) {
		this.color = color;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.col = col;
	}


	
	
}
