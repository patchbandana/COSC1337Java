/*Eman Eizenga
 * COSC 1337 001
 * 2023-10-25
 * Purpose: To handle inventory for a bookstore (Lab9L2)
 * Insight: 1)
 * for (int i = 0; i < inventory.size(); i++)
		{
			Book current = inventory.get(i);
			System.out.println(current);
		}
	2) In any situation where you need the index number as well -
	the enhanced for loop hides that as an extra detail.
 */
package bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**A class for demonstrating how ArrayLists of Books will work
 * @author eeizenga
 * 
 */
public class Lab9L2 {

	/**The entry point for the program
	 * @param args NOT USED
	 * @throws FileNotFoundException if inventory.dat is not found
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner to read the text file
		Scanner scanner = new Scanner(new File("inventory.dat"));
		
		//ArrayList to hold Books
		ArrayList<Book> inventory = new ArrayList<>();
		
		//Read from file and create new Books
		while (scanner.hasNext()) {
			String title = scanner.nextLine();
			String author = scanner.nextLine();
			String priceString = scanner.nextLine();
			double price = Double.parseDouble(priceString);
			
			Book temporaryBook = new Book(title, author, price);
			inventory.add(temporaryBook);	
		}
		scanner.close();
		
		//Change the price of the second Book
		Book temp = inventory.get(1);
		temp.setRetailPrice(0.00);
		
		//Enhanced for loop to print Books
		for (Book current:inventory)
			System.out.println(current);
		
		//Enhanced for loop to update price of each Book
		for (Book current:inventory)
		{
			current.setRetailPrice(current.getRetailPrice()*1.1);
			System.out.println(current);
		}
	}
}