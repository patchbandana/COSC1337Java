/* Course Class
   Anderson, Franceschi
*/

public class Course
{
  private String code;
  private String description;
  private int credits;

  /**
  * Constructor:<BR>
  * Allows client to set beginning values for code,
  *   description, and credits
  * This constructor takes three parameters<BR>
  * Calls mutator methods to validate new values
  * @param newCode the code of the course
  * @param newDescription the description of the course
  * @param newCredits the credits of the course
  */
  public Course( String newCode, String newDescription, int newCredits )
  {
    setCode( newCode );
    setDescription( newDescription );
    setCredits( newCredits );
  }

  /** getCode method
  * @return the code
  */
  public String getCode( )
  {
    return code;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of code
  * @param newCode the code
  */
  public void setCode( String newCode )
  {
    code = newCode;
  }

  /** getDescription method
  * @return the description
  */
  public String getDescription( )
  {
    return description;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of description
  * @param newDescription the new description
  */
  public void setDescription( String newDescription )
  {
    description = newDescription;
  }

  /** getCredits method
  * @return the number of credits
  */
  public int getCredits( )
  {
    return credits;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of credits
  * <B>setCredits</B> sets the value of <B>credits</B>
  *  to 1 if newCredits does not have positive value
  * @param newcredits the new number of credits
  */
  public void setCredits( int newCredits )
  {
    if ( newCredits > 0 )
      credits = newCredits;
    else
    {
      credits = 1;
      System.err.println( "Credits cannot be negative or equal to 0." );
      System.err.println( "Credits set to 1." );
    }
  }

  /**
  * @return the code, description, and credits for the course
  */
  public String toString( )
  {
    return( "code: " + code + "; description: " + description
          + "; credits: " + credits );
  }

  /**
  * equals method
  * Compares two Course objects for the same field values
  * @param o another Course object
  * @return a boolean, true if this object
  * has the same field values as the parameter c
  */
  public boolean equals( Object o )
  {
	if ( ! ( o instanceof Course ) )
	   return false;
	else
	{
	   Course c = (Course) o;
       return ( code.equals( c.code )
                && description.equals( c.description )
                && credits == c.credits );
     }
  }
}