package managers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import entities.Enemy;
import entities.Tower;
import entities.enemies.*;
import hud.TopHUDPanel;
import utils.Constants;

public class EnemyManager {
    
    private List<Enemy> enemiesOnGrid;
    private TowerManager towerManager;
    private int newEnemyNumber = 2; // For test spawn


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
                iterator.remove();
                TopHUDPanel.decreaseCowCounter();

                // wait 3 seconds
                // itarator.remove(); 
            }
        }

        // Just because
        int[] rows = {0, 1, 2, 3, 4};
        int[] cols = {5, 6, 7, 8};
        Random random = new Random();

        if (enemiesOnGrid.size() == 0) {

            int newEnemyCounter = newEnemyNumber;
            while (newEnemyCounter >= 0) {

                int randomIndexX = random.nextInt(rows.length);  // Random row index
                int row = rows[randomIndexX];  // Get the row number
                int randomIndexY = random.nextInt(cols.length);  // Random row index
                int col = cols[randomIndexY];  // Get the row number
                addEnemy(new StandardAlien(Constants.TILE_WIDTH * col + 20, Constants.TILE_HEIGHT * row + 30));
                newEnemyCounter--;

            }
            newEnemyNumber += 1;
            
        }
    }
}
