package map;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import entities.Projectile;
import entities.Tower;
import entities.enemies.StandardAlien;
import entities.towers.MooCop;
import utils.Constants;
import managers.*;

public class GridBoard extends JPanel {

    private int width;
    private int height;
    private int rows = Constants.GRID_BOARD_ROWS;
    private int cols = Constants.GRID_BOARD_COLS;
    private int tileWidth = Constants.TILE_WIDTH;
    private int tileHeight = Constants.TILE_HEIGHT;

    // Store the placed towers
    private TowerManager towerManager;
    private EnemyManager enemyManager;
    private static ProjectileManager projectileManager; // Easier to maintain if static


    public GridBoard() {
        width = cols * tileWidth;
        height = rows * tileHeight;

        setLayout(new GridLayout(rows, cols));
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));

        towerManager = new TowerManager();
        enemyManager = new EnemyManager(towerManager);
        projectileManager = new ProjectileManager(enemyManager);

        // Add tiles to the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                add(new Tile(row, col, this)); // Pass reference to GridBoard
            }
        }

        // Added a test enemy to continue with tower attacking and collision detection
        
    }

    public TowerManager getTowerManager() {
        return towerManager;    
    }

    public EnemyManager getEnemyManager() {
        return enemyManager;    
    }

    public static ProjectileManager getProjectileManager() {
        return projectileManager;    
    }

    public void updateBoard() {

        towerManager.update();
        enemyManager.update();
        projectileManager.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateBoard();
        towerManager.draw(g);
        enemyManager.draw(g);
        projectileManager.draw(g);
    }
}
