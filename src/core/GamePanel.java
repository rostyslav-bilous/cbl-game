package core;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import hud.LeftHUDPanel;
import hud.TopHUDPanel;
import map.GridBoard;
import utils.Constants;

class GamePanel extends JPanel implements ActionListener {

    private Timer timer;
    private GridBoard gridBoard;

    public GamePanel() {

        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));  // Align panels horizontally (left and right)

        // Create the first container (left HUD part)
        JPanel firstContainer = new JPanel();
        firstContainer.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH / 7, Constants.WINDOW_HEIGHT));
        firstContainer.setBackground(Color.BLUE);
        firstContainer.setLayout(new BorderLayout());
        LeftHUDPanel leftHUDPanel = new LeftHUDPanel();
        firstContainer.add(leftHUDPanel);


        // Create the second container to hold the GridBoard and Barn
        JPanel secondContainer = new JPanel();
        secondContainer.setPreferredSize(new Dimension((4 * Constants.WINDOW_WIDTH) / 5, Constants.WINDOW_HEIGHT));
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
        TopHUDPanel topHUDPanel = new TopHUDPanel(Game.getInstance());
        topHUDContainer.add(topHUDPanel, BorderLayout.WEST);

        // Add top HUD and centerContainer (which contains GridBoard and Barn) into secondContainer
        secondContainer.add(topHUDContainer);
        secondContainer.add(centerContainer);

        // Add both containers to the main GamePanel
        add(firstContainer); // Add left HUD (firstContainer)
        add(secondContainer); // Add right section (GridBoard)

        timer = new Timer(1000 / Constants.GAME_FPS, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // updateGameLogic();
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
