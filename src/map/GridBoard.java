package map;

import java.awt.*;
import javax.swing.*;

import utils.*;


public class GridBoard extends JPanel {

    int width;
    int height;

    int rows = Constants.GRID_BOARD_ROWS;
    int cols = Constants.GRID_BOARD_COLS;
    int tileWidth = Constants.TILE_WIDTH;
    int tileHeight = Constants.TILE_HEIGHT;
    
    
    public GridBoard() {

        width = cols * tileWidth;
        height = rows * tileHeight;
        
        setLayout(new GridLayout(rows, cols));
        setPreferredSize(new Dimension(width, height));


        // Add tiles to the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                add(new Tile());
            }
        }
    }
}
