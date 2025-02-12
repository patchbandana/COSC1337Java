/** Utility class for inputting using Scanner
*   Anderson, Franceschi
*/

import java.util.Scanner;

public class Utility
{
   public static int getInt( String prompt )
   {
      Scanner scan = new Scanner( System.in );
      System.out.println( prompt );
      return scan.nextInt( );  
   }
}