package entities.towers;

import entities.Tower;
import hud.LeftHUDPanel;

import java.awt.*;

public class DairyPotter extends Tower {

    public static final int DEFAULT_HEALTH = 70;
    public static final int DEFAULT_MILK_PRODUCED = 10;
    public static final int DEFAULT_PRODUCTION_SPEED = 60 * 20;
    public static final int DEFAULT_PRICE = 20;

    public DairyPotter(int x, int y) {
        super(x, y, 50, 70, DEFAULT_HEALTH, DEFAULT_MILK_PRODUCED, DEFAULT_PRODUCTION_SPEED, DEFAULT_PRICE);
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
        
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);

        g.setColor(Color.GREEN);
        g.drawString("" + getActionCooldown(), x, y - 10);
    }
}
