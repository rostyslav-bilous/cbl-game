package entities.towers;

import entities.Tower;

import java.awt.*;

public class DairyPotter extends Tower {

    public static final int DEFAULT_HEALTH = 70;
    public static final int DEFAULT_DAMAGE = 0;
    public static final int DEFAULT_ATTACK_SPEED = 0;
    public static final int DEFAULT_PRICE = 20;

    public DairyPotter(int x, int y) {
        super(x, y, 50, 70, DEFAULT_HEALTH, DEFAULT_DAMAGE, DEFAULT_ATTACK_SPEED, DEFAULT_PRICE);
    }


    @Override
    public void draw(Graphics g) {
        
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
        // Debugging
        System.out.println("Drawing DairyPotter at (" + x + ", " + y + ") with size " + width + "x" + height);
        // System.out.println("MooCop on the grid");
    }
}
