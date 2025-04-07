package image;

import manipulation.RotationDirection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class TextImageTest {

    TextImage cooked;
    TextImage cooked_left;
    TextImage cooked_right;

    @BeforeEach
    void setUp() {
        cooked = new TextImage("text");
        cooked_left = new TextImage("text_left");
        cooked_right = new TextImage("text_right");
    }

    @Test
    void getWidth() throws IOException {
        Files.readAllLines(Paths.get("text")).stream()
                .mapToInt(String::length)
                .max()
                .ifPresent(width -> assertEquals(width, cooked.getWidth()));
    }

    @Test
    void getHeight() throws IOException {
        assertEquals(Files.readAllLines(Paths.get("text")).size(), cooked.getHeight());
    }

    @Test
    void getSymbol() {
        assertThrows(IllegalArgumentException.class, () -> cooked.getSymbol(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> cooked.getSymbol(0, -1));
        assertThrows(IllegalArgumentException.class, () -> cooked.getSymbol(cooked.getWidth(), 0));
        assertThrows(IllegalArgumentException.class, () -> cooked.getSymbol(0, cooked.getHeight()));
    }

    @Test
    void rotate() {
        assertThrows(IllegalArgumentException.class, () -> cooked.rotate(null));
        cooked.rotate(RotationDirection.LEFT);
        assertEquals(cooked.getWidth(), cooked_left.getWidth());
        assertEquals(cooked.getHeight(), cooked_left.getHeight());
        for (int i = 0; i < cooked.getHeight(); i++) {
            assertArrayEquals(cooked.getImage()[i], cooked_left.getImage()[i]);
        }

        cooked.rotate(RotationDirection.RIGHT);
        cooked.rotate(RotationDirection.RIGHT);
        assertEquals(cooked.getWidth(), cooked_right.getWidth());
        assertEquals(cooked.getHeight(), cooked_right.getHeight());
        for (int i = 0; i < cooked.getHeight(); i++) {
            assertArrayEquals(cooked.getImage()[i], cooked_right.getImage()[i]);
        }
    }
}