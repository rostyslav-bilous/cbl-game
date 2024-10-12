package entities.towers;

import entities.Tower;

import java.awt.*;

public class MooCop extends Tower {

    public static final int DEFAULT_HEALTH = 100;
    public static final int DEFAULT_DAMAGE = 10;
    public static final int DEFAULT_ATTACK_SPEED = 60;
    public static final int DEFAULT_PRICE = 20;

    public MooCop(int x, int y) {
        super(x, y, 50, 50, DEFAULT_HEALTH, DEFAULT_DAMAGE, DEFAULT_ATTACK_SPEED, DEFAULT_PRICE);
    }


    @Override
    public void draw(Graphics g) {
        
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
        // Debugging
        System.out.println("Drawing MooCop at (" + x + ", " + y + ") with size " + width + "x" + height);
        // System.out.println("MooCop on the grid");
    }
}
