package entities.towers;

import entities.Projectile;
import entities.Tower;
import java.awt.*;
import java.awt.image.BufferedImage;
import map.GridBoard;
import map.Tile;  // Import the ImageLoader for loading images
import utils.ImageLoader;

public class MooCop extends Tower {

    public static final int DEFAULT_HEALTH = 100;
    public static final int DEFAULT_DAMAGE = 10;
    public static final int DEFAULT_ATTACK_SPEED = 60;
    public static final int DEFAULT_PRICE = 20;

    // Store the image of MooCop
    private BufferedImage mooCopImage;

    public MooCop(int x, int y, Tile tile) {
        super(x, y, 95, 100, DEFAULT_HEALTH, DEFAULT_DAMAGE, DEFAULT_ATTACK_SPEED, DEFAULT_PRICE, tile);

        // Load the MooCop image (make sure the path is correct)
        mooCopImage = ImageLoader.loadImage("src/images/MooCop.png");
    }

    @Override
    public void act() {
        if (canAct()) {
            Projectile projectile = new Bullet(x + width/2, y + 50);
            GridBoard.getProjectileManager().add(projectile);
            resetCooldown();
        }
    }

    public static int getDamage() {
        return DEFAULT_DAMAGE;
    }

    @Override
    public void draw(Graphics g) {
        if (mooCopImage != null) {
            // Draw the loaded image at the tower's coordinates
            g.drawImage(mooCopImage, x, y, width, height, null);
        } else {
            // Fallback: Draw a placeholder if the image is not loaded
            g.setColor(Color.CYAN);
            g.fillOval(x, y, width, height);
        }

        // For debugging, you can still draw the cooldown and health info
        g.setColor(Color.WHITE);
        g.drawString("Cooldown: " + getActionCooldown(), x, y - 15);
        g.setColor(Color.GREEN);
        g.drawString("HP: " + getHealth(), x, y - 5);
    }
}

class Bullet extends Projectile {

    private static final int DEFAULT_WIDTH = 30;
    private static final int DEFAULT_HEIGHT = 5;
    private static final int DEFAULT_SPEED = 10;

    public Bullet(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_SPEED, MooCop.getDamage());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
