package controllers;


import entity.ScenesEnum;
import javafx.event.ActionEvent;

/**
 * Controller for the scene NewUser.fxml
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
