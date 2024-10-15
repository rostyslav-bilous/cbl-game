package entities;

import java.awt.*;


public abstract class Tower{

    protected int x, y, width, height;
    protected int health;
    protected boolean alive;
    protected int actionValue; // Damage dealing, milk production, etc.
    protected int actionSpeed;
    protected int actionCooldown;
    protected int buyPrice;

    public Tower(int x, int y, int width, int height, int health, 
            int actionValue, int actionSpeed, int buyPrice) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;   
        this.health = health;
        this.alive = true;
        this.actionValue = actionValue;
        this.actionSpeed = actionSpeed;
        this.buyPrice = buyPrice;
        this.actionCooldown = 0;
    }

    public void updateCooldown() {
        if (actionCooldown > 0) {
            actionCooldown--;
        }
    }

    public boolean canAct() {
        return actionCooldown <= 0;
    }

    public void resetCooldown() {
        actionCooldown = actionSpeed;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            alive = false;
        }
    }

    public int getActionValue() {
        return actionValue;
    }

    public int getActionCooldown() {
        return actionCooldown;
    }

    public int getTowerPrice() {
        return buyPrice;
    }

    public abstract void act(); 
    public abstract void draw(Graphics g);
}
