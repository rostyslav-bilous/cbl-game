package core;

import hud.LeftHUDPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import map.GridBoard;
import utils.Constants;

class GamePanel extends JPanel implements ActionListener {

    private Timer timer;
    private GridBoard gridBoard;


    public GamePanel() {
        setPreferredSize(new Dimension(Constants.WINDOW_WIDTH , Constants.WINDOW_HEIGHT));
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());  // Align panels horizontally (left and right)
        GridBagConstraints gbc = new GridBagConstraints();

        // Create the first container (left HUD part)
        JPanel firstContainer = new JPanel();
        //firstContainer.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH / 7, Constants.WINDOW_HEIGHT));
        firstContainer.setBackground(Color.BLUE);
        firstContainer.setLayout(new BorderLayout());
        LeftHUDPanel leftHUDPanel = new LeftHUDPanel();
        firstContainer.add(leftHUDPanel);


        // Create the second container to hold the GridBoard and Barn
        JPanel secondContainer = new JPanel();
        //secondContainer.setPreferredSize(new Dimension((4 * Constants.WINDOW_WIDTH) / 5, Constants.WINDOW_HEIGHT));
        secondContainer.setBackground(Color.RED);
        secondContainer.setLayout(new BoxLayout(secondContainer, BoxLayout.Y_AXIS)); // Vertical stacking inside the right container

        // Create a container for the center section (GridBoard and Barn side by side)
        JPanel centerContainer = new JPanel();
        centerContainer.setLayout(new BoxLayout(centerContainer, BoxLayout.X_AXIS));

        // Create a container for the GridBoard
        JPanel gridMapContainer = new JPanel(new GridBagLayout());
        gridMapContainer.setBackground(Color.GRAY);
        gridMapContainer.setPreferredSize(new Dimension(4 * Constants.WINDOW_WIDTH / 5, 600));
        gridBoard = new GridBoard();
        gridMapContainer.add(gridBoard);

        // Set left padding for the gridMapContainer
        gridMapContainer.setBorder(new EmptyBorder(0, 50, 0, 0));

        // Create a container for the Barn map
        // JPanel barnMapContainer = new JPanel(new GridBagLayout()); // Center the barn image
        // barnMapContainer.setBackground(Color.YELLOW); // Barn map container background

        // Add the GridBoard and Barn container to the center container
        // centerContainer.add(barnMapContainer); // Add Barn to the right
        centerContainer.add(gridMapContainer);

        // Create a container for the top section of the HUD
        JPanel topHUDContainer = new JPanel(new BorderLayout());
        topHUDContainer.setBackground(Color.LIGHT_GRAY); // Background for top HUD

        JLabel progressLabel = new JLabel("Civil cow counter and wave progress bar should be here");
        progressLabel.setForeground(Color.BLACK);
        topHUDContainer.add(progressLabel, BorderLayout.WEST);

        // Add top HUD and centerContainer (which contains GridBoard and Barn) into secondContainer
        secondContainer.add(topHUDContainer);
        secondContainer.add(centerContainer);

        // Add both containers to the main GamePanel
        gbc.fill = GridBagConstraints.BOTH; // Fill both directions
        gbc.gridx = 0; // First column
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        add(firstContainer, gbc); // Add left HUD (firstContainer)

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.8;
        add(secondContainer, gbc); // Add right section (GridBoard)

        timer = new Timer(1000 / Constants.GAME_FPS, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        repaint();
    }

    


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
