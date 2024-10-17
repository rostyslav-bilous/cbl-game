package hud;

import java.awt.*;
import javax.swing.*;

public class LeftHUDPanel extends JPanel {

    MoneyPanel moneyPanel;
    TowerListPanel towerListPanel;

    public LeftHUDPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  // Stack vertically

        moneyPanel = new MoneyPanel();
        towerListPanel = new TowerListPanel();
        JPanel spacer = new JPanel();

        add(moneyPanel);
        add(Box.createRigidArea(new Dimension(10, 40))); // Adds a fixed horizontal spacer
        add(towerListPanel);
        spacer.setOpaque(false);
        spacer.setPreferredSize(new Dimension(1000, 300));
        add(spacer);
    }
}
