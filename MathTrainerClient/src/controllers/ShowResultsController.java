package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;

public class ShowResultsController extends SceneControllerParent implements InitializeSceneInterface{
    @Override
    public void setInitialValues(Object object) {
        //TODO: Objektet är en array av typ Question[]. Varje Questions fråga, användarsvar och korrekt svar bör visas.
        
    }


    public void goToHome(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Home);
    }

    public void backToScore(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.QuizCompleted);
    }
}
