package controllers;

import entity.ScenesEnum;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Random;
import java.util.Timer;


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
    public Label countdownLabel = new Label();
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
    public Button startQuiz = new Button();
    public Spinner sumAdd;
    public Spinner sumDivided;

    public Label additionRightLabel;
    public Label additionLeftLabel;

    private Random random = new Random();
    private int numb1;
    private int numb2;
    private int numb3;
    private int numb4;
    private int numb5;
    private int numb6;
    private int numb7;
    private int numb8;

    // private class constant and some variables
    private static final Integer STARTTIME = 60;
    private Timeline timeline;
    private Integer timeSeconds = STARTTIME;


    public GameController() {

    }


    public void quitGame(ActionEvent actionEvent) {
        boolean answer = mainController.popUpWindow(Alert.AlertType.CONFIRMATION, "Avsluta?", "Är du säker på att du vill avsluta, dina svar sparas inte");
        if (answer) {
            mainController.setScene(ScenesEnum.Exercises);

            startQuiz.setDisable(false);
        }
    }

    @java.lang.Override
    public void setInitialValues(Object object) {

    }

    public void startQuiz() {
        // Fill in the addition problem.
        // Store the values in the variables 'num1' and 'num2'.
        numb1 = random.nextInt(49);
        numb2 = random.nextInt(49);

        // Convert the two randomly generated numbers into strings so that they can be displayed
        // in the label controls.
        plusLeftLabel.setText(String.valueOf(numb1));
        plusRightLabel.setText(String.valueOf(numb2));

        numb3 = random.nextInt(49);
        numb4 = random.nextInt(49);

        minusLeftLabel.setText(String.valueOf(numb3));
        minusRightLabel.setText(String.valueOf(numb4));

        numb5 = random.nextInt(49);
        numb6 = random.nextInt(49);

        additionLeftLabel.setText(String.valueOf(numb5));
        additionRightLabel.setText(String.valueOf(numb6));

        numb7 = random.nextInt(49);
        numb8 = random.nextInt(49);

        devidedLeftLabel.setText(String.valueOf(numb7));
        devidedRightLabel.setText(String.valueOf(numb8));

        // 'sumplus' is the name of the spinner control.
        // This step makes sure its value is zero before adding any values to it. And you can choose from 0-1000
        SpinnerValueFactory<Integer> sumValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0);
        this.sumPlus.setValueFactory(sumValue);

        SpinnerValueFactory<Integer> sumMinus = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0);
        this.sumMinus.setValueFactory(sumMinus);

        SpinnerValueFactory<Integer> sumAdd = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0);
        this.sumAdd.setValueFactory(sumAdd);

        SpinnerValueFactory<Integer> sumDivided = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0);
        this.sumDivided.setValueFactory(sumDivided);

        startQuiz.setDisable(true);


        // Configure the Label
        countdownLabel.setText(timeSeconds.toString());
        //timerLabel.setTextFill(Color.RED);
        //timerLabel.setStyle("-fx-font-size: 4em;");
        if (timeline != null) {
            timeline.stop();
        }
        timeSeconds = STARTTIME;

        // update timerLabel
        countdownLabel.setText(timeSeconds.toString());
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler() {

                            @Override
                            public void handle(Event event) {
                                timeSeconds--;
                                // update timerLabel
                                countdownLabel.setText(
                                        timeSeconds.toString());
                                if (timeSeconds <= 0) {
                                    timeline.stop();
                                    showAlert();

                                    //System.out.println("Tiden är ute");
                                }
                            }
                        }));
        timeline.playFromStart();
    }
    public void showAlert() {
        Platform.runLater(new Runnable() {
            public void run() {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Gameover");
                alert.setHeaderText("Tiden är ute, men försök en gång till!");
                alert.showAndWait();
            }
        });
    }
}




