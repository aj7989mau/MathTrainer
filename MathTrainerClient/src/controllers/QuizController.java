package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sharedEntities.Questions;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class QuizController extends SceneControllerParent {

    @FXML
    private Button currentQuestion;
    @FXML
    private RadioButton radioButtonOne;
    @FXML
    private RadioButton radioButtonTwo;
    @FXML
    private RadioButton radioButtonThree;
    @FXML
    private RadioButton radioButtonFour;
    @FXML
    private Label questionLabel;
    @FXML
    private ToggleGroup Group1;
    @FXML
    private Button previousQuestionButton;
    @FXML
    private Button nextQuestionButton;
    @FXML
    private Button submitResultsButton;

    private int questionNumber = -1;

    private Questions[] questions;

    private QuizCompletedController quizCompleteController;


    public QuizController(){

    }

    public void previousQuestion(ActionEvent actionEvent){

        updateLabels(false);
        if( questionNumber == 0){

            previousQuestionButton.setVisible(false);
        }

        if(questionNumber ==  questions.length -2){

            nextQuestionButton.setVisible(true);
            submitResultsButton.setVisible(false);
        }


    }

    public void updateLabels(boolean nextQuestion){



        if (nextQuestion){
            questionNumber++;
        } else{
            questionNumber--;
        }
        LinkedList<String> answerArray = new LinkedList<String>();
        answerArray.add(questions[questionNumber].getAnswer());

        String[] wrongAnswers = questions[questionNumber].getWrongAnswers();

        for (int i = 0; i < wrongAnswers.length; i++ ){
            answerArray.add(wrongAnswers[i]);
        }

        Collections.shuffle(answerArray);
        System.out.println(answerArray + " " + radioButtonOne);

        radioButtonOne.setText(answerArray.removeFirst());
        radioButtonTwo.setText(answerArray.removeFirst());
        radioButtonThree.setText(answerArray.removeFirst());
        radioButtonFour.setText(answerArray.removeFirst());
        currentQuestion.setText((questionNumber + 1) + "/" + questions.length);
        questionLabel.setText(questions[questionNumber].getQuestion());

    }

    public void initializeValues(){
        updateLabels(true);
        questionLabel.setWrapText(true);
        previousQuestionButton.setVisible(false);
        radioButtonOne.setSelected(true);

    }


    public void checkAnswer(int questionNumber){

      RadioButton selectedButton = (RadioButton) Group1.getSelectedToggle();
        System.out.println(questions);
        if (selectedButton.getText().equals(questions[questionNumber].getAnswer())){
            questions[questionNumber].correctAnswer(true);
        } else {questions[questionNumber].correctAnswer(false);
        }
    }


    public void nextQuestion(ActionEvent actionEvent){

        previousQuestionButton.setVisible(true);


        checkAnswer((questionNumber));
        if(questionNumber ==  questions.length -2){

            nextQuestionButton.setVisible(false);
            submitResultsButton.setVisible(true);
        }
            updateLabels(true);
    }

    public Questions[] getQuestions() {
        return questions;
    }


    public void setQuestion(Questions[] questions){
            this.questions = questions;
           System.out.println(questions);

    }


    public void setQuizCompleteController(QuizCompletedController quizCompleteController){
        this.quizCompleteController = quizCompleteController;
    }


    public void toResults(ActionEvent actionEvent){
        checkAnswer(questionNumber);
        quizCompleteController.setResult(questions);
         mainController.setScene(ScenesEnum.QuizCompleted);
    }

    public void quitQuiz(ActionEvent actionEvent){

      boolean answer =  mainController.popUpWindow(Alert.AlertType.CONFIRMATION, "Avsluta?" , "Är du säker på att du vill avsluta, dina svar sparas inte" );
      if (answer){
          mainController.setScene(ScenesEnum.Home);
      }

    }


}