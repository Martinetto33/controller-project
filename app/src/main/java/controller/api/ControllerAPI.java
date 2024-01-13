package controller.api;

import java.util.Optional;

public interface ControllerAPI {
    
    void connectController();
    
    boolean isConnected();
    
    boolean isInputAvailable();

    Optional<ControllerInput> getInput();

}
