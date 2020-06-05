package Questions;

import Server.Course;
import sharedEntities.Questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a subclass to the parent Course, this class makes an
 * array of the Question class and returns it back whenever the user
 * selects to be apart of the class. Added new questions
 *
 * @author JohannaDahlborn
 * @version 2.0
 * @since 2020-05-11
 */

public class Sixth extends Course {
    //adding the various types of questions into an array called Questions
    private Questions[] statisticQuestion;
    private Questions[] geometryQuestions;
    private Questions[] fourCountQuestions;
    private Questions[] randomlyQuestions;

    private List<String> statisticList;

    private String statisticLoc, geoLoc, FouCountLoc;

    private int statQuesLength;
    private String question, correct, wrong1, wrong2, wrong3;
    private String n = "\n";

    /**
     * Constructs the class
     * @since 2020-05-28
     */
    public Sixth() {

        //statistic questions
        initStatisticQuestions();

        //Geometry questions
        initGeometryQuestions();

        //four counting ways
        initFourCountQuestions();


        //slumpade frågor
        initRandomlyQuestion();

        //Down commented code are some experiments for creating and reading questions from a text file

        /* statisticLoc = "/Users/abdulsamisahil/Documents/GitHub/MathTrainer/MathTrainerServer/Statistic.txt";
        geoLoc = "";
        FouCountLoc = "";
        readStatQue();
        statQuesLength = statisticList.size() / 5;
        statisticQuestion = new Questions[statQuesLength];
        setStatisticQuestions();
        createStatQueArray();
        System.out.println(statQuesLength);*/
    }

    /**
     * This method takes a question array as an arg and randomise the elements in it and returns back the array
     * @author abdul sami sahil
     * @since 2020-05-28
     * @param array arg that is taken
     * @return returns back the array randomly
     */
    public Questions[] shuffleArrayRandomly(Questions [] array)
    {
        int nbrOfQuestions = array.length;

        for (int i = 0; i < nbrOfQuestions; i++)
        {
            int rand = (int) (Math.random() * (nbrOfQuestions));
            Questions question = array[i];
            array[i] = array[rand];
            array[rand] = question;
        }
        return array;
    }
    // creating statistic questions
    private void initStatisticQuestions(){
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



        statisticQuestion = new Questions[]{
                new Questions(q1, "3", "1", "15", "30"),
                new Questions(q2, "3", "6", "2", "0"),
                new Questions(q3, "6", "10", "3", "32"),
                new Questions(q4, "36", "26", "10", "134"),
                new Questions(q5, "Kolumn", "Titel", "Rad", "Figur"),
                new Questions(q6, "Rad", "Kolumn", "Figur", "Titel"),
                new Questions(q7, "6", "8", "9", "4"),
                new Questions(q8, "12", "11", "13", "10"),
                new Questions(q9, "3", "15", "4", "2"),
                new Questions(q10, "8", "6", "9", "7")};
    }
    // creating geometry questions
    private void initGeometryQuestions() {
        String q1 = "Fem tärningar kastas och de visar sidorna: 4, 2, 3, 3, 3. Beräkna medelvärdet.";
        String q2 = "En triangel har sidlängderna 4 cm, 10 cm och 14 cm. Hur stor omkrets har denna triangel?";
        String q3 = "En triangel har sidlängderna 7 cm, 41 mm och 62 mm. Observera enheterna."
                + n + " Hur stor omkrets har denna triangel i centimeter?";
        String q4 = " Hur många hörn har en kub?";
        String q5 = "Hur många hörn har ett Parallellogram";
        String q6 = "Hur många hörn har en cirkel";
        String q7 = "Den geometrisk figuren cylinder, vad liknar den i verkligheten?";
        String q8 = "Den geometrisk figuren rektangel, vad liknar den i verkligheten?";
        String q9 = "Den geometrisk figuren cirkel, vad liknar den i verkligheten?";
        String q10 = "Den punkt linjerna möts i, där vi mäter vinkeln, kallas...";
        geometryQuestions = new Questions[]{
                new Questions(q2, "28", "23", "27", "34"),
                new Questions(q3, "17.3", "25", "15", "2"),
                new Questions(q4, "8", "6", "4", "6"),
                new Questions(q5, "4", "5", "8", "7"),
                new Questions(q6, "0", "4", "5", "2"),
                new Questions(q7, "Läskburk", "Fotboll", "Dator", "Bil"),
                new Questions(q8, "Pappersark", "Tärning", "Kartong", "Tåg"),
                new Questions(q9, "CD-skiva", "Datorskärm", "CD-fodral", "Kruka"),
                new Questions(q1, "3", "4", "7,5", "8"),
                new Questions(q10, "Vinkelspets", "Mötesplats", "Vikelhake", "Vinkelpunkt")};
    }
    // creating four count questions
    private void initFourCountQuestions() {
        String q1 = "Räkna ut 455,77+131,5";
        String q2 = "Räkna ut 36,55+94,20 med överslagsräkning, avrunda till närmaste tiotal.";
        String q3 = "Räkna ut 25,5*2";
        String q4 = "Räkna ut 500⋅8";
        String q5 = "Räkna ut 24 - 36";
        String q6 = "Räkna ut divisionen där talet 35 är täljaren, talet 7 är nämnaren";
        String q7 = "Räkna ut divisionen där talet 7 är täljaren, talet 35 är nämnaren";
        String q8 = "Mikaels favorittröja brukade kosta 150 kr. På rea blev den 20% billigare, då köpte han den. Hur mycket kostade den då?";
        String q9 = "Räkna ut  20 % av 150 kr";
        String q10 = "Vad blir 4 . 5 . 3?";
        fourCountQuestions = new Questions[]{new Questions(q1, "587.27", "550", "480", "245"),
                new Questions(q2, "130", "140", "230", "312"),
                new Questions(q3, "51", "23", "25.52", "40"),
                new Questions(q4, "4000", "4500", "4050", "5141"),
                new Questions(q5, "-12", "12", "8", "10"),
                new Questions(q6, "5", "6", "3", "7.5"),
                new Questions(q7, "0.2", "0.5", "0.6", "0.7"),
                new Questions(q8, "120kr", "140kr", "100kr", "80kr"),
                new Questions(q9, "30kr", "50kr", "40kr", "35kr"),
                new Questions(q10, "60", "40", "70", "43"),
        };
    }
    // creating randomly questions from all three categories
    private void initRandomlyQuestion(){
        String q1 = "Fem tärningar kastas och de visar sidorna: 5, 1, 1, 3, 5. Vad är medelvärdet.";
        String q2 = "Erika spelar fotboll. Under de senaste tre matcherna har hon gjort i genomsnitt 3 mål per match. " +
                "Beräkna medelvärdet för alla mål under de senaste tre matcherna.";
        String q3 = "Medelvärdet av tre tal är 5. Två av talen är 4 och 5. Vilket är det tredje talet?";
        String q4 = "Fem tärningar kastas och de visar sidorna: 4, 2, 3, 3, 3. Beräkna medelvärdet.";
        String q5 = "En triangel har sidlängderna 4 cm, 10 cm och 14 cm. Hur stor omkrets har denna triangel?";
        String q6 = "En triangel har sidlängderna 7 cm, 41 mm och 62 mm. Observera enheterna."
                + n + " Hur stor omkrets har denna triangel i centimeter?";
        String q7 = "Räkna ut divisionen där talet 35 är täljaren, talet 7 är nämnaren";
        String q8 = "Räkna ut divisionen där talet 7 är täljaren, talet 35 är nämnaren";
        String q9 = "Mikaels favorittröja brukade kosta 150 kr. På rea blev den 20% billigare, då köpte han den. Hur mycket kostade den då?";
        String q10 = "Räkna ut  20 % av 150 kr";




       randomlyQuestions = new Questions[]{
                new Questions(q1, "3", "1", "15", "30"),
                new Questions(q2, "3", "6", "2", "0"),
                new Questions(q3, "6", "10", "3", "32"),
               new Questions(q5, "28", "23", "27", "34"),
               new Questions(q6, "17.3", "25", "15", "2"),
               new Questions(q4, "3", "4", "7,5", "8"),
               new Questions(q7, "5", "6", "3", "7.5"),
               new Questions(q8, "0.2", "0.5", "0.6", "0.7"),
               new Questions(q9, "120kr", "140kr", "100kr", "80kr"),
               new Questions(q10, "30kr", "50kr", "40kr", "35kr")};
    }

    //Getter methods for StaticQuestions, GeometryQuestions & CountQuestions
    @Override
    public Questions[] getStatisticQuestion() {
        Questions [] array = shuffleArrayRandomly(statisticQuestion);
        return array;
    }
    @Override
    public Questions[] getGeometryQuestions() {
        Questions [] array = shuffleArrayRandomly(geometryQuestions);
        return array;
    }
    @Override
    public Questions[] getFourCountQuestions() {
        Questions [] array = shuffleArrayRandomly(fourCountQuestions);
        return array;
    }

    @Override
    public Questions[] getRandomiseQuestions() {
        Questions [] array = shuffleArrayRandomly(randomlyQuestions);
        return array;
    }

    @Override
    public Questions[] getQuestions() {
        return new Questions[0];
    }

    /**
     *
     * @author abdul sami sahil
     * @since 2020-05-28
     * @param args to have an executable code,
     */
    public static void main(String[] args) {
        Sixth sixth = new Sixth();

        Questions [] array = new Questions[]{new Questions("What is your name?", "A", "B", "C", "D"),
                new Questions("What is your job?", "A", "B", "C", "D"),
                new Questions("Where do you live?", "A", "B", "C", "D")};

        Questions q [] = sixth.shuffleArrayRandomly(array);
        //printing the array randomly test
        for (Questions qe: q )
        {
            System.out.println(qe + " ");
        }
    }
    private void readStatQue()
    {
        String line;
        statisticList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(statisticLoc));
            while ((line = reader.readLine()) != null)
            {
                statisticList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Another way to declare questions
    private void initQA(){
        int questionIndex = 0;
        for (int i = 0; i < statisticList.size(); i++)
        {
            if (statisticList.get(i).contains("?"))
            {
                question = statisticList.get(i);
                questionIndex = Integer.valueOf(i);
                System.out.println("Question index: " + questionIndex);
            }
        }
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


    public void setStatisticQuestions() {
        //  String question = null, correct = null, wrong1 = null, wrong2 = null, wrong3 = null;

        for (int j = 0; j < statisticQuestion.length; j++) {

            //  System.out.println(statisticQuestion.toString());
            for (int i = 0; i < statisticList.size(); i++) {
                question = statisticList.get(i);
                i++;
                correct = statisticList.get(i);
                i++;
                wrong1 = statisticList.get(i);
                i++;
                wrong2 = statisticList.get(i);
                i++;
                wrong3 = statisticList.get(i);
                //  statisticQuestion = new Questions[]{new Questions(question, correct, wrong1, wrong2, wrong3)};
                //  statisticQuestion[i] = new Questions()
            }
            System.out.println(question + "\n" + correct + "\n" + wrong1 + "\n" + wrong2 + "\n" + wrong3);
            statisticQuestion[j] = new Questions(question, correct, wrong1, wrong2, wrong3);
        }

       /*     statisticQuestion = new Questions[19];
        statisticQuestion[0] = new Questions(question, correct, wrong1, wrong2, wrong3);
        statisticQuestion[1] = new Questions(question, correct, wrong1, wrong2, wrong3);
        statisticQuestion[2] = new Questions(question, correct, wrong1, wrong2, wrong3);
        statisticQuestion[3] = new Questions(question, correct, wrong1, wrong2, wrong3);
        statisticQuestion[4] = new Questions(question, correct, wrong1, wrong2, wrong3);*/

    }
    private void createStatQueArray(){
        for (int i = 0; i < statisticQuestion.length; i++)
        {
            statisticQuestion[i] = new Questions(statisticList.get(i), statisticList.get(i), statisticList.get(i), statisticList.get(i), statisticList.get(i));

            //  System.out.println(statisticQuestion.toString());
        }
    }
}