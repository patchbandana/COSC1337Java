/* Pat Eizenga
 * COSC 1337 001
 * 2023-10-11
 * Purpose: To encapsulate an Airplane including a model,
 *  milesFlown, and the gallons of fuel used so far (Lab7L3)
 * Insight: The classes could easily be combined since they both
 * 	have only a model, miles traveled, and an amount of fuel used.
 * */
package automobiles;

/**A class that encapsulates information about an Airplane including
 * model, the miles flown, and the amount of fuel used. <hr> Some stuff 
 * I want to say
 * @author peizenga
 * 
 */
public class Airplane {
	/**The model of the Airplane*/
	private String model;
	/**The miles flown by this Airplane*/
	private int milesFlown;
	/**The amount of fuel this Airplane has used so far*/
	private double gallonsOfFuel;

	/**Creates a new Airplane with the input information
	 * 
	 * @param model The model of the new Airplane
	 * @param milesFlown The number of miles flown by this Airplane
	 * @param gallonsOfFuel The amount of fuel used by this Airplane
	 */
	public Airplane(String model, int milesFlown, double gallonsOfFuel) {
		setModel(model);
		setMilesFlown(milesFlown);
		setGallonsOfFuel(gallonsOfFuel);
	}

	/**Gets the model of the airplane
	 * 
	 * @return the model of the Airplane
	 */
	public String getModel() {
		return model;
	}
	/**Sets the model of the Airplane
	 * 
	 * @param model the new model of the Airplane
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**Returns the milesFlown by the Airplane
	 * 
	 * @return milesFlown the milesFlown by this Airplane
	 */
	public int getMilesFlown() {
		return milesFlown;
	}
	/**Sets the milesFlown by this Airplane
	 * 
	 * @param milesFlown sets the new milesFlown by this Airplane
	 */
	public void setMilesFlown(int milesFlown) {
		this.milesFlown = milesFlown;
	}
	/**Gets the gallonsOfFuel used by the Airplane so far
	 * 
	 * @return gallonsOfFuel used by this Airplane so far
	 */
	public double getGallonsOfFuel() {
		return gallonsOfFuel;
	}
	/**Sets the gallonsOfFuel used by this Airplane so far
	 * 
	 * @param gallonsOfFuel sets the new gallonsOfFuel used by this Airplane so far
	 */
	public void setGallonsOfFuel(double gallonsOfFuel) {
		this.gallonsOfFuel = gallonsOfFuel;
	}

	//data manipulation method for airplane
	/**Gets the fuel efficiency of this Airplane. Note that if 
	 * gallonsOfFuel is less than or equal to .001,
	 * this method just returns 0.
	 * 
	 * @return the number of miles per gallon for this Airplane.
	 */
	public double getMilesPerGallon() {
		if (getGallonsOfFuel() > .001)
			return getMilesFlown() / getGallonsOfFuel();
		else
			return 0.0;
	}
	/**Returns a String representation of this Airplane
	 * 
	 * @return the String representation of this Airplane
	 */
	public String toString() {
		return "Airplane: "+getModel()+"\n\tMiles Flown: "+getMilesFlown()+". Fuel Used: "+getGallonsOfFuel()+
				" gallons.\n\tFuel efficiency: "+getMilesPerGallon()+ " mpg.";
	}
	/**Return true if and only if the input Airplane has the same data
	 * as this Airplane.
	 * 
	 * @param o the Object to compare this Airplane to
	 * @return true iff the two Airplanes have the same data
	 */
	public boolean equals(Object o) {
		return o.toString().equals(toString());
	}
}
