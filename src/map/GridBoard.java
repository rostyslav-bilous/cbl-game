package map;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import managers.*;
import utils.Constants;
import utils.ImageLoader;

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

    // Grid image for the background
    private BufferedImage GridImage;

    public GridBoard() {

        width = cols * tileWidth;
        height = rows * tileHeight;

        setLayout(new GridLayout(rows, cols));
        setOpaque(false); // Ensure background is drawn correctly
        setPreferredSize(new Dimension(width, height));

        // Load the grid image (floor background)
        GridImage = ImageLoader.loadImage("src/images/MudFloor.png");

        towerManager = new TowerManager();
        enemyManager = new EnemyManager(towerManager);
        projectileManager = new ProjectileManager(enemyManager);

        // Add tiles to the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                add(new Tile(row, col, this)); // Pass reference to GridBoard
            }
        }

        // Add test enemy for tower attacking and collision detection
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

        // Draw the grid image as the background
        if (GridImage != null) {
            g.drawImage(GridImage, 0, 0, getWidth(), getHeight(), this);
        }

        // Now draw the grid components
        updateBoard();
        towerManager.draw(g);
        enemyManager.draw(g);
        projectileManager.draw(g);
    }
}
