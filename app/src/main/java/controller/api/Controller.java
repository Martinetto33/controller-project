package controller.api;

public interface Controller {
    
    void connectController();
    
    boolean isControllerConnected();
    
    boolean isInputAvailable();

    ControllerInput getInput();

}
