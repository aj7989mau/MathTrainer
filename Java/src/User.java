/**
 * The user class
 * @author abdulsamisahil
 * @version 1.0
 * @since  2020-03-23
 *
 */
public class User {
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    private UserType userType;
    private String id;
    private CourseType course;
    //Variables needed for a client to connect to the server will be added later on

    /**
     * Constructor
     * @param name name of the user
     * @param age age of the user
     * @param id unique id of the user
     * //@param type is the user a student or a teacher
     */
    public User(String name, int age, String id) {
        this.name = name;
        this.age = age;
        //  this.userType = type;
        this.id = id;
        //this.course = course;
    }

    /**
     * Each user should know which
     * @param course course he/she follows
     */
    public void useCourse(CourseType course){
        this.course = course;
    }

    public String toString() {
        return "User{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", userType = " + userType +
                ", id = '" + id + '\'' +
                ", course = "  + course +
                '}';
    }

    //Inner class for User GUI
}
