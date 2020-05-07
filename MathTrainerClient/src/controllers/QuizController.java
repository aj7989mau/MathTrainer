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

public class QuizController extends SceneControllerParent implements Initializable {

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

    private int questionNumber = -1;

    private static Questions[] questions;



    public QuizController(){

    }

    public void previousQuestion(ActionEvent actionEvent){

        updateLabels(false);
        if( questionNumber == 0){

            previousQuestionButton.setVisible(false);
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

        if(questionNumber ==  questions.length -1){

        } else {
            updateLabels(true);
        }

    }

    public void setQuestion(Questions[] questions){
            this.questions = questions;
           System.out.println(questions);
    }
    public void quitQuiz(ActionEvent actionEvent){

      boolean answer =  mainController.popUpWindow(Alert.AlertType.CONFIRMATION, "Avsluta?" , "Är du säker på att du vill avsluta, dina svar sparas inte" );
      if (answer){
          mainController.setScene(ScenesEnum.Home);
      }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeValues();
    }
}