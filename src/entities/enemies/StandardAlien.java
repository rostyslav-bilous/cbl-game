package entities.enemies;

import java.awt.*;

import entities.Enemy;

public class StandardAlien extends Enemy{
    
    public static final int DEFAULT_HEALTH = 40;
    public static final int DEFAULT_DAMAGE = 10;
    public static final int DEFAULT_ATTACK_SPEED = 60;
    public static final int DEFAULT_MOVEMENT_SPEED = 1;

    public StandardAlien(int x, int y) {
        super(x, y, 50, 50, DEFAULT_HEALTH, DEFAULT_DAMAGE, 
            DEFAULT_ATTACK_SPEED, DEFAULT_MOVEMENT_SPEED);
    }

    @Override
    public void draw(Graphics g) {
        
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);

        // Debugging
        g.drawString("HP: " + health, x + 10, y - 5);
        g.setColor(Color.WHITE);
        g.drawString("Cooldown: " + attackCooldown, x + 10, y - 15);
        g.drawString("X coordinate: " + x, x + 10, y - 30);
        

        // Debugging
        // System.out.println("Drawing StandardAlien at (" + x + ", " + y + ") with size " + width + "x" + height);
    }
}
