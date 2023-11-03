/*Eman Eizenga
 * COSC 1337 001
 * 2023-11-03
 * Purpose: To encapsulate the concept of a GroceryStore (Lab10L2)
 * 
 */
package typesOfStores;

/** Encapsulates a Grocery Store. Inherits from Store.
 * @author eeizenga
 */
public class GroceryStore extends Store{
	/**The annual revenue this store brings in*/
	private double annualRevenue;
	/**Stores whether or not this store is part of a national chain*/
	private boolean isChain;
	
	/**Constructs a new GroceryStore from input data
	 * @param name the name of the store
	 * @param address the address of the store
	 * @param annualRevenue the annual revenue this store brings in
	 * @param isChain true iff the store should be part of a national chain
	 */
	public GroceryStore(String name, String address, double annualRevenue, boolean isChain) {
		super(name, address);
		setAnnualRevenue(annualRevenue);
		setChain(isChain);
	}

	/**Gets the annual revenue for this store
	 * @return the annualRevenue
	 */
	public double getAnnualRevenue() {
		return annualRevenue;
	}

	/**Sets the annual revenue for this store
	 * @param annualRevenue the annualRevenue to set
	 */
	public void setAnnualRevenue(double annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	/**
	 * @return the isChain
	 */
	public boolean isChain() {
		return isChain;
	}

	/**
	 * @param isChain the isChain to set
	 */
	public void setChain(boolean isChain) {
		this.isChain = isChain;
	}
}