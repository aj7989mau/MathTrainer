package controllers;

import entity.Buffer;
import entity.ScenesEnum;
import entity.ScenesHashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class MainController is created by the Main class. It is the controller of the other controllers. All scene
 * controllers has a reference to this controller to communicate it. NetworkController communicates through the buffers.
 */

public class MainController {
    private Stage window;
    private SceneSetter sceneSetter = new SceneSetter();
    private Buffer<String> incomingBuffer = new Buffer<>(); //Tanken är att denna klass bara ska hämta objekt från denna buffer
    private Buffer<String> outgoingBuffer = new Buffer<>(); //Tanken är att denna klass bara ska lägga in objekt i denna buffer

    /**
     * Starts the network that connects to the server and creates and populates the ScenesHashMap.
     * @param window The main window where the scenes are displayed (received from Main)
     */
    public MainController(Stage window) {
        this.window = window;
        window.setTitle("MathTrainer");
        //new NetworkController(incomingBuffer, outgoingBuffer);

        try {
            sceneSetter.addScenesToHashMap();
        } catch (IOException e) {
            System.out.println("Error loading scenes");
            e.printStackTrace();
        }

        sceneSetter.setScene(ScenesEnum.LogIn);
        window.show();
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

    // Inte helt nöjd med denna lösning, men hittar inget smidigt sätt att annars lista ut vilken scen man ska till
    // när man t ex backar i menyn, så man får helt enkelt skicka med namnet på den scen den ska till.
    public void changeScene(ScenesEnum sceneToShow){
        sceneSetter.setScene(sceneToShow);
    }

    public void newUser(String userInformation){
        //Massa kod för att skapa ny användare här
        sceneSetter.setScene(ScenesEnum.MainMenu);
    }

    /**
     * Inner class SceneSetter handles the Scenes. It loads them, hands over the controllers to the MainController
     * for communication, and handles communication with the ScenesHashmap. It also sets up the current scene.
     */
    private class SceneSetter {
        private ScenesHashMap scenes = new ScenesHashMap();

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

        public void setScene(ScenesEnum sceneName) {
            window.setScene(scenes.get(sceneName));
        }
    }
}