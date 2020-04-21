package controllers;


import entity.ScenesEnum;
import javafx.event.ActionEvent;

/**
 * Controller for handling button-presses in the scene NewUser.fxml. Each method represent a possible user action.
 * @author Niklas Hultin
 * @version 1.0
 */

public class NewUserController extends SceneControllerParent {

    public void backClicked(ActionEvent actionEvent){
        mainController.setScene(ScenesEnum.LogIn);
    }

    public void continueClicked(ActionEvent actionEvent){
        //ToDo: Kod här för att skapa användaren.
        mainController.setScene(ScenesEnum.Home);
    }


}
