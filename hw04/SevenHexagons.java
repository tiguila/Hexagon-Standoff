package hw04;
/**
 * @author Juan Tiguila
 * 
 *         This class solves the puzzle
 * 
 *         It has a solve(), leftShift(), rightShift(), printBoard(), and
 *         isValid(), all of them will work together to solve the puzzle.
 */

public class SevenHexagons {
	
	/** @param board 	A board object.
	 * 
	 * This helper method solves the puzzle. */
	
	public void solve(Board board) {
		
		/* Calling the overloaded helper method. */
		solve(board, 1	, 0);
		if (board.solutionNumber == 0) {
			System.out.println("No solution");
		}
		
	}
	
	
	/** This method solves the puzzle.
	 *  @param board	A board Object.
	 *  @param row 		The total number of tiles.
	 *  @param cols	 	The total number of colors in a tile.
	 * 
	 *  */
	public void solve(Board board, int row, int cols) {
		/* Base case */
		if(row==board.getRows()) {
//			++board.solutionNumber;
			System.out.println("Solution # " + ++board.solutionNumber+ "-----------------------------------------");
			printTiles(board);
		}
		
		/* Recursive call. */
		else {
			for (int currentColumn = 0 ; currentColumn < board.getCols(); ++currentColumn) {
				
				/* Check whether the works at the current position. */
				if (isValid(board, row, cols)) {
					board.getCoordinate(row, currentColumn).setColor(board.getCoordinate(row, currentColumn).getColor());
					
					rightShift(board, row);
					board.solutionNumber++;
					
					//Recurse to the next tile
					solve(board, row + 1, 0);
					
					
					//Backtracking step
					leftShift(board, row);
					board.getCoordinate(row, currentColumn).setColor(board.getCoordinate(row, currentColumn).getColor());
					board.solutionNumber--;
					
				}
			}
		}
		
	}
	
	/**This methods check if a tile works at a given position.
	 * @param board	a map.
	 * @param currentR 		The current of the tile.
	 * @param currentColumn 	The current index of a color in a tile. 
	 * @return 	return true if a tile fits at the given position. */

	public boolean isValid(Board board, int currentR, int currentColumn) {
		
		int currentColTemp1 = currentColumn;
		int currentColTemp2 = currentColumn;
		int currentColTemp3 = currentColumn;
		int currentColTemp4 = currentColumn;
		int tempRow =  currentR;
		
		/** if we are in tile 1, change the index of the color we are interested
		 * in, the color at the south position. */
		if(currentR==1) {
			currentColTemp1 = currentColumn+3;
		}
		
		else if(currentR == 2) {
			currentColTemp1 = currentColTemp1 + 4;
			currentColTemp2 = currentColTemp2 + 5;
			currentColTemp3 = currentColTemp3 + 2;	
		}
		
		else if(currentR == 3) {
			currentColTemp1 = currentColTemp1 + 0;
			currentColTemp2 = currentColTemp2 + 5;	
			currentColTemp3 = currentColTemp3 + 3;
			tempRow = tempRow-1;
		}
		else if(currentR == 4) {
			currentColTemp1 = currentR - 4;
			currentColTemp2 = currentColTemp2 + 4;
			currentColTemp3 = currentColTemp3 + 1;
		}
		else if(currentR == 5) {
			currentColTemp1 = currentColTemp1 + 1;
			currentColTemp2 = currentColTemp2 + 2;
			currentColTemp3 = currentColTemp3 + 5;
		}
	
		else if(currentR == 6) {
			currentColTemp1 = currentColTemp1 + 2;
			currentColTemp2 = currentColTemp2 + 3;
			currentColTemp3 = currentColTemp3 + 0;
			currentColTemp4 = currentColTemp4 + 1;
			tempRow = tempRow - 6;
		}
		
		
		/* Check if tile 1 fits at the north position relative to the center
		 * tile. */
		if (board.getCoordinate(0, 0).getColor() != 
				board.getCoordinate(currentR, currentColTemp1).getColor()) {
			return false;
		}
		
		/** check if tile 2 works at the north east position relative to the
		 * center tile. */ 
		if(board.getCoordinate(0, 1).getColor() != board.getCoordinate(currentR, currentColTemp1).getColor() && 
				board.getCoordinate(currentR, currentColTemp2).getColor() != board.getCoordinate(currentR-1, currentColTemp3).getColor() 
				){
			return false;
		}
		
		/** check if tile 3 fits at  south-east position. */
		if (board.getCoordinate(0, 2).getColor() != board.getCoordinate(currentR, currentColTemp2).getColor() &&
				board.getCoordinate(currentR, currentColTemp1).getColor() != board.getCoordinate(tempRow, currentColTemp3).getColor()
				) {
			return false;
			
		}
		
		/** check if tile 4 works at the south position. */
		if (board.getCoordinate(0, 3).getColor() != board.getCoordinate(currentR, currentColTemp1).getColor() &&
				board.getCoordinate(currentR, currentColTemp3).getColor() != board.getCoordinate(currentR - 1, currentColTemp2).getColor()
				) {
			return false;
		}
		
		/** Check if tile 5 works at south-west position. */
		if (board.getCoordinate(0, 4).getColor() != board.getCoordinate(currentR, currentColTemp1).getColor() &&
				board.getCoordinate(currentR, currentColTemp2).getColor() != board.getCoordinate(currentR - 1, currentColTemp3).getColor() 
				) {
			return false;
		}
		
		/** check if tile 6 works at north-west position.*/
		if (board.getCoordinate(0, 5).getColor() != board.getCoordinate(currentR, currentColTemp1).getColor() &&
				board.getCoordinate(currentR, currentColTemp2).getColor() != board.getCoordinate(currentR-1, tempRow).getColor() &&
				board.getCoordinate(currentR, currentColTemp4).getColor() != board.getCoordinate(tempRow+1, currentColTemp2+1).getColor()
				) {
			return false;
		}
		return true;
	}
	
	
	/** This  method right shifts all values.
	 * @param tile	A tile, or an array of colors represented by a set of chars.
	 * @return	Returns this array of chars. */
	public char[] rightShift(char[] tile) {
		int shiftDistance = 1;
		
		/** Create a copy of the original array. */
		char[] deepCopy = new char[tile.length];
		
		/** Add the items before the shift distance from the original array to 
		 * the array.*/
		char[] firstSubset = new char[tile.length - shiftDistance];
		for(int i=0;i<firstSubset.length;i++) {
			firstSubset[i] = tile[i];
		}
		
		/** Create another array to store the values after the shift distance.*/
		char[] secondsubset = new char[deepCopy.length-firstSubset.length];
		
		/** Add the remaining items from the original array to the new array.*/
		for(int i=deepCopy.length-1, z=0;i>=firstSubset.length;i--, z++) {
			secondsubset[z] = tile[i];
		}
		
		/** Copy the first segment from the original array to the array copy.*/
		for(int i=0;i<secondsubset.length;i++) {
			deepCopy[i] = secondsubset[i];
		}
		
		/** Copy the second segment from the original array to the array copy.*/
		for(int i=secondsubset.length, z=0; i<deepCopy.length;i++, z++) {
			deepCopy[i] = firstSubset[z];
		}
		return deepCopy;
	}
	
	
	/** This method right shifts all values from a tile by 1 unit. 
	 * @param board 	A reference of a map object
	 * @param row	The tile to right shift. */
	public void rightShift(Board board, int row) {
		/** Make a copy of the tile at the given row. */
		char[] tile = new char[board.getCols()];
		for(int i=0;i<board.getCols();i++) {
			tile[i] = board.getCoordinate(row, i).getColor();
		}
		
		/** Calling the shift() helper method to right shift by 1 unit and
		 * passing a 1D array of chars as argument.
		 * 
		 * Reset the values in the original map/tile.
		 * */
		for(int i=0;i<rightShift(tile).length;i++) {
			board.getCoordinate(row, i).setColor(rightShift(tile)[i]);
		}
	}
	
	
	/** This is a helper method that left shifts all values by 1.
	 * @param tile	A tile represented in an array of chars.
	 * @return 	Returns this tile. */
	public char[] leftShift(char[] tile) {

		char[] deepCopy = new char[tile.length];

		/** Hold the given index for later reference. */
		int shiftDistance = 1;

		/** Copy the values after the index from original array to a different
		 * array. */
		char[] listsubsetA = new char[tile.length - 1];
		for (int i = 0; i < listsubsetA.length; i++, ++shiftDistance) {
			listsubsetA[i] = tile[shiftDistance];
		}

		/**
		 * Copy the values before the index from original array to a different
		 * array. */
		char[] listsubsetB = new char[1];
		for (int i = 0; i < listsubsetB.length; i++) {
			listsubsetB[i] = tile[i];
		}

		/** Copying the first subset of the original array to the deep copy
		 * thereof. */
		for (int i = 0; i < listsubsetA.length; i++) {
			deepCopy[i] = listsubsetA[i];
		}

		/** Copying the second subset of the original array to the deep copy
		 * thereof. */
		for (int i = listsubsetA.length, z = 0; i < tile.length; i++, z++) {
			deepCopy[i] = listsubsetB[z];
		}
		return deepCopy;
	}
	
	
	/** This method left shifts all values by 1 unit.
	 * @param board 	A reference of a map object
	 * @param row	The tile to right shift. */
	public void leftShift(Board board, int row) {
		/** Make a copy of the tile at the given row. */
		char[] tile = new char[board.getCols()];
		for(int i=0;i<board.getCols();i++) {
			tile[i] = board.getCoordinate(row, i).getColor();
		}
		
		/** Calling the shift() helper method to right shift by 1 unit and
		 * passing a 1D array of chars as argument.
		 * 
		 * Reset the values in the original tile.
		 * */
		for(int i=0;i<leftShift(tile).length;i++) {
			board.getCoordinate(row, i).setColor(leftShift(tile)[i]);
		}
	}
	
	
	/** This method prints all 7 tiles. */
	public void printTiles(Board board) {
		// print the board formatted.
		System.out.println("                          SA   SB   SC   SD   SE   SF\n");
		for(int r=0;r<board.getRows();r++) {	
			System.out.printf("Position %d: Tile #%d:  ", (r+1),(r+1));
			for(int c=0;c<board.getCols();c++) {
				System.out.printf("%5c" , board.getCoordinate(r, c).getColor());
			}
			System.out.println();
		}
		System.out.println("\n");	
	}

	
	
}
