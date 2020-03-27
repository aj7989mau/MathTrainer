package controllers;

/**
 * Controller for the scene MainMenu.fxml
 */

import javafx.event.ActionEvent;

public class MainMenuController extends ControllerParent {

    public void logOutClicked(ActionEvent actionEvent){
        mainController.logOut();
    }

}
