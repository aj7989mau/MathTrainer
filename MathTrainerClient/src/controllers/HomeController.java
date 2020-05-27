package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import sharedEntities.User;

/**
 * Controller for handling button-presses in the scene Home.fxml. It contains only a method to initialize correct values.
 * The controller, as all other controllers that are part of the Main menu, extends the MainMenuControllerParent.
 * @author Niklas Hultin
 * @version 1.0
 */
public class HomeController extends MainMenuControllerParent implements InitializeSceneInterface {

    @FXML
    Label welcomeLabel;
    @FXML
    ProgressBar pbAllCategories;
    @FXML
    ProgressBar pbGeometry;
    @FXML
    ProgressBar pbStatistics;
    @FXML
    ProgressBar pbCounting;
    @FXML
    ProgressBar pbPlaceholder;

    private User user;
    private int[] results;

    @Override
    public void setInitialValues(Object object) {
        if(object != null) {
            user = (User) object;
            welcomeLabel.setText("Välkommen " + user.getUserName());
            results = user.getResults();

            int total = 0;
            for (int result : results){
                total += result;
            }

            pbCounting.setProgress((double) results[0]/10);
            pbStatistics.setProgress((double) results[1]/10);
            pbPlaceholder.setProgress((double) results[2]/10);
            pbGeometry.setProgress((double) results[3]/10);
            pbAllCategories.setProgress((double) total/40);

        } else {
            welcomeLabel.setText("Välkommen ");
        }
    }
}
