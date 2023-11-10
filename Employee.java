/*Eman Eizenga
 *COSC 1337 001
 *2023-11-08
 * Purpose: To encapsulate information about an Employee (Lab 10L3)
 */
package employeeSystem;

/**Encapsulates Employee information
 * @author emane
 * 
 */
public class Employee {
	/**The Employee's first name*/
	protected String firstName;
	/**The Employee's last name*/
	protected String lastName;
	/**The Employee's eid*/
	protected String eid;
	
	/**Creates a new Employee with input data
	 * @param firstName the firstName of the new Employee
	 * @param lastName the lastName of the new Employee
	 * @param eid the ID of the new Employee
	 */
	public Employee(String firstName, String lastName, String eid) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setEid(eid);
	}

	/**Gets the first name of the Employee
	 * @return the firstName of the Employee
	 */
	public String getFirstName() {
		return firstName;
	}

	/**Sets the first name of the Employee
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**Gets the last name of the Employee
	 * @return the lastName of the Employee
	 */
	public String getLastName() {
		return lastName;
	}

	/**Sets the last name of the Employee
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**Sets the ID of the Employee
	 * @return the eid
	 */
	public String getEid() {
		return eid;
	}

	/**Sets the ID of the Employee
	 * @param eid the eid to set
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}
	
	/**Return true iff the data in o is equal to this Employee
	 * @param o the object to compare this Employee to
	 * @return true iff the data in o is equal to this Employee
	 */
	@Override
	public boolean equals(Object o) {
		return toString().equals(o.toString());
	}

	/**Returns a String version of this Employee
	 * @return a string representation of the Employee object
	 */
	@Override
	public String toString() {
		return "Employee: " + getFirstName() + " " + getLastName() +
				"\nEmployee ID: " + getEid();
	}
	
}