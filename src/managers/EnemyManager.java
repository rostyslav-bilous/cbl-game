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

    public EnemyManager() {
        enemiesOnGrid = new ArrayList<>();
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
            enemy.updateCooldown();
        }
    }
}
