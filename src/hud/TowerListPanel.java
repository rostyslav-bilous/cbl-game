package hud;

import entities.Tower;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;


public class TowerListPanel extends JPanel {
    
    private List<Tower> availableTowers = new ArrayList<>();

    public TowerListPanel(int hudwidth, int hudheight) {

        setLayout(new GridLayout(0, 1));
        setPreferredSize(new Dimension(hudwidth, hudheight/2));
        setBackground(Color.RED);

        initializeTowerButtons();   
    }

    private void initializeTowerButtons() {
        // Example tower names; replace with actual Tower instances if necessary
        String[] towerNames = {"MooCop", "DairyPotter"}; // Add more names if needed

        for (String towerName : towerNames) {
            TowerButton button = new TowerButton(towerName);

            // Add button to the panel
            add(button);
            //add(Box.createRigidArea(new Dimension(0, 0))); // Adds a fixed vertical spacer between buttons
            
            
        }
    }
}
