package controllers;

import entity.Buffer;
import entity.ScenesEnum;
import entity.ScenesHashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class MainController is created by the Main class. It is the controller of the other controllers. All scene
 * controllers has a reference to this controller to communicate with it. NetworkController communicates through the buffers.
 * @author Niklas Hultin
 * @version 1.0
 */

public class MainController {
    private Stage mainWindow;
    private SceneSetter sceneSetter = new SceneSetter();
    private Buffer<String> incomingBuffer = new Buffer<>(); //Tanken är att denna klass bara ska hämta objekt från denna buffer
    private Buffer<String> outgoingBuffer = new Buffer<>(); //Tanken är att denna klass bara ska lägga in objekt i denna buffer

    /**
     * Starts the network that connects to the server and creates and populates the ScenesHashMap.
     * It also sets up the window with the correct information for the start screen.
     * @param mainWindow The main window where the scenes are displayed (received from Main)
     */
    public MainController(Stage mainWindow) {
        this.mainWindow = mainWindow;
        mainWindow.setTitle("MathTrainer");
        mainWindow.setOnCloseRequest(e -> { //Detta stoppar close eventen (consume) och skickar istället programmet till
            e.consume();                //metoden closeProgram() som finns längre ner. Den skapar en confirmation ruta.
            closeProgram();
        });
        //new NetworkController(incomingBuffer, outgoingBuffer);

        try {
            sceneSetter.addScenesToHashMap();
        } catch (IOException e) {
            System.out.println("Error loading scenes");
            e.printStackTrace();
        }

        sceneSetter.setScene(ScenesEnum.LogIn);
        mainWindow.show();
    }

    public void sendSelfToControllers(FXMLLoader loader) {
        ((ControllerParent) loader.getController()).setMainController(this);
    }

    public void logIn(String username, String password) {
        if (username.equals("Guest")){
            //Kod för att spela som gäst
        }
        else {
            //Kod för att logga in
        }
        sceneSetter.setScene(ScenesEnum.MainMenu);
    }

    public void logOut(){
        //Kod för utloggning
        sceneSetter.setScene(ScenesEnum.LogIn);
    }

    // Inte helt nöjd med denna lösning, vi får nog göra om sen så varje action som görs (eller knapp som klickas på)
    // kallar på någon metod i maincontrollern, och i varje metod sätts scenen baserat på utfall.
    public void changeScene(ScenesEnum sceneToShow){
        sceneSetter.setScene(sceneToShow);
    }

    public void newUser(String userInformation){
        //Massa kod för att skapa ny användare här
        sceneSetter.setScene(ScenesEnum.MainMenu);
    }

    // Har ersatt egen alertbox med detta. Mycket smidigare. Använd bara Alerttype Confirm och Error för enkelhetens skull.
    // Om Error används behöver ni troligtvis inte göra något av denna return boolean sen.
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

    public void closeProgram(){
        boolean answer = popUpWindow(Alert.AlertType.CONFIRMATION, "Avsluta?", "Är du säker på att du vill avsluta MathTrainer?");
        if (answer){
            mainWindow.close();
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

            FXMLLoader mainMenuLoader = new FXMLLoader(getClass().getResource("../scenes/MainMenu.fxml"));
            Scene mainMenuScene = new Scene(mainMenuLoader.load());
            sendSelfToControllers(mainMenuLoader);

            FXMLLoader newUserLoader = new FXMLLoader(getClass().getResource("../scenes/NewUser.fxml"));
            Scene newUserScene = new Scene(newUserLoader.load());
            sendSelfToControllers(newUserLoader);

            scenes.put(ScenesEnum.LogIn, logInScene);
            scenes.put(ScenesEnum.MainMenu, mainMenuScene);
            scenes.put(ScenesEnum.NewUser, newUserScene);
        }

        /**
         * Sets the current scene in the main window.
         * @param sceneName The ScenesEnum name of the scene you want displayed.
         */
        public void setScene(ScenesEnum sceneName) {
            mainWindow.setScene(scenes.get(sceneName));
        }
    }
}