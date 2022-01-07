import java.awt.Image;
import java.util.Random;
import oop.ex2.*;

/**
 * This spaceship represents cool Trump.
 * It will have two situations, one being weird, and the other running the USA (very aggressive).
 * In addition, it will turn on the shield and fire simultaneously when other ship nearby only
 * when he is at very aggressive state.
 * more over, As a privilege for being president, cool Trump have
 * 4 times for fire and 4 times regeneration per turn!
 *
 * @author skelner
 */
public class SpecialShip extends ComputerControlledShip {

    /** Determines the situation, weird or not. */
    private boolean weird;

    /**
     * Constructor so that every ship will be in other state.
     */
    SpecialShip() {
        this.weird = true;
    }

    /**
     * this is override for getImage() method.
     * This method should return the image of the ship with or without the shield
     * and in weird state.
     *
     * @return the image of cool Trump.
     */
    @Override
    public Image getImage() {

        if (this.shield)
                return Pictures.COOLTRUMP2;
        else if (this.weird)
                return Pictures.WEIRDTRUMP;
        else
            return Pictures.COOLTRUMP;
    }

    /**
     * An override method.
     * The method is responsible for the ship's operations.
     * The method will implement according to game rules order.
     * cool Trump have 4 times for fire and 4 times regeneration per turn!
     *
     * @param game the game object to which this ship belongs.
     */
    @Override
    public void doAction(SpaceWars game) {
        weirdMovement(game);
        for (int i=0;i<4;i++) // 4 times per turn.
            super.doAction(game);
    }

    /**
     * The method is responsible for the special operation of each type of ship.
     * When its angle to the nearest ship is less than 0.21 radians,
     * When its distance to the nearest ship is less than 0.25,
     * it will try to fire and turn on shield.
     *
     * @param game the game object to which this ship belongs.
     */
    public void mySpecialThing(SpaceWars game) {

        if ((distanceToCloseShip(game) < 0.25) && (!(this.weird)) && (angleToCloseShip(game) < 0.21)){
            shieldOn();
            fire(game);
        }
        else
            this.shield = false;
        }

    /**
     * cool Trump will have two situations, one being weird, and the other very aggressive.
     * In each turn, 1 percent chance the ship will be in or out of weird state.
     * if weird, The spaceship will not accelerate and spin for no reason.
     * if not, it will chase the closest ship.
     *
     * @param game the game object to which this ship belongs.
     */
    private void weirdMovement(SpaceWars game) {

        Random rand = new Random();
        int n = rand.nextInt(100); // Random num.

        if (n == 0) // 1% chance.
            this.weird = !this.weird;

        SpaceShipPhysics currentPhysics = getPhysics();

        if (this.weird) // How to move cool Trump according weired state.
            currentPhysics.move(false, GameRules.RIGHT); // RIGHT - Republican Party.
        else
            movement(true, game);
    }
}