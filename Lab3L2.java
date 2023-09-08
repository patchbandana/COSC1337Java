/* Pat Eizenga
 * COSC 1337 001
 * 2023-09-01
 * Purpose: To practice working with Strings and Random integers (Lab3L2)
 * Insight: 
*/
package lab3L2;
import java.util.Random;

public class Lab3L2 {

	public static void main(String[] args) {
		//Create some Strings
		String alphabet = "ABCDEFGHIJKLMNOPQRZTUVWXYZ";
		String everyEvenLetter = "BDFHJLNPRTVXZ";
		String politeGreeting = new String("Hello, World! How are you?");
		String sentenceWithEveryLetter = 
				"The quick brown fox jumps over the lazy dog.";
		
		//Using Length
		System.out.println("Alphabet: "+alphabet+" Length of alphabet: "+
				+alphabet.length());
		System.out.println("Changing cases:");
		System.out.println(everyEvenLetter.toUpperCase());
		System.out.println(politeGreeting.toLowerCase());
		System.out.println(politeGreeting);
		
		
		//charAT and indexOf
		System.out.println("Index of J: :" + alphabet.indexOf('J'));
		System.out.println("Index of \"brown\": " +
				sentenceWithEveryLetter.indexOf("brown"));
		System.out.println("Index of \"JR\": " + 
				alphabet.indexOf("JR"));
		System.out.println("Character at position 2: " + 
				alphabet.charAt(2));
		
		//substrings
		int startIndex = 4, endIndex = startIndex + 5;
		System.out.println("sentenceWithEveryLetter starting at " + 
				"index 31: "+sentenceWithEveryLetter.substring(31));
		System.out.println("sentenceWithEveryLetter with indices " + 
				"8 to 12: " + sentenceWithEveryLetter.substring(8, 8+5));
		String substring = sentenceWithEveryLetter.substring(startIndex, endIndex);
		System.out.println(substring);
		
		//random entities
		Random random = new Random();
		System.out.println("Random Boolean: " + random.nextBoolean());
		
	}

}
