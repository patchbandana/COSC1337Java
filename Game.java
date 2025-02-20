/* Game Class
   Anderson, Franceschi
*/

public class Game
{
  private String description;

  /**
  * Constructor:<BR>
  * Allows client to set beginning value for description
  * This constructor takes one parameter<BR>
  * Calls mutator methods
  * @param description the description of the game
  */
  public Game( String description )
  {
    setDescription( description );
  }

  /** getDescription method
  * @return a String, the description of the game
  */
  public String getDescription( )
  {
    return description;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of description
  * @param description the new description for the game
  */
  public void setDescription( String description )
  {
    this.description = description;
  }

  /**
  * @return a string representation of the game
  */
  public String toString( )
  {
    return( "description: " + description );
  }

  /**
  * equals method
  * Compares two Game objects for the same field value
  * @param o another Game object
  * @return a boolean, true if this object
  * has the same field value as the parameter g
  */
  public boolean equals( Object o )
  {
	if ( ! ( o instanceof Game ) )
	   return false;
	else
	{
		Game g = (Game) o;
        return ( description.equals( g.description ) );
	}
  }
}