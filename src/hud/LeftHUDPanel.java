package hud;

import java.awt.*;
import java.awt.event.*;
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
        add(towerListPanel);
        spacer.setOpaque(false);
        spacer.setPreferredSize(new Dimension(1000, 400));
        add(spacer);
    }
}
