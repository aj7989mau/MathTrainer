package controllers;

/**
 * An interface that all scene Controllers will implement, so that they can easily communicate with the MainController
 */

public abstract class ControllerParent {
    protected MainController mainController;

    public void setMainController(MainController mainController){
           this.mainController = mainController;
    }
}
