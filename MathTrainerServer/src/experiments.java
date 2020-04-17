import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is made for purpose small tests of the project
 * after every development iteration.
 * @author abdulsamisahil
 */
/*public class experiments {
    public static void main(String[] args) {
        Course seventh = new Seventh();

       /* Questions q1 = new Questions("What comes 12x12?");
        Questions q2 = new Questions("What is the answer of 144 divided by 12? ");
        Questions q3 = new Questions("How many days does it take to go a distance of 120km if I can go up to 20 kms a day?");





        seventh.addQuestions(q1);
        seventh.addQuestions(q2);
        seventh.addQuestions(q3);

        Questions q4 = new Questions("How old am I?");

        Course eighth = new Eighth();
        eighth.addQuestions(q4);

        User u1 = new User("Taha", 29, "08098", UserType.student, Courses.seventh);
        User u2 = new User("Yasin", 45, "03234234", UserType.teacher, Courses.seventh);
        User u3 = new User("Johan", 45, "3497987", UserType.teacher, Courses.ninth);



        Course ninth = new Ninth();
        ninth.addUser(u1);
        ninth.addUser(u2);
        ninth.addUser(u3);
        ninth.removeUser(u2);
        ninth.removeUser(u1);

        ninth.printUsersList();


        seventh.addUser(u1);
        seventh.addUser(u2);


        //Sizes

        int score = 0;
        Scanner userInput = new Scanner(System.in);
        List<User> usersList = new ArrayList<>();

        Questions[] questions = seventh.getQuestions();

        System.out.println("Please enter your username");
        String username = userInput.nextLine();
        System.out.println("Please enter your age");
        int userAge = userInput.nextInt();
        System.out.println("Please enter your id");
        String id = userInput.nextLine();
       // userInput.nextLine();
        userInput.nextLine();

        User user = new User(username, userAge, id);
        usersList.add(user);
        System.out.println("Mr " + username + ", you are admitted to the 7th course");


        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            String answer = userInput.nextLine();
            if (answer.equals(questions[i].getAnswer())) {
                score++;
            }
        }
        String str = "Dear Mr " + user.getName() + ", you got " + score + "/" + questions.length;
        System.out.println(str);
        System.out.println();
    }
}*/