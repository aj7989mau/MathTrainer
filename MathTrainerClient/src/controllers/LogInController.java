package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controller for handling button-presses in the scene LogIn.fxml. Each method represent a possible user action.
 * @author Niklas Hultin
 * @version 1.0
 */

public class LogInController extends SceneControllerParent {



    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;


    public void skipLogInClicked(ActionEvent actionEvent) {
        boolean answer = mainController.popUpWindow(Alert.AlertType.CONFIRMATION, "Fortsätt utan att logga in?", "Om du inte loggar in eller skapar en användare kommer ingenting att sparas. " +
                "Är du säker på att du vill fortsätta utan att logga in?");
        if (answer){
            //ToDo: Kod för att spela som gäst
            mainController.setScene(ScenesEnum.Home);
        }
    }

    private void UserNameInfo(){
        String firstName = usernameField.getText();
        String password = passwordField.getText();
    }

    public void logInClicked(ActionEvent actionEvent) {
            //ToDo: Kod för att logga in med befintlig användare
        String firstName = usernameField.getText();
        String password = passwordField.getText();
        mainController.setScene(ScenesEnum.Home);


// String användarman = textfield.gettext
// användarnamn i metod i maincontroller som tar emot parameter och lösenord , och skicka till buffern

    }



    public void newUserClicked(ActionEvent actionEvent) {
        //ToDO: Kod för att skapa ny användare
        mainController.setScene(ScenesEnum.NewUser);
    }

    public void exitClicked(ActionEvent actionEvent) {
        mainController.closeProgram();
    }
}
