/**
 * This ship attempts to collide with other ships.
 * It will always accelerate, and will constantly turn towards the closest ship.
 *
 * @author skelner
 */
public class BasherShip extends ComputerControlledShip {

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
     * If it gets within a distance of 0.19 units (inclusive) from another ship,
     * it will attempt to turn on its shields.
     *
     * @param game the game object to which this ship belongs.
     */
    public void mySpecialThing(SpaceWars game) {
        if (distanceToCloseShip(game) < 0.19)
            shieldOn();
        else
            this.shield = false;
    }
}
