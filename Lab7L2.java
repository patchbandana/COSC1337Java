/*Eman Eizenga
 * COSC 1337 001
 * 2023-10-04
 * Purpose: To test the Car and Airplane classes (Lab7L2)
 * Insight: 
 */
package workingWithInheritedMethods;

import java.util.Scanner;

import automobiles.Airplane;
import automobiles.Car;

public class Lab7L2 {

	public static void main(String[] args) {
		//Create a new Scanner and initialize switchCondtion, oldPlane, and oldCar
		Scanner scanner = new Scanner(System.in);
		char switchCondition = 'A';
		Airplane oldPlane = new Airplane("Cesna 172", 110, 7);
		Car oldCar = new Car("Kia Forte", 2000, 65);

		//Create a while loop that continues while switchCondition
		//is not x or X
		while (switchCondition != 'x' &&
				switchCondition != 'X') {
			//prompt and read in which type of automobile they wish
			//to add
			System.out.print("Add an (A)irplane or (C)ar "
					+ "or e(X)it: ");
			switchCondition = scanner.next().charAt(0);

			//throw away whitespace
			scanner.nextLine();

			//if we are not exiting
			if (switchCondition != 'x' &&
					switchCondition != 'X') {
				switch (switchCondition) {
				case 'a':
				case 'A':
					//Input data for Airplane
					System.out.print("Enter the model name: ");
					String model = scanner.nextLine();
					System.out.print("Enter the number of miles: ");
					int miles = scanner.nextInt();
					System.out.print("Enter the amount of fuel used: ");
					double fuelUsed = scanner.nextDouble();

					//Create and output the Airplane
					Airplane newPlane = new Airplane(model, miles, fuelUsed);
					System.out.println(newPlane);

					//Compare this Airplane to the old Airplane

					if (oldPlane == newPlane)
						System.out.println("The planes are the same object.");
					else
						System.out.println("The planes are NOT the same object.");
					if (oldPlane.equals(newPlane))
						System.out.println("The planes have the same data.");
					else
						System.out.println("The planes have different data.");

					//store the Airplane as oldPlane and break
					oldPlane = newPlane;
					break;
				case 'c':
				case 'C':
					//Input data for Car
					System.out.print("Enter the model name: ");
					model = scanner.nextLine();
					System.out.print("Enter the number of miles: ");
					miles = scanner.nextInt();
					System.out.print("Enter the amount of gas used: ");
					fuelUsed = scanner.nextDouble();

					//Create and output the Car
					Car newCar = new Car(model, miles, fuelUsed);
					System.out.println(newCar);

					//Compare this Car to the old Car

					if (oldCar == newCar)
						System.out.println("The cars are the same object.");
					else
						System.out.println("The cars are NOT the same object.");
					if (oldCar.equals(newCar))
						System.out.println("The cars have the same data.");
					else
						System.out.println("The cars have different data.");

					//store the Car as oldCar and break
					oldCar = newCar;
					break;
				}//end of !x switch
				System.out.println("\n");
			} //end of if not x
		} //end of loop not x
		scanner.close();
	} //end main
} //end of Lab7L2