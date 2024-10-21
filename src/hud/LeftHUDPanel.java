package hud;

import java.awt.*;
import javax.swing.*;

public class LeftHUDPanel extends JPanel {

    MoneyPanel moneyPanel;
    TowerListPanel towerListPanel;

    public LeftHUDPanel(int hudwidth, int hudheight) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  // Stack vertically
        setPreferredSize(new Dimension(hudwidth, hudheight));
        setBackground(Color.GREEN);
        
        
        
        moneyPanel = new MoneyPanel(hudwidth, hudheight/10);
        
        towerListPanel = new TowerListPanel(hudwidth, hudheight);
        JPanel spacer = new JPanel();

        add(moneyPanel);
        add(Box.createRigidArea(new Dimension(hudwidth,100))); // Adds a fixed horizontal spacer
        add(towerListPanel);
        add(Box.createRigidArea(new Dimension(hudwidth,150))); // Adds a fixed horizontal spacer
        
        //spacer.setPreferredSize(new Dimension(200, 300));
        //spacer.setBackground(Color.YELLOW);
        //add(spacer);
         

         
    }
}
