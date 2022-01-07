import java.awt.Image;
import oop.ex2.*;

/**
 * This class produces a human-controlled spaceship.
 * The class is a subsidiary of the spaceship class.
 * The class takes care of moving the ship, adjusting it for a special
 * image and arranging its possible operations.
 *
 * @author skelner
 */
public class humanControlledShip extends SpaceShip {

    /**
     * Implementing the abstract doAction() method.
     * The method will implement according to rules order.
     *
     * @param game the game object to which this ship belongs.
     */
    public void doAction (SpaceWars game) {
        GameGUI gameGUI = game.getGUI();

        if (gameGUI.isTeleportPressed()) // teleport.
            teleport();

        accelerateAndTurn(gameGUI); // move.

        if (gameGUI.isShieldsPressed()) // shield.
            shieldOn();
        else this.shield = false;

        if (gameGUI.isShotPressed()) // fire.
            fire(game);

        regeneration(); // regeneration.
    }

    /**
     * Implementing the abstract getImage() method.
     * This method should return the image of the ship with or without the shield.
     *
     * @return the image of this ship.
     */
    public Image getImage() {
        if (this.shield)
            return GameGUI.SPACESHIP_IMAGE_SHIELD;
        else
            return GameGUI.SPACESHIP_IMAGE;
        }

    /**
     * Determines the displacement of the probe according to
     * what the user pressed on the keyboard.
     *
     * @param gameGUI the game object to which this ship belongs.
     */
    private void accelerateAndTurn(GameGUI gameGUI) {

        boolean accel;
        int turn;
        SpaceShipPhysics currentPhysics = getPhysics();

        // Turn the ship.
        if (gameGUI.isRightPressed() && gameGUI.isLeftPressed())
            turn = GameRules.DONTTURN;
        else if (gameGUI.isRightPressed())
            turn = GameRules.RIGHT;
        else if (gameGUI.isLeftPressed())
            turn = GameRules.LEFT;
        else
            turn = GameRules.DONTTURN;

        // Accelerate the ship.
        if (gameGUI.isUpPressed())
            accel = GameRules.ACCELE;
        else
            accel = GameRules.DONTACCELE;

        // execution.
        currentPhysics.move(accel, turn);
    }

}
