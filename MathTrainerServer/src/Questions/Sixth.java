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
 * @author JohannaDahlborn, Motaz Kasem
 * @version 2.0
 * @since 2020-05-11
 */

public class Sixth extends Course {
    //adding the various types of questions into an array called Questions
    private Questions[] statisticQuestion;
    private Questions[] geometryQuestions;
    private Questions[] fourCountQuestions;

    private List<User> QuestionList;


    public Sixth() {
        QuestionList = new ArrayList<>();
        String n = "\n";
        //statistic questions
        String q1 = "Fem tärningar kastas och de visar sidorna: 5, 1, 1, 3, 5. Vad är medelvärdet.";
        String q2 = "Erika spelar fotboll. Under de senaste tre matcherna har hon gjort i genomsnitt 3 mål per match. " +
                "Beräkna medelvärdet för alla mål under de senaste tre matcherna.";
        String q3 = "Medelvärdet av tre tal är 5. Två av talen är 4 och 5. Vilket är det tredje talet?";
        String q4 = "Skriv vad 1/4 är i procent.";
        String q5 = "Välj rätt namn till vad som förklaras i tabeller. Information från topp till botten";
        String q6 = "Välj rätt namn till vad som förklaras i tabeller. Information från vänster till höger";
        String q7 = "Erika spelar fotboll. Under de senaste tre matcherna har hon gjort i genomsnitt 2 mål per match. " +
                "Beräkna summan för alla mål under de senaste tre matcherna";
        String q8 = "Medelvärdet av tre tal är 10. Två av talen är 8 och 10. Vilket är det tredje talet?";
        String q9 = "Fem tärningar kastas och de visar sidorna: 6, 0, 4, 3, 2. Beräkna medelvärdet.";
        String q10 = "Medelvärdet av tre tal är 5. Två av talen är 2 och 5. Vilket är det tredje talet?";
        String q11 = "Fem tärningar kastas och de visar sidorna: 4, 2, 3, 3, 3. Beräkna medelvärdet.";


        statisticQuestion = new Questions[]{new Questions(q1, "3", "1", "15", "30")
                , new Questions(q2, "3", "6", "2", "0"),
                new Questions(q3, "6", "10", "3", "32"),
                new Questions(q4, "36", "26", "10", "134"),
                new Questions(q5, "Kolumn", "Titel", "Rad", "Figur"),
                new Questions(q6, "Rad", "Kolumn", "Figur", "Titel"),
                new Questions(q7, "6", "8", "9", "4"),
                new Questions(q8, "12", "11", "13", "10"),
                new Questions(q9, "3", "15", "4", "2"),
                new Questions(q10, "8", "6", "9", "7"),
                new Questions(q11, "3", "4", "7,5", "8")};


        //takeTest(questions);


        //Geometry questions
        String q21 = "En triangel har sidlängderna 4 cm, 10 cm och 14 cm. Hur stor omkrets har denna triangel?";
        String q22 = "En triangel har sidlängderna 7 cm, 41 mm och 62 mm. Observera enheterna."
                + n + " Hur stor omkrets har denna triangel i centimeter?";
        String q23 = " Hur många hörn har en kub?";
        String q24 = "Hur många hörn har ett Parallellogram";
        String q25 = "Hur många hörn har en cirkel";
        String q26 = "Den geometrisk figuren cylinder, vad liknar den i verkligheten?";
        String q27 = "Den geometrisk figuren rektangel, vad liknar den i verkligheten?";
        String q28 = "Den geometrisk figuren cirkel, vad liknar den i verkligheten?";

        geometryQuestions = new Questions[]{new Questions(q21, "28", "23", "27", "34"),
                new Questions(q22, "17.3", "25", "15", "2"),
                new Questions(q23, "8", "6", "4", "6"),
                new Questions(q24, "4", "5", "8", "7"),
                new Questions(q25, "0", "4", "5", "2"),
                new Questions(q26, "Läskburk", "Fotboll", "Dator", "Bil"),
                new Questions(q27, "Pappersark", "Tärning", "Kartong", "Tåg"),
                new Questions(q28, "CD-skiva", "Datorskärm", "CD-fodral", "Kruka")};


        //four counting ways
        String q31 = "Räkna ut 455,77+131,5";
        String q32 = "Räkna ut 36,55+94,20 med överslagsräkning, avrunda till närmaste tiotal.";
        String q33 = "Räkna ut 25,5*2";
        String q34 = "Räkna ut 500⋅8";

        fourCountQuestions = new Questions[]{new Questions(q31, "587.27", "550", "480", "245"),
                new Questions(q32, "130", "140", "230", "312")
                , new Questions(q33, "51"
                , "23", "25.52", "40"),
                new Questions(q34, "4000", "4500", "4050", "5141")};


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

    //Getter methods for StaticQuestions, GeometryQuestions & CountQuestions
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
