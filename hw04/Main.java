package hw04;

/**
 * @author Juan Tiguila
 * 
 * 
 *         This is the main class. Create an instance of SevenHexagon class
 *         Create an instance of Board class.
 * 
 *         Call necessary methods from given classes to solve the 7 hexagons.
 */

public class Main {
	
	public static void main(String[] args) {

		Board m = new Board(7, 6);
		
		SevenHexagons s = new SevenHexagons();
		
		s.solve(m);
		
		System.out.println(m.solutionNumber);

	}

}
