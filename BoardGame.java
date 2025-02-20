/* BoardGame Class
   Anderson, Franceschi
*/

public class BoardGame extends Game
{
  private int numberOfPlayers;
  private boolean canTie;

  /**
  * Constructor:<BR>
  * Allows client to set beginning value for numberOfPlayers, canTie and cpuGhz
  * This constructor takes three parameters<BR>
  * Calls super constructor
  * Calls mutator methods
  * @param description the new description for the game
  * @param numberOfPlayers the number of players
  * @param canTie whether the game can end in a tie
  */
  public BoardGame( String description, int numberOfPlayers, boolean canTie )
  {
    super( description );
    setNumberOfPlayers( numberOfPlayers );
    setCanTie( canTie );
  }

  /** getNumberOfPlayers method
  * @return an int, the number of players
  */
  public int getNumberOfPlayers( )
  {
    return numberOfPlayers;
  }

  /** getCanTie method
  * @return true if the game can end in a tie, false otherwise
  */
  public boolean getCanTie( )
  {
    return canTie;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of numberOfPlayers
  * @param numberOfPlayers the new number of players
  *        if newNumberOfPlayers is negative, numberOfPlayers is not changed
  */
  public void setNumberOfPlayers( int numberOfPlayers )
  {
    if ( numberOfPlayers  >= 0 )
      this.numberOfPlayers = numberOfPlayers;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of canTie
  * @param canTie the new value of whether the game can end in a tie
  */
  public void setCanTie( boolean canTie )
  {
    this.canTie = canTie;
  }

  /**
  * @return a string representation of the board game
  */
  public String toString( )
  {
    return( super.toString( ) + ": Number of players: " + numberOfPlayers
                              + "; Can end in a tie: " + canTie );
  }

  /**
  * equals method
  * Compares two BoardGame objects for the same field value
  * @param  o another BoardGameobject
  * @return a boolean, true if this object
  * has the same field values as the parameter bg
  */
  public boolean equals( Object o )
  {
    if ( ! ( o instanceof BoardGame ) )
      return false;
    else
    {
	   BoardGame bg = (BoardGame) o;
      return ( super.equals( bg )
             && numberOfPlayers == bg.numberOfPlayers
             && canTie == bg.canTie );
	}
  }
}