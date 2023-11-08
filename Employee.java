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

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * @param eid the eid to set
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}
}