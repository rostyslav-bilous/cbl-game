package map;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;

import entities.Tower;
import entities.towers.MooCop;
import utils.Constants;

public class Tile extends JButton {
    
    private boolean occupied = false;
    private int row;
    private int col;
    private GridBoard gridBoard; // Reference to the GridBoard

    public Tile(int row, int col, GridBoard gridBoard) {
        this.row = row;
        this.col = col;
        this.gridBoard = gridBoard; // Initialize the reference

        setPreferredSize(new Dimension(Constants.TILE_WIDTH, Constants.TILE_HEIGHT));
        setBackground(Color.GREEN);
        setOpaque(false);  // Make tile transparent
        setContentAreaFilled(false);
        setBorderPainted(true);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!occupied) {
                    occupied = true;
                    setBackground(Color.RED);

                    int x = col * Constants.TILE_WIDTH;
                    int y = row * Constants.TILE_HEIGHT;
                    System.out.println("Placing MooCop at: (" + x + ", " + y + ")");
                    MooCop mooCop = new MooCop(x, y);
                    gridBoard.getTowerManager().addTower(mooCop);

                    gridBoard.repaint();
                }
            }
        });
    }
}
