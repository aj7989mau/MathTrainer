package controllers;

import entity.ScenesEnum;
import entity.ScenesHashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import sharedEntities.Questions;

import java.io.IOException;

/**
 * Class MainController is controller of the other controllers. All scene controllers has a reference to this controller
 * to communicate with it. NetworkController communicates with it through the buffers. In this class, only the general
 * and recurring logic is handled, such as setting scenes (inner class), pop-up windows and closing the program.
 * @author Niklas Hultin
 * @version 1.0
 */

public class MainController {
    private Stage mainWindow;

    private SceneSetter sceneSetter = new SceneSetter();
    private NetworkController networkController;
    private QuizController quizController;

    /**
     * Starts the network that connects to the server and creates and populates the ScenesHashMap.
     * It also sets up the window with the correct information for the start screen.
     * @param mainWindow The main window where the scenes are displayed (received from Main)
     */
    public MainController(Stage mainWindow) {
        this.mainWindow = mainWindow;

         networkController = new NetworkController();

        try {
            sceneSetter.addScenesToHashMap();
        } catch (IOException e) {
            System.out.println("Error loading scenes");
            e.printStackTrace();
        }


        mainWindow.setOnCloseRequest(e -> {//Denna metod bestämmer vad som händer när man trycker på krysset i fönstret.
            e.consume();                //Detta stoppar close-eventen (consume) och skickar istället programmet till
            closeProgram();             //metoden closeProgram() som finns längre ner. Den skapar en confirmation ruta.
        });
        this.mainWindow.setTitle("MathTrainer");
        sceneSetter.setScene(ScenesEnum.LogIn);
        this.mainWindow.show();
    }

    /**
     * Uses the interface SceneControllerParent (used by all Scene-controllers) to send itself to the scene-controller for
     * the FXML-file loaded in to the FXMLLoader. This gives the Scene-controllers a reference to this MainController.
     * @param loader The loader for a specific FXML-file. This gives access to that files specified controller.
     */
    public void sendSelfToControllers(FXMLLoader loader) {
        ((SceneControllerParent) loader.getController()).setMainController(this);
    }

    /**
     * Changes the current scene that is being displayed on the Stage.
     * @param sceneToShow The ScenesEnum-name of the Scene that should be displayed.
     */
    public void setScene(ScenesEnum sceneToShow){
        sceneSetter.setScene(sceneToShow);
    }

    /**
     * Uses a static class Alarm to create Pop-Up boxes. The box will be the only interactive object until it has been
     * handled by the user. The code is only made for using the AlertTypes Confirm (Yes/no-option) and Error (Only OK).
     * @param alertType The type of box. Confirm gives a box with OK and Cancel buttons. Error only gives an OK button.
     * @param title The title of the pop-up window
     * @param message The message shown in the pop-up window.
     * @return Returns true if the user pressed the OK button, otherwise returns false. The return value is not always
     * useful (the Error Pop-Up only has one option, for example) and it is up to the developer to handle it correctly.
     */
    public boolean popUpWindow (Alert.AlertType alertType, String title, String message){
        boolean choice = false;

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        if (alert.showAndWait().get().equals(ButtonType.OK)){
            choice = true;
        }
        return choice;
    }

    /**
     * This method is used both when the user hits the button to close to program, and if the user tries to shut down
     * the program using the standard close option in the OS (for example: X in the top right corner of the window).
     */
    public void closeProgram(){
        boolean answer = popUpWindow(Alert.AlertType.CONFIRMATION, "Avsluta?", "Är du säker på att du vill avsluta MathTrainer?");
        if (answer){
            mainWindow.close();
        }
    }


public void LogIn(String firstName, String Password){

//TODO Skicka till nätverket buffer
// och vänta svar från mainmenuscene

}
    /**
     * Method is used to pass object of questions to network Controller.
     * @param Quiz The quiz String that is used to send it to the neworkController
     */

    public void QuizTest(String Quiz){


        java.lang.Object object = networkController.SendRequest(Quiz);
        if (object instanceof Questions[]) {
            quizController.setQuestion((Questions[]) object);
            setScene(ScenesEnum.Quiz);
           quizController.initializeValues();

        } else{

            popUpWindow(Alert.AlertType.ERROR, "Error" , (String) object);
        }
}

    /**
     * Inner class SceneSetter handles the Scenes. It loads them, hands over the controllers to the MainController
     * for communication, and handles communication with the ScenesHashmap. It also sets up the current scene.
     */
    private class SceneSetter {
        private ScenesHashMap scenes = new ScenesHashMap();

        /**
         * Loads the scenes and adds every fxml-scene to the HashMap with the corresponding ScenesEnum-name.
         * @throws IOException
         */
        private void addScenesToHashMap() throws IOException {
            FXMLLoader logInLoader = new FXMLLoader(getClass().getResource("../scenes/LogIn.fxml"));
            Scene logInScene = new Scene(logInLoader.load());
            sendSelfToControllers(logInLoader);

            FXMLLoader newUserLoader = new FXMLLoader(getClass().getResource("../scenes/NewUser.fxml"));
            Scene newUserScene = new Scene(newUserLoader.load());
            sendSelfToControllers(newUserLoader);

            FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("../scenes/mainMenu/Home.fxml"));
            Scene homeScene = new Scene(homeLoader.load());
            sendSelfToControllers(homeLoader);

            FXMLLoader exercisesLoader = new FXMLLoader(getClass().getResource("../scenes/mainMenu/Exercises.fxml"));
            Scene exercisesScene = new Scene(exercisesLoader.load());
            sendSelfToControllers(exercisesLoader);

            FXMLLoader quizLoader = new FXMLLoader(getClass().getResource("../scenes/mainMenu/Quiz.fxml"));
            Scene quizScene = new Scene(quizLoader.load());
            quizController = quizLoader.getController();
            sendSelfToControllers(quizLoader);

            FXMLLoader quizCompletedLoader = new FXMLLoader(getClass().getResource("../scenes/mainMenu/QuizCompleted.fxml"));
            Scene quizCompletedScene = new Scene(quizCompletedLoader.load());
            QuizCompletedController quizCompleteController = quizCompletedLoader.getController();
            quizController.setQuizCompleteController(quizCompleteController);
            sendSelfToControllers(quizCompletedLoader);

            FXMLLoader nationalTestLoader = new FXMLLoader(getClass().getResource("../scenes/mainMenu/NationalTest.fxml"));
            Scene nationalTestScene = new Scene(nationalTestLoader.load());
            sendSelfToControllers(nationalTestLoader);

            FXMLLoader settingsLoader = new FXMLLoader(getClass().getResource("../scenes/mainMenu/Settings.fxml"));
            Scene settingsScene = new Scene(settingsLoader.load());
            sendSelfToControllers(settingsLoader);


            scenes.put(ScenesEnum.LogIn, logInScene);
            scenes.put(ScenesEnum.NewUser, newUserScene);
            scenes.put(ScenesEnum.Home, homeScene);
            scenes.put(ScenesEnum.Exercises, exercisesScene);
            scenes.put(ScenesEnum.Quiz, quizScene);
            scenes.put(ScenesEnum.QuizCompleted, quizCompletedScene);
            scenes.put(ScenesEnum.NationalTest, nationalTestScene);
            scenes.put(ScenesEnum.Settings, settingsScene);
        }

        /**
         * Sets the current scene in the main window.
         * @param sceneName The ScenesEnum name of the scene you want displayed.
         */
        public void setScene(ScenesEnum sceneName) {
            if (scenes.get(sceneName) != mainWindow.getScene())
            mainWindow.setScene(scenes.get(sceneName));
        }
    }
}