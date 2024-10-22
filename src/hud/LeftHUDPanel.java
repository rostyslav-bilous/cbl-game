
package hud;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import utils.ImageLoader;

public class LeftHUDPanel extends JPanel {

        
        
    private BufferedImage hudimage;
    private static MoneyPanel moneyPanel;
    TowerListPanel towerListPanel;


    public LeftHUDPanel(int hudwidth, int hudheight) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  // Stack vertically
        setPreferredSize(new Dimension(hudwidth, hudheight));
        setBackground(Color.GREEN);
        //setOpaque(false);
        

        hudimage = ImageLoader.loadImage("src/HUD.png");
        
        moneyPanel = new MoneyPanel(hudwidth, hudheight);
        
        
        towerListPanel = new TowerListPanel(hudwidth, hudheight);

        add(Box.createRigidArea(new Dimension(0, 50))); // Smaller vertical spacer
        add(moneyPanel); 
        // Adjust the rigid area between moneyPanel and towerListPanel
        add(Box.createRigidArea(new Dimension(0, 100))); // Smaller vertical spacer
        add(towerListPanel);
        add(Box.createRigidArea(new Dimension(0, 170))); // Spacer below towerListPanel if needed
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // If the image is loaded, draw it
        if (hudimage != null) {
            g.drawImage(hudimage, 0, 0, getWidth(), getHeight(), this); // Draw the image to cover the entire panel
        }
    }

    public static MoneyPanel getMoneyPanel() {
        return moneyPanel;
    }
}
 