package entities;

import java.awt.*;


public abstract class Enemy{

    protected int x, y, width, height;
    protected int health;
    protected boolean alive;
    protected int attackDamage;
    protected int attackSpeed;
    protected int attackCooldown;

    public Enemy(int x, int y, int width, int height, int health, 
            int attackDamage, int attackSpeed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;   
        this.health = health;
        this.alive = true;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
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

    protected void die() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public abstract void draw(Graphics g);
}