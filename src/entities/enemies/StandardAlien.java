package entities.enemies;

import entities.Enemy;
import java.awt.*;
import java.awt.image.BufferedImage;
import utils.ImageLoader;

public class StandardAlien extends Enemy {

    public static final int DEFAULT_HEALTH = 40;
    public static final int DEFAULT_DAMAGE = 10;
    public static final int DEFAULT_ATTACK_SPEED = 60;
    public static final int DEFAULT_MOVEMENT_SPEED = 1;

    // Store the StandardAlien image
    private BufferedImage alienImage;

    // Offset variables to adjust the position
    private static final int OFFSET_X = -5;   // Move slightly to the left
    private static final int OFFSET_Y = -10;  // Move slightly higher

    public StandardAlien(int x, int y) {
        super(x, y, 95, 95, DEFAULT_HEALTH, DEFAULT_DAMAGE, DEFAULT_ATTACK_SPEED, DEFAULT_MOVEMENT_SPEED);

        // Load the StandardAlien image
        alienImage = ImageLoader.loadImage("src/images/Alien.png");
    }

    @Override
    public void draw(Graphics g) {
        int drawX = x + OFFSET_X;  // Apply the X offset
        int drawY = y + OFFSET_Y;  // Apply the Y offset

        if (alienImage != null) {
            // Draw the StandardAlien image with the offset applied
            g.drawImage(alienImage, drawX, drawY, width, height, null);
        } else {
            // Fallback: Draw a placeholder if the image is not loaded
            g.setColor(Color.RED);
            g.fillOval(drawX, drawY, width, height);
        }

        // Debugging
        g.setColor(Color.WHITE);
        g.drawString("HP: " + health, drawX + 10, drawY - 5);
        g.drawString("Cooldown: " + attackCooldown, drawX + 10, drawY - 15);
        g.drawString("X coordinate: " + x, drawX + 10, drawY - 30);
    }
}
