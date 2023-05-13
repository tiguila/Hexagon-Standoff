package hw04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Juan Tiguila
 * 
 *         This map class sets a color at each row and column. The color is
 *         represented by a char such as B, Y and such for blue, yellow
 *         respectively.
 */

public class Board {
	
	// Keeps track of the number of solutions.
	public int solutionNumber = 0;
	
	/** Create a 2-D instance of a Tile class. */
	private Tile[][] tiles;

	/** The total number of tiles. */
	private int numRows;

	/** The total number of colors in a tile. */
	private int numCols;
	
	/** Creates a Board object.
	 * @param row 	The tile number
	 * @param col 	The index of a color in the given tile. */
	public Board(int row, int col) {
		this.tiles = new Tile[row][col];
		this.boardSetup(row, col);
		this.numRows = row;
		this.numCols = col;
	}
	
	/** Allows to get a color from a tile, given the tile number and color
	 * index.
	 * 
	 * @param row	The tile number
	 * @param col 	The index of the color.
	 * */
	public Tile getCoordinate(int row, int col) {
		return this.tiles[row][col];
		
	}
	
	
	/** Place each color in the coordinate, or place a color in its respective
	 * tile and index therein.
	 * 
	 * @param row 	Tile number
	 * @param col 	Index of the color in a tile.
	 * */
	public void boardSetup(int row, int col) {
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				tiles[r][c] = new Tile(r, c, tiles()[r][c]);
			}
		}
	}
	
	
	/** @return 	Returns a tile number*/
	public int getRows() {
		return numRows;
	}
	
	
	/** @return 	Returns index of a color from a tile. */
	public int getCols() {
		return numCols;
	}
	
	
	/** This method returns the tiles as a 2 dimensional array of char. 
	 * 
	 * First row being the first tile; second row being the second tile and so
	 * on.
	 * */
	public char[][] tiles() {

		String[] tile = new String[7];
		/** Create a file Object and pass the path of tile to read . */
		File input = new File("src/files/tileset2-1.txt");

		try
		{
			/** Value to track the index of the current tile in the file. */
			int i=0;
			
			/** @Param input	The location of the file to read data from. */
			Scanner fileR = new Scanner(input);
			
			String[] index = null;
			String line = null;
			
			/** Read all colors from the file and store each tile as a string. */
			while(fileR.hasNextLine()) {
				fileR.next();
				fileR.next();
				fileR.hasNextByte();
				line = fileR.nextLine();
				
				/** Split each tile after each comma, ","*/
				index = line.split(",");
				
				/** Store all colors from a tile in a String*/
				tile[i] = index[0].charAt(1) + index[1] + index[2] + index[3] + index[4] + index[5];
				i++;
			}
			fileR.close();
		}
		
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		/** Put the colors from each tile in a 2D array. */
		char[][] tiles = new char[7][6];
		for (int i = 0; i < tile.length; i++) {
			for (int z = 0; z < tile[i].length(); z++) {
				tiles[i][z] = tile[i].charAt(z);
			}
		}
		
		return tiles;
	}
	

}
