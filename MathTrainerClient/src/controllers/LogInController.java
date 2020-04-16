package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

/**
 * Controller for handling button-presses in the scene LogIn.fxml. Each method represent a possible user action.
 * @author Niklas Hultin
 * @version 1.0
 */

public class LogInController extends SceneControllerParent {


    public void skipLogInClicked(ActionEvent actionEvent) {
        boolean answer = mainController.popUpWindow(Alert.AlertType.CONFIRMATION, "Fortsätt utan att logga in?", "Om du inte loggar in eller skapar en användare kommer ingenting att sparas. " +
                "Är du säker på att du vill fortsätta utan att logga in?");
        if (answer){
            //ToDo: Kod för att spela som gäst
            mainController.setScene(ScenesEnum.Home);
        }
    }


    public void logInClicked(ActionEvent actionEvent) {
            //ToDo: Kod för att logga in med befintlig användare
        mainController.setScene(ScenesEnum.Home);
    }

    public void newUserClicked(ActionEvent actionEvent) {
        //ToDO: Kod för att skapa ny användare
        mainController.setScene(ScenesEnum.NewUser);
    }

    public void exitClicked(ActionEvent actionEvent) {
        mainController.closeProgram();
    }
}
