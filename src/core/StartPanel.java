package core;

import javax.swing.*;

import hud.TopHUDPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import utils.StyledButton;


class StartPanel extends JPanel {

    private StyledButton startButton;
    private StyledButton githubButton;
    private StyledButton lossPanelButton;

    public StartPanel(Game game) {

        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);

        // Start button
        startButton = new StyledButton("| Start Game");
        startButton.addActionListener(e -> game.showGamePanel());

        // GitHub button
        githubButton = new StyledButton("| GitHub Repository");
        githubButton.addActionListener(e -> openWebpage("https://github.com/rostyslav-bilous/cbl-game"));

        JLabel gameName = new JLabel("Cows vs Aliens");
        gameName.setForeground(new Color(255, 255, 255));
        gameName.setFont(new Font("Trebuchet MS", Font.BOLD, 40));

        // Layout setup
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 10, 3, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        add(gameName, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(startButton, gbc);

        gbc.gridy = 2;
        add(githubButton, gbc);

        // Debugging panels
        lossPanelButton = new StyledButton("| (Testing) Game Over Screen");
        lossPanelButton.addActionListener(e -> game.showLossPanel());

        gbc.gridy = 3;
        add(lossPanelButton, gbc);

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
