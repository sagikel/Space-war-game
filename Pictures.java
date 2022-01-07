import javax.swing.*;
import java.awt.*;

/**
 * This class should upload the png files that is the image of the special ship.
 * it is copy paste from GameGUI - BECAUSE GameGUI is mostly private.
 */
public class Pictures {

    /** The image of the human player's spaceship */
    public static final Image COOLTRUMP = createImageIcon("cool Trump.png", "");

    /** The image of the human player's spaceship */
    public static final Image COOLTRUMP2 = createImageIcon("cool Trump with shield.png", "");

    /** The image of the human player's spaceship */
    public static final Image WEIRDTRUMP = createImageIcon("weird Trump.png", "");

    /** The size of the area the game occurs in. */
    private static final int DISPLAY_SIZE = 700;

    /** The panel the game is drawn in. */
    private Pictures _panel;

    /**
     * A constructor. Copy from GameGUI !
     */
    public Pictures(int displaySize){
        _panel = new Pictures(DISPLAY_SIZE);
    }

    /**
     * Copy from GameGUI !
     * Get the Image Icon from the given path (relative to the source code)
     *
     * @param path the relative path to the image file.
     * @param description A description of the file.
     * @return the icon with the image.
     */
    private static Image createImageIcon(String path, String description) {
        java.net.URL imgURL = Pictures.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description).getImage();
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
