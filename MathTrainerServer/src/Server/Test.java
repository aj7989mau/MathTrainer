package Server;

import sharedEntities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is made for purpose small tests of the project
 * after every development iteration.
 * @author abdulsamisahil
 */
public class Test {
    private User user;
    private ArrayList<User> usersList;
    private String fileLocation;
    private boolean isUserNew = true;
    private boolean isLoginSucceeded;

    /**
     * Here you need to change the path to your individual file.
     *
     */
    public Test() throws IOException, ClassNotFoundException {
        usersList = new ArrayList<User>();
        this.fileLocation = "/Users/johannadahlborn/Documents/GitHub/MathTrainer/MathTrainerServer/inlogningsUppgifter.txt";
        readFile(fileLocation);
        testEverything();
    }

    private void readFile(String fileLocation) throws FileNotFoundException {
        String line;
        String username = null;
        String password = null;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));
            while ((line = br.readLine())!= null)
            {

                String[] tokenize = line.split("\n");
                for (int i = 0; i < tokenize.length; i++)
                {
                    username = tokenize[i];
                    password = br.readLine();
                    //  password = br.readLine();//Problem is here!
                    // System.out.println("testU:" +username);
                    // System.out.println("testP:" +password);
                }
                        /*for (int i = 1; i < tokenize.length; i = i+2)
                        {
                            password = tokenize[i];
                        }*/
                user = new User(username, password);

                usersList.add(user);
                System.out.println(user);

                //   line = br.readLine();

            }
            br.close();
            System.out.println("Size of user array: " + usersList.size());
        }

        catch (FileNotFoundException e)
        {
            System.out.println("file not found");
        }

        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    /**
     * Adds a new user
     */
    private boolean newUser(User user) {

        for (int i = 0; i < usersList.size(); i++) {
            if (user.getUserName().equals(usersList.get(i).getUserName())) {
                isUserNew = false;
            }
        }
        return isUserNew;
    }

    /**
     * If the login is succeeded method goes thrue an array and searches for the value of username and password
     */
    private boolean isLoginSucceeded(User receivedUser) throws IOException, ClassNotFoundException {
        String username = receivedUser.getUserName();
        String password = receivedUser.getPassword();
        //  System.out.println(username + " " + password);

        for (int i = 0; i < usersList.size(); i++) {
            //  System.out.println("Testing array -  " + usersList.get(i));
            //   System.out.println("Usernames: " + usersList.get(i).getUserName());
            //    System.out.println("Passwords: " + usersList.get(i).getPassword());
            if ((username.equals(usersList.get(i).getUserName())) && (password.equals(usersList.get(i).getPassword()))) {
                isLoginSucceeded = true;
            }
            else {
                isLoginSucceeded = false;
            }
        }
        return isLoginSucceeded;
    }


    private void testEverything() throws IOException, ClassNotFoundException {

        Scanner read = new Scanner(System.in);

        System.out.println("Enter your choice:");
        String choice = read.nextLine();

        if (choice.equals("login"))
        {
            User user = new User("kkaa", "hhaa");
            boolean login = isLoginSucceeded(user);
            if (login){
                System.out.println("Login succeeded: "+user.toString());
            }
            else {
                System.out.println("Username and password failure ");
            }
        }

        else if (choice.equals("new user")){
            User user = new User("u5", "p5");
            boolean isUserNew = newUser(user);
            if (isUserNew)
            {
                usersList.add(user);
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileLocation, true));
                PrintWriter pw = new PrintWriter(bw);
                pw.write("\n"+user.toString());
                pw.flush();
                System.out.println("The following user is newly added: \n"+user.toString());
            }
            else {
                System.out.println("Användarnamnet är upptaget!");
            }
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Test();
    }
}