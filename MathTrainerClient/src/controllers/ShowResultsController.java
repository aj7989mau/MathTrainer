package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import sharedEntities.Questions;
import sharedEntities.User;

public class ShowResultsController extends SceneControllerParent implements InitializeSceneInterface{
    @FXML
    public TextArea txtArea;
    @FXML
    public ScrollBar scrollbar;

    private Questions[] questions;





    @Override
    public void setInitialValues(Object object) {
        questions = (Questions[]) object;
        txtArea.setWrapText(true);

        //TODO: Objektet är en array av typ Question[]. Varje Questions fråga, användarsvar och korrekt svar bör visas.
        
    }
    public void showQuestions(ActionEvent actionEvent) {
        mainController.showDetailedResults();
    }


    public void goToHome(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Home);
    }

    public void backToScore(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.QuizCompleted);
    }
}
