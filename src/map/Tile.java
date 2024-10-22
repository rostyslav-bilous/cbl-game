package map;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import entities.Tower;
import entities.towers.DairyPotter;
import entities.towers.MooCop;
import hud.LeftHUDPanel;
import utils.Constants;

public class Tile extends JButton {
    
    private boolean occupied = false;
    private int row;
    private int col;
    private GridBoard gridBoard; // Reference to the GridBoard
    public static String selectedTower = null;
    public static int selectedTowerPrice = 0;

    public Tile(int row, int col, GridBoard gridBoard) {
        this.row = row;
        this.col = col;
        this.gridBoard = gridBoard; // Initialize the reference

        setPreferredSize(new Dimension(Constants.TILE_WIDTH, Constants.TILE_HEIGHT));
        setBackground(Color.GREEN);
        setOpaque(false);  // Make tile transparent
        setContentAreaFilled(false);
        setBorderPainted(true);
        setBorder(new LineBorder(Color.WHITE, 1));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(new LineBorder(Color.WHITE, 3));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(new LineBorder(Color.WHITE, 1));
            }
        });

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!occupied) {

                    LeftHUDPanel.getMoneyPanel().decreaseMoneyBy(selectedTowerPrice);
                    selectedTowerPrice = 0;
                    int x = col * Constants.TILE_WIDTH + 22;
                    int y = row * Constants.TILE_HEIGHT + 25;
                    System.out.println("Placing tower at: (" + x + ", " + y + ")");

                    Tower tower = createTower(selectedTower, x, y);
                    if (tower != null) {
                        occupied = true;
                        setBackground(Color.RED);
                        gridBoard.getTowerManager().addTower(tower);
                        gridBoard.repaint();
                    } else {
                        System.out.println("Tower type not recognized.");
                    }
                    selectedTower = null;
                }
            }
        });
    }

    public void setFree() {
        occupied = false;
    }
    
    private Tower createTower(String towerType, int x, int y) {
        switch (towerType) {
            case "MooCop":
                return new MooCop(x, y, this);
            case "DairyPotter":
                return new DairyPotter(x, y, this);
            default:
                return null; // Unrecognized tower type
        }
    }
}
