/**
 * The Questions class will store all the questions
 * @author abdulsamisahil
 * @version 1.0
 * @since 2020-03-25
 */
public class Questions {
    private String question;
    private String answer;

    //Constructor
    //addQuestions method
    //removeQuestions method
    //getQuestions method
    //setQuestions method

    public Questions(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question ;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String toString() {
        return "Questions: " +
                question;
    }
}
