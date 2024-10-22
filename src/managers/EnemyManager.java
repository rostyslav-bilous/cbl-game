package managers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import core.Game;
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

        TopHUDPanel.checkWave(Game.getInstance());
        
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
                TopHUDPanel.decreaseCowCounter(Game.getInstance());

                // wait 3 seconds
                // itarator.remove(); 
            }
        }

        // Just because
        int[] rows = {0, 1, 2, 3, 4};
        Random random = new Random();

        // Don't ask me how waves work. They just work.
        if (enemiesOnGrid.size() == 0) {
            int newEnemyCounter = newEnemyNumber;
            while (newEnemyCounter >= 0) {
                int i = newEnemyCounter;
                while (i > 0) {
                    int randomIndexX = random.nextInt(rows.length);  // Random row index
                    int row = rows[randomIndexX]; // Get the row number
                    addEnemy(new StandardAlien(Constants.TILE_WIDTH * 8 + i * 60 + 200, Constants.TILE_HEIGHT * row + 30));
                    i--;
                }
                newEnemyCounter--;
            }
            TopHUDPanel.increaseCurrentWave();
            newEnemyNumber += 1;
        }
    }
}
