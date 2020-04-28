package Server;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a subclass to the parent Course, this class makes an
 * array of the Question class and returns it back whenever the user
 * selects to be apart of the class. Added new questions and
 * @author JohannaDahlborn
 * @version 1.0
 * @since 2020-04-22
 */

public class Sixth extends Course {
    //add
    private Questions[] stastisticQuestion;
    private Questions[] geometryQuestions;
    private Questions[] fourCountQuestions;

    private List<User> statisticList;


    public Sixth() {
        statisticList = new ArrayList<>();
        String n = "\n";
        String q1 = "Fem tärningar kastas och de visar sidorna: 5, 1, 1, 3, 5. Vad är medelvärdet." + n + "(a) 3" + n +
                "(b) 1" + n + "(c) 15" + n;
        String q2 = "Erika spelar fotboll. Under de senaste tre matcherna har hon gjort i genomsnitt 2 mål per match. " +
                "Beräkna medelvärdet för alla mål under de senaste tre matcherna." + n +
                "(a) 2" + n + "(b) 6" + n + "(c) 3" + n;
        String q3 = "Medelvärdet av tre tal är 5. Två av talen är 4 och 5. Vilket är det tredje talet?" + n + "(a) 3" + n +
                "(b) 6" + n + "(c) 10" + n;
        String q4 = "Skriv vad 1/4 är i procent." + n + "(a) 25 " + n + "(b) 30" + n + "(c) 10" + n;
        stastisticQuestion = new Questions[]{new Questions(q1, "a"), new Questions(q2, "c"), new Questions(q3, "b"),
        new Questions(q4, "b")};
        //takeTest(questions);


        //Geometry questions
        String q5 = "En triangel har sidlängderna 4 cm, 10 cm och 14 cm. Hur stor omkrets har denna triangel?" + n +
                "(a) 28" + "(b) 23" + n + "(c) 27" + n;
        String q6 = "En triangel har sidlängderna 7 cm, 41 mm och 62 mm. Observera enheterna. " +
                "Hur stor omkrets har denna triangel i centimeter?" + n + "(a) 25 " + n + "(b) 15" + n + "(c) 17,3" + n;
        geometryQuestions = new Questions[]{new Questions(q5, "a"), new Questions(q6, "c")};


        //four counting ways
        String q7 = "Räkna ut 455,77+131,5" + n + "(a) 587,27" + n + "(b) 550" + n + "(c) 432,4" + n;
        String q8 = "Räkna ut 36,55+94,20 med överslagsräkning, avrunda till närmaste tiotal." + n +
                "(a) 130" + n + "(b) 140" + n + "(c) 230" + n;
        String q9 = "Räkna ut 25,5⋅2" + n + "(a) 23" + n + "(b) 51" + n + "(c) 52" + n;
        String q10 = "Räkna ut 500⋅8" + n + "(a) 4000" + n + "(b) 4500" + n + "(c) 4000" + n;
        fourCountQuestions = new Questions[]{new Questions(q7, "a"), new Questions(q8, "a"), new Questions(q9, "b"),
        new Questions(q10, "c")};


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
        return new Questions[0];
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
    public Questions[] getQuestions() {
        return new Questions[0];
    }


    public void printQuestions() {
        for (Questions q : stastisticQuestion) {
            System.out.println(q);
        }
    }

    public void printUsersList() {
        for (User u : statisticList) {
            System.out.println(u);
        }
    }
}
