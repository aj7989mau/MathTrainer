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

    public void backClicked(ActionEvent actionEvent){
        mainController.setScene(ScenesEnum.LogIn);
    }

    public void createUserClicked(ActionEvent actionEvent) {
        if (password.getText().equals(passwordRepeat.getText())) {
            mainController.newUser(username.getText(), password.getText());
        } else {
            mainController.popUpWindow(Alert.AlertType.ERROR, "Felaktigt lösenord", "Lösenorden du angav stämmer ej överens med varandra");
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
