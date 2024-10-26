package hud;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import map.Tile;
import utils.ImageLoader; // Make sure to import your ImageLoader

public class TowerButton extends JButton {

    private String towerName;
    private int towerPrice;  // Tower price for validation

    public TowerButton(String towerName, int towerPrice) {
        this.towerName = towerName;
        this.towerPrice = towerPrice;

        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);

        // Load the image based on the tower name
        loadTowerImage();

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if player has enough money to buy the tower
                if (enoughMoney()) {
                    Tile.selectedTower = towerName;
                    Tile.selectedTowerPrice = towerPrice;

                    System.out.println(towerName + " selected for placement.");
                } else {
                    System.out.println("Not enough money to buy " + towerName);
                }
            }
        });
    }

    private void loadTowerImage() {
        String imagePath = "src/images/" + towerName + "Button.png"; // Adjust path if necessary
        BufferedImage towerImage = ImageLoader.loadImage(imagePath);

        if (towerImage != null) {
            // Resize the image to fit the button
            ImageIcon icon = new ImageIcon(towerImage.getScaledInstance(215, 100, java.awt.Image.SCALE_SMOOTH)); // Change 100, 100 to your desired button size
            setIcon(icon);
        } else {
            System.out.println("Image not found for " + towerName);
        }
    }

    private boolean enoughMoney() {
        return LeftHUDPanel.getMoneyPanel().getMoney() >= towerPrice;
    }
}

