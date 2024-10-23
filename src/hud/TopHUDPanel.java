// Repeat reseting the game also in the Start, Loss, Win screens to make sure 
// it's reset and avoid some bugs related to this mechanism

package hud;

import utils.Constants;
import java.awt.*;
import javax.swing.*;

import core.Game;


public class TopHUDPanel extends JPanel{
    
    private static int cowCounter = 5;
    public static int maxWaveCounter = 5;
    public static int currentWave = 0;
    private Game game; // Reference to the Game instance

    public TopHUDPanel(Game game) {
        
        this.game = game;
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(1200, 50));
        setOpaque(true);
    }

    public static void decreaseCowCounter(Game game) {
        
        cowCounter--;
        if (cowCounter <= 0) {
            game.resetGamePanel();
            resetCowCounter();  // Cow counter is static, don't want to change it now
            resetCurrenWave();
            game.showLossPanel();
        }
    }

    public static void checkWave(Game game) {
        if (currentWave > maxWaveCounter) {
            game.resetGamePanel();
            resetCowCounter();  // Cow counter is static, don't want to change it now
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

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString("^__^ " + cowCounter, 10, 50);
        g.drawString("Wave " + currentWave + "/" + maxWaveCounter, 200, 50);
    }
    
}
