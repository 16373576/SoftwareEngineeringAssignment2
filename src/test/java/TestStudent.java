import org.joda.time.DateTime;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestStudent {
    Module module1= new Module("software engineering 3",  "CT417");
    Module module2= new Module("machine learning",  "CT4101");
    Module[] modules = new Module[2];

    @Test(expected = NullPointerException.class)
    public void testGetUsernameIfOnlyFirstNameGiven() {
        Student student = new Student("Bob", 21, new DateTime(), "1234");
        assertEquals("Bob21", student.getUsername());
    }

    @Test
    public void testGetUsernameIfFirstAndSecondNameGiven() {
        Student student = new Student("Mary Smith", 17, new DateTime(), "1236");
        assertEquals("Mary Smith17", student.getUsername());
    }

    @Test
    public void testGetUsernameIfNoNameGiven() {
        Student student = new Student("", 23, new DateTime(), "1235");
        assertEquals("23", student.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testGetUsernameIfNoAgeGiven(){
        Integer age = null;
        Student student = new Student("Una Healey", age, new DateTime(), "1235");
    }

    @Test
    public void testGetID() {

    }

}
