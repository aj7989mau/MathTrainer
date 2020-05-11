package Questions;

import Server.Course;
import sharedEntities.User;
import sharedEntities.Questions;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a subclass to the parent Course, this class makes an
 * array of the Question class and returns it back whenever the user
 * selects to be apart of the class. Added new questions
 *
 * @author JohannaDahlborn
 * @version 1.0
 * @since 2020-04-22
 */

public class Sixth extends Course {
    //add
    private Questions[] statisticQuestion;
    private Questions[] geometryQuestions;
    private Questions[] fourCountQuestions;

    private List<User> QuestionList;


    public Sixth() {
        QuestionList = new ArrayList<>();
        String n = "\n";
        String q1 = "Fem tärningar kastas och de visar sidorna: 5, 1, 1, 3, 5. Vad är medelvärdet.";
        String q2 = "Erika spelar fotboll. Under de senaste tre matcherna har hon gjort i genomsnitt 3 mål per match. " +
                "Beräkna medelvärdet för alla mål under de senaste tre matcherna.";
        String q3 = "Medelvärdet av tre tal är 5. Två av talen är 4 och 5. Vilket är det tredje talet?";
        String q4 = "Skriv vad 1/4 är i procent.";
        statisticQuestion = new Questions[]{new Questions(q1, "3", "1", "15", "30")
                , new Questions(q2, "3", "6", "2", "0"),
                new Questions(q3, "6", "10", "3", "32"),
                new Questions(q4, "25", "26", "10", "134")};
        //takeTest(questions);


        //Geometry questions
        String q5 = "En triangel har sidlängderna 4 cm, 10 cm och 14 cm. Hur stor omkrets har denna triangel?";
        String q6 = "En triangel har sidlängderna 7 cm, 41 mm och 62 mm. Observera enheterna."
                + n + " Hur stor omkrets har denna triangel i centimeter?";
        geometryQuestions = new Questions[]{new Questions(q5, "28", "23", "27", "34"),
                new Questions(q6, "17.3", "25", "15", "2")};


        //four counting ways
        String q7 = "Räkna ut 455,77+131,5";
        String q8 = "Räkna ut 36,55+94,20 med överslagsräkning, avrunda till närmaste tiotal.";
        String q9 = "Räkna ut 25,5*2";
        String q10 = "Räkna ut 500⋅8";
        fourCountQuestions = new Questions[]{new Questions(q7, "587.27", "550", "480", "245"),
                new Questions(q8, "130", "140", "230", "312")
                , new Questions(q9, "51"
                , "23", "25.52", "40"),
                new Questions(q10, "4000", "4500", "4050", "5141")};


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
    public Questions[] getStatisticQuestion() {
        return statisticQuestion;
    }

    @Override
    public Questions[] getGeometryQuestions() {
        return geometryQuestions;
    }

    @Override
    public Questions[] getFourCountQuestions() {
        return fourCountQuestions;
    }

    @Override
    public Questions[] getQuestions() {
        return new Questions[0];
    }


    public void printQuestions() {
        for (Questions q : statisticQuestion) {
            System.out.println(q);
        }
    }

    public void printUsersList() {
        for (User u : QuestionList) {
            System.out.println(u);
        }
    }
}
