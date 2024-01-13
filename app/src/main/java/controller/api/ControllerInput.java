package controller.api;

import net.java.games.input.Event;

/**
 * A class modelling the different kinds of inputs that can be received from a controller.
 * TODO: this class should contain all the relevant data about a controller input.
 */

public class ControllerInput {
    
    public enum INPUT_TYPE {
        BUTTON,
        BUMPER, // R1, L1
        TRIGGER, // R2, L2
        LEFT_STICK_MOVEMENT,
        RIGHT_STICK_MOVEMENT,
        DPAD_ARROW;
    }

    /* To be used only for DPAD; I want to handle the sticks inclinations
     * in a more detailed way, allowing for complex values of inclinations and
     * rotations to be recognised.
     */
    public enum DIRECTIONS {
        NORTH,
        SOUTH,
        EAST,
        WEST,
        NORTH_EAST,
        NORTH_WEST,
        SOUTH_EAST,
        SOUTH_WEST;
    }

    private final String name;
    /*private final double value;*/

    /**
     * Class constructor.
     * @param e a {@link net.java.games.input.Event} extracted from the {@link net.java.games.input.EventQueue} of
     * a {@link controller.code.ControllerAPI}.
     */
    public ControllerInput(final Event e) {
        this.name = e.toString();
    }

    public String toString() {
        return this.name;
    }

}
