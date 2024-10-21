package entities.towers;

import entities.Tower;
import hud.LeftHUDPanel;
import map.Tile;

import java.awt.*;

public class DairyPotter extends Tower {

    public static final int DEFAULT_HEALTH = 70;
    public static final int DEFAULT_MILK_PRODUCED = 20;
    public static final int DEFAULT_PRODUCTION_SPEED = 60 * 4;
    public static final int DEFAULT_PRICE = 20;

    public DairyPotter(int x, int y, Tile tile) {
        super(x, y, 50, 70, DEFAULT_HEALTH, DEFAULT_MILK_PRODUCED, DEFAULT_PRODUCTION_SPEED, DEFAULT_PRICE, tile);
        resetCooldown(); // Wait till produce first milk
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
        
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);

        // Debugging
        g.setColor(Color.WHITE);
        g.drawString("Cooldown: " + getActionCooldown(), x, y - 15);
        g.setColor(Color.GREEN);
        g.drawString("HP: " + getHealth(), x, y - 5);
    }
}
