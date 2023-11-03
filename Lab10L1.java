/*Eman Eizenga
 * COSC 1337 001
 * 2023-11-03
 * Purpose: To test Store, WebStore, and MusicStore (Lab 10L1)
 * Insight: They DO have addToInventory, because it was inherited from Store.
 */
package someOtherPackage;

import typesOfStores.MusicStore;
import typesOfStores.Store;
import typesOfStores.WebStore;

/** Tests Store, WebStore, and MusicStore
 * @author eeizenga
 */
public class Lab10L1 {

	/**The entry point of the program. Test Store and its subclasses.
	 * @param args NOT USED
	 */
	public static void main(String[] args) {
		//Create some shops
		Store myShop = new Store("Dave's Awesome Store", "111 Main St., Tyler, TX 75701");
		MusicStore myMusicShop = new MusicStore("Dave's Awesome Music Emporium",
				"1212 Main St., Tyler, TX 75701", "Metallica");
		WebStore myWebStore = new WebStore("Dave's Webstore",
				"11313 Main St., Waynesboro, Virgina 22980",
				"www.davestore.com", "Java");
		
		//Add some inventory to the shops
		myShop.addToInventory("Rocks");
		myShop.addToInventory("Blocks");
		myMusicShop.addToInventory("Guitars");
		myWebStore.addToInventory("Black Lotus");
		
		//Print out the shops
		System.out.println(myShop);
		System.out.println(myMusicShop);
		System.out.println(myWebStore);
	}
}