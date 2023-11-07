/*Eman Eizenga
 * COSC 1337 001
 * 2023-11-03
 * Purpose: to convert a number in some other number system (such as binary)
 *  to decimal. The base (also known as a radix) will have a maximum of 16.
 */
package numberSystem;

import java.util.Scanner;

/** Converts a number in some number system to decimal.
 */
public class Program3NumberConversion {

	/**Receives input from the scanner to convert numbers with
	 * 
	 * @param args NOT USED
	 */
	public static void main(String[] args) {
		//Make a new Scanner named scanner bound to the keyboard
		Scanner scanner = new Scanner(System.in);
		//Make a new String named response and set it equal to an empty String
		String response = "";
		//Do the following while response equals "y" (use equalsIgnoreCase)
		do
		{
			//initialize an integer named sum and set it to 0
			int sum = 0;
			//Prompt for a radix (or base) up to 16 and read it in
			System.out.print("Enter the base to convert from: ");
			int radix = scanner.nextInt();
			//Prompt for a number named inputNumber and read it in as a String (use scanner.next())
			System.out.print("Input the number you wish to convert to decimal: ");
			String inputNumber = scanner.next();
			//Start a for loop that runs backwards through to characters of inputNumber. Do the following inside the for:
			for (int i = inputNumber.length() - 1; i > -1; i--)
			{
				//Get the current character based on i
				char currentCharacter = inputNumber.charAt(i);
				//Get the currentDigit based on the parseNumber of the result of the previous step
				int currentDigit = parseNumber(currentCharacter);
				//Accumulate in sum the value of the digit. Make sure to compensate for the fact that your loop is running backwards.
				sum += valueOfDigit((inputNumber.length()-i-1), radix, currentDigit);
			}//End for loop
			//Now, just output inputNumber+" in base "+radix+" converts to "+sum+" in base 10."
			System.out.print(inputNumber + " in base " + radix + 
					" converts to " + sum + " in base 10. \n");
			//Prompt the user to enter 'y' to enter another number to convert and read in their response
			System.out.print("Enter \"y\" to enter another number to convert: ");
			response = scanner.next();
		} while (response.equalsIgnoreCase("y"));
		//close the scanner
		scanner.close();
	}

	public static int parseNumber(char letter) 
	{
		switch (letter) 
		{
		case '0':
			return 0;
		case '1': 
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case 'A':
		case 'a':
			return 10;
		case 'B':
		case 'b':
			return 11;
		case 'C':
		case 'c':
			return 12;
		case 'D':
		case 'd':
			return 13;
		case 'E':
		case 'e':
			return 14;
		case 'F':
		case 'f':
			return 15;
			default:
				return 0;
		}
	}

	public static int valueOfDigit(int place, int radix, int number) {
		int result = (int) (number*(Math.pow(radix, place)));
		//System.out.print(result+"+");
		return result;
	}
}