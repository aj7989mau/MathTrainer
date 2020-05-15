package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

//Denna är kopplad till GameScene

/** Class GameController that extends SceneControllerParent that handles the game(gamesceens) which is a mathgame that runs on a time schedule
 * @author Johanna Dahlborn
 * @version 1.0
 */
public class GameController extends SceneControllerParent {


    public void submitAnswer(){

    }
    public void quitGame(ActionEvent actionEvent) {
        boolean answer = mainController.popUpWindow(Alert.AlertType.CONFIRMATION, "Avsluta?", "Är du säker på att du vill avsluta, dina svar sparas inte");
        if (answer) {
            mainController.setScene(ScenesEnum.Home);
        }
    }
}
