package controllers;

/**
 * An interface that all scene-controllers will implement, so that they can easily communicate with the MainController
 * @author Niklas Hultin
 * @version 1.0
 */

public abstract class ControllerParent {
    protected MainController mainController;

    public void setMainController(MainController mainController){
           this.mainController = mainController;
    }
}
