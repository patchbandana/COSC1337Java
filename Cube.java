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
		setLengthOfSide(1);
	}

	/**Constructs a Cube that takes lengthOfSide as an argument
	 * @param lengthOfSide the length of each side
	 */
	public Cube(int lengthOfSide) {
		setLengthOfSide(lengthOfSide);
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
		if (lengthOfSide >= 0)
			this.lengthOfSide = lengthOfSide;
	}

	/**Returns a string representation of the Cube object
	 * 
	 * @return a string with the Cube's dimensions
	 */
	@Override
	public String toString() {
		return "Cube: " + getLengthOfSide() + " Surface Area: "
				+ getSurfaceArea() + " Volume: "
				+ getVolume();
	}

	/**Calculates and returns the surface area of a Cube
	 * 
	 * @param lengthOfSide the length of each side of the cube
	 * @return the surfaceArea of the cube (6a^2)
	 */
	public int getSurfaceArea() {
		return 6*(getLengthOfSide()*getLengthOfSide());
	}

	/**Calculates and returns the volume of a Cube
	 * 
	 * @param lengthOfSide the length of each dimension
	 * @return the volume of the cube (a^3)
	 */
	public int getVolume() {
		return (getLengthOfSide()*getLengthOfSide()*getLengthOfSide());
	}

	/**Equals method compares two Cubes to see if they are the same
	 * 
	 * @param obj takes a cube to compare the original Cube too
	 * @return true iff the lengthOfSide of the cubes are the same
	 */
	@Override
	public boolean equals(Object o) {
		return toString().equals(o.toString());
	}
}
