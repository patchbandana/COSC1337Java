/*Eman Eizenga
 * COSC 1337 001
 * 2023-11-09
 * Purpose: To practice using methods to manipulate, compare
 * and calculate the area and volume of three dimensional
 * shapes. (Program 4: Three Dimensional Shapes)
 */
package threeDimensional;

//import java.text.DecimalFormat;
import java.util.Scanner;

/**A class for manipulating, comparing, and calculating three dimensional shapes
 * 	and printing them using toString.
 */
public class Program4 {

	/**The entry point for the Program.
	 * @param args NOT USED
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Cube firstCube = new Cube();
		System.out.println(firstCube);
		Cube secondCube = new Cube();
		System.out.print("Please enter the length of the side for secondCube: ");
		secondCube.setLengthOfSide(scanner.nextInt());
		Cube thirdCube = new Cube(3);
		int accessorValue = firstCube.getLengthOfSide();
		System.out.println("First Cube side length: " + accessorValue
		+ "\n Second Cube surface area: " + secondCube.getSurfaceArea()
		+ "\n Third Cube volume: " + thirdCube.getVolume());
		System.out.println("First Cube: " + firstCube + 
				"\nSecond Cube: " + secondCube + 
				"\nThird Cube: " + thirdCube);
		System.out.println();
		if (firstCube.equals(secondCube))
			System.out.println("The first and second cubes are equal!");
		if (secondCube.equals(thirdCube))
			System.out.println("The second and third cubes are equal!");
		if (thirdCube.equals(firstCube))
			System.out.println("The first and third cubes are equal!");
		
		//Repeat with Spheres
		Sphere firstSphere = new Sphere();
		//I can remove this part if unnecessary but it made the output of the doubles much nicer
		//DecimalFormat format = new DecimalFormat("#0.00");
		System.out.println(firstSphere);
		Sphere secondSphere = new Sphere();
		System.out.print("Please enter the radius of the second Sphere: ");
		secondSphere.setRadius(scanner.nextInt());
		System.out.println(secondSphere);
		Sphere thirdSphere = new Sphere(3);
		int sphereAccessorValue = firstSphere.getRadius();
		System.out.println("First Sphere radius: " + sphereAccessorValue
				+ "\nSecond Sphere surface area: " + secondSphere.getSurfaceArea()
				+ "\nThird Sphere volume: " + thirdSphere.getVolume());
		System.out.println("First Sphere: " + firstSphere + 
				"\nSecond Sphere: " + secondSphere + 
				"\nThird Sphere: " + thirdSphere + "\n");
		if (firstSphere.equals(secondSphere))
			System.out.println("The first and second spheres are equal!");
		if (secondSphere.equals(thirdSphere))
			System.out.println("The second and third spheres are equal!");
		if (thirdSphere.equals(firstSphere))
			System.out.println("The first and third spheres are equal!");
		
		//Close the Scanner
		scanner.close();
	}
}