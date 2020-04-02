package controllers;

/**
 * Controller for handling button-presses in the scene MainMenu.fxml. Each method represent a possible user action.
 * @author Niklas Hultin
 * @version 1.0
 */

import javafx.event.ActionEvent;

public class MainMenuController extends ControllerParent {

    public void logOutClicked(ActionEvent actionEvent){
        mainController.logOut();
    }

}
