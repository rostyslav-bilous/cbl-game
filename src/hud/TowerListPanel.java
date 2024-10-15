package hud;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TowerListPanel extends JPanel {

    public TowerListPanel() {
        setLayout(new GridLayout(0, 1));  // Vertical list of buttons
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(1000, 200));

        // Add buttons for each tower type
        addTowerButton("MooCop", 20);
        addTowerButton("DairyPotter", 20);
    }

    // Helper method to create a button for a specific tower
    private void addTowerButton(String towerName, int price) {
        TowerButton button = new TowerButton(towerName, price);
        add(button);  // Add the button to the panel
    }
}
