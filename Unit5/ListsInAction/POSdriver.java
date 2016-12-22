import java.io.IOException;
import java.util.Iterator;
import java.util.Collections;

/**
 * Demonstrates the use of a list to manage a set of objects.
 * 
 * @author Murray Butler
 * @version 1.0
 */
public class POSdriver
{
	/**
	 * Creates and populates a Program of Study. Then saves it using serialization.
	 */
	public static void main(String[] args) throws IOException
	{
		ProgramOfStudy pos = new ProgramOfStudy();
	
    // Add courses
		pos.addCourse(new Course("CS", 101, "Introduction to Programming", "A-"));
		pos.addCourse(new Course("ARCH", 305, "Building Analysis", "A"));
		pos.addCourse(new Course("GER", 210, "Intermediate German"));
		pos.addCourse(new Course("CS", 320, "Computer Architecture"));
		pos.addCourse(new Course("THE", 201, "The Theatre Experience"));

    // Added size to POS, may as well see it
    System.out.println("List: " + pos.size());

    Course cs1 = pos.find("CS", 101);
		Course arch = pos.find("CS", 320);
		pos.addCourseAfter(arch, new Course("CS", 321, "Operating Systems"));
		
		Course theatre = pos.find("THE", 201);
		theatre.setGrade("A-");
		
		Course german = pos.find("GER", 210);
		pos.replace(german, new Course("FRE", 110, "Beginning French", "B+"));

    // sort ascending
    pos.sortForward();
    System.out.println(pos);

    // sort descending
    pos.sortReverse();
    System.out.println(pos);

    pos.save("ProgramOfStudy.txt");		
	}

}
