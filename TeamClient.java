/* Team Client
   Anderson, Franceschi
*/

public class TeamClient
{
  public static void main( String [] args )
  {
    Team t1 = new Team( "Orioles" );
    Team t2 = new Team( "Yankees" );
    System.out.println( "The name of team #1 is " + t1.getName( ) );
    System.out.println( "Team #2: " + t2.toString( ) );

    if ( t1.equals( t2 ) )
      System.out.println( "Original teams #1 and #2 are identical." );
    else
      System.out.println( "Original teams #1 and #2 are different." );

    System.out.println( "\nSetting team #2 name to Orioles." );
    t2.setName( "Orioles" );

    if ( t1.equals( t2 ) )
      System.out.println( "Original team #1 and modified team #2 are identical." );
    else
      System.out.println( "Original team #1 and modified team #2 are different." );

  }
}