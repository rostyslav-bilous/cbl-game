package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import utils.ImageLoader;
import hud.TopHUDPanel;
import utils.StyledButton;
import java.net.URI;

class StartPanel extends JPanel {

    private StyledButton startButton;
    private StyledButton githubButton;
    private StyledButton lossPanelButton;
    private StyledButton winPanelButton;
    private JLabel developedByLabel;
    private JLabel author1Label;
    private JLabel author2Label;
    private JLabel gameTitleImage; // Declare the game title as an image
    private Color[] colors; // Colors for animation
    private int currentColorIndex; // Track current color for animation
    private BufferedImage[] titleImages; // Array to hold the two title images
    private int currentImageIndex; // To track which image is currently displayed
    private BufferedImage startscreenImage; // Background image

    public StartPanel(Game game) {
        setLayout(new GridBagLayout());
        setBackground(Color.black);

        // Load background image
        startscreenImage = ImageLoader.loadImage("src/images/StartScreen.png"); // Update the path if necessary

        // Initialize colors for button animation
        colors = new Color[]{
            new Color(139, 69, 19), // Brown
            new Color(0, 0, 0)      // Black
        };
        currentColorIndex = 0; // Start with the first color

        // Game title image label
        gameTitleImage = new JLabel();
        
        // Load the two images for animation
        titleImages = new BufferedImage[2];
        titleImages[0] = ImageLoader.loadImage("src/images/Title1.png");
        titleImages[1] = ImageLoader.loadImage("src/images/Title2.png");

        if (titleImages[0] != null) {
            gameTitleImage.setIcon(new ImageIcon(titleImages[0])); // Set the first image as the initial icon
        } else {
            gameTitleImage.setText("Cow Defense Force"); // Fallback text if the image fails to load
        }
        gameTitleImage.setHorizontalAlignment(JLabel.CENTER);

        // Layout setup for title image
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 10, 3, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(gameTitleImage, gbc);

        // Start button
        startButton = new StyledButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.resetGamePanel();
                TopHUDPanel.resetCowCounter();
                TopHUDPanel.resetCurrenWave();
                game.showGamePanel();
            }
        });

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(startButton, gbc);

        // GitHub button
        githubButton = new StyledButton("GitHub Repository");
        githubButton.addActionListener(e -> openWebpage("https://github.com/rostyslav-bilous/cbl-game"));

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

        // Project Group Label
        developedByLabel = new JLabel("Project Group 38");
        developedByLabel.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        developedByLabel.setForeground(Color.BLACK); // Set text color to black
        developedByLabel.setOpaque(true); // Make background visible
        developedByLabel.setBackground(Color.LIGHT_GRAY); // Set highlight color

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        add(developedByLabel, gbc);

        author1Label = new JLabel("| Rostyslav Bilous (2154803)");
        author1Label.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        author1Label.setForeground(Color.BLACK); // Set text color to black
        author1Label.setOpaque(true); // Make background visible
        author1Label.setBackground(Color.LIGHT_GRAY); // Set highlight color

        gbc.gridy = 6;
        add(author1Label, gbc);

        author2Label = new JLabel("| Suhail Abbas (2141523)");
        author2Label.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        author2Label.setForeground(Color.BLACK); // Set text color to black
        author2Label.setOpaque(true); // Make background visible
        author2Label.setBackground(Color.LIGHT_GRAY); // Set highlight color

        gbc.gridy = 7;
        add(author2Label, gbc);


        // Start color-changing animation for the Start button
        startColorAnimation();
        
        // Start image-switching animation for the game title
        startImageSwitchAnimation();
    }

    // Override paintComponent to draw the startscreen image
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image to cover the entire panel
        if (startscreenImage != null) {
            g.drawImage(startscreenImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Method to start the color-changing animation for the start button
    private void startColorAnimation() {
        Timer timer = new Timer(500, new ActionListener() { // Change color every 500 milliseconds
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColorIndex = (currentColorIndex + 1) % colors.length; // Cycle through colors
                startButton.setForeground(colors[currentColorIndex]); // Update the button color
            }
        });

        timer.start(); // Start the animation
    }

    // Method to start the image-switching animation for the game title
    private void startImageSwitchAnimation() {
        Timer timer = new Timer(1000, new ActionListener() { // Switch image every 1000 milliseconds
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex + 1) % titleImages.length; // Cycle through the images
                gameTitleImage.setIcon(new ImageIcon(titleImages[currentImageIndex])); // Set the next image
            }
        });

        timer.start(); // Start the image-switching animation
    }

    // Method to open a webpage
    private void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URI(urlString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



