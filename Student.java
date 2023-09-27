/* Eman Eizenga
 * COSC 1337 001
 * 2023-09-20
 * Purpose: To encapsulate information about a Student (Lab6L1)
 * Insight: Using get___() over just the variable name allows us
 * to use our modification of the data rather than just the raw data.
 * For instance, we might force a name to start with a capital letter.
 */
package lab6l1;

public class Student {
	//Fields
	private String name = "";
	private String sid = "";
	private double gpa = -1;
	private int numberOfHours = -1;

	//Static Initializers - none

	//Constructors
	public Student(String name, String sid, double gpa, int numberOfHours) {
		setName(name);
		setSID(sid);
		setGPA(gpa);
		setNumberOfHours(numberOfHours);
	}

	//Methods - Getters and Setters
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSID()
	{
		return sid;
	}

	public void setSID(String sid)
	{
		if (sid.charAt(0) != '0' && sid.charAt(0) != ' ')
			this.sid = sid;
	}

	public double getGPA()
	{
		return gpa;
	}

	public void setGPA(double gpa)
	{
		if (gpa >= 0.0 && gpa <= 4.0)
			this.gpa = gpa;
	}

	public int getNumberOfHours()
	{
		return numberOfHours;
	}

	public void setNumberOfHours(int numberOfHours)
	{
		if (numberOfHours >= 0)
			this.numberOfHours = numberOfHours;
	}

	//Methods - Data Manipulation Methods - none

	//Methods - Overridden Methods
	public String toString()
	{
		return "Student Name: " + getName() + "\n\tStudent ID: " + 
				(getSID().equals("")?"Not set":getSID()) +
				" GPA: " +(getGPA()<0.0?"Not set":getGPA()) +
				" Number of Hours: " + 
				(getNumberOfHours()<0?"Not set":getNumberOfHours());
	}
}