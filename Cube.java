/*Eman Eizenga
 * COSC 1337 001
 * 2023-11-07
 * Purpose: To calculate area and volume of a cube using getters
 * and setters and a fully Javadoc'd functional class.
 * (Program 4: Three Dimensional Shapes)
 */
package threeDimensional;

/**Cube class for testing Three Dimensional Shapes
 * @author emane
 * 
 */
public class Cube {
	/**The length of each side*/
	private int lengthOfSide;

	/**No argument constructs a Cube with length 1
	 * 
	 */
	public Cube() {
		this.lengthOfSide = 1;
	}

	/**Constructs a Cube that takes lengthOfSide as an argument
	 * @param lengthOfSide the length of each side
	 */
	public Cube(int lengthOfSide) {
		this.lengthOfSide = lengthOfSide;
	}

	/**Gets the lengthOfSide of the Cube
	 * @return the lengthOfSide of the Cube
	 */
	public int getLengthOfSide() {
		return lengthOfSide;
	}

	/**Sets the lengthOfSide of an existing Cube
	 * @param lengthOfSide the lengthOfSide to set
	 */
	public void setLengthOfSide(int lengthOfSide) {
		this.lengthOfSide = lengthOfSide;
	}

	/**Returns a string representation of the Cube object
	 * 
	 * @return a string with the Cube's dimensions
	 */
	@Override
	public String toString() {
		return "Cube: " + getLengthOfSide() + " Surface Area: "
				+ getSurfaceArea(getLengthOfSide()) + " Volume: "
				+ getVolume(getLengthOfSide());
	}

	/**Calculates and returns the surface area of a Cube
	 * 
	 * @param lengthOfSide the length of each side of the cube
	 * @return the surfaceArea of the cube (6a^2)
	 */
	public int getSurfaceArea(int lengthOfSide) {
		return 6*(lengthOfSide*lengthOfSide);
	}

	/**Calculates and returns the volume of a Cube
	 * 
	 * @param lengthOfSide the length of each dimension
	 * @return the volume of the cube (a^3)
	 */
	public int getVolume(int lengthOfSide) {
		return (lengthOfSide*lengthOfSide*lengthOfSide);
	}

	/**Equals method compares two Cubes to see if they are the same
	 * 
	 * @param obj takes a cube to compare the original Cube too
	 * @return true iff the lengthOfSide of the cubes are the same
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cube))
			return false;
		Cube other = (Cube) obj;
		return lengthOfSide == other.lengthOfSide;
	}
}
