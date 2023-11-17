/*Eman Eizenga
 * COSC 1337 001
 * 2023-11-10
 * Purpose: To encapsulate an HourlyEmployee based on Employee (Lab10L4)
 */
package employeeSystem;

/**To encapsulate an Employee whom is paid by the Hour.
 * @author emane
 */
public class HourlyEmployee extends Employee {
	/**The Employee's hours this period*/
	protected double hours;
	/**The Employee's pay per hour*/
	protected double wage;
	
	/**Creates a new HourlyEmployee based on the incoming data
	 * @param firstName The first name of the Employee
	 * @param lastName The last name of the Employee
	 * @param eid The ID of the Employee
	 * @param wage The wage of the Employee
	 */
	public HourlyEmployee(String firstName, String lastName, String eid, double wage) {
		super(firstName, lastName, eid);
		setWage(wage);
		setHours(0);
		
	}

	/**Gets the hours of this Employee
	 * @return the hours of this Employee
	 */
	public double getHours() {
		return hours;
	}

	/**Sets the hours of this Employee iff >= 0
	 * @param hours the hours to set
	 */
	public void setHours(double hours) {
		if (hours >= 0)
		this.hours = hours;
	}

	/**Gets the wage of this Employee
	 * @return the wage of the HourlyEmployee
	 */
	public double getWage() {
		return wage;
	}

	/**Sets the wage of this Employee iff >= 0
	 * @param wage the wage to set
	 */
	public void setWage(double wage) {
		if (wage >= 0)
		this.wage = wage;
	}
	
	/**Returns the earnings for this period for this Employee
	 * 
	 * @return the earnings for this period for this Employee
	 */
		public double getEarnings()
		{
			return getWage() * getHours();
		}

	/**Returns a String version of the HourlyEmployee
	 * 
	 * @return a String representation of the HourlyEmployee
	 */
	@Override
	public String toString() {
		return "Hourly " + super.toString() + "\nWage: "
				+ MONEY.format(getWage());
	}
}
