/* Eman Eizenga
*  COSC 1337 001
*  2023-09-15
*  Purpose: Processing a series of strings in an array and separating their constituent parts,
*  outputting each part, as well as practicing with random strings. (Program1Initials)
*  Insight: The call to random.nextInt() takes currentName.length() - 4 as an argument so
*  	that no matter which index it chooses, you will always be able to get 5 characters
*  	after it and it won't be out of bounds for the array (because the index starts at 0 and length() doesn't).
* */

package initials;
import java.util.Random;

public class Program1Initials {
	public static void main(String[] args) {
		String[] strings = {"David Lee Alger", "Kate Garry Hudson", "Tina Stamatina Fey", "Hugh Mungo Grant",
		"Uma Karuna Thurman"};
		//Loop iterates through each string in the array
		for (int i = 0; i < strings.length; i++)
		{
			//Sets the currentName to the current string in the array
			String currentName = strings[i];
			
			
			//Identify the firstSpace
			int firstSpace = currentName.indexOf(' ');
			
			//Separate the firstName from the middleName in the currentName
			String firstName = currentName.substring(0, firstSpace);
			
			//Get rid of the firstName so that we can find the lastSpace
			String middleName = currentName.substring(firstSpace + 1);
			int lastSpace = middleName.indexOf(' ');
			middleName = middleName.substring(0, lastSpace);
			
			//Separate the lastName from the middleName in the String
			String lastName = currentName.substring(firstSpace + 1);
			lastName = lastName.substring(lastSpace + 1);
			
			//Initialize a new random object and set the boundary to be the length of currentName minus 4
			Random random = new Random();
			int randomSequenceIndex = random.nextInt(currentName.length() - 4);
			String randomName = currentName.substring(randomSequenceIndex, randomSequenceIndex + 5);
			
			//Output all the results with proper formatting
			System.out.println("Your first name is " + firstName + 
					" with a length of " + firstName.length());
			System.out.println("Your middle name is " + middleName +
					" with a length of " + middleName.length());
			System.out.println("Your last name is " + lastName +
					" with a length of " + lastName.length());
			System.out.println("Your initials are " + firstName.charAt(0) +
					middleName.charAt(0) + lastName.charAt(0) + 
					". The length of your entire name is " + currentName.length() + ".");
			System.out.println("A random sequence of 5 letters in your name is " + "\""
					+ randomName + "\"" + "\n\n");
		}
	}
}