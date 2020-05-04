package controllers;


import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ExercisesController extends MainMenuControllerParent {
    //ToDO: Metoder för att hantera de actions användaren kan göra i Övningar.

    @FXML
    private Button AdditionButton;
    @FXML
    private Button GeometryButton;
    @FXML
    private Button StatisticsButton;
    private String Questions = "Questions ";



    public void ButtonClicked(ActionEvent actionEvent){

        //ToDO: Fixa bugg där AdditionWindow skickar användaren tillbaka till log in screen efter en viss tid.

        if (actionEvent.getSource() == AdditionButton) {

            Questions += "Addition";
        } else if ( actionEvent.getSource() == GeometryButton){
            Questions += "Geometry";
        }
        else if ( actionEvent.getSource() ==  StatisticsButton){
            Questions += "Statistics";
        }
        System.out.println(Questions);
        mainController.QuizTest(Questions);
    }

//ArrayList list = new ArrayList

    //list.add(fråga)



}
