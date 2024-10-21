package core;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import map.GridBoard;
import utils.Constants;


public class SecondContainer extends JPanel {
    private GridBoard gridBoard;

    public SecondContainer() {
        setBackground(Color.RED);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Vertical stacking

        // Create a container for the center section (GridBoard and Barn side by side)
        JPanel centerContainer = new JPanel();
        centerContainer.setLayout(new BoxLayout(centerContainer, BoxLayout.X_AXIS));
        centerContainer.setBackground(Color.CYAN);

        // Create a container for the GridBoard
        JPanel gridMapContainer = new JPanel(new GridBagLayout());
        gridMapContainer.setBackground(Color.yellow);
        gridMapContainer.setPreferredSize(new Dimension( Constants.WINDOW_WIDTH/10 , 600));
        gridBoard = new GridBoard();
        gridMapContainer.add(gridBoard);

        // Set left padding for the gridMapContainer
        gridMapContainer.setBorder(new EmptyBorder(0, 50, 0, 0));

        // Add the GridBoard to the center container


                centerContainer.add(gridMapContainer);

        // Create a container for the top section of the HUD
        JPanel topHUDContainer = new JPanel(new BorderLayout());
        topHUDContainer.setBackground(Color.LIGHT_GRAY); // Background for top HUD

        //JLabel progressLabel = new JLabel("Civil cow counter and wave progress bar should be here");
        //progressLabel.setForeground(Color.BLACK);
        //topHUDContainer.add(progressLabel, BorderLayout.WEST);

        // Add top HUD and centerContainer (which contains GridBoard) into SecondContainer
        add(topHUDContainer);
        add(gridMapContainer);
    }

    // Getter method to access the gridBoard if needed
    public GridBoard getGridBoard() {
        return gridBoard;
    }
}


