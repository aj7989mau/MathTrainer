package sharedEntities;

import java.io.Serializable;

/**
 * The Questions class will store all the questions
 * @author abdulsamisahil
 * @version 1.0
 * @since 2020-03-25
 */
public class Questions implements Serializable {
    private String question;
    private String answer;
    private String [] wrongAnswers;
    //private Course course;
    //Constructor
    //addQuestions method
    //removeQuestions method

    public Questions(String question, String answer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
        this.question = question;
        this.answer = answer;
        wrongAnswers[0] = wrongAnswer1;
        wrongAnswers[1] = wrongAnswer2;
        wrongAnswers[2] = wrongAnswer3;
    }
    //getQuestions method
    //setQuestions method

    public Questions(){}

    public String getQuestion() {
        return question ;
    }

    public String [] getWrongAnswers()
    {
        return wrongAnswers;
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
