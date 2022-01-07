import oop.ex2.*;
import java.util.Random;

/**
 * This ship has a pilot that had too much to drink.
 * It will have two situations, one being drunk and confuse, and the other running away.
 * In addition, it will turn on and off the shield randomly, and
 * with every action of the shield it will also fire.
 *
 * @author skelner
 */
public class DrunkardShip extends ComputerControlledShip {

    /** Determines the situation, confused or not. */
    private boolean confusion;

    /**
     * Constructor so that every ship will be in other state.
     */
    DrunkardShip() {
        this.confusion = true;
    }

    /**
     * An override method.
     * The method is responsible for the ship's operations.
     * The method will implement according to game rules order.
     *
     * @param game the game object to which this ship belongs.
     */
    @Override
    public void doAction(SpaceWars game) {
        drunkMovement(game);
        super.doAction(game);
    }

    /**
     * The method is responsible for the special operation of each type of ship.
     * In each turn, one percent chance the ship will turn on the shield and
     * will shoot simultaneously. The same goes for shutdown the shield.
     *
     * @param game the game object to which this ship belongs.
     */
    public void mySpecialThing(SpaceWars game) {

        Random rand = new Random();
        int n = rand.nextInt(100); // Random num.

        if (n == 0) { // 1% chance.
            if (this.shield)
                this.shield = false;
            else
                shieldOn();

            fire(game); // Always executed.
        }
     }

    /**
     * the ship will have two situations, one being drunk and confuse, and the other running away.
     * In each turn, 0.5 percent chance the ship will be in or out of confusion.
     * if confusion, The spaceship will not accelerate and spin for no reason.
     * if not, it will run away rom the closest ship.
     *
     * @param game the game object to which this ship belongs.
     */
    private void drunkMovement(SpaceWars game) {

        Random rand = new Random();
        int n = rand.nextInt(200); // Random num.

        if (n == 0)  // 1% chance.
            this.confusion = !this.confusion;

        SpaceShipPhysics currentPhysics = getPhysics();

        if (this.confusion) // How to move the drunk ship according confusion state.
            currentPhysics.move(false, GameRules.LEFT);
        else
            movement(false, game);
        }
}
