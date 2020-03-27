import java.util.ArrayList;
import java.util.List;

public class Seventh extends Course{
    private Questions[] questions;
    private List<User> usersList;
    public Seventh(){
        usersList = new ArrayList<>();
        String n = "\n";
        String q1 = "What is 12 multiply by 12?" + n + "(a) 144" + n + "(b) 148" + n + "(c) 240" + n;
        String q2 = "What is the square value of 169?" + n + "(a) 12" + n + "(b) 34" + n + "(c) 13" + n;
        questions = new Questions[]{new Questions(q1, "a"), new Questions(q2, "c")};
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
    public Questions[] getQuestions() {
        return questions;
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