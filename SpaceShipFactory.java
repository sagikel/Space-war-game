/**
 * This class has a single static method.
 * It is used by the driver to create all the spaceship objects
 * according to the command line arguments.
 *
 * @author skelner
 */
public class SpaceShipFactory {

    // Defining ships by specific letter.
    /** A letter that represent Human ship. */
    private static final String HUMAN = "h";
    /** A letter that represent Runner ship. */
    private static final String RUNNER = "r";
    /** A letter that represent Basher ship. */
    private static final String BASHER = "b";
    /** A letter that represent Aggressive ship. */
    private static final String AGGRESSIVE = "a";
    /** A letter that represent Drunker ship. */
    private static final String DRUNKAR = "d";
    /** A letter that represent Special ship. */
    private static final String SPECIAL = "s";

    /**
     * Create all the spaceship objects according to the command line arguments
     * to an array.
     *
     * @param args the command line arguments.
     * @return Array of SpaceShip objects or null if the args incorrect.
     */
    public static SpaceShip[] createSpaceShips(String[] args) {

        SpaceShip[] spaceShipsArray = new SpaceShip[args.length]; // New array.
        boolean oneHumanShip = true;
        int counter = 0;

        if (args.length <= 1){ // Not enough arguments.
            return null;}
        else {
            for (String note : args) { // Same for switch.
                if (note.equals(HUMAN) && oneHumanShip) {
                    spaceShipsArray[counter] = new humanControlledShip();
                    oneHumanShip = false;
                    counter++;
                }
                else if (note.equals(RUNNER)) {
                    spaceShipsArray[counter] = new RunnerShip();
                    counter++;
                }
                else if (note.equals(BASHER)) {
                    spaceShipsArray[counter] = new BasherShip();
                    counter++;
                }
                else if (note.equals(AGGRESSIVE)) {
                    spaceShipsArray[counter] = new AggressiveShip();
                    counter++;
                }
                else if (note.equals(DRUNKAR)) {
                    spaceShipsArray[counter] = new DrunkardShip();
                    counter++;
                }
                else if (note.equals(SPECIAL)) {
                    spaceShipsArray[counter] = new SpecialShip();
                    counter++;
                }
                else // A char that doesn't match destroys all.
                    return null;
            }
        }
        return spaceShipsArray;
    }
}

