package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

class StartPanel extends JPanel {

    private JButton startButton;

    public StartPanel(Game game) {

        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);

        startButton = new JButton("Start");
        startButton.setBackground(new Color(50, 50, 50));
        startButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        startButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(200, 70));
        startButton.setFocusPainted(false);
        startButton.setFont(new Font("Arial", Font.BOLD, 20));

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setBackground(new Color(75, 75, 75));
                startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setBackground(new Color(50, 50, 50));
            }
        });

        JLabel gameName = new JLabel("Cows vs Aliens");
        gameName.setForeground(Color.WHITE);
        gameName.setFont(new Font("Arial", Font.BOLD, 40));

        // Clickable label for GitHub link
        JLabel githubLink = new JLabel("Go to GitHub Repository ->");
        githubLink.setForeground(Color.WHITE);
        githubLink.setFont(new Font("Arial", Font.ITALIC, 15));
        githubLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        githubLink.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                // Open the GitHub repository link
                openWebpage("https://github.com/rostyslav-bilous/cbl-game");
            }

        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        add(gameName, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(startButton, gbc);

        gbc.gridy = 2; // Set this for the GitHub link
        add(githubLink, gbc);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.showGamePanel();
            }
        });
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
