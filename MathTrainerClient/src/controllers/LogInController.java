package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import entity.AlertBox;

import java.io.IOException;

/**
 * Controller for the scene LogIn.fxml
 */

public class LogInController extends ControllerParent {

    public void skipLogInClicked(ActionEvent actionEvent) {
        boolean answer = AlertBox.yesNoOption("Logga in?", "Om du inte loggar in eller skapar en användare kommer ingenting att sparas. " +
                "Är du säker på att du vill fortsätta utan att logga in?", "Ja", "Nej");
        if (answer){
            mainController.logIn("Guest","");
        }
    }

    public void logInClicked(ActionEvent actionEvent) {
        mainController.logIn("test", "test");
    }

    public void newUserClicked(ActionEvent actionEvent) {
        mainController.changeScene(ScenesEnum.NewUser);
    }
}
