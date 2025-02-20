/* PCBasedGame Class
   Anderson, Franceschi
*/

public class PCBasedGame extends Game
{
  private int ramMB;
  private int hdMB;
  private double cpuGhz;

  /**
  * Constructor:<BR>
  * Allows client to set beginning value for ramMB, hdMB and cpuGhz
  * This constructor takes four parameters<BR>
  * Calls super constructor
  * Calls mutator methods
  * @param description the new description for the game
  * @param ramMB the minimum number of megabytes of RAM to play the game
  * @param hdMB the minimum number of megabytes needed on the hard disk to install the game
  * @param cpuGhz the minimum CPU performance in Ghz needed to play the game
  */
  public PCBasedGame( String description, int ramMB, int hdMB, 
                                     double cpuGhz )
  {
    super( description );
    setRamMB( ramMB );
    setHdMB( hdMB );
    setCpuGhz( cpuGhz );
  }

  /** getRamMB method
  * @return an int, the number of megabytes of RAM needed to play the game
  */
  public int getRamMB( )
  {
    return ramMB;
  }

  /** getHdMB method
  * @return an int, the number of megabytes needed on the hard disk to install the game
  */
  public int getHdMB( )
  {
    return hdMB;
  }

  /** getCpuGhz method
  * @return a double, the minimum CPU performance in Ghz needed to play the game
  */
  public double getCpuGhz( )
  {
    return cpuGhz;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of ramMB
  * @param ramMB the new number of megabytes of RAM needed to play the game
  *        if ramMB is negative, ramMB is not changed
  */
  public void setRamMB( int ramMB )
  {
    if ( ramMB  >= 0 )
      this.ramMB = ramMB;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of hdMB
  * @param newHdMB the new number of megabytes needed on the hard disk to install the game
  *        if hdMB is negative, hdMB is not changed
  */
  public void setHdMB( int hdMB )
  {
    if ( hdMB >= 0 )
      this.hdMB = hdMB;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of cpuGhz
  * @param newCpuGhz the new minimum CPU performance in Ghz needed to play the game
  *        if cpuGhz is negative, cpuGhz is not changed
  */
  public void setCpuGhz( double cpuGhz )
  {
    if ( cpuGhz >= 0 )
      this.cpuGhz = cpuGhz;
  }

  /**
  * @return a string representation of the pc based game
  */
  public String toString( )
  {
    return( super.toString( ) + "\nMinimum configuration: RAM: " + ramMB + " MB; hard disk: "
                    + hdMB + " MB; CPU: " + cpuGhz + " Ghz" );
  }

  /**
  * equals method
  * Compares two PCBasedGame objects for the same field value
  * @param  o another PCBasedGame object
  * @return a boolean, true if this object
  * has the same field values as the parameter pcbg
  */
  public boolean equals( Object o )
  {
	if ( ! ( o instanceof PCBasedGame ) )
	   return false;
	else
	{
	   PCBasedGame pcbg = (PCBasedGame) o;
       return ( super.equals( pcbg )
            && ramMB == pcbg.ramMB && hdMB == pcbg.hdMB
            && Math.abs( cpuGhz - pcbg.cpuGhz ) < 0.0001 );
 	}
  }
}