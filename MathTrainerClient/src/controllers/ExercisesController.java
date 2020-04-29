package controllers;


import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ExercisesController extends MainMenuControllerParent {
    //ToDO: Metoder för att hantera de actions användaren kan göra i Övningar.
    @FXML
    private Button AdditionButton; // bör förfinas


    public void AdditionClicked(ActionEvent actionEvent){

     AdditionButton.setOnAction( e ->  mainController.setScene(ScenesEnum.ExerciseAddition)); // bör förfinas
        //ToDO: Fixa bugg där AdditionWindow skickar användaren tillbaka till log in screen efter en viss tid.
    }



//ArrayList list = new ArrayList

    //list.add(fråga)



}
