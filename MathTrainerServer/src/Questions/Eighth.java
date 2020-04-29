package Questions;

import Server.Course;
import Server.User;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a subclass to the parent Course, this class makes an
 * array of the Question class and returns it back whenever the user
 * selects to be apart of the class.
 * @author abdulsamisahil
 * @version 1.0
 * @since 2020-03-31
 */
public class Eighth extends Course {
    private Questions[] questions;
    private List<User> usersList;

    public Eighth() {
        usersList = new ArrayList<>();
        String n = "\n";

        String q1 = "Three workers are building a room, each worker should work 16 hours a day to make the room ready in two days."
                + n + "If four workers are given the same task, how many hours should each worker work to complete the task in two days?"
                + n + "(a) 11 hours" + n + "(b) 9 hours" + n + "(c) 12 hours" + n;


        String q2 = "What is the correct value of x in the following equation \n" +
                "2x + 4 = 12?" + n + "(a) x = 8" + n + "(b) x = 4" + n + "(c) x = 2" + n;

        questions = new Questions[]{new Questions(q1, "c"), new Questions(q2, "b")};
        //takeTest(questions);
    }

    /*public void takeTest(Questions [] questions){
        int score = 0;
        Scanner userInput = new Scanner(System.in);

        /*System.out.println("Please enter your username");
        String username = userInput.nextLine();
        System.out.println("Please enter your age");
        int userAge = userInput.nextInt();
        System.out.println("Please enter your id");
        String id = userInput.nextLine();
        userInput .nextLine();

        User user = new User(username, userAge, id);
        usersList.add(user);
        System.out.println("Mr " + username + ", you are admitted to the 7th course");


        for (int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);
            String answer = userInput.nextLine();
            if (answer.equals(questions[i].getAnswer())){
                score++;
            }
        }
        }*/
    @Override
    public Questions[] getStastisticQuestion() {
        return questions;
    }

    @Override
    public Questions[] getgeometryQuestions() {
        return new Questions[0];
    }

    @Override
    public Questions[] getfourCountQuestions() {
        return new Questions[0];
    }

    @Override
    public Questions[] getQuestions() { return new Questions[0];
    }



    public void printQuestions(){
        for (Questions q: questions){
            System.out.println(q);
        }
    }
    public void printUsersList(){
        for (User u: usersList){
            System.out.println(u);
        }
    }
}
