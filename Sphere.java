/*Eman Eizenga
 * COSC 1337 001
 * 2023-11-07
 * Purpose: To calculate Area and Volume of,
 *  and to manipulate a Sphere object (Program 4: Three Dimensional Shapes)
 */
package threeDimensional;

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
		this.radius = radius;
	}
	
	/**Calculates and returns the surface area of a Sphere
	 * 
	 * @param radius the radius to the center of the Sphere
	 * @return the surfaceArea of the Sphere (4pi*r^2)
	 */
	public double getSurfaceArea(int radius) {
		return (4*(Math.PI*(Math.pow(getRadius(), 2))));
	}
	
	/**Calculates and returns the volume of a Sphere
	 * 
	 * @param radius the length of the radius to the center
	 * @return the volume of the cube ((4/3)*pi*r^3)
	 */
	public double getVolume(int radius) {
		return ((4/3)*Math.PI*(Math.pow(getRadius(), 3)));
	}

	/**Compares two Sphere objects to see if they are the same
	 * 
	 * @param obj passes one Sphere object in as an argument
	 * @return true iff both Sphere objects have the same data
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Sphere))
			return false;
		Sphere other = (Sphere) obj;
		return radius == other.radius;
	}
}
