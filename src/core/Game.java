package core;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    private static Game instance; // Singleton instance

    private JPanel mainPanel;      // Holds both StartPanel and GamePanel
    private StartPanel startPanel; // The start menu panel
    private GamePanel gamePanel;   // The actual game panel
    private LossPanel lossPanel;   // The "Game Over" panel
    private WinPanel winPanel;     // The "Operation Successful" screen
    private CardLayout cardLayout; // To switch between panels

    public Game() {

        instance = this; // Initialize the instance

        setTitle("Cows vs Aliens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        startPanel = new StartPanel(this);
        gamePanel = new GamePanel();
        lossPanel = new LossPanel(this);
        winPanel = new WinPanel(this);

        mainPanel.add(startPanel, "StartPanel");
        mainPanel.add(gamePanel, "GamePanel");
        mainPanel.add(lossPanel, "LossPanel");
        mainPanel.add(winPanel, "WinPanel");

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static Game getInstance() {
        return instance;
    }

    // Switch to the GamePanel
    public void showGamePanel() {
        cardLayout.show(mainPanel, "GamePanel");
        gamePanel.requestFocusInWindow();
    }

    // Switch to the LossPanel
    public void showLossPanel() {
        cardLayout.show(mainPanel, "LossPanel");
        lossPanel.requestFocusInWindow();
    }

    public void showWinPanel() {
        cardLayout.show(mainPanel, "WinPanel");
        lossPanel.requestFocusInWindow();
    }

    // Switch to the StartPanel
    public void showStartPanel() {
        cardLayout.show(mainPanel, "StartPanel");
        startPanel.requestFocusInWindow();
    }

    // Reset the gamePanel completely
    public void resetGamePanel() {

        // Remove the old GamePanel from the main panel
        mainPanel.remove(gamePanel);

        gamePanel = new GamePanel();

        mainPanel.add(gamePanel, "GamePanel");

        // Apply changes
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        new Game();
    }
}
