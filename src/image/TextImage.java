package image;


import manipulation.Rotatable;
import manipulation.Substitutable;

/**
 * This class represents a textual image, for instance ascii art.
 * It implements {@link Substitutable}, {@link Rotatable} and {@link Savable}.
 */
public class TextImage {
    /**
     * Construct a TextImage from the specified text file.
     * @param imagePath path to the text file to load
     * @throws IllegalArgumentException if the imagePath is invalid or the file is empty.
     */
    public TextImage(String imagePath) {
    }

    /**
     * Get the image.
     * @return image
     */
    public char[][] getImage() {
        // todo implement and remove UnsupportedOperationException
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get the image's width.
     * @return width
     */
    public int getWidth() {
        // todo implement and remove UnsupportedOperationException
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get the image's height.
     * @return height
     */
    public int getHeight() {
        // todo implement and remove UnsupportedOperationException
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get the character at the specified coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the symbol at the position (x, y)
     * @throws IllegalArgumentException if the coordinates are out of bounds
     */
    public char getSymbol(int x, int y) {
        // todo implement and remove UnsupportedOperationException
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
