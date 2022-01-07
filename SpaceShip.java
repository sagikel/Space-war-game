import java.awt.Image;
import oop.ex2.*;

/**
 * The spaceship object that is used in the SpaceWars game.
 * This is a master class. below it are more specific classes that produce
 * different types of spaceships.
 *  
 * @author skelner
 */
public abstract class SpaceShip{

    private int health;
    private int energy;
    private int energyCurrentMax;
    protected boolean shield; // public just for classes inherit spaceship.
    private int fireTime;
    private SpaceShipPhysics currentSSPhysics;

    /**
     * A constructor that gives each spaceship object features for the game.
     */
    protected SpaceShip() {
        this.health = GameRules.HEALTHSTART;
        this.energy = GameRules.ENERGYSTART;
        this.energyCurrentMax = GameRules.ENERGYSTART;
        this.shield = GameRules.SHIELD;
        this.fireTime = GameRules.FIRE;
        this.currentSSPhysics = new SpaceShipPhysics();
    }

    /**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
    public abstract void doAction(SpaceWars game);

    /**
     * This method is called every time a collision with this ship occurs 
     */
    public void collidedWithAnotherShip(){
        if (this.shield) {
            this.energy = this.energy + GameRules.ENERGYBASHING;
            this.energyCurrentMax = this.energyCurrentMax + GameRules.ENERGYBASHING;
        }
        else
            this.gotHit();
    }

    /** 
     * This method is called whenever a ship has died. It resets the ship's 
     * attributes, and starts it at a new random position.
     */
    public void reset(){
        this.health = GameRules.HEALTHSTART;
        this.energy = GameRules.ENERGYSTART;
        this.energyCurrentMax = GameRules.ENERGYSTART;
        this.shield = GameRules.SHIELD;
        this.fireTime = GameRules.FIRE;
        this.currentSSPhysics = new SpaceShipPhysics();
    }

    /**
     * Checks if this ship is dead.
     * 
     * @return true if the ship is dead. false otherwise.
     */
    public boolean isDead() {
        return this.health <= GameRules.DEATH;
    }

    /**
     * Gets the physics object that controls this ship.
     * 
     * @return the physics object that controls the ship.
     */
    public SpaceShipPhysics getPhysics() {
        return this.currentSSPhysics;
    }

    /**
     * This method is called by the SpaceWars game object when ever this ship
     * gets hit by a shot.
     */
    public void gotHit() {
        int newEnergy;
        if (!this.shield) {
            this.health = this.health - GameRules.HEALTHDAMAGE;
            this.energyCurrentMax = this.energyCurrentMax - GameRules.ENERGYDAMAGE;
            if (this.energyCurrentMax < this.energy) {
                newEnergy = this.energyCurrentMax;
                this.energy = newEnergy;
            }
        }
    }

    /**
     * This method should return the image of the ship with or without the shield.
     * This will be displayed on the GUI at the end of the round.
     */
    public abstract Image getImage();

    /**
     * Attempts to fire a shot.
     *
     * @param game the game object.
     */
    public void fire(SpaceWars game) {
       if (this.fireTime == GameRules.FIRE && this.energy >= GameRules.ENERGYFIRING) {
           this.fireTime = 0;
           this.energy = this.energy - GameRules.ENERGYFIRING;
           game.addShot(this.currentSSPhysics);
       }
    }

    /**
     * Attempts to turn on the shield.
     */
    public void shieldOn() {
        if (this.energy >= GameRules.ENERGYSHIELDS) {
            this.energy = this.energy - GameRules.ENERGYSHIELDS;
            this.shield = true;
        }
        else
            this.shield = false;
    }

    /**
     * Attempts to teleport.
     */
    public void teleport() {
       if (this.energy >= GameRules.ENERGYTELEPORTING) {
           this.energy = this.energy - GameRules.ENERGYTELEPORTING;
           this.currentSSPhysics = new SpaceShipPhysics();
       }
    }

    /**
     * Regeneration of the 1 unit of energy of this round.
     * manage the energy if exceeded the max.
     * Also add 1 to fireTime per round.
     */
    protected void regeneration() {

        int newEnergy;

        // Regeneration of the energy + Compliance with game rules.
        this.energy = this.energy + GameRules.ENERGYCHARGE;
        if (this.energyCurrentMax > GameRules.ENERGYMAX)
            this.energyCurrentMax = GameRules.ENERGYMAX;
        if (this.energy > this.energyCurrentMax) {
            newEnergy = this.energyCurrentMax;
            this.energy = newEnergy;
        }

        // Regeneration of the fire time.
        if (this.fireTime < GameRules.FIRE)
            this.fireTime = this.fireTime + GameRules.FIRECHARGE;
    }
}