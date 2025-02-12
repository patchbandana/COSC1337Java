/* CourseGrade Class
   Anderson, Franceschi
*/

public class CourseGrade
{
  private String courseName;
  private char grade;

  /**
  * Constructor:<BR>
  * Allows client to set beginning values for courseName and grade
  * This constructor takes two parameters<BR>
  * Calls mutator methods to validate new values
  * @param newCourseName the name of the course
  * @param newGrade the grade for the course
  */
  public CourseGrade( String newCourseName, char newGrade )
  {
    setCourseName( newCourseName );
    setGrade( newGrade );
  }

  /** getCourseName method
  * @return the name of the course
  */
  public String getCourseName( )
  {
    return courseName;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of courseName
  * @param courseName the new course name
  * @return a reference to this object
  */
  public CourseGrade setCourseName( String courseName )
  {
    this.courseName = courseName;
    return this;
  }

  /** getGrade method
  * @return the grade
  */
  public char getGrade( )
  {
    return grade;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of grade
  * <B>setGrade</B> assigns 'I' to grade
  * if newGrade is not A, B, C, D, nor F
  * @param grade the new grade
  * @return a reference to this object
  */
  public CourseGrade setGrade( char grade )
  {
    if ( grade == 'A' || grade == 'B' || grade == 'C'
            || grade == 'D' || grade == 'F' )
      this.grade = grade;
    else
      this.grade = 'I';
    
    return this;
  }

  /**
  * @return the name and grade for the course
  */
  public String toString( )
  {
    return( "course name: " + courseName + "; grade: " + grade );
  }

  /**
  * equals method
  * Compares two CourseGrade objects for the same field values
  * @param o another CourseGrade object
  * @return a boolean, true if this object
  * has the same field value as the parameter cg
  */
  public boolean equals( Object o )
  {
    if ( ! ( o instanceof CourseGrade ) )
      return false;
    else
    {
	   CourseGrade cg = (CourseGrade) o;
      return ( courseName.equals( cg.courseName )
                && grade == cg.grade  );
	}
  }
}