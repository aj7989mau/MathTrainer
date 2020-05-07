package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sharedEntities.Questions;

import java.util.Collections;
import java.util.LinkedList;

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
    private ToggleGroup group1;
    @FXML
    private Button previousQuestionButton;
    @FXML
    private Button nextQuestionButton;


    private Questions[] questions;



    public QuizController(){
    }

    public void previousQuestion(ActionEvent actionEvent){

        String questionNumber =  currentQuestion.getText().substring(0 , currentQuestion.getText().indexOf('/'));

        updateLabels(false);


        if(Integer.parseInt(questionNumber) == 1){

            previousQuestionButton.setVisible(false);
        }

    }

    public void updateLabels(boolean nextQuestion){

        String questionNumber =  currentQuestion.getText().substring(0 , currentQuestion.getText().indexOf('/'));


        int  currentNumber  =  Integer.parseInt(questionNumber)-1;
        if (nextQuestion){
            currentNumber++;
        } else{
            currentNumber--;
        }
        LinkedList<String> answerArray = new LinkedList<String>();
        answerArray.add(questions[currentNumber].getAnswer());

        String[] wrongAnswers = questions[currentNumber].getWrongAnswers();

        for (int i = 0; i < wrongAnswers.length; i++ ){
            answerArray.add(wrongAnswers[i]);
        }

        Collections.shuffle(answerArray);

        radioButtonOne.setText(answerArray.removeFirst());
        radioButtonTwo.setText(answerArray.removeFirst());
        radioButtonThree.setText(answerArray.removeFirst());
        radioButtonFour.setText(answerArray.removeFirst());
        currentQuestion.setText((currentNumber + 1) + "/" + questions.length);
        questionLabel.setText(questions[currentNumber].getQuestion());
    }

    public void checkAnswer(int questionNumber){

      RadioButton selectedButton = (RadioButton) group1.getSelectedToggle();
        if (selectedButton.getText().equals(questions[questionNumber].getAnswer())){
            questions[questionNumber].correctAnswer(true);
        } else {questions[questionNumber].correctAnswer(false);
        }
    }


    public void nextQuestion(ActionEvent actionEvent){

        previousQuestionButton.setVisible(true);

       String questionNumber =  currentQuestion.getText().substring(0 , currentQuestion.getText().indexOf('/'));

        checkAnswer(Integer.parseInt(questionNumber)-1);

        if(Integer.parseInt(questionNumber) == questions.length){

        } else {
            updateLabels(true);
        }

    }

    public void setQuestion(Questions[] questions){
            this.questions = questions;

    }
    public void quitQuiz(ActionEvent actionEvent){

      boolean answer =  mainController.popUpWindow(Alert.AlertType.CONFIRMATION, "Avsluta?" , "Är du säker på att du vill avsluta, dina svar sparas inte?" );
      if (answer){
          mainController.setScene(ScenesEnum.Exercises);
      }

    }

}