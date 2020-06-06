package controllers;

import entity.ScenesEnum;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sharedEntities.Questions;

public class ShowResultsController extends SceneControllerParent implements InitializeSceneInterface{
    @FXML
    private TableView<Questions> tableView = new TableView<Questions>();

    @FXML
    private TableColumn<Questions, String> questionColumn;

    @FXML
    private TableColumn<Questions, String> answerColumn;

    @FXML
    private TableColumn<Questions, String> yourAnswerColumn;

    private Questions[] questions;


    @Override
    public void setInitialValues(Object object) {
        //TODO: Objektet är en array av typ Question[]. Varje Questions fråga, användarsvar och korrekt svar bör visas.
        questions = (Questions[]) object;
        questionColumn.setCellValueFactory(new PropertyValueFactory<>("question"));
        answerColumn.setCellValueFactory(new PropertyValueFactory<>("answer"));
        yourAnswerColumn.setCellValueFactory(new PropertyValueFactory<>("userAnswer"));

        tableView.setItems(getQuestions());

        for(int i = 0; i < questions.length; i++){

        }
    }

    public void goToHome(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Home);
    }

    public void backToScore(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.QuizCompleted);

    }
    /**
     * Get all of the questions
     */
    public ObservableList<Questions> getQuestions()
    {
        ObservableList<Questions> questions = FXCollections.observableArrayList();
     /*   Button buttonClicked = new ExercisesController().buttonClicked(new ActionEvent());
        String button = buttonClicked.getText();
        if (button == "Statistik")
        {
            questions.add(new Questions("Statistik questions?", "Sami", "Johanna", "Bajram", "Motaz"));
        }
        else if (button == "Geometri")
        {
            questions.add(new Questions("Geometri questions?", "Sami", "Johanna", "Bajram", "Motaz"));
        }
        else if (button == "Räknesätten")
        {
            questions.add(new Questions("Räknesätten questions?", "Sami", "Johanna", "Bajram", "Motaz"));

        }
        else if (button == "Slumpade frågor")
        {
            questions.add(new Questions("Slumpade questions?", "Sami", "Johanna", "Bajram", "Motaz"));

        }*/
        questions.add(new Questions("Vad heter du?", "Sami", "Johanna"));
        questions.add(new Questions("Vad heter du?", "Sami", "Johanna,"));
        questions.add(new Questions("Vad heter du?", "Sami", "Johanna"));
        questions.add(new Questions("Vad heter du?", "Sami", "Johanna,"));
        return questions;
    }
}
