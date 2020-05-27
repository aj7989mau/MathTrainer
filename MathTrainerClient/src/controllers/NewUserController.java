package controllers;


import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller for handling button-presses in the scene NewUser.fxml. Each method represent a possible user action.
 * @author Niklas Hultin
 * @version 1.0
 */

public class NewUserController extends SceneControllerParent implements InitializeSceneInterface {
    @FXML
    TextField username, school, city;
    @FXML
    PasswordField password, passwordRepeat;
    @FXML
    ChoiceBox year;

    /**
     * Returns to the login scene if the user backs out of creating a new user.
     * @param actionEvent
     */
    public void backClicked(ActionEvent actionEvent){
        mainController.setScene(ScenesEnum.LogIn);
    }

    /**
     * Checks that the values for username and password are reasonable and if so, sends them to the MainController.
     * @param actionEvent
     */
    public void createUserClicked(ActionEvent actionEvent) {
        if (!password.getText().equals(passwordRepeat.getText())) {
            mainController.popUpWindow(Alert.AlertType.ERROR, "Felaktigt lösenord", "Lösenorden du angav stämmer ej överens med varandra");
        } else if (username.getText().length() < 5) {
            mainController.popUpWindow(Alert.AlertType.ERROR, "Användarnamnet är för kort", "Användarnamnet måste vara minst 5 tecken långt");
        } else if (password.getText().length() < 6){
            mainController.popUpWindow(Alert.AlertType.ERROR, "Lösenordet är för kort", "Lösenordet måste vara minst 6 tecken långt");
        } else {
            mainController.newUser(username.getText(), password.getText());
        }
    }

    @Override
    public void setInitialValues(Object object) {
        username.setText("");
        school.setText("");
        city.setText("");
        password.setText("");
        passwordRepeat.setText("");
        year.getSelectionModel().select(0);
    }
}
