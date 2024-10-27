package core;

import hud.LeftHUDPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class FirstContainer extends JPanel {
    private LeftHUDPanel hud1;
    public int midPanelWidth;
    public int midPanelHeight;

    public FirstContainer() {
        

        setLayout(new GridBagLayout());
        setOpaque(false);

        // Create and add left and right thin panels using a helper method
        addSpacingPanel(0, 1, 0.05, 0.9, 1, 1, false); // Left thin panel at (0,1) with weightx = 0.01
        addSpacingPanel(2, 1, 0.05, 0.9, 1, 1, false); // Right thin panel at (2,1) with weightx = 0.01
        addSpacingPanel(1, 1, 0.9, 0.9, 1, 1, true); // Mid panel
        addSpacingPanel(0, 0, 1, 0.05, 3, 1, false); // Top spacer
        addSpacingPanel(0, 2, 1, 0.05, 3, 1, false); // Bottom spacer
    }

    // Method to create and add a thin panel
    private void addSpacingPanel(int gridx, int gridy, double weightx, double weighty, int gridwidth, int gridheight, boolean ishud) {
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.gridx = gridx;
        gbc2.gridy = gridy;
        gbc2.weightx = weightx;
        gbc2.weighty = weighty;
        gbc2.gridwidth = gridwidth;
        gbc2.gridheight = gridheight;

        if (ishud) {
            // Create a midPanel to hold the HUD
            JPanel midPanel = new JPanel();
            midPanel.setOpaque(false); // Set opaque to true to visualize it
            midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));

            // Add the LeftHUDPanel to the midPanel
            hud1 = new LeftHUDPanel();
            midPanel.add(hud1);


            // Add the midPanel (which now contains the HUD) to the FirstContainer
            add(midPanel, gbc2);
        } else {
            // Otherwise, add a thin transparent panel
            JPanel thinPanel = new JPanel();
            thinPanel.setOpaque(false); // Set the panel to be transparent
            add(thinPanel, gbc2);
        }
    }
}
