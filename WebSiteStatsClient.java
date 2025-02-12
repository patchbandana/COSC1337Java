/* WebSiteStats Client
   Anderson, Franceschi
*/

public class WebSiteStatsClient
{
  public static void main( String [] args )
  {
    WebSiteStats wss1 = new WebSiteStats( 12804, "government" );
    WebSiteStats wss2 = new WebSiteStats( 45009, "commercial" );
    System.out.println( "The visitors of web site stats #1 is " + wss1.getVisitors( ) );
    System.out.println( "The type of web site stats #1 is " + wss1.getType( ) );
    System.out.println( "Web Site Stats #2 is " + wss2.toString( ) );

    if ( wss1.equals( wss2 ) )
      System.out.println( "Original web site stats #1 and #2 are identical" );
    else
      System.out.println( "Original web site stats #1 and #2 are different" );

    wss2.setVisitors( 12804 ).setType( "government" );
 
    if ( wss1.equals( wss2 ) )
      System.out.println( "Original web site stats #1 and modified web site stats #2 are identical" );
    else
      System.out.println( "Original web site stats #1 and modified web site stats #2 are different" );

  }
}