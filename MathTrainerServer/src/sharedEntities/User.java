package sharedEntities;

import java.io.Serializable;

/**
 * The user class that is responsible for each new user
 * @author abdulsamisahil
 * @version 1.5
 * @since  2020-05-27
 *
 */
public class User implements Serializable {
    private String userName;
    private int age;
    private String email;
    private String password;
    private String school;
    private String town;
    private int[] results = new int[]{0,0,0,0};
    private String id;


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

    public void setResults(int[] results){ this.results = results; }

    public int[] getResults(){ return results;}

    public String getPassword() { return password; }


    public User(String userName, int age, String id) {
        this.userName = userName;
        this.age = age;
        this.id = id;
    }

    public String toString() {
        return "Accessing User {" +
                "name = '" + userName + '\'' +
                ", password = " + password +
                '}';
    }
}
