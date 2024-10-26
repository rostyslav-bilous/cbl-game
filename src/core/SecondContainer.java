package core;

import hud.TopHUDPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;  // Import the TopHUDPanel
import javax.swing.border.EmptyBorder;
import map.GridBoard;
import utils.Constants;

public class SecondContainer extends JPanel {

    private GridBoard gridBoard;
    private BufferedImage GridImage;

    public SecondContainer() {


        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Vertical stacking

       

        // Create a container for the top section of the HUD
        JPanel topHUDContainer = new JPanel(new BorderLayout());
        topHUDContainer.setBackground(Color.LIGHT_GRAY); // Background for top HUD
        TopHUDPanel topHUDPanel = new TopHUDPanel(Game.getInstance());// Create an instance of TopHUDPanel
        topHUDContainer.add(topHUDPanel, BorderLayout.CENTER); // Add it to the top HUD container

        // Create a container for the GridBoard
        JPanel gridMapContainer = new JPanel(new GridBagLayout());
        gridMapContainer.setOpaque(false);
        gridMapContainer.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH / 10, 600));
        gridBoard = new GridBoard();
        gridMapContainer.add(gridBoard);

        // Set left padding for the gridMapContainer
        gridMapContainer.setBorder(new EmptyBorder(0, 50, 0, 0));

        // Add the top HUD and gridMapContainer to the SecondContainer
        add(topHUDContainer); // Add the top HUD
        add(gridMapContainer); // Add the grid board
    }
    

    // Getter method to access the gridBoard if needed
    public GridBoard getGridBoard() {
        return gridBoard;
    }
}




