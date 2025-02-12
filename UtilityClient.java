/** UtilityClient - client for Utility class
*   Anderson, Franceschi
*/

public class UtilityClient
{
  public static void main( String [] args )
  {
     int pets = Utility.getInt( "How many pets do you have?" );
     System.out.println( "You have " + pets + " pets." ); 
  }
}