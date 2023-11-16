/*Eman Eizenga
 * COSC 1337 001
 * 2023-11-07
 * Purpose: To calculate Area and Volume of,
 *  and to manipulate a Sphere object (Program 4: Three Dimensional Shapes)
 */
package threeDimensional;

import java.text.DecimalFormat;

/**Sphere class for testing Three Dimensional Shapes
 * @author emane
 */
public class Sphere {
	/**The radius of a given Sphere*/
	private int radius;

	/**A no argument constructor for the Sphere class
	 */
	public Sphere() {
		setRadius(1);
	}

	/**A constructor for the Sphere class that takes radius as an argument
	 * @param radius the radius of the sphere.
	 */
	public Sphere(int radius) {
		setRadius(radius);
	}

	/**Returns the radius of the current Sphere
	 * @return the radius of the Sphere object
	 */
	public int getRadius() {
		return radius;
	}

	/**Sets the radius of the current Sphere
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		//input validation
		if (radius >= 0)
			this.radius = radius;
	}
	
	
	/**Returns a string representation of the sphere object
	 * 
	 * @return a string with the Sphere's dimensions
	 */
	@Override
	public String toString() {
		//I can remove this part if unnecessary but it made the output of the doubles much nicer
		DecimalFormat format = new DecimalFormat("#0.00");
		return "Sphere: " + getRadius() + " Surface Area: "
				+ format.format(getSurfaceArea() + " Volume: "
				+ format.format(getVolume()));
	}

	/**Calculates and returns the surface area of a Sphere
	 * 
	 * @param radius the radius to the center of the Sphere
	 * @return the surfaceArea of the Sphere (4pi*r^2)
	 */
	public double getSurfaceArea() {
		return (4*(Math.PI*(Math.pow(getRadius(), 2))));
	}

	/**Calculates and returns the volume of a Sphere
	 * 
	 * @param radius the length of the radius to the center
	 * @return the volume of the cube ((4/3)*pi*r^3)
	 */
	public double getVolume() {
		return ((4.0/3.0)*Math.PI*(Math.pow(getRadius(), 3)));
	}

	/**Compares two Sphere objects to see if they are the same
	 * 
	 * @param obj passes one Sphere object in as an argument
	 * @return true iff both Sphere objects have the same data
	 */
	@Override
	public boolean equals(Object o) {
		return toString().equals(o.toString());
	}
}