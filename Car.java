/* Pat Eizenga
 * COSC 1337 001
 * 2023-10-11
 * Purpose: To encapsulate a Car including a model,
 *  milesDriven, and the gallons of gas used so far (Lab7L3)
 * */
package automobiles;

import java.text.DecimalFormat;

/**To encapsulate information about a Car including the model,
 * the miles driven, and the gallons of gas used so far.
 * @author peizenga
 */
public class Car {

	/**The model of the car*/
	private String model;
	/**The miles driven in the car*/
	private int milesDriven;
	/**The gallons of gas used in the car so far*/
	private double gallonsOfGas;
	/**The default format for printing out decimals in the car*/
	private DecimalFormat decFormat = new DecimalFormat("0.0");

	/**Creates a Car about which we know nothing
	 * 
	 */
	public Car() {
		setModel("unknown");
	}
	/**Creates a car with the input information.
	 * 
	 * @param model The desired model of the Car
	 * @param milesDriven The desired number of miles driven in the Car
	 * @param gallonsOfGas The desired gallons of gas used by this Car so far
	 */
	public Car(String model, int milesDriven, double gallonsOfGas) {
		setModel(model);
		setMilesDriven(milesDriven);
		setGallonsOfGas(gallonsOfGas);
	}

	/**Gets the model of the Car
	 * 
	 * @return the model of the Car
	 */
	public String getModel() {
		return model;
	}
	/**Sets the model of the car
	 * 
	 * @param model The desired model of the car
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**Gets the miles driven by the car
	 * 
	 * @return miles driven in the car
	 */
	public int getMilesDriven() {
		return milesDriven;
	}
	/**Sets the miles driven in the Car iff the input is greater than 0. 
	 * Otherwise, sets it to 0.
	 * 
	 * @param milesDriven the desired number of miles driven in the car
	 */
	public void setMilesDriven(int milesDriven) {
		if (milesDriven > 0)
			this.milesDriven = milesDriven;
		else
			this.milesDriven = 0;
	}
	/**Gets the number of gallons used by this Car so far
	 * 
	 * @return the gallons of gas used by the Car so far 
	 */
	public double getGallonsOfGas() {
		return gallonsOfGas;
	}
	/**Sets the amount of gas used by the Car so far iff the input is greater than 0.
	 * Otherwise, sets it to 0.
	 * 
	 * @param gallonsOfGas used by this Car so far
	 */
	public void setGallonsOfGas(double gallonsOfGas) {
		if (gallonsOfGas > 0)
			this.gallonsOfGas = gallonsOfGas;
		else
			this.gallonsOfGas = 0;
	}

	/**Gets the fuel efficiency of the Car iff the amount of gas
	 * used is > .001. Otherwise, sets it to 0.
	 * 
	 * @return the fuel efficiency of the car
	 */
	public double getMilesPerGallon() {
		if (getGallonsOfGas() > .001)
			return getMilesDriven()/getGallonsOfGas();
		return 0.0;
	}
	/**Gets the amount of money spent on gas for this car so far
	 * 
	 * @param pricePerGallon the price per gallon of gas
	 * @return the amount of money spent on gas so far
	 */
	public double getMoneySpentOnGas(double pricePerGallon) {
		return pricePerGallon*getGallonsOfGas();
	}

	/**Returns true iff the input Car has the same data as this Car
	 * 
	 * @param o object to compare this car to
	 * @return true iff the input Car has the same data as this Car
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Car))
			return false;
		Car otherCar = (Car) o ;
		return otherCar.getModel().equals(getModel()) && otherCar.getMilesDriven() == getMilesDriven() &&
				otherCar.getGallonsOfGas() == getGallonsOfGas();
	}

	/**Returns a String version of this Car
	 * 
	 * @return a String version of this Car
	 */
	public String toString() {
		return "Car:"+getModel()+"\n\tMiles Driven:"+getMilesDriven()+". Gas Used: "+getGallonsOfGas()+
				" Fuel Efficiency: "+decFormat.format(getMilesPerGallon())+" mpg.";
	}
}
