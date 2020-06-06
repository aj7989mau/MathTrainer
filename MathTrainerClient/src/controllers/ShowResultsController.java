package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import sharedEntities.Questions;

public class ShowResultsController extends SceneControllerParent implements InitializeSceneInterface{
    public TextArea answerTx;
    public RadioButton answer;
    private String userAnswer;

    private Questions[] questions;


    @Override
    public void setInitialValues(Object object) {
        //TODO: Objektet är en array av typ Question[]. Varje Questions fråga, användarsvar och korrekt svar bör visas.
        questions = (Questions[]) object;
        for(Questions que: questions){
            answerTx.setText(que.toString());
            System.out.println(questions);
        }
  
    }
    public String getUserAnswer() {return userAnswer;}

    public void goToHome(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Home);
    }

    public void backToScore(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.QuizCompleted);
    }
}
