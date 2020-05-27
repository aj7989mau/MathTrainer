package controllers;

import entity.ScenesEnum;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.awt.Color.*;

//Denna är kopplad till GameScene

/**
 * Class GameController that extends SceneControllerParent that handles the game(gamesceens) which is a mathgame that runs on a time schedule
 *
 * @author Johanna Dahlborn
 * @version 1.0
 */
public class GameController extends SceneControllerParent implements InitializeSceneInterface {
    public Label matematicLbl;
    public Label timeremaininglbl;
    public Button quitGame;

    public Label plusLeftLabel;
    public Label plusRightLabel;

    public Label minusLeftLabel;
    public Label minusRightLabel;

    public Label devidedLeftLabel;
    public Label devidedRightLabel;

    public Label plusLbl;
    public Label minusLbl;
    public Label addLbl;
    public Label dividedLbl;
    public Spinner sumPlus;
    public Spinner sumMinus;
    public Button startQuiz;
    public Spinner sumAdd;
    public Spinner sumDivided;

    public Label additionRightLabel;
    public Label additionLeftLabel;


    private final Integer STARTTIME = 60;
    public Label label;
    private Integer timeSeconds = STARTTIME;


    private Random random = new Random();
    private int numb1;
    private int numb2;




    public GameController() {

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

    public void startQuiz() {
        // Fill in the addition problem.
        // Store the values in the variables 'num1' and 'num2'.
        numb1 = random.nextInt(51);
        numb2 = random.nextInt(51);

        // Convert the two randomly generated numbers into strings so that they can be displayed
        // in the label controls.
        plusLeftLabel.setText(String.valueOf(numb1));
        plusRightLabel.setText(String.valueOf(numb2));

        // 'sumplus' is the name of the spinner control.
        // This step makes sure its value is zero before adding any values to it.
        sumPlus.setPromptText("0");
        startQuiz.setDisable(true);

    }
    public void doTime(){
       
        }
    }
}




