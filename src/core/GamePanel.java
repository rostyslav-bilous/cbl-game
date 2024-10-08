package core;

import java.awt.*;
import javax.swing.*;

class GamePanel extends JPanel {

    int windowWidth = 720;
    int windowHeight = 480;

    public GamePanel() {

        setPreferredSize(new Dimension(windowWidth, windowHeight));
        setBackground(Color.BLUE);
    }

    // @Override
    // protected void painComponent(Graphics g) {
    //     super.paintComponent(g);

    // }

}