package core;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import map.GridBoard;
import utils.*;

class GamePanel extends JPanel implements ActionListener {

    private Timer timer;
    private GridBoard gridBoard;

    public GamePanel() {
        
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        // setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        // setBackground(Color.GRAY);

        // Create the center container to hold the GridBoard
        JPanel centerContainer = new JPanel();
        centerContainer.setLayout(new GridBagLayout());
        centerContainer.setBackground(Color.GRAY);
        gridBoard = new GridBoard();
        centerContainer.add(gridBoard);

        add(centerContainer, BorderLayout.CENTER);

        // Create the Left container to hold the HUD
        JPanel leftContainer = new JPanel();
        leftContainer.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH / 5, Constants.WINDOW_HEIGHT));
        leftContainer.setBackground(Color.BLUE);
        leftContainer.setLayout(new BoxLayout(leftContainer, BoxLayout.Y_AXIS));

        JLabel cowListLabel = new JLabel("Cow list");
        leftContainer.setBorder(new EmptyBorder(0, 0, 0, 40));
        leftContainer.add(cowListLabel);

        add(leftContainer, BorderLayout.WEST);

        timer = new Timer(1000 / Constants.GAME_FPS, this);
        timer.start();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateGameLogic();
        repaint();
    }

    private void updateGameLogic() {
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
