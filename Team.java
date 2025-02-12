/* Team Class
   Anderson, Franceschi
*/

public class Team
{
  private String name;

  /**
  * Constructor:<BR>
  * Allows client to set beginning value for name
  * This constructor takes one parameter<BR>
  * Calls mutator method to validate new value
  * @param newName the name of the team
  */
  public Team( String newName )
  {
    setName( newName );
  }

  /** getName method
  * @return the name
  */
  public String getName( )
  {
    return name;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of name
  * @param name the new name
  * @return a reference to this object
  */
  public Team setName( String name )
  {
    this.name = name;
    return this;
  }

  /**
  * @return the name of the team
  */
  public String toString( )
  {
    return( "name: " + name );
  }

  /**
  * equals method
  * Compares two Team objects for the same field value
  * @param o another Team object
  * @return a boolean, true if this object
  * has the same field value as the parameter t
  */
  public boolean equals( Object o )
  {
	if ( ! ( o instanceof Team ) )
	   return false;
	else
	{
		Team t = (Team) o;
      return ( name.equals( t.name ) );
	}
  }
}