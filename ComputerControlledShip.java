import java.awt.Image;
import oop.ex2.*;

/**
 * This is an abstract class that responsible for computer-driven spaceship operations.
 * The class is a subsidiary of the spaceship class.
 * The class takes care of make the ships move, adjusting them for same
 * image and arranging their possible operations.
 *
 * @author skelner
 */
public abstract class ComputerControlledShip extends SpaceShip {

    /**
     * Implementing the abstract doAction() method.
     * The method will implement according to game rules order.
     *
     * @param game the game object to which this ship belongs.
     */
    public void doAction (SpaceWars game) {

        mySpecialThing(game); // unique activity
        regeneration(); // regeneration
    }

    /**
     * Implementing the abstract getImage() method.
     * This method should return the image of the ship with or without the shield.
     *
     * @return the image of this ship.
     */
    public Image getImage() {
        if (this.shield)
            return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
        else
            return GameGUI.ENEMY_SPACESHIP_IMAGE;
    }

    /**
     * The method should return the ship's angle to the nearest ship.
     *
     * @param game the game object to which this ship belongs.
     * @return The angle to the closest ship.
     */
    protected double angleToCloseShip(SpaceWars game) {

        SpaceShip closestShip;
        closestShip = game.getClosestShipTo(this);

        // Physical data of both ships.
        SpaceShipPhysics currentPhysics = getPhysics();
        SpaceShipPhysics anotherPhysics = closestShip.getPhysics();

        return currentPhysics.angleTo(anotherPhysics);
    }

    /**
     * The method should return the ship's distance to the nearest ship.
     *
     * @param game the game object to which this ship belongs.
     * @return The distance to the closest ship.
     */
    protected double distanceToCloseShip(SpaceWars game) {

        SpaceShip closestShip;
        closestShip = game.getClosestShipTo(this);

        // Physical data of both ships.
        SpaceShipPhysics currentPhysics = getPhysics();
        SpaceShipPhysics anotherPhysics = closestShip.getPhysics();

        return currentPhysics.distanceFrom(anotherPhysics);
    }

    /**
     * The method is responsible for the movement of the ships.
     * If a true value is entered, the ship should approach the nearest ship.
     * If false, the ship will move away from the nearest ship.
     * The ships always accelerate.
     *
     * @param chase boolian the determine if the ship will
     *               follow the nearest ship or run away from it.
     * @param game the game object to which this ship belongs.
     */
    protected void movement(boolean chase, SpaceWars game) {


        int right = GameRules.RIGHT;
        int left =  GameRules.LEFT;
        int dontTurn = GameRules.DONTTURN;
        double angle;

        // switch between left and right for running away.
        if (!chase) {
            right = GameRules.LEFT;
            left = GameRules.RIGHT;}

        angle = angleToCloseShip(game);
        SpaceShipPhysics currentPhysics = getPhysics();

        // Movement determination.
        if (angle < dontTurn)
            currentPhysics.move(GameRules.ACCELE, right);
        else if (angle > dontTurn)
            currentPhysics.move(GameRules.ACCELE, left);
        else if ((!chase) && (angle == Math.PI || angle == -Math.PI))
            currentPhysics.move(GameRules.ACCELE, dontTurn);
        else
            currentPhysics.move(GameRules.ACCELE, dontTurn);
    }

    /**
     * abstract method That all ships must implement.
     * The method is responsible for the special operation of each type of ship.
     *
     * @param game the game object to which this ship belongs.
     */
    public abstract void mySpecialThing(SpaceWars game);
}
