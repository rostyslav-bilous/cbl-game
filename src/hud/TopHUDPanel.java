package hud;

import utils.Constants;
import java.awt.*;
import javax.swing.*;

public class TopHUDPanel extends JPanel{
    
    private static int cowCounter = 5;

    public TopHUDPanel() {
        
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(1200, 50));
        setOpaque(true);
    }

    public static void decreaseCowCounter() {
        cowCounter--;
    }

    public int getCowCounter() {
        return cowCounter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString("^__^ " + cowCounter, 10, 50);
    }
    
}
