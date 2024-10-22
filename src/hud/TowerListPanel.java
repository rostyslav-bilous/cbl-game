package hud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class TowerListPanel extends JPanel {

    public TowerListPanel(int hudwidth, int hudheight) {

        setLayout(new GridLayout(0, 1));
        setPreferredSize(new Dimension(hudwidth, hudheight / 2));
        setBackground(Color.RED);

        // Initialize tower buttons
        initializeTowerButtons();
    }

    // Initialize buttons from the list of tower names
    private void initializeTowerButtons() {
        // Example tower names; replace with actual Tower instances if necessary
        String[] towerNames = {"MooCop", "DairyPotter"}; // Add more names if needed

        for (String towerName : towerNames) {
            // Example price for each tower
            addTowerButton(towerName, 20); // Assume 20 is the default price
        }
    }

    // Helper method to create a button for a specific tower
    private void addTowerButton(String towerName, int price) {
        TowerButton button = new TowerButton(towerName, price);
        add(button);  // Add the button to the panel
    }
}
