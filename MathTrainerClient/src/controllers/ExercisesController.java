package controllers;


import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/** Controller ExercisesController handles the Exercises scene where the user can select which quiz they want to enter,
 *  the method is an action event from userinput, this controller extends MainMenuControllerParent
 * @author Bajram Gerbeshi
 * @version 1.0
 */

public class ExercisesController extends MainMenuControllerParent {
    //ToDO: Metoder för att hantera de actions användaren kan göra i Övningar.

    @FXML
    private Button additionButton;
    @FXML
    private Button geometryButton;
    @FXML
    private Button statisticsButton;


    /**
     * This method is used both when the user hits the button to select which quiz they want to enter.
     * @param actionEvent The button action
     */

    public void buttonClicked(ActionEvent actionEvent){

        //ToDO: Fixa bugg där AdditionWindow skickar användaren tillbaka till log in screen efter en viss tid.
        String Questions = "Questions ";

        if (actionEvent.getSource() == additionButton) {

            Questions += "Counting";
        } else if ( actionEvent.getSource() == geometryButton){
            Questions += "Geometry";
        }
        else if ( actionEvent.getSource() ==  statisticsButton){
            Questions += "Statistics";
        }
        mainController.QuizTest(Questions);
    }

//ArrayList list = new ArrayList

    //list.add(fråga)



}
