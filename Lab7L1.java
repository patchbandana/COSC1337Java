/*Eman Eizenga
 * COSC 1337 001
 * 2023-09-27
 * Purpose: To test the Car class (Lab7L1)
 */
package automobiles;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Lab7L1 {

	public static void main(String[] args) {
		//Create a Sample Car
		Car gasGuzzler = new Car("Trailblazer", 7000, 437.5);
		
		//Print out the mileage per gallon for this Car
		double mileage = gasGuzzler.getMilesPerGallon();
		DecimalFormat decimalFormat = new DecimalFormat("0.0");
		System.out.println("Mileage for this car: " + 
				decimalFormat.format(mileage) + " mpg.");
		
		//Print our the gas cost for this car
		double totalGasCost = gasGuzzler.getMoneySpentOnGas(2.79);
		NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
		System.out.println("Gas cost for this car: " +
				moneyFormatter.format(totalGasCost));
		
		//Initialize a scanner and modelName
		Scanner in = new Scanner(System.in);
		String modelName = "";
		
		//do/while modelName != "done"
		do {
			
		} while (modelName != "done")
			in.close();
	}
}