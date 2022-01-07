/**
 * A class that defines all information about the rules of the
 * game and defines them as unchangeable and public.
 *
 * @author skelner
 */
public class GameRules {

    // Health rules.
    /** start health level. */
    public static final int HEALTHSTART = 22;
    /** Health damage. */
    public static final int HEALTHDAMAGE = 1;
    /** Death health level. */
    public static final int DEATH = 0;

    // Energy rules.
    /** Max energy level.  */
    public static final int ENERGYMAX = 210;
    /** Start energy level. */
    public static final int ENERGYSTART = 190;
    /** Bashing energy cost. */
    public static final int ENERGYBASHING = 18;
    /** Damage energy cost. */
    public static final int ENERGYDAMAGE = 10;
    /** Fire energy cost. */
    public static final int ENERGYFIRING = 19;
    /** Teleport energy cost. */
    public static final int ENERGYTELEPORTING = 140;
    /** Shield energy cost. */
    public static final int ENERGYSHIELDS = 3;

    // Waiting period per rounds;
    /** Cannot fire for a period of X rounds. */
    public static final int FIRE = 7;

    // Charge per round.
    /** Fire charge per round. */
    public static final int FIRECHARGE = 1;
    /** Energy charge per round. */
    public static final int ENERGYCHARGE = 1;

    // Default state of shield.
    /** state of the shield. */
    public static final boolean SHIELD = false;

    // Associated with spaceship displacement operation
    /** Number for not turning. */
    public static final int DONTTURN = 0;
    /** Number for turning left. */
    public static final int LEFT = 1;
    /** Number for turning right. */
    public static final int RIGHT = -1;
    /** boolean for acceleration. */
    public static final boolean ACCELE = true;
    /** boolean for not acceleration. */
    public static final boolean DONTACCELE = false;
}
