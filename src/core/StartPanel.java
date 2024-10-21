package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import hud.TopHUDPanel;
import utils.StyledButton;

class StartPanel extends JPanel {

    private StyledButton startButton;
    private StyledButton githubButton;
    private StyledButton lossPanelButton;
    private StyledButton winPanelButton;
    private JLabel developedByLabel;
    private JLabel author1Label;
    private JLabel author2Label;

    public StartPanel(Game game) {
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);

        // Start button
        startButton = new StyledButton("Start Game");
        startButton.addActionListener(e -> game.showGamePanel());

        // GitHub button
        githubButton = new StyledButton("GitHub Repository");
        githubButton.addActionListener(e -> openWebpage("https://github.com/rostyslav-bilous/cbl-game"));

        JLabel gameName = new JLabel("Cows vs Aliens");
        gameName.setForeground(new Color(255, 255, 255));
        gameName.setFont(new Font("Helvetica", Font.BOLD, 40));

        // Layout setup
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 10, 3, 10);
        gbc.gridx = 0; // First column for the game name and buttons
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        add(gameName, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(startButton, gbc);

        gbc.gridy = 2;
        add(githubButton, gbc);

        // Debugging panels
        lossPanelButton = new StyledButton("(Testing) Game Over Screen");
        lossPanelButton.addActionListener(e -> game.showLossPanel());

        gbc.gridy = 3;
        add(lossPanelButton, gbc);

        winPanelButton = new StyledButton("(Testing) Operation Successful Screen");
        winPanelButton.addActionListener(e -> game.showWinPanel());

        gbc.gridy = 4;
        add(winPanelButton, gbc);

        // Project Group Label in the second column
        developedByLabel = new JLabel("Project Group 38");
        developedByLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        developedByLabel.setForeground(new Color(150, 150, 150));

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(developedByLabel, gbc);

        author1Label = new JLabel("| Rostyslav Bilous (2154803)");
        author1Label.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        author1Label.setForeground(new Color(150, 150, 150));

        gbc.gridy = 5;
        add(author1Label, gbc);

        author2Label = new JLabel("| Suhail Abbas (2141523)");
        author2Label.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        author2Label.setForeground(new Color(150, 150, 150));

        gbc.gridy = 6;
        add(author2Label, gbc);

    }

    // Method to open a webpage
    private void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URI(urlString));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
