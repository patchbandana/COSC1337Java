/*Eman Eizenga
 * COSC 1337 001
 * 2023-09-27
 * Purpose: To test the Car class (Lab7L1)
 */
package automobiles;

import java.text.DecimalFormat;

public class Lab7L1 {

	public static void main(String[] args) {
		//Create a Sample Car
		Car gasGuzzler = new Car("Trailblazer", 7000, 437.5);
		
		//Print out the mileage per gallon for this Car
		double mileage = gasGuzzler.getMilesPerGallon();
		DecimalFormat decimalFormat = new DecimalFormat("0.0");
		System.out.println();
	}
}