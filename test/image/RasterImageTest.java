package image;

import manipulation.RotationDirection;
import org.junit.jupiter.api.BeforeEach;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class RasterImageTest {

    RasterImage dude;
    RasterImage dudeLeft;
    RasterImage dudeRight;

    @BeforeEach
    void setUp() {
        dude = new RasterImage("dude.png");
        dudeLeft = new RasterImage("dude_rotated_left.png");
        dudeRight = new RasterImage("dude_rotated_right.png");
    }

    @org.junit.jupiter.api.Test
    void getImage() throws IOException {
        FileInputStream fis = new FileInputStream("dude.png");
        BufferedImage tmpImage = ImageIO.read(fis);
        BufferedImage image = dude.getImage();
        assertEquals(image.getWidth(), tmpImage.getWidth());
        assertEquals(image.getHeight(), tmpImage.getHeight());
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int rgb1 = tmpImage.getRGB(i, j) & 0x00ffffff;
                int rgb2 = image.getRGB(i, j) & 0x00ffffff;
                assertEquals(rgb1, rgb2);
            }
        }
    }

    @org.junit.jupiter.api.Test
    void rotate() {
        assertThrows(IllegalArgumentException.class, () -> dude.rotate(null));
        dude.rotate(RotationDirection.LEFT);
        assertEquals(dudeLeft.getImage().getWidth(), dude.getImage().getWidth());
        assertEquals(dudeLeft.getImage().getHeight(), dude.getImage().getHeight());
        for (int i = 0; i < dudeLeft.getImage().getWidth(); i++) {
            for (int j = 0; j < dudeLeft.getImage().getHeight(); j++) {
                assertEquals(dudeLeft.getImage().getRGB(i, j), dude.getImage().getRGB(i, j));
            }
        }

        dude.rotate(RotationDirection.RIGHT);
        dude.rotate(RotationDirection.RIGHT);
        assertEquals(dudeRight.getImage().getWidth(), dude.getImage().getWidth());
        assertEquals(dudeRight.getImage().getHeight(), dude.getImage().getHeight());
        for (int i = 0; i < dudeRight.getImage().getWidth(); i++) {
            for (int j = 0; j < dudeRight.getImage().getHeight(); j++) {
                assertEquals(dudeRight.getImage().getRGB(i, j), dude.getImage().getRGB(i, j));
            }
        }
    }

    @org.junit.jupiter.api.Test
    void save() throws IOException {
        dude.save("dude2.png");
        RasterImage dude2 = new RasterImage("dude2.png");
        assertEquals(dude.getImage().getWidth(), dude2.getImage().getWidth());
        assertEquals(dude.getImage().getHeight(), dude2.getImage().getHeight());
        for (int i = 0; i < dude2.getImage().getWidth(); i++) {
            for (int j = 0; j < dude2.getImage().getHeight(); j++) {
                assertEquals(dude.getImage().getRGB(i, j), dude2.getImage().getRGB(i, j));
            }
        }
        Files.delete(Paths.get("dude2.png"));
    }
}