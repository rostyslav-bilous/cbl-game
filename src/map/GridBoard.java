package map;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import entities.Tower;
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


    public GridBoard() {
        width = cols * tileWidth;
        height = rows * tileHeight;

        setLayout(new GridLayout(rows, cols));
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(width, height));

        towerManager = new TowerManager();

        // Add tiles to the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                add(new Tile(row, col, this)); // Pass reference to GridBoard
            }
        }
    }

    public TowerManager getTowerManager() {
        return towerManager;    
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        towerManager.draw(g);
    }
}
