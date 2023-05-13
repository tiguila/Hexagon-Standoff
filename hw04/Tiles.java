//package hw04;
//
///** This class reads the data from a .txt file and returns data colors from
// * this file in a 2D array of chars.*/
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class Tiles {
//	
//	/** This method returns the tiles as a 2 dimensional array of char. 
//	 * 
//	 * First row being the first tile; second row being the second tile and so
//	 * on.
//	 * */
//	public char[][] tiles() {
//		String[] tile = new String[7];
//		/** Create a file Object and pass the path of tile to read . */
//		File input = new File("src/files/tileset2-1.txt");
//
//		try
//		{
//			/** Value to track the index of the current tile in the file. */
//			int i=0;
//			
//			/** @Param input	The location of the file to read data from. */
//			Scanner fileR = new Scanner(input);
//			
//			String[] index = null;
//			String line = null;
//			
//			/** Read all colors from the file and store each tile as a string. */
//			while(fileR.hasNextLine()) {
//				fileR.next();
//				fileR.next();
//				fileR.hasNextByte();
//				line = fileR.nextLine();
//				
//				/** Split each tile after each comma, ","*/
//				index = line.split(",");
//				
//				/** Store all colors from a tile in a String*/
//				tile[i] = index[0].charAt(1) + index[1]+ index[2]+
//						index[3] + index[4] + index[5];
//				i++;
//			}
//			fileR.close();
//		}
//		catch (FileNotFoundException e) {
//			System.out.println(e);
//		}
//		
//		/** Put the colors from each tile in a 2D array. */
//		char[][] tiles = new char[7][6];
//		for (int i = 0; i < tile.length; i++) {
//			for (int z = 0; z < tile[i].length(); z++) {
//				tiles[i][z] = tile[i].charAt(z);
//			}
//		}
//		return tiles;
//	}	
//
//}
