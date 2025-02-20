/* BoardGameClient class
   Anderson, Franceschi
*/

public class BoardGameClient
{
  public static void main( String [] args )
  {
    BoardGame bg1 = new BoardGame( "Scrabble", 2, true );
    BoardGame bg2 = new BoardGame( "Chess", 2, true );

    System.out.println( bg1 );
    System.out.println( bg2 );

    if ( bg1.equals( bg2 ) )
      System.out.println( "bg1 and bg2 are equal" );
    else
      System.out.println( "bg1 and bg2 are not equal" );

    bg2.setDescription( "Scrabble" );

    if ( bg1.equals( bg2 ) )
      System.out.println( "bg1 and bg2 are now equal" );
    else
      System.out.println( "bg1 and bg2 are still not equal" );
  }
}