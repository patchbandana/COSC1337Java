/* PCBasedGameClient class
   Anderson, Franceschi
*/

public class PCBasedGameClient
{
  public static void main( String [] args )
  {
    PCBasedGame pcbg1 = new PCBasedGame( "CounterStrike", 256, 3000, 1.8 );
    PCBasedGame pcbg2 = new PCBasedGame( "NFL", 128, 1500, 1.5 );

    System.out.println( pcbg1 );
    System.out.println( pcbg2 );

    pcbg2.setRamMB( 256 );
    pcbg2.setHdMB( 3000 );
    pcbg2.setCpuGhz( 1.8 );

    if ( pcbg1.equals( pcbg2 ) )
      System.out.println( "pcbg1 and pcbg2 are equal" );
    else
      System.out.println( "pcbg1 and pcbg2 are not equal" );

    pcbg2.setDescription( "CounterStrike" );

    if ( pcbg1.equals( pcbg2 ) )
      System.out.println( "pcbg1 and pcbg2 are now equal" );
    else
      System.out.println( "pcbg1 and pcbg2 are still not equal" );
  }
}