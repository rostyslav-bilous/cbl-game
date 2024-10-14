package entities;

import java.awt.*;

import utils.Constants;

public abstract class Projectile {

    protected int x, y, width, height;
    protected int speed;
    protected int damage;
    protected boolean active;

    public Projectile(int x, int y, int width, int height, int speed, int damage) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.damage = damage;
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }

    public boolean collidesWith(Enemy enemy) {

        return x + width > enemy.x
            && x < enemy.x + enemy.width
            && y + height > enemy.y
            && y < enemy.y + enemy.height;
    }

    public void update() {
        x += speed; // Move the projectile forward
    
        // Deactivate if it goes off-screen
        if (x >= Constants.TILE_WIDTH * Constants.GRID_BOARD_COLS) {
            deactivate();
            System.out.println("Projectile deactivated (off-screen)."); // Debugging
        }
    }
    

    public int getDamage() {
        return damage;
    }
    public abstract void draw(Graphics g);

}
