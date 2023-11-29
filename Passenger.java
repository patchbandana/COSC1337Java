/*Eman Eizenga
 * COSC 1337 001
 * 2023-11-17
 * Purpose: To encapsulate information about an individual Passenger (Program5Trains)
 */
package trainsDemo;

/**Encapsulates information about an individual passenger, including
 * the passenger's name and whether or not the bought a first class
 * ticket.
 * @author emane
 */
public class Passenger {
	/**The name of the Passenger*/
	private String name;
	/**True iff the passenger is traveling in first class*/
	private boolean isFirstClass;
	
	/**Creates a new Passenger off of input parameters
	 * @param name the desired name of the passenger
	 * @param isFirstClass true iff the Passenger is traveling in first class
	 */
	public Passenger(String name, boolean isFirstClass) {
		setName(name);
		setFirstClass(isFirstClass);
	}

	/**Returns the name of the Passenger
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**Sets the name of the Passenger
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**Returns true iff the Passenger has a first class ticket
	 * @return isFirstClass
	 */
	public boolean isFirstClass() {
		return isFirstClass;
	}

	/**Sets isFirstClass to true if passenger is traveling first class
	 * @param isFirstClass isFirstClass to set
	 */
	public void setFirstClass(boolean isFirstClass) {
		this.isFirstClass = isFirstClass;
	}

	/**Returns true if the two Passengers are considered equal
	 * 
	 * @param o the object to compare this passenger to
	 * @return true iff the two Passengers are to be considered equal
	 */
	@Override
	public boolean equals(Object o) {
		return toString().equals(o.toString());
	}
	
	/**Returns a String version of this Passenger
	 * 
	 * @return a String representation of this Passenger
	 */
	@Override
	public String toString() {
		return getName() + "\t\t" + (isFirstClass()?"!":"");
	}
	
}
