package entities.towers;

import entities.Tower;
import hud.LeftHUDPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import map.Tile;
import utils.ImageLoader;

public class DairyPotter extends Tower {

    public static final int DEFAULT_HEALTH = 70;
    public static final int DEFAULT_MILK_PRODUCED = 20;
    public static final int DEFAULT_PRODUCTION_SPEED = 60 * 4;
    public static final int DEFAULT_PRICE = 20;

    // Store the DairyPotter image
    private BufferedImage dairyPotterImage;

    // Offset variables to adjust the position
    private static final int OFFSET_X = -10;  // Move 10 pixels to the left
    private static final int OFFSET_Y = -15;  // Move 15 pixels higher

    public DairyPotter(int x, int y, Tile tile) {
        super(x, y, 110, 130, DEFAULT_HEALTH, DEFAULT_MILK_PRODUCED, DEFAULT_PRODUCTION_SPEED, DEFAULT_PRICE, tile);
        resetCooldown(); // Wait till produce first milk

        // Load the DairyPotter image
        dairyPotterImage = ImageLoader.loadImage("src/images/DairyPotter.png");
    }

    @Override
    public void act() {
        if (canAct()) {
            LeftHUDPanel.getMoneyPanel().increaseMoneyBy(DEFAULT_MILK_PRODUCED);
            System.out.println("Added milk");
            resetCooldown();
        }
    }

    @Override
    public void draw(Graphics g) {
        int drawX = x + OFFSET_X;  // Apply the X offset
        int drawY = y + OFFSET_Y;  // Apply the Y offset

        if (dairyPotterImage != null) {
            // Draw the DairyPotter image with the offset applied
            g.drawImage(dairyPotterImage, drawX, drawY, width, height, null);
        } else {
            // Fallback: Draw a placeholder if the image is not loaded
            g.setColor(Color.ORANGE);
            g.fillRect(drawX, drawY, width, height);
        }

        // Debugging information
        g.setColor(Color.WHITE);
        g.drawString("Cooldown: " + getActionCooldown(), drawX, drawY - 15);
        g.setColor(Color.GREEN);
        g.drawString("HP: " + getHealth(), drawX, drawY - 5);
    }
}
