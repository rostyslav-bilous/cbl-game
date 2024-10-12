// package entities;

// import java.awt.*;

// public abstract class Entity {

//     private int x;
//     private int y;
//     private int width;
//     private int height;
//     private int health;
//     private boolean alive;
//     private Rectangle bounds; // For collision detection

//     public Entity(int x, int y, int width, int height, int health) {

//         this.x = x;
//         this.y = y;
//         this.width = width;
//         this.height = height;
//         this.health = health;
//         this.alive = true;
//         this.bounds = new Rectangle(x, y, width, height);
//     }

//     public void takeDamage(int damage) {

//         health -= damage;
//         if (health <= 0) {
//             die();
//         }
//     }

//     private void die() {
//         alive = false;
//     }

//     public boolean collidesWith(Entity other) {
//         return this.bounds.intersects(other.getBounds());
//     }

//     public int getX() { return x; }
//     public int getY() { return y; }
//     public int getWidth() { return width; }
//     public int getHeight() { return height; }
//     public Rectangle getBounds() { return bounds; }
//     public boolean isAlive() { return alive; }

//     // Specific entities override this method
//     public abstract void draw(Graphics g);

//     // Specific entities override this method
//     protected Color getColor() {
//         return Color.YELLOW; // Default color
//     }
// }
