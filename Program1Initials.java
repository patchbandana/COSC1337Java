/* Eman Eizenga
*  COSC 1337 001
*  2023-09-15
*  Purpose: Processing a series of strings in an array and outputting the details.
*  Insight: The call to random.nextInt() takes currentName.length() - 5 as an argument so
*  	that no matter which index it chooses, you will always be able to get 5 characters
*  	after it and it won't be out of bounds for the array.
* */

package initials;
import java.util.Random;

public class Program1Initials {
	public static void main(String[] args) {
		String[] strings = {"David Lee Alger", "Kate Garry Hudson", "Tina Stamatina Fey", "Hugh Mungo Grant",
		"Uma Karuna Thurman"};
		for (int i = 0; i < strings.length; i++)
		{
			String currentName = strings[i];
			int indexOfSpace = currentName.indexOf(' ');
			String firstName = currentName.substring(0,indexOfSpace);
			System.out.println("Your first name is " + firstName + 
					" with a length of " + firstName.length());
			currentName = currentName.substring(indexOfSpace + 1);
			indexOfSpace = currentName.indexOf(' ');
			String middleName = currentName.substring(0, indexOfSpace);
			System.out.println("Your middle name is " + middleName +
					" with a length of " + middleName.length());
			String lastName = currentName.substring(indexOfSpace + 1);
			System.out.println("Your last name is " + lastName +
					" with a length of " + lastName.length());
			currentName = strings[i];
			System.out.println("Your initials are " + firstName.charAt(0) +
					middleName.charAt(0) + lastName.charAt(0) + 
					". The length of your entire name is " + strings[i].length() + ".");
			Random random = new Random();
			int randomSequenceIndex = random.nextInt(currentName.length() - 5);
			String randomName = currentName.substring(randomSequenceIndex, randomSequenceIndex + 5);
			System.out.println("A random sequence of 5 letters in your name is " 
					+ randomName + "\n\n");
		}
	}
}