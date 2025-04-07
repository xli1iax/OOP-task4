import java.io.File;

public class Main {
    public static void main(String[] args) {
        // TEXT IMAGE
        File inputText = new File("test/text");
        File textLeft = new File("test/text_left");
        File textRight = new File("test/text_right");
        File textSubstituted = new File("test/text_substituted");

        // 1. Создаёшь TextImage из файла
        // 2. Вызываешь rotate(...) и save(...) для left и right
        // 3. substitute('#', '@'), save(...) для substituted


        // RASTER IMAGE
        File inputPng = new File("test/dude.png");
        File rotatedLeft = new File("test/dude_rotated_left.png");
        File rotatedRight = new File("test/dude_rotated_right.png");
        File normalized = new File("test/dude_normalized.png");

        // 1. Создаёшь RasterImage из файла
        // 2. rotate(...) и save(...) для left и right
        // 3. normalize(), потом save(...) для normalized
    }
}
