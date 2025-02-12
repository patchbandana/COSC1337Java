/* TVSet Client
   Anderson, Franceschi
*/

public class TVSetClient
{
  public static void main( String [] args )
  {
    TVSet tvs1 = new TVSet( "Sony", 1249.99 );
    TVSet tvs2 = new TVSet( "RCA", 999.99 );
    System.out.println( "The brand of TV set #1 is " + tvs1.getBrand( ) );
    System.out.println( "The price of TV set #1 is " + tvs1.getPrice( ) );
    System.out.println( "TV set #2 is " + tvs2.toString( ) );

    if ( tvs1.equals( tvs2 ) )
      System.out.println( "Original TV sets #1 and #2 are identical." );
    else
      System.out.println( "Original TV sets #1 and #2 are different." );

    System.out.println( "\nSetting TV set #2's brand to Sony and price to $1249.99." );
    tvs2.setBrand( "Sony" ).setPrice( 1249.99 );

    if ( tvs1.equals( tvs2 ) )
      System.out.println( "Original TV set #1 and modified TV set #2 are identical." );
    else
      System.out.println( "Original TV set #1 and modified TV set #2 are different." );
  }
}