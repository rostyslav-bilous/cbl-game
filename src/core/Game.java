package core;

import javax.swing.*;
import java.awt.*;

class Game extends JFrame {

    private JPanel mainPanel;      // Holds both StartPanel and GamePanel
    private StartPanel startPanel; // The start menu panel
    private GamePanel gamePanel;   // The actual game panel
    private CardLayout cardLayout; // To switch between panels

    public Game() {
        setTitle("Cows vs Aliens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        startPanel = new StartPanel(this);
        gamePanel = new GamePanel();

        mainPanel.add(startPanel, "StartPanel");
        mainPanel.add(gamePanel, "GamePanel");

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Switch to the GamePanel
    public void showGamePanel() {
        cardLayout.show(mainPanel, "GamePanel");
        gamePanel.requestFocusInWindow();
    }

    public static void main(String[] args) {
        new Game();
    }
}
