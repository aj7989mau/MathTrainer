package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;

/**
 * An abstract class that extends the SceneController, as this too will be used by scene controllers. All Main Menu
 * controllers extend this class. It defines the code for the left menu panel which stays
 * the same until you leave the main menu completely.
 * @author Niklas Hultin
 * @version 1.0
 */

public abstract class MainMenuControllerParent extends SceneControllerParent {

    public void logOutClicked(ActionEvent actionEvent){
        //ToDo: kod för att bli utloggad.
        mainController.setScene(ScenesEnum.LogIn);
    }

    public void homeButtonClicked(ActionEvent actionEvent) {
        //ToDo: kod för hemvyn, t ex ladda hem statistik från servern.
        mainController.setScene(ScenesEnum.Home);
    }

    public void exercisesButtonClicked(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Exercises);
    }

    public void nationalTestButtonClicked(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.NationalTest);
    }

    public void settingsButtonClicked(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Settings);
    }


}
