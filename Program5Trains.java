/*Eman Eizenga
 * COSC 1337 001
 * 2023-11-17
 * Purpose: To test the Passenger and Train classes (Program5Trains)
 */
package trainsDemo;

/**Testing class to test both Passenger and Train*/
public class Program5Trains {

	/**entry point for the program. Tests Passenger and Train
	 * 
	 * @param args Not Used. Ignore.
	 */
	public static void main(String[] args) {
		Passenger[] passengers = new Passenger[5];
		
		//create 5 passengers
		passengers[0] = new Passenger("David Alger",true);
		passengers[1] = new Passenger("Bob Marley", true);
		passengers[2] = new Passenger("Albert Einstein", false);
		passengers[3] = new Passenger("Harry", false);
		passengers[4] = new Passenger("A whole family", true);
		
		//print out these passengers
		System.out.println("Your complete list of passengers is: ");
		String testString = "";
		for (Passenger passenger:passengers) {
			testString+=passenger+"\n";
		}
		System.out.println(testString);
		
		//create a new Train named "Zelda 550" and add your list of passengers to it, reporting the
		//size after each addition	
		Train zelda = new Train("Zelda 550");
		for (Passenger passenger:passengers)
			System.out.println(zelda.addPassenger(passenger));
		System.out.println();
		
		//create a new Train named "Link 200" and add Bob Marley and a new Passenger to it
		Train link = new Train("Link 200");
		link.addPassenger(passengers[1]);
		link.addPassenger(new Passenger("Bozo the Clown", false));
		
		//print out both Trains along with their percentage in first class
		System.out.println(zelda+"\t"+zelda.getPercentInFirstClass()+"\n\t"+zelda.getTrainRevenue(15.85, 7.10)+"\n");
		System.out.println(link+"\t"+link.getPercentInFirstClass()+"\n\t"+link.getTrainRevenue(7.82, 5)+"\n");
		
		//check for passengers
		System.out.println("Bob Marley is "+(zelda.isPassengerOnTrain("Bob Marley")?"":"not ")+"on Zelda 550");
		System.out.println("Bozo the clown is "+(link.isPassengerOnTrain("Bozo the Clown")?"":"not ")+"on Link 200");
		System.out.println("Bozo the clown is "+(zelda.isPassengerOnTrain("Bozo the Clown")?"":"not ")+"on Zelda 550");
		System.out.println("David Alger is "+(link.isPassengerOnTrain("David Alger")?"":"not ")+"on Link 200");
		System.out.println();
	}

}
