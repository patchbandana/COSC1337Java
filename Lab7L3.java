/* Pat Eizenga
 * COSC 1337 001
 * 2023-10-11
 * Purpose: To test the Airplane and Car classes (Lab7L3)
 * */
package automobiles;

/**The test class for Car and Airplane that prints out their data*/
public class Lab7L3 {
	/**The entry point for the program.
	 * 
	 * @param args NOT USED
	 */
	public static void main(String[] args) {
		//create a Car and an Airplane
		Car myCar = new Car();
		Airplane myPlane = new Airplane("model",0,0.0);
		
		//print out the info for the car and the airplane that you created
		System.out.println(myCar);
		System.out.println(myPlane);
		
		System.out.println(Math.sqrt(3));
		System.out.println(myPlane.getGallonsOfFuel());
	}//end main
}