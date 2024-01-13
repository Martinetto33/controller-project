import java.util.Optional;

import controller.api.ControllerAPI;
import controller.api.ControllerInput;
import controller.code.ControllerManager;

/**
 * This is the main class. For now it only executes for 10 seconds and prints on the terminal
 * the inputs it gets from a controller, if any. This program performs polling, so a better
 * version based on listeners should be implemented.
 * 
 * TODO: there's a dead zone that needs to be created, since the axes are detected even with no input
 */
public class App {
    private static final long EXECUTION_TIME = 10_000; // execute for 10 seconds
    public static final void main(String... args) {
        ControllerAPI controller = new ControllerManager();
        final long currentTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - currentTime < App.EXECUTION_TIME) {
            if(controller.isConnected()) {
                if (controller.isInputAvailable()) {
                    final Optional<ControllerInput> input = controller.getInput(); 
                    System.out.println(input.isPresent() ? input.get() : "Received an empty optional...");
                }
            } else {
                controller.connectController();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        System.out.println("Execution ended.");
    }
}
