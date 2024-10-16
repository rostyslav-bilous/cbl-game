package managers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.Enemy;
import entities.Tower;
import entities.enemies.*;;

public class EnemyManager {
    
    private List<Enemy> enemiesOnGrid;
    private TowerManager towerManager;

    public EnemyManager(TowerManager towerManager) {
        enemiesOnGrid = new ArrayList<>();
        this.towerManager = towerManager;
    }

    public void addEnemy(Enemy enemy) {
        enemiesOnGrid.add(enemy);
    }


    public void draw(Graphics g) {
        for (Enemy enemy : enemiesOnGrid) {
            enemy.draw(g);
        }
    }

    public List<Enemy> getEnemiesOnGrid() {
        return enemiesOnGrid;
    }

    public void update() {
        
        Iterator<Enemy> iterator = enemiesOnGrid.iterator();
        while (iterator.hasNext()) {
            Enemy enemy = iterator.next();
            if (!enemy.isAlive()) {
                iterator.remove();
                continue;
            }

            enemy.updatePosition();
            enemy.updateCooldown();

            boolean isCollidingWithAnyTower = false;

            for (Tower tower : towerManager.getTowersOnGrid()) {
                if (enemy.collidesWith(tower)) {
                    enemy.setStop();
                    isCollidingWithAnyTower = true;

                    enemy.updateCooldown();
                    enemy.attack(tower);
                    System.out.println("Enemy attacking tower."); // Debugging
                } 
            }

            if (!isCollidingWithAnyTower) {
                enemy.setMoving();
            }

            if (enemy.getX() <= 0) {
                enemy.setStop();
                // wait 3 seconds
                // itarator.remove(); 
            }
        }

    }
}
