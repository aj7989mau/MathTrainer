package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sharedEntities.Questions;

import java.awt.*;


/** Class QuizCompletedController that extends SceneControllerParent that handles the fxml file QuizCompleted.fxml and shows the user their final score from the quiz
 * @author Bajram Gerbeshi
 * @version 1.0
 */



public class QuizCompletedController extends SceneControllerParent implements InitializeSceneInterface{


    @FXML
    private Label scoreLabel;

    /**
     * This method is used when the user wants to continue to the home screen from the quizCompleted scene.
     * @param actionEvent The button action
     */

    public void continueMenu(ActionEvent actionEvent){

        mainController.setScene(ScenesEnum.Home);
    }
    /**
     * This method is used to set the results in the final scene and to get the results from the questions array.
     * @param questions questions array to get the results
     */

    public void setResult(Questions[] questions){
        int score = 0;
        for (int i = 0; i < questions.length; i++){
            if (questions[i].getCorrectAnswer()){
                score++;
            }
        }
        scoreLabel.setText(score + "/" + questions.length);

    }

    public void setInitialValues(Object object) {
        setResult((Questions[]) object);
    }
}
