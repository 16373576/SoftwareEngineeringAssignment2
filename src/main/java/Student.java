import org.joda.time.DateTime;

public class Student {

    private String name;
    private int age;
    private DateTime dob;
    private String id;
    private String username;
    private Course[] courses;
    private Module[] modules;

    public Student(String name, int age, DateTime dateOfBirth, String id, Module[] modules, Course[] courses){
        this.name = name;
        this.age = age;
        this.dob = dateOfBirth;
        this.id = id;
        this.modules = modules;
        this.courses = courses;
    }

    // need second constructor with no modules and courses given
    public Student(String name, int age, DateTime dateOfBirth, String id){
        this.name = name;
        this.age = age;
        this.dob = dateOfBirth;
        this.id = id;
    }

    public String getUsername(){
        username = this.name + this.age;
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DateTime getDob() {
        return dob;
    }

    public void setDob(DateTime dob) {
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Module[] getModules(){
        return modules;
    }

    public void setModules(Module[] modules){
        this.modules = modules;
    }

    public Course[] getCourses(){
        return courses;
    }

    public void setCourses(Course[] courses){
        this.courses = courses;
    }
}

