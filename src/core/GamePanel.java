package core;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import map.GridBoard;
import utils.Constants;

class GamePanel extends JPanel implements ActionListener {

    private Timer timer;
    private GridBoard gridBoard;
    private FirstContainer firstContainer;
    private SecondContainer secondContainer;


    public GamePanel() {
        setPreferredSize(new Dimension(Constants.WINDOW_WIDTH , Constants.WINDOW_HEIGHT));
        setBackground(Color.blue);
        setLayout(new GridBagLayout());  // Align panels horizontally (left and right)
        GridBagConstraints gbc = new GridBagConstraints();

        // Create the first container (left HUD part)
        JPanel leftSide = new JPanel();
        leftSide.setLayout(new BorderLayout());
        firstContainer = new FirstContainer();
        leftSide.setBackground(Color.BLACK);
        leftSide.add(firstContainer, BorderLayout.CENTER);

        JPanel rightSide = new JPanel();
        rightSide.setLayout(new BorderLayout());
        secondContainer = new SecondContainer();
        rightSide.setBackground(Color.CYAN);
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
