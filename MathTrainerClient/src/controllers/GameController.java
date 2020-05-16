package controllers;

import entity.ScenesEnum;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

//Denna är kopplad till GameScene

/** Class GameController that extends SceneControllerParent that handles the game(gamesceens) which is a mathgame that runs on a time schedule
 * @author Johanna Dahlborn
 * @version 1.0
 */
public class GameController extends SceneControllerParent implements InitializeSceneInterface  {


    public ChoiceBox answer1;
    public ChoiceBox answer2;
    public ChoiceBox answer3;
    public ChoiceBox answer4;
    public Button timeUpdate;
    public Label timelbl;
    public Button submitAnswer;
    public Label question1;
    public Label question2;
    public Label question3;
    public Label question4;

    public GameController() {
    }

    public void gameTime(){

    }


    public void submitAnswer(){

    }
    public void quitGame(ActionEvent actionEvent) {
        boolean answer = mainController.popUpWindow(Alert.AlertType.CONFIRMATION, "Avsluta?", "Är du säker på att du vill avsluta, dina svar sparas inte");
        if (answer) {
            mainController.setScene(ScenesEnum.Home);
        }
    }

    @java.lang.Override
    public void setInitialValues(Object object) {

    }
}
