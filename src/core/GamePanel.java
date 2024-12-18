package core;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import map.GridBoard;
import utils.Constants;
import utils.ImageLoader;

class GamePanel extends JPanel implements ActionListener {

    private Timer timer;
    private GridBoard gridBoard;
    private FirstContainer firstContainer;
    private SecondContainer secondContainer;
    private BufferedImage backgroundImage;

    public GamePanel() {
        setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        setOpaque(false);
        setLayout(new GridBagLayout());  // Align panels horizontally (left and right)
        GridBagConstraints gbc = new GridBagConstraints();
        backgroundImage = ImageLoader.loadImage("src/images/FinalGrass2.png");

        // Create the first container (left HUD part)
        JPanel leftSide = new JPanel();
        leftSide.setLayout(new BorderLayout());
        firstContainer = new FirstContainer();
        leftSide.setOpaque(false);
        leftSide.add(firstContainer, BorderLayout.CENTER);

        // Create the second container (right section)
        JPanel rightSide = new JPanel();
        rightSide.setLayout(new BorderLayout());
        secondContainer = new SecondContainer();
        rightSide.setOpaque(false);
        rightSide.add(secondContainer, BorderLayout.CENTER);

        // Add both containers to the main GamePanel
        gbc.fill = GridBagConstraints.BOTH; // Fill both directions
        gbc.gridx = 0; // First column
        gbc.gridy = 0;
        gbc.weightx = 0.25;
        gbc.weighty = 1.0;
        add(leftSide, gbc); // Add left HUD (firstContainer)

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.75;
        gbc.weighty = 1.0;
        add(rightSide, gbc); // Add right section (GridBoard)

        // Start the timer for game updates
        timer = new Timer(1000 / Constants.GAME_FPS, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image to cover the entire panel
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update game logic (if any)
        repaint();
    }
}




