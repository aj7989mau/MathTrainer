package controllers;

import entity.ScenesEnum;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sharedEntities.Questions;

public class ShowResultsController extends SceneControllerParent implements InitializeSceneInterface{
    @FXML
    private TableView<String> tableView = new TableView<String>();

    @FXML
    private TableColumn<String, String> questionColumn;

    @FXML
    private TableColumn<String, String> answerColumn;

    @FXML
    private TableColumn<String, String> numberColumn;

    private Questions[] questions;


    @Override
    public void setInitialValues(Object object) {
        //TODO: Objektet är en array av typ Question[]. Varje Questions fråga, användarsvar och korrekt svar bör visas.
        questions = (Questions[]) object;
        for(int i = 0; i < questions.length; i++){

        }
    }

    public void goToHome(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Home);
    }

    public void backToScore(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.QuizCompleted);

    }
}
