/*Eman Eizenga
 * COSC 1337 001
 * 2023-10-20
 * Purpose: To echo an Arraylist of Integers (Lab9L1)
 * Insight: It would read the String "Integer.dat" - that is 
 * 	I n t e... etc
 */

package arrayListOfIntegers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**A class that echoes an Arraylist of Integers*/
public class Lab9L1 {
	/**The starting point for the program
	 * 
	 * @param args NOT USED
	 * @throws FileNotFoundException if Integers.dat is not found.
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Integer> list = new ArrayList<>();
		File file = new File("Integers2.dat");
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNext())
			list.add(scanner.nextInt());
		
		for (int i=0; i < list.size(); i++)
		{
			int currentItem = list.get(i);
			System.out.print(currentItem + " ");
		}
		
		for (int i:list)
			System.out.println(i + " ");
		
		System.out.println();
		System.out.println(list);
		
		scanner.close();
	}
}
