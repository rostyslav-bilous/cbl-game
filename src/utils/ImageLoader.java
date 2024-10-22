package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
    // Method to load an image from a file path
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path)); // Load the image
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if loading fails
        }
    }
}
