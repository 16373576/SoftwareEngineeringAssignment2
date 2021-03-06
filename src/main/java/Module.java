public class Module {
    private String name;
    private String id;
    private Student[] students;
    private Course[] courses;

    public Module(String name, String id, Student[] students, Course[] courses) {
        this.name = name;
        this.id = id;
        this.students = students;
        this.courses = courses;
    }

    //create constructor without students
    public Module(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }
}
