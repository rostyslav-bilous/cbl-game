package entities.towers;

import entities.Projectile;
import entities.Tower;
import managers.ProjectileManager;
import map.GridBoard;
import map.Tile;

import java.awt.*;
// import entities.Projectile;

public class MooCop extends Tower {

    public static final int DEFAULT_HEALTH = 100;
    public static final int DEFAULT_DAMAGE = 10;
    public static final int DEFAULT_ATTACK_SPEED = 60;
    public static final int DEFAULT_PRICE = 20;

    public MooCop(int x, int y, Tile tile) {
        super(x, y, 50, 70, DEFAULT_HEALTH, DEFAULT_DAMAGE, DEFAULT_ATTACK_SPEED, DEFAULT_PRICE, tile);
    }

    @Override
    public void act() {
        
        if (canAct()) {
            Projectile projectile = new Bullet(x + width, y + 20);
            GridBoard.getProjectileManager().add(projectile);
            resetCooldown();
        }
    }

    public static int getDamage() {
        return DEFAULT_DAMAGE;
    }

    @Override
    public void draw(Graphics g) {
        
        g.setColor(Color.CYAN);
        g.fillOval(x, y, width, height);

        // Debugging
        g.setColor(Color.WHITE);
        g.drawString("Cooldown: " + getActionCooldown(), x, y - 15);
        g.setColor(Color.GREEN);
        g.drawString("HP: " + getHealth(), x, y - 5);
        
        // Debugging
        // System.out.println("Drawing MooCop at (" + x + ", " + y + ") with size " + width + "x" + height);
    }
}


class Bullet extends Projectile {

    private static final int DEFAULT_WIDTH = 30;
    private static final int DEFAULT_HEIGHT = 5;
    private static final int DEFAULT_SPEED = 10;

    public Bullet(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_SPEED, MooCop.getDamage());
    }

    public void draw(Graphics g) {

        g.setColor(Color.GREEN);
        g.fillOval(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
