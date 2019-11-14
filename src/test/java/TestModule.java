import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestModule {
    @Test
    public void testGetNameIfNameGiven() {
        Module module = new Module("software engineering 3", "CT417");
        assertEquals("software engineering 3", module.getName());
    }

    @Test
    public void testGetNameIfNoNameGiven() {
        Module module = new Module("", "CT417");
        assertEquals("", module.getName());
    }

    @Test
    public void testSetName() {
        Module module = new Module("software engineering 3", "CT417");
        module.setName("machine learning");
        assertNotEquals("software engineering 3", module.getName());
        assertEquals("machine learning", module.getName());
    }

    @Test
    public void testGetIdIfIdGiven() {
        Module module = new Module("software engineering 3", "CT417");
        assertEquals("CT417", module.getId());
    }

    @Test
    public void testGetIdIfNoIdGiven() {
        Module module = new Module("software engineering 3", "");
        assertEquals("", module.getId());
    }

    @Test
    public void testSetId() {
        Module module = new Module("software engineering 3", "CT417");
        module.setId("CT4101");
        assertNotEquals("CT417", module.getId());
        assertEquals("CT4101", module.getId());
    }

    @Test
    public void testGetStudents() {
        Student student1 = new Student("Una Healey", 23, new DateTime(), "1235");
        Student student2 = new Student("Mary Smith", 17, new DateTime(), "1236");
        Student[] students = {student1, student2};

        DateTime startDate = new DateTime();
        DateTime endDate = new DateTime();
        Course course = new Course("ECE", startDate, endDate);
        Course[] courses = {course};

        Module module = new Module("software engineering 3", "CT417", students, courses);
        assertEquals(students.length, module.getStudents().length);
        Student[] moduleStudents = module.getStudents();
        assertEquals(moduleStudents[0], student1);
        assertEquals(moduleStudents[1], student2);
    }

    @Test
    public void testSetStudents() {
        Student student1 = new Student("Una Healey", 23, new DateTime(), "1235");
        Student student2 = new Student("Mary Smith", 17, new DateTime(), "1236");
        Student[] students = {student1, student2};

        DateTime startDate = new DateTime();
        DateTime endDate = new DateTime();
        Course course = new Course("ECE", startDate, endDate);
        Course[] courses = {course};

        Module module = new Module("software engineering 3", "CT417", students, courses);

        Student student3 = new Student("Tom Jones", 47, new DateTime(), "1237");
        Student[] newStudents = {student2, student3, student1};
        module.setStudents(newStudents);

        assertNotEquals(students.length, module.getStudents().length);
        assertEquals(newStudents.length, module.getStudents().length);

        Student[] moduleStudents = module.getStudents();
        assertNotEquals(moduleStudents[0], student1);
        assertEquals(moduleStudents[0], student2);
        assertNotEquals(moduleStudents[1], student2);
        assertEquals(moduleStudents[1], student3);
        assertEquals(moduleStudents[2], student1);
    }

    @Test
    public void testSetCourses() {
        Student student1 = new Student("Una Healey", 23, new DateTime(), "1235");
        Student student2 = new Student("Mary Smith", 17, new DateTime(), "1236");
        Student[] students = {student1, student2};

        DateTime startDate = new DateTime();
        DateTime endDate = new DateTime();
        Course course1 = new Course("ECE", startDate, endDate);
        Course[] courses = {course1};

        Module module = new Module("software engineering 3", "CT417", students, courses);

        Course course2 = new Course("CS and IT", startDate, endDate);
        Course course3 = new Course("Civil Law", startDate, endDate);
        Course[] newCourses = {course2, course3, course1};
        module.setCourses(newCourses);

        assertNotEquals(courses.length, module.getCourses().length);
        assertEquals(newCourses.length, module.getCourses().length);

        Course[] moduleCourses = module.getCourses();
        assertNotEquals(moduleCourses[0], course1);
        assertEquals(moduleCourses[0], course2);
        assertEquals(moduleCourses[1], course3);
        assertEquals(moduleCourses[2], course1);
    }

}
