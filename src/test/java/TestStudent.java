import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStudent {

    @Test
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
    public void testGetUsernameIfNoAgeGiven() {
        Integer age = null;
        Student student = new Student("Una Healey", age, new DateTime(), "1235");
    }

    @Test
    public void testGetName() {
        Student student = new Student("Una Healey", 23, new DateTime(), "1235");
        assertEquals("Una Healey", student.getName());
    }

    @Test
    public void testSetName() {
        Student student = new Student("Una Healey", 23, new DateTime(), "1235");
        student.setName("Mary Smith");
        assertNotEquals("Una Healey", student.getName());
        assertEquals("Mary Smith", student.getName());
    }

    @Test
    public void testGetAge() {
        Student student = new Student("Una Healey", 23, new DateTime(), "1235");
        assertEquals(23, student.getAge());
    }

    @Test
    public void testSetAge() {
        Student student = new Student("Una Healey", 23, new DateTime(), "1235");
        student.setAge(107);
        assertNotEquals(23, student.getAge());
        assertEquals(107, student.getAge());
    }

    @Test
    public void testGetDOB() {
        DateTime dateOfBirth = new DateTime();
        Student student = new Student("Una Healey", 23, dateOfBirth, "1235");
        assertEquals(dateOfBirth, student.getDob());
    }

    @Test
    public void testSetDOB() {
        DateTime dateOfBirth = new DateTime();
        Student student = new Student("Una Healey", 23, dateOfBirth, "1235");

        DateTime newDOB = new DateTime().withTime(5, 20, 0, 0);
        student.setDob(newDOB);
        assertNotEquals(dateOfBirth, student.getDob());
        assertEquals(newDOB, student.getDob());
    }

    @Test
    public void testGetID() {
        Student student = new Student("Una Healey", 23, new DateTime(), "1235");
        assertEquals("1235", student.getId());
    }

    @Test
    public void testSetID() {
        Student student = new Student("Una Healey", 23, new DateTime(), "1235");
        student.setId("1");
        assertNotEquals("1235", student.getId());
        assertEquals("1", student.getId());
    }

    @Test
    public void testGetModules() {
        Module module1 = new Module("software engineering 3", "CT417");
        Module module2 = new Module("machine learning", "CT4101");
        Module[] modules = {module1, module2};

        DateTime startDate = new DateTime();
        DateTime endDate = new DateTime();
        Course course = new Course("ECE", startDate, endDate);
        Course[] courses = {course};

        Student student = new Student("Una Healey", 23, new DateTime(), "1235", modules, courses);
        assertEquals(modules.length, student.getModules().length);
        Module[] studentModules = student.getModules();
        assertEquals(studentModules[0], module1);
        assertEquals(studentModules[1], module2);
    }

    @Test
    public void testSetModules() {
        Module module1 = new Module("software engineering 3", "CT417");
        Module module2 = new Module("machine learning", "CT4101");
        Module[] modules = {module1, module2};

        DateTime startDate = new DateTime();
        DateTime endDate = new DateTime();
        Course course = new Course("ECE", startDate, endDate);
        Course[] courses = {course};

        Student student = new Student("Una Healey", 23, new DateTime(), "1235", modules, courses);

        Module module3 = new Module("digital signal processing", "EE445");
        Module[] newModules = {module2, module3, module1};
        student.setModules(newModules);
        //check the length was updated
        assertNotEquals(modules.length, student.getModules().length);
        assertEquals(newModules.length, student.getModules().length);
        // check the modules changed order
        Module[] studentModules = student.getModules();
        assertNotEquals(studentModules[0], module1);
        assertEquals(studentModules[0], module2);
        assertNotEquals(studentModules[1], module2);
        assertEquals(studentModules[1], module3);
        assertEquals(studentModules[2], module1);
    }

    @Test
    public void testGetCourses() {
        Module module1 = new Module("software engineering 3", "CT417");
        Module module2 = new Module("machine learning", "CT4101");
        Module[] modules = {module1, module2};

        DateTime startDate = new DateTime();
        DateTime endDate = new DateTime();
        Course course = new Course("ECE", startDate, endDate);
        Course[] courses = {course};

        Student student = new Student("Una Healey", 23, new DateTime(), "1235", modules, courses);

        assertEquals(courses.length, student.getCourses().length);
        Course[] studentCourses = student.getCourses();
        assertEquals(studentCourses[0], course);
    }

    @Test
    public void testSetCourses() {
        Module module1 = new Module("software engineering 3", "CT417");
        Module module2 = new Module("machine learning", "CT4101");
        Module[] modules = {module1, module2};

        DateTime startDate = new DateTime();
        DateTime endDate = new DateTime();
        Course course1 = new Course("ECE", startDate, endDate);
        Course[] courses = {course1};

        Student student = new Student("Una Healey", 23, new DateTime(), "1235", modules, courses);

        Course course2 = new Course("IT",  startDate, endDate);
        Course[] newCourse = {course2};
        student.setCourses(newCourse);

        assertEquals(newCourse.length, student.getCourses().length);
        Course[] studentCourses = student.getCourses();
        assertNotEquals(studentCourses[0], course1);
        assertEquals(studentCourses[0], course2);
    }

}
