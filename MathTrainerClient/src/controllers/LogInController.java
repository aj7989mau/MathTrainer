package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * Controller for handling button-presses in the scene LogIn.fxml. Each method represent a possible user action.
 * @author Niklas Hultin
 * @version 1.0
 */

public class LogInController extends SceneControllerParent implements InitializeSceneInterface {


    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    private String username, password;


    public void skipLogInClicked(ActionEvent actionEvent) {
        boolean answer = mainController.popUpWindow(Alert.AlertType.CONFIRMATION, "Fortsätt utan att logga in?", "Om du inte loggar in eller skapar en användare kommer ingenting att sparas. " +
                "Är du säker på att du vill fortsätta utan att logga in?");
        if (answer){
            //ToDo: Kod för att spela som gäst
            mainController.skipLogin();
        }
    }

    private void getUserInfo(){
        username = usernameField.getText();
        password = passwordField.getText();
    }

    public void logInClicked(ActionEvent actionEvent) {
        getUserInfo();
        mainController.logIn(username, password);
        //ToDo: Kod för att logga in med befintlig användare
    }



    public void newUserClicked(ActionEvent actionEvent) {
        //ToDO: Kod för att skapa ny användare
        mainController.createNewUser();
    }

    public void exitClicked(ActionEvent actionEvent) {
        mainController.closeProgram();
    }

    @Override
    public void setInitialValues(Object object) {
        usernameField.setText("");
        passwordField.setText("");
    }
}
