/**
 * This spaceship attempts to run away from the fight.
 * It will always accelerate, and will constantly turn away from the closest ship.
 *
 * @author skelner
 */
public class RunnerShip extends ComputerControlledShip {

    /**
     * An override method.
     * The method is responsible for the ship's operations.
     * The method will implement according to game rules order.
     *
     * @param game the game object to which this ship belongs.
     */
    @Override
    public void doAction(SpaceWars game) {

        // Different from the others because the teleport must be done before moving.
        mySpecialThing(game);
        movement(false, game); // False as to run away.
        regeneration();
    }

    /**
     * The method is responsible for the special operation of each type of ship.
     * If the nearest ship is closer than 0.25 units, and if its angle to
     * the Runner is less than 0.23 radians, the Runner feels threatened and
     * will attempt to teleport.
     *
     * @param game the game object to which this ship belongs.
     */
    public void mySpecialThing(SpaceWars game) {
        if ((angleToCloseShip(game) < 0.23) && (distanceToCloseShip(game) < 0.25))
            teleport();
    }
}