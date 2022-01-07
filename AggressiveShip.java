/**
 * This ship pursues other ships and tries to fire at them.
 * It will always accelerate, and turn towards the nearest ship.
 *
 * @author skelner
 */
public class AggressiveShip extends ComputerControlledShip {

    /**
     * An override method.
     * The method is responsible for the ship's operations.
     * The method will implement according to game rules order.
     *
     * @param game the game object to which this ship belongs.
     */
    @Override
    public void doAction(SpaceWars game) {
        movement(true,game); // True as to chase.
        super.doAction(game);
    }

    /**
     * The method is responsible for the special operation of each type of ship.
     * When its angle to the nearest ship is less than 0.21 radians,
     * it will try to fire.
     *
     * @param game the game object to which this ship belongs.
     */
    public void mySpecialThing(SpaceWars game) {
        if (angleToCloseShip(game) < 0.21)
            fire(game);
    }
}
