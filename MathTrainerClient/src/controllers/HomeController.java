package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sharedEntities.User;

/**
 * Controller for handling button-presses in the scene Home.fxml. Each method represent a possible user action.
 * The controller, as all other controllers that are part of the Main menu, extends the MainMenuControllerParent.
 * @author Niklas Hultin
 * @version 1.0
 */


public class HomeController extends MainMenuControllerParent implements InitializeSceneInterface {

    @FXML
    Label welcomeLabel;

    @Override
    public void setInitialValues(Object object) {
        if(object != null) {
            User user = (User) object;
            welcomeLabel.setText("Välkommen " + user.getUserName());
            //ToDo: Kod för statistiken osv
        } else {
            welcomeLabel.setText("Välkommen ");
        }
    }
}
