/* Course Client
   Anderson, Franceschi
*/

public class CourseClient
{
  public static void main( String [] args )
  {
    Course c1 = new Course( "CS1", "Intro to Computer Science", 4 );
    Course c2 = new Course( "CS2", "Intro to Data Structures", 3 );
    System.out.println( "The code of course # 1 is " + c1.getCode( ) );
    System.out.println( "The description of course # 1 is " + c1.getDescription( ) );
    System.out.println( "The number of credits of course # 1 is " + c1.getCredits( ) );
    System.out.println( "Course # 2 is " + c2.toString( ) );

    if ( c1.equals( c2 ) )
      System.out.println( "Original courses #1 and #2 are identical" );
    else
      System.out.println( "Original courses #1 and #2 are different" );

    c2.setCode( "CS1" );
    c2.setDescription( "Intro to Computer Science" );
    c2.setCredits( 4 );

    if ( c1.equals( c2 ) )
      System.out.println( "Original course #1 and modified course #2 are identical" );
    else
      System.out.println( "Original course #1 and modified course #2 are different" );

  }
}