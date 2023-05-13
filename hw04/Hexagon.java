package hw04;

/** @author Juan Tiguila
 * 
 * This is my second approach at solving this puzzle. I did not get to finish it.
 * 
 * */

public class Hexagon {
	
	
	
	//Validate if a tile works in a given position.
	public boolean isSafe(char[][] board, int currentR, int currentColumn) {
		// Use if statements.
		
		return false;
	}
	
	// Recursive method.
	public boolean solve(char[][] board, char[][] solution, int row, int col) {
		
		/* base case */
		if (row == board.length-1) {
			return false;
		}
		
		/* Recursive case */
		if (isSafe(board, row, col)) {
			
			/*
			 * set the value in the solution board at the current tile and color therein
			 * from the board
			 */
			solution[row][col] = board[row][col];

			// call the  leftshift() method.
			
			/* recursive call
			 * 
			 * Go to the next tile.
			 * */
			
			
			if (solve(board, solution, row + 1, col)) {
				return true;
			}

			
			/*
			 * Backtracking
			 * Undo the process done above
			 * Remove the color placed at the previous position in the solution
			 * board
			 * 
			 * call the rightShift() to undo the leftShift().
			 */
			
			row--;
			solution[row][col] = board[row][col];
			
			return false;
		}
		return false;
	}









	public void solve(Board board) {
		char[][] solution = new char[7][6];

		/* if the solve(board, solution, 0, 0) returns true, print the current board */

		/* otherwise, print that there was no solution to the set of tiles. */
		

	}
	
	
	public void printArray(char[][] board) {
		/**
		 * Print the board formatted.
		 * Use a nested for loop. */
	}
	
	
	
	
	// create a leftShift() for a tile.
	
	
	
	// create a rightshift() for a tile.
}
