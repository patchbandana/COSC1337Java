/*Eman Eizenga
 * COSC 1337 001
 * 2023-10-11
 * Purpose: To encapsulate a salaried employee based on Employee (Lab 10L3)
 */
package employeeSystem;

/**This encapsulates information about an Employee that is paid the same
 * every pay period.
 * @author emane
 */
public class SalariedEmployee extends Employee {
	/**The Employee's salary*/
	protected double salary;

	/**Creates a new SalariedEmployee based on incoming data
	 * @param firstName the first name of the Employee
	 * @param lastName the last name of the Employee
	 * @param eid the id of the Employee
	 * @param salary the salary of the Employee
	 */
	public SalariedEmployee(String firstName, String lastName, String eid,
			double salary) {
		super(firstName, lastName, eid);
		setSalary(salary);
	}

	/**Gets the salary of the SalariedEmployee
	 * @return the salary of this Employee
	 */
	public double getSalary() {
		return salary;
	}

	/**Sets the salary of the Employee if salary >= 0
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		if (salary >= 0)
			this.salary = salary;
	}

	/**Returns the earnings for this period for this Employee
	 * 
	 * @return the earnings for this period for this Employee
	 */
	public double getEarnings()
	{
		return getSalary();
	}

	/**Returns a string version of the SalariedEmployee
	 * @return a string representation of SalariedEmployee
	 */
	@Override
	public String toString() {
		return "Salaried " + super.toString() + "\nSalary: " + MONEY.format(getSalary());
	}	
}
