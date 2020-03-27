package entity;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Class AlertBox is an abstract class with methods that opens a pop-up window that blocks the user from interacting
 * with the window behind it until they have interacted with the AlertBox.
 */

public abstract class AlertBox{
    static boolean choice;

    public static boolean yesNoOption(String title, String message, String yesButtonText, String noButtonText){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label label = new Label(message);

        Button yesButton = new Button(yesButtonText);
        yesButton.setOnAction(e -> {
            choice = true;
            window.close();
        });
        Button noButton = new Button(noButtonText);
        noButton.setOnAction(e -> {
            choice = false;
            window.close();
        });
        window.setOnCloseRequest(e -> {
            choice = false;
            window.close();
        });

        VBox vBox = new VBox();
        vBox.getChildren().add(label);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(15));

        HBox hBox = new HBox();
        hBox.getChildren().addAll(yesButton, noButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        vBox.getChildren().add(hBox);

        Scene scene = new Scene(vBox);
        scene.setUserAgentStylesheet("entity/MathTrainerStylesheet.css");
        window.setScene(scene);
        window.showAndWait();

        return choice;
    }
}
