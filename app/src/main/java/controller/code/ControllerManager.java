package controller.code;

import java.util.Optional;

import controller.api.ControllerAPI;
import controller.api.ControllerInput;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Event;

public class ControllerManager implements ControllerAPI {
    private Controller joystick = null;
    private final ControllerEnvironment ce;

    public ControllerManager() {
        this.ce = ControllerEnvironment.getDefaultEnvironment();
        searchController();
    }

    private void searchController() {
        for (final Controller c : this.ce.getControllers()) {
            System.out.println("Detected controller with name: " +
                                  c.getName() +
                                  ", of type: " + 
                                  c.getType().toString());
            if (c.getType() == Controller.Type.GAMEPAD) {
                this.joystick = c;
                break;
            }
        }
        final String controllerDescription = this.isConnected() ? this.joystick.getName() : "null";
        System.out.println("Attached controller: " + controllerDescription);
    }

    @Override
    public void connectController() {
        /* The poll method returns false if the controller
         * is no longer valid.
         */
        if(this.isConnected() && !this.joystick.poll()) {
            this.joystick = null;
            /* Attempt to reconnect... */
            searchController();
            if(this.joystick == null) {
                throw new IllegalStateException("No controller can be found.\n");
            }
        }
    }

    @Override
    public boolean isConnected() {
        return this.joystick != null;
    }

    @Override
    public boolean isInputAvailable() {
        return this.joystick.poll();
    }

    @Override
    public Optional<ControllerInput> getInput() {
        Event e = new Event();
        if (this.joystick.getEventQueue().getNextEvent(e)) {
            return Optional.of(new ControllerInput(e));
        }
        return Optional.empty();
    }

}
