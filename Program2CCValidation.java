/*Eman Eizenga
 * COSC 1337 001
 * 2023-10-22
 * Purpose: To validate a credit card number given via user input and process the string's
 * 	information. (Program2CCN)
 * Insight: 
 */

package creditCard;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

public class Program2CCValidation {

	public static void main(String[] args) {

		//set up a Scanner
		Scanner scanner = new Scanner(System.in);
		//set up a boolean named validCreditCard and set it to false
		boolean validCreditCard = false;       

		//loop while not a valid credit card  
		while (validCreditCard == false)
		{
			System.out.println("Please enter your credit card number: ");
			//Get the credit card number as a String - store in potentialCCN (use scanner's nextLine)

			String potentialCCN = scanner.nextLine();
			//use Luhn to validate credit card using the following steps:
			//store the last digit AS AN INT for later use in lastDigit (probably requires Integer.parseInt(String)

			int lastDigit = Integer.parseInt(potentialCCN.substring(potentialCCN.length()-1));
			//TEST then comment out! - check the last digit - System.out.println(lastDigit);
			//System.out.println(lastDigit);

			//remove the last digit from potentialCCN and store in potentialCCN using String's substring
			potentialCCN = potentialCCN.substring(0, potentialCCN.length() - 1);
			//TEST then comment out! - check potentialCCN - System.out.println(potentialCCN);
			//System.out.println(potentialCCN);
			//create reversedCCN as a empty String by:
			String reversedCCN = "";
			//reversing the digits using a for loop by adding characters to reversedCCN
			for (int i = potentialCCN.length()-1; i >= 0; i--)
			{
				reversedCCN += potentialCCN.charAt(i);
				//end the reverse the string loop
			}

			//TEST then comment out! - check reversedCCN - System.out.println(reversedCCN);
			//System.out.println(reversedCCN);
			//set boolean isOddDigit to false
			boolean isOddDigit = false;
			//set up an integer called current digit and set it to 0
			int currentDigit = 0;
			//create an integer named sum and set it to 0
			int sum = 0;
			//multiply the digits in odd positions by 2, then subtract 9 from any number higher than 9 using:
			//(for loop running 0 to less than length of reversed CCN)
			for (int i = 0; i < reversedCCN.length(); i++)
			{
				//set currentDigit equal to the integer version of the current character
				currentDigit = Integer.parseInt(reversedCCN.substring(i, i+1));
				//Test then comment out! - currentDigit -System.out.print(currentDigit);
				//System.out.print(currentDigit);
				//toggle isOddDigit (like a light switch - if it is true, make it false. If it is false, make it true)
				isOddDigit = !isOddDigit;
				//if isOddDigit
				if (isOddDigit)
				{
					//multiply currentDigit by 2 and store in currentDigit
					currentDigit = currentDigit * 2;
					//if currentDigit > 9, subtract 9 from currentDigit and store in currentDigit
					if (currentDigit > 9)
						currentDigit = currentDigit - 9;
					//TEST then comment out - Check currentDigit - System.out.println(currentDigit);
					//System.out.println(currentDigit);
				}
				//end if isOddDigit
				//Comment in this segment for a useful test output string
				System.out.print(currentDigit);
				if (i>=reversedCCN.length()-1)
					System.out.println();
				else 
					System.out.print(" + ");
				// add currentDigit to sum and store in sum 
				sum += currentDigit;
				//end the for loop that runs from 0 to less than the length of reversed CCN   
			}

			//TEST and comment out -  System.out.println("sum:"+sum);
			//System.out.println("sum:"+sum);
			//if the last digit of sum + the last Digit ends in a zero, set validCreditCard to true
			if ((((sum%10)+ lastDigit) % 10) == 0)
				validCreditCard = true;
			//end if
			//if validCreditCard is false, output an appropriate message
			else 
			{
				validCreditCard = false;
				System.out.println("Oops! Please enter a valid credit card number: ");
				//end if
			}
			//end while that checks for valid credit card
		}
		if (validCreditCard)
		{
			Random random = new Random();
			DecimalFormat decimalFormat = new DecimalFormat("0000");
			int pin = random.nextInt(10000);
			//issue a RANDOM PIN and print it out - no more help :)
			System.out.println("Your new PIN is: " + decimalFormat.format(pin));
		}
		scanner.close();
	}
}