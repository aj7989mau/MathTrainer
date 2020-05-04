package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for handling button-presses in the scene Home.fxml. Each method represent a possible user action.
 * The controller, as all other controllers that are part of the Main menu, extends the MainMenuControllerParent.
 * @author Niklas Hultin
 * @version 1.0
 */


public class HomeController extends MainMenuControllerParent implements Initializable {

    @FXML
    private Label UserNameLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    void setText(String firstName){
        this.UserNameLabel.setText(firstName);
    }

    public void updateButtonPressed(ActionEvent actionEvent) {
        //ToDo: Kod för att hämta statistik från servern på nytt. Oklart om detta behövs egentligen.
    }

}
