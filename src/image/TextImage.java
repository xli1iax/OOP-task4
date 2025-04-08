package image;


import manipulation.Rotatable;
import manipulation.RotationDirection;
import manipulation.Substitutable;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * This class represents a textual image, for instance ascii art.
 * It implements {@link Substitutable}, {@link Rotatable} and {@link Savable}.
 */
public class TextImage implements Rotatable, Substitutable {
    /**
     * Construct a TextImage from the specified text file.
     * @param imagePath path to the text file to load
     * @throws IllegalArgumentException if the imagePath is invalid or the file is empty.
     */

    private char[][] image;
    public TextImage(String imagePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(imagePath));

        while (! lines.isEmpty() && lines.get(lines.size() - 1).trim().isEmpty()) {
            lines.remove(lines.size() - 1);
        }

        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        image = new char[lines.size()][maxLength];

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < maxLength; j++) {
                if (j < line.length()) {
                    image[i][j] = line.charAt(j);
                } else {
                    image[i][j] = ' ';
                }
            }
        }
    }

    /**
     * Get the image.
     * @return image
     */
    public char[][] getImage() {
        return image;
    }

    /**
     * Get the image's width.
     * @return width
     */
    public int getWidth() {
        return image.length > 0 ? image[0].length : 0;
    }

    /**
     * Get the image's height.
     * @return height
     */
    public int getHeight() {
        return image.length;
    }

    /**
     * Get the character at the specified coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the symbol at the position (x, y)
     * @throws IllegalArgumentException if the coordinates are out of bounds
     */
    public char getSymbol(int x, int y) {
        if (y < 0 || y >= getHeight() || x < 0 || x >= getWidth()) {
            throw new IllegalArgumentException("Coordinates out of bounds: (" + x + ", " + y + ")");
        }
        return image[y][x];
    }

    @Override
    public void rotate(RotationDirection direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Rotation direction cannot be null");
        }

        int rows = image.length;
        int cols = image[0].length;
        char[][] rotated;

        if (direction == RotationDirection.RIGHT) {
            rotated = new char[cols][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    rotated[j][rows - 1 - i] = image[i][j];
                }
            }
        } else if (direction == RotationDirection.LEFT) {
            rotated = new char[cols][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    rotated[cols - 1 - j][i] = image[i][j];
                }
            }
        } else {
            throw new IllegalArgumentException("Unknown rotation direction: " + direction);
        }

        image = rotated;
    }


    @Override
    public void substituteSymbol(char oldSymbol, char newSymbol) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == oldSymbol) {
                    image[i][j] = newSymbol;
                }
            }
        }
    }

}
