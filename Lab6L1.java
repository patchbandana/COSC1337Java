/* Eman Eizenga
 * COSC 1337 001
 * 2023-09-25
 * Purpose: To collect and validate Student information (Lab6L1)
 */

package lab6l1;

import java.util.Scanner;

public class Lab6L1 {

	public static void main(String[] args) {
		//Create a Scanner and a String called name
		Scanner scanner = new Scanner(System.in);
		String name = "";

		//Create a do-while loop to read in Students
		do {
			System.out.print("Please enter a student's name: ");
			name = scanner.nextLine();
			//Only prompt the user for the rest of the data if:
			//Input!="done"
			if (!name.equals("done")) {
				System.out.print("Please enter the student's ID: ");
				String sid = scanner.nextLine();
				System.out.print("Please enter the student's GPA: ");
				double GPA = scanner.nextDouble();
				System.out.print("Please enter the student's number of hours: ");
				int numberOfHours = scanner.nextInt();

				//Throw away whitespace
				scanner.nextLine();

				//Create and print out the Student
				Student student = new Student(name, sid, GPA, numberOfHours);
				System.out.println(student);
			}
		} while (!name.equals("done"));

		scanner.close();
	}
}