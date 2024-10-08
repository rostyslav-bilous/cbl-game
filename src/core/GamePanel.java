package core;

import java.awt.*;
import javax.swing.*;

import utils.*;

class GamePanel extends JPanel {

    public GamePanel() {

        setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(100, 100, Constants.WINDOW_WIDTH / 20, Constants.WINDOW_HEIGHT / 20);
        g.fillRect(400, 100, Constants.WINDOW_WIDTH / 20, Constants.WINDOW_HEIGHT / 20);
        g.fillRect(100, 400, Constants.WINDOW_WIDTH / 20 + 300, Constants.WINDOW_HEIGHT / 20);

    }

}