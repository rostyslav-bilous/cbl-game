package entities;

import java.awt.*;


public abstract class Tower{

    protected int x, y, width, height;
    protected int health;
    protected boolean alive;
    protected int attackDamage;
    protected int attackSpeed;
    protected int attackCooldown;
    protected int buyPrice;

    public Tower(int x, int y, int width, int height, int health, 
            int attackDamage, int attackSpeed, int buyPrice) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;   
        this.health = health;
        this.alive = true;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.buyPrice = buyPrice;
        this.attackCooldown = 0;
    }

    public void updateCooldown() {
        if (attackCooldown > 0) {
            attackCooldown--;
        }
    }

    public boolean canAttack() {
        return attackCooldown <= 0;
    }

    public void resetCooldown() {
        attackCooldown = attackSpeed;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            alive = false;
        }
    }

    public abstract void draw(Graphics g); 
}
