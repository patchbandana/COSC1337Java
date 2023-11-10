/*Eman Eizenga
 * COSC 1337 001
 * 2023-11-09
 * Purpose: To practice using methods to manipulate, compare
 * and calculate the area and volume of three dimensional
 * shapes. (Program 4: Three Dimensional Shapes)
 * 
 */
package threeDimensional;

import java.util.Scanner;

/**A class for manipulating, comparing, and calculating three dimensional shapes.
 */
public class Program4 {

	/**The entry point for the Program.
	 * @param args NOT USED
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Cube firstCube = new Cube();
		System.out.println(firstCube.toString());
		Cube secondCube = new Cube();
		System.out.print("Please enter the length of the side for secondCube: ");
		secondCube.setLengthOfSide(scanner.nextInt());
		Cube thirdCube = new Cube(3);
		int accessorValue = firstCube.getLengthOfSide();
		System.out.println("First Cube side length: " + accessorValue
		+ " Second Cube surface area: " + secondCube.getSurfaceArea(secondCube.getLengthOfSide())
		+ " Third Cube volume: " + thirdCube.getVolume(thirdCube.getLengthOfSide()));
		System.out.println("First Cube: " + firstCube.toString() + 
				" Second Cube: " + secondCube.toString() + 
				" Third Cube: " + thirdCube.toString());
		System.out.println();
		if (firstCube.equals(secondCube))
			System.out.println("The first and second cubes are equal!");
		if (secondCube.equals(thirdCube))
			System.out.println("The second and third cubes are equal!");
		if (thirdCube.equals(firstCube))
			System.out.println("The first and third cubes are equal!");
		
		//Repeat with Spheres
		scanner.close();
	}

}
