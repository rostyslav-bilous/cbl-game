package entities;

import java.awt.*;


public abstract class Enemy{

    protected int x, y, width, height;
    protected int health;
    protected boolean alive;
    protected int attackDamage;
    protected int attackSpeed;
    protected int attackCooldown;
    protected int movementSpeed;
    protected boolean isMoving = true;

    public Enemy(int x, int y, int width, int height, int health, 
            int attackDamage, int attackSpeed, int movementSpeed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;   
        this.health = health;
        this.alive = true;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.attackCooldown = 0;
        this.movementSpeed = movementSpeed;
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

    public boolean isAlive() {
        return alive;
    }

    public void attack(Tower tower) {
        
        if (canAttack()) {
            tower.takeDamage(attackDamage);
            resetCooldown();
        }
    }

    public void setStop() {
        isMoving = false;
    }

    public void setMoving() {
        isMoving = true;
    }

    public boolean collidesWith(Tower tower) {

        return x + width > tower.x
            && x < tower.x + tower.width
            && y + height > tower.y
            && y < tower.y + tower.height;
    }

    public void updatePosition() {

        if (isMoving) {
            x -= movementSpeed;
        }
    }

    public void update() {

        updatePosition();
        updateCooldown();
    }

    public int getX() {
        return x;
    }

    public abstract void draw(Graphics g);
}