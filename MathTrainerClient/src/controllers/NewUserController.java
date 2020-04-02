package controllers;


import entity.ScenesEnum;
import javafx.event.ActionEvent;

/**
 * Controller for handling button-presses in the scene NewUser.fxml. Each method represent a possible user action.
 * @author Niklas Hultin
 * @version 1.0
 */

public class NewUserController extends ControllerParent {

    public void backClicked(ActionEvent actionEvent){
        mainController.changeScene(ScenesEnum.LogIn);
    }

    public void continueClicked(ActionEvent actionEvent){
        //Behövs massa kod här för att skapa användaren. Kanske ej bör kalla nästa scen härifrån men gör det nu som test.
        mainController.newUser("All information från fälten ska in här");
    }


}
