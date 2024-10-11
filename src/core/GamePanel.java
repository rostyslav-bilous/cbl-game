package core;

import hud.HUD;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import map.GridBoard;
import utils.Constants;

class GamePanel extends JPanel implements ActionListener {

    private Timer timer;
    private GridBoard gridBoard;
    private HUD hud;

    public GamePanel() {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());  // Align panels horizontally (left and right)
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        // Create the first container (left HUD part)
        JPanel firstContainer = new JPanel();
        firstContainer.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH / 5, Constants.WINDOW_HEIGHT));
        firstContainer.setBackground(Color.blue);
        firstContainer.setLayout(new GridBagLayout()); // Use BoxLayout for vertical stacking
        

        

    
        
        //hud.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH / 5, Constants.WINDOW_HEIGHT)); // Set your desired size here
        //hud.setMinimumSize(new Dimension(Constants.WINDOW_WIDTH / 5, Constants.WINDOW_HEIGHT)); // Prevent resizing below this size
        

        

        // Add HUD to firstContainer
     

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.BOTH; 
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;

        JPanel leftThinPanel = new JPanel();
        leftThinPanel.setBackground(Color.yellow);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.weightx = 0.01;
        firstContainer.add(leftThinPanel, gbc2);

        JPanel rightThinPanel = new JPanel();
        rightThinPanel.setBackground(Color.yellow);
        gbc2.gridx = 2;
        gbc2.gridy = 1;
        gbc2.weightx = 0.01;
        firstContainer.add(rightThinPanel, gbc2);

        

        JPanel midPanel = new JPanel(new GridBagLayout()); // Your existing panel
        HUD hud = new HUD(); // Your HUD panel
        GridBagConstraints gbc3 = new GridBagConstraints();
        midPanel.setBackground(Color.yellow);
        gbc3.fill = GridBagConstraints.BOTH; // Allow HUD to fill both horizontally and vertically
        gbc3.weightx = 1.0; // Take up all horizontal space
        gbc3.weighty = 1.0; // Take up all vertical space
        
        midPanel.add(hud, gbc3);

        gbc2.gridy = 1;//row 1
        gbc2.gridx = 1;
        gbc2.weighty = 0.9;//90% space
        gbc2.weightx = 0.98;
        firstContainer.add(midPanel, gbc2);

        JPanel topThinPanel = new JPanel();
        topThinPanel.setBackground(Color.yellow);
        gbc2.gridy = 0; // Row 0
        gbc2.gridx = 0;
        gbc2.gridwidth = 3;
        gbc2.weighty = 0.05; // 5% vertical space
        gbc2.weightx = 0.98;
        firstContainer.add(topThinPanel, gbc2);

        JPanel bottomThinPanel = new JPanel();
        bottomThinPanel.setBackground(Color.yellow);
        gbc2.gridy = 2; // Row 0
        gbc2.gridx = 0;
        gbc2.gridwidth = 3;
        gbc2.weighty = 0.05; // Small vertical weight
        gbc2.weightx = 0.98;
        firstContainer.add(bottomThinPanel, gbc2);


        
         

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

        // Add the GridBoard to the center container
        centerContainer.add(gridMapContainer);

        // Create a container for the top section of the HUD
        JPanel topHUDContainer = new JPanel(new BorderLayout());
        topHUDContainer.setBackground(Color.LIGHT_GRAY); // Background for top HUD
        JLabel progressLabel = new JLabel("Civil cow counter and wave progress bar should be here");
        progressLabel.setForeground(Color.BLACK);
        topHUDContainer.add(progressLabel, BorderLayout.WEST);

        // Add top HUD and centerContainer into secondContainer
        secondContainer.add(topHUDContainer);
        secondContainer.add(centerContainer);

        gbc.fill = GridBagConstraints.BOTH; // Fill both directions
        gbc.gridx = 0; // First column
        gbc.gridy = 0; // First row
        gbc.weightx = 0.2; // 20% width for the side panel
        gbc.weighty = 1.0; // Full height
        add(firstContainer, gbc); // Add firstContainer to GamePanel

        // Set constraints for the secondContainer
        gbc.gridx = 1; // Second column
        gbc.gridy = 0;
        gbc.weightx = 0.8; // 80% width for the main content area
        add(secondContainer, gbc); // Add secondContainer to GamePanel

        

        timer = new Timer(1000 / Constants.GAME_FPS, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateGameLogic();
        repaint();
    }

    private void updateGameLogic() {
        // Update your game logic here
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
