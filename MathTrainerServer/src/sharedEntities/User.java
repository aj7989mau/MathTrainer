package sharedEntities;

import java.io.Serializable;

/**
 * The user class that is responsible for each new user
 * @author abdulsamisahil
 * @version 1.0
 * @since  2020-03-23
 *
 */
public class User implements Serializable {
    private String userName;
    private int age;
    private String email;
    private String password;
    private String school;
    private String town;


    public User(){

    }

    //To create login for user
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    /**
     * Constructor
     * @param userName name of the user
     * @param age age of the user
     * @param id unique id of the user
     * //@param type is the user a student or a teacher
     */
    public User(String userName, int age, String email, String password, String school, String town, String id)
    {
        this.userName = userName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.school = school;
        this.town = town;
        this.id = id;
    }



    public String getUserName() {
        return userName;
    }

    public String getPassword() { return password; }

    //private UserType userType;
    private String id;
    //private CourseType course;
    //Variables needed for a client to connect to the server will be added later on


    public User(String userName, int age, String id) {
        this.userName = userName;
        this.age = age;
        //  this.userType = type;
        this.id = id;
        //this.course = course;
    }

    /**
     * Each user should know which
     * @param course course he/she follows
     */
    /*public void useCourse(CourseType course){
        this.course = course;
    }

    public String toString() {
        return "User{" +
                "name = '" + userName + '\'' +
                ", age = " + age +
                ", userType = " + userType +
                ", id = '" + id + '\'' +
                ", course = "  + course +
                '}';
    }*/

    //Inner class for User GUI
}
