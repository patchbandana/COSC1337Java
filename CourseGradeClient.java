/* CourseGrade Client
   Anderson, Franceschi
*/

public class CourseGradeClient
{
  public static void main( String [] args )
  {
    CourseGrade cg1 = new CourseGrade( "CS1", 'A' );
    CourseGrade cg2 = new CourseGrade( "CS2", 'B' );
    System.out.println( "The course of course grade #1 is " + cg1.getCourseName( ) );
    System.out.println( "The grade of course grade #1 is " + cg1.getGrade( ) );
    System.out.println( "Course Grade #2 is " + cg2.toString( ) );

    if ( cg1.equals( cg2 ) )
      System.out.println( "Original CourseGrade #1 and #2 are identical." );
    else
      System.out.println( "Original CourseGrade #1 and #2 are different." );

    cg2.setCourseName( "CS1" ).setGrade( 'A' );
 
    if ( cg1.equals( cg2 ) )
      System.out.println( "Original CourseGrade #1 and modified CourseGrade #2 are identical." );
    else
      System.out.println( "Original CourseGrade #1 and modified CourseGrade #2 are different." );
      
    System.out.println( "\nSetting CourseGrade #1 grade to 'Z'- an invalid value." );
    cg1.setGrade( 'Z' );
    System.out.println( "The new grade for CourseGrace #1 is " + cg1.getGrade( ) );
  }
}