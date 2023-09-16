/* Eman Eizenga
*  COSC 1337 001
*  2023-09-15
*  Purpose:
*  Insight: 
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
			System.out.println("Your first name is " + currentName. + 
					"with a length of " + currentName);
		}
		//Output "Your first name is [David] with a length of [5]"
		//Output "Your middle name is [Lee] with a length of [3]"
		//Output "Your last name is [Alger] with a length of [5]"
		//Output "Your initials are [DLA]. The length of your entire name is [15]"
		//Output "A random sequence of 5 letters in your name is "[d Lee A]""
		//Output two blank lines to separate the name being processed from the next name being processed
	}

}
