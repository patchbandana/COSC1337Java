/* Eman Eizenga
 * COSC 1337 001
 * 2023-10-11
 * Purpose: To encapsulate a Car including a model,
 *  milesDriven, and the gallons of gas used so far
 * */
package automobiles;

import java.text.DecimalFormat;

/**To encapsulate information about a Car including the model,
 * the miles driven, and the gallons of gas used so far.
 * @author eeizenga
 */
public class Car {
	
	private String model;
	private int milesDriven;
	private double gallonsOfGas;
	private DecimalFormat decFormat = new DecimalFormat("0.0");
	
	
	public Car() {
		setModel("unknown");
	}
	
	public Car(String model, int milesDriven, double gallonsOfGas) {
		setModel(model);
		setMilesDriven(milesDriven);
		setGallonsOfGas(gallonsOfGas);
	}
	
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getMilesDriven() {
		return milesDriven;
	}
	
	public void setMilesDriven(int milesDriven) {
		if (milesDriven > 0)
			this.milesDriven = milesDriven;
		else
			this.milesDriven = 0;
	}
	
	public double getGallonsOfGas() {
		return gallonsOfGas;
	}
	
	public void setGallonsOfGas(double gallonsOfGas) {
		if (gallonsOfGas > 0)
			this.gallonsOfGas = gallonsOfGas;
		else
			this.gallonsOfGas = 0;
	}
	
	
	public double getMilesPerGallon() {
		if (getGallonsOfGas() > .001)
			return getMilesDriven()/getGallonsOfGas();
		return 0.0;
	}
	
	public double getMoneySpentOnGas(double pricePerGallon) {
		return pricePerGallon*getGallonsOfGas();
	}
	

	public boolean equals(Object o) {
		if (!(o instanceof Car))
			return false;
		Car otherCar = (Car) o ;
		return otherCar.getModel().equals(getModel()) && otherCar.getMilesDriven() == getMilesDriven() &&
				otherCar.getGallonsOfGas() == getGallonsOfGas();
	}
	

	public String toString() {
		return "Car:"+getModel()+"\n\tMiles Driven:"+getMilesDriven()+". Gas Used: "+getGallonsOfGas()+
				" Fuel Efficiency: "+decFormat.format(getMilesPerGallon())+" mpg.";
	}
}
