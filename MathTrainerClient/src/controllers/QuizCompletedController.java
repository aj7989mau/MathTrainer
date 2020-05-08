package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sharedEntities.Questions;

import java.awt.*;

public class QuizCompletedController extends SceneControllerParent {


    @FXML
    private Label scoreLabel;



    public void continueMenu(ActionEvent actionEvent){

        mainController.setScene(ScenesEnum.Home);
    }


    public void setResult(Questions[] questions){
        int score = 0;
        for (int i = 0; i < questions.length; i++){
            if (questions[i].getCorrectAnswer()){
                score++;
            }
        }
        scoreLabel.setText(score + "/" + questions.length);

    }



}
