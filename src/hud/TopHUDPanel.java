// Repeat reseting the game also in the Start, Loss, Win screens to make sure 
// it's reset and avoid some bugs related to this mechanism

package hud;

import core.Game;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import utils.ImageLoader;

public class TopHUDPanel extends JPanel {

    private static int cowCounter = 5; 
    public static int maxWaveCounter = 5;
    public static int currentWave = 0;
    private Game game; // Reference to the Game instance

    // Load background image
    private BufferedImage Tophudimage;

    public TopHUDPanel(Game game) {
        this.game = game;
        setBackground(Color.WHITE); // Optional: set background color in case image doesn't load
        setPreferredSize(new Dimension(300, 50));

        // Load background image (fill entire panel with this image)
        Tophudimage = ImageLoader.loadImage("src/images/TopHUD.png");  // Make sure the image path is correct
    }

    public static void decreaseCowCounter(Game game) {
        cowCounter--;
        if (cowCounter <= 0) {
            game.resetGamePanel();
            resetCowCounter();  // Cow counter is static, don't want to change it now
            resetCurrenWave(); // Reset current wave
            game.showLossPanel(); // Show loss panel
        }
    }

    public static void checkWave(Game game) {
        if (currentWave > maxWaveCounter) { 
            game.resetGamePanel();
            resetCowCounter();  
            resetCurrenWave(); 
            game.showWinPanel(); 
        }
    }

    public static void increaseCurrentWave() {
        currentWave++;
    }

    public int getCowCounter() {
        return cowCounter;
    }

    public static void resetCowCounter() {
        cowCounter = 5;
    }

    public static void resetCurrenWave() {
        currentWave = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image, scaled to fill the entire panel
        if (Tophudimage != null) {
            g.drawImage(Tophudimage, 0, 0, getWidth(), getHeight(), this);
        }

        // Draw a border around the panel for better visibility
        g.setColor(Color.GRAY);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        // Set font for the cow counter and increase size
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30)); 
        g.setColor(new Color(100, 100, 100)); // Set text color to (100, 100, 100)
        int cowCounterY = (getHeight() / 2) + (g.getFontMetrics().getHeight() / 4);
        int cowCounterX = 770; 
        g.drawString("Cow Counter: " + cowCounter, cowCounterX, cowCounterY); 

        // Set font and color for the wave counter
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30)); 
        g.setColor(new Color(100, 100, 100)); // Set text color to (100, 100, 100)
        int waveCounterY = (getHeight() / 2) + (g.getFontMetrics().getHeight() / 4);
        int waveCounterX = 100; 
        g.drawString("Wave " + currentWave + "/" + maxWaveCounter, waveCounterX, waveCounterY);
    }
}
