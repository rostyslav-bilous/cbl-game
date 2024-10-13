package hud;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import utils.Constants;

class RoundedPanel extends JPanel {
    private Color __backgroundColor__; // Underlined unofficial variable

    public RoundedPanel(Color __backgroundColor__) {
        this.__backgroundColor__ = __backgroundColor__;
        setOpaque(false); // Make the panel transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded rectangle
        g2d.setColor(__backgroundColor__);
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50)); // Adjust arc width and height for roundness
    }
}

public class HUD extends RoundedPanel {
    private RoundedPanel cowCounterPanel;
    private RoundedPanel currencyPanel;
    private RoundedPanel towerPanel1;
    private RoundedPanel towerPanel2;
    private RoundedPanel towerPanel3;
    private Image cowskin;

    public HUD() {
        super(Color.gray); // Call the parent constructor with a color

        // Set layout for the HUD
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Load the image
        cowskin = new ImageIcon(getClass().getResource("cowskin.png")).getImage(); // image object

        // Create and configure the cow counter panel
        cowCounterPanel = new RoundedPanel(Color.CYAN); // For visibility
        cowCounterPanel.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH / 10, Constants.WINDOW_HEIGHT / 10)); // Set preferred size
        cowCounterPanel.setMaximumSize(new Dimension(Constants.WINDOW_WIDTH / 10, Constants.WINDOW_HEIGHT / 10)); // Prevent resizing
        cowCounterPanel.add(new JLabel("Cows: 0")); // Sample content

        // Create and configure the currency panel
        currencyPanel = new RoundedPanel(Color.CYAN); // For visibility
        currencyPanel.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH / 10, Constants.WINDOW_HEIGHT / 10)); // Set preferred size
        currencyPanel.setMaximumSize(new Dimension(Constants.WINDOW_WIDTH / 10, Constants.WINDOW_HEIGHT / 10)); // Prevent resizing
        currencyPanel.add(new JLabel("Currency: $0")); // Sample content

        // Create tower panels
        towerPanel1 = new RoundedPanel(Color.CYAN); // For visibility
        towerPanel1.setPreferredSize(new Dimension((Constants.WINDOW_WIDTH / 8), (Constants.WINDOW_HEIGHT / 8))); // Set preferred size
        towerPanel1.setMaximumSize(new Dimension((Constants.WINDOW_WIDTH / 8), (Constants.WINDOW_HEIGHT / 8))); // Prevent resizing
        towerPanel1.add(new JLabel("Tower 1:")); // Sample content

        towerPanel2 = new RoundedPanel(Color.CYAN); // For visibility
        towerPanel2.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH / 8, Constants.WINDOW_HEIGHT / 8)); // Set preferred size
        towerPanel2.setMaximumSize(new Dimension(Constants.WINDOW_WIDTH / 8, Constants.WINDOW_HEIGHT / 8)); // Prevent resizing
        towerPanel2.add(new JLabel("Tower 2:")); // Sample content

        towerPanel3 = new RoundedPanel(Color.CYAN); // For visibility
        towerPanel3.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH / 8, Constants.WINDOW_HEIGHT / 8)); // Set preferred size
        towerPanel3.setMaximumSize(new Dimension(Constants.WINDOW_WIDTH / 8, Constants.WINDOW_HEIGHT / 8)); // Prevent resizing
        towerPanel3.add(new JLabel("Tower 3:")); // Sample content

        // Add panels to the HUD
        add(Box.createVerticalStrut(20)); // Add space above
        add(cowCounterPanel);
        add(Box.createVerticalStrut(20)); // Add space between
        add(currencyPanel);
        add(Box.createVerticalStrut(100));
        add(towerPanel1);
        add(Box.createVerticalStrut(10));
        add(towerPanel2);
        add(Box.createVerticalStrut(10));
        add(towerPanel3);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call this first

        Graphics2D g2d = (Graphics2D) g.create(); // Create a copy of the graphics context

        // Set the clip to the rounded rectangle
        g2d.setClip(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));

        // Draw the image, scaling to fit the panel
        if (cowskin != null) {
            g2d.drawImage(cowskin, 0, 0, getWidth(), getHeight(), this); // Draw the image
        } else {
            g2d.setColor(Color.MAGENTA); // Fallback color if the image is not loaded
            g2d.fillRect(0, 0, getWidth(), getHeight()); // Fill the background with the fallback color
        }

        g2d.dispose(); // Dispose of the graphics context
    }

}
