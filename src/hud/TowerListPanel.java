package hud;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import entities.Tower;
import utils.Constants;

import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.constant.Constable;
import java.util.ArrayList;


public class TowerListPanel extends JPanel {
    
    private List<Tower> availableTowers = new ArrayList<>();

    public TowerListPanel() {

        setLayout(new GridLayout(2, 0));
        setPreferredSize(new Dimension(1000, 200));
        setBackground(Color.RED);

        initializeTowerButtons();   
    }

    private void initializeTowerButtons() {
        // Example tower names; replace with actual Tower instances if necessary
        String[] towerNames = {"MooCop", "Dairy Potter"}; // Add more names if needed

        for (String towerName : towerNames) {
            TowerButton button = new TowerButton(towerName);

            // Add button to the panel
            add(button);
        }
    }
}
