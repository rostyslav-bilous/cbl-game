package managers;

import entities.Enemy;
import entities.Projectile;
import map.GridBoard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProjectileManager {
    
    private List<Projectile> projectiles;
    private EnemyManager enemyManager; 

    public ProjectileManager(EnemyManager enemyManager) {

        this.projectiles = new ArrayList<>();
        this.enemyManager = enemyManager;
    }

    public void add(Projectile p) {
        projectiles.add(p);
    }

    public void update() {
        
        Iterator<Projectile> iterator = projectiles.iterator();
        while (iterator.hasNext()) {
            Projectile p = iterator.next();
            p.updatePosition();
    
            if (!p.isActive()) {
                iterator.remove();
                System.out.println("Projectile removed."); // Debugging
                continue;
            }
    
            // Check for collisions with enemies
            for (Enemy enemy : enemyManager.getEnemiesOnGrid()) {
                if (p.collidesWith(enemy)) {
                    enemy.takeDamage(p.getDamage());
                    p.deactivate();
                    System.out.println("Projectile hit an enemy!"); // Debugging
                    break;
                }
            }
        }
    }

    public void draw(Graphics g) {
        for (Projectile p : projectiles) {
            p.draw(g);
        }
    }
}
