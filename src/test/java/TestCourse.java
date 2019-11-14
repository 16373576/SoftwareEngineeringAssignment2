import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCourse {
    DateTime startDate = new DateTime().withTime(5, 20, 0, 0);
    DateTime endDate = new DateTime().withTime(10, 20, 0, 0);

    @Test
    public void testGetName() {
        Course course = new Course("ECE", startDate, endDate);
        assertEquals("ECE", course.getName());
    }

    @Test
    public void testSetName() {
        Course course = new Course("ECE", startDate, endDate);
        course.setName("CS and IT");
        assertNotEquals("ECE", course.getName());
        assertEquals("CS and IT", course.getName());
    }

    @Test
    public void testGetStartDate() {
        Course course = new Course("ECE", startDate, endDate);
        assertEquals(startDate, course.getStartDate());
    }

    @Test
    public void testSetStartDate() {
        Course course = new Course("ECE", startDate, endDate);

        DateTime newStart = new DateTime();
        course.setStartDate(newStart);
        assertNotEquals(startDate, course.getStartDate());
        assertEquals(newStart, course.getStartDate());
    }

    @Test
    public void testGetEndDate() {
        Course course = new Course("ECE", startDate, endDate);
        assertEquals(endDate, course.getEndDate());
    }

    @Test
    public void testSetEndDate() {
        Course course = new Course("ECE", startDate, endDate);

        DateTime newEnd = new DateTime();
        course.setEndDate(newEnd);
        assertNotEquals(endDate, course.getEndDate());
        assertEquals(newEnd, course.getEndDate());
    }

    @Test
    public void testGetStudents() {
        Student student1 = new Student("Una Healey", 23, new DateTime(), "1235");
        Student student2 = new Student("Mary Smith", 17, new DateTime(), "1236");
        Student[] students = {student1, student2};

        Module module1 = new Module("software engineering 3", "CT417");
        Module module2 = new Module("machine learning", "CT4101");
        Module[] modules = {module1, module2};

        Course course = new Course("ECE", modules, students, startDate, endDate);

        assertEquals(students.length, course.getStudents().length);
        Student[] courseStudents = course.getStudents();
        assertEquals(courseStudents[0], student1);
        assertEquals(courseStudents[1], student2);
    }

    @Test
    public void testSetStudents() {
        Student student1 = new Student("Una Healey", 23, new DateTime(), "1235");
        Student student2 = new Student("Mary Smith", 17, new DateTime(), "1236");
        Student[] students = {student1, student2};

        Module module1 = new Module("software engineering 3", "CT417");
        Module module2 = new Module("machine learning", "CT4101");
        Module[] modules = {module1, module2};

        Course course = new Course("ECE", modules, students, startDate, endDate);

        Student student3 = new Student("Tom Jones", 47, new DateTime(), "1237");
        Student[] newStudents = {student2, student3, student1};
        course.setStudents(newStudents);

        assertNotEquals(students.length, course.getStudents().length);
        assertEquals(newStudents.length,course.getStudents().length);

        Student[] courseStudents = course.getStudents();
        assertNotEquals(courseStudents[0], student1);
        assertEquals(courseStudents[0], student2);
        assertNotEquals(courseStudents[1], student2);
        assertEquals(courseStudents[1], student3);
        assertEquals(courseStudents[2], student1);
    }

    @Test
    public void testGetModules() {
        Student student1 = new Student("Una Healey", 23, new DateTime(), "1235");
        Student student2 = new Student("Mary Smith", 17, new DateTime(), "1236");
        Student[] students = {student1, student2};

        Module module1 = new Module("software engineering 3", "CT417");
        Module module2 = new Module("machine learning", "CT4101");
        Module[] modules = {module1, module2};

        Course course = new Course("ECE", modules, students, startDate, endDate);
        assertEquals(modules.length, course.getModules().length);
        Module[] courseModules = course.getModules();
        assertEquals(courseModules[0], module1);
        assertEquals(courseModules[1], module2);
    }

    @Test
    public void testSetModules() {
        Student student1 = new Student("Una Healey", 23, new DateTime(), "1235");
        Student student2 = new Student("Mary Smith", 17, new DateTime(), "1236");
        Student[] students = {student1, student2};

        Module module1 = new Module("software engineering 3", "CT417");
        Module module2 = new Module("machine learning", "CT4101");
        Module[] modules = {module1, module2};

        Course course = new Course("ECE", modules, students, startDate, endDate);

        Module module3 = new Module("digital signal processing", "EE445");
        Module[] newModules = {module2, module3, module1};
        course.setModules(newModules);
        //check the length was updated
        assertNotEquals(modules.length, course.getModules().length);
        assertEquals(newModules.length, course.getModules().length);
        // check the modules changed order
        Module[] courseModules = course.getModules();
        assertNotEquals(courseModules[0], module1);
        assertEquals(courseModules[0], module2);
        assertNotEquals(courseModules[1], module2);
        assertEquals(courseModules[1], module3);
        assertEquals(courseModules[2], module1);
    }
}
