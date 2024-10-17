package hud;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import map.Tile;

public class TowerButton extends JButton {

    private String towerName;
    private int towerPrice;  // Tower price for validation

    public TowerButton(String towerName, int towerPrice) {
        this.towerName = towerName;
        this.towerPrice = towerPrice;

        setBackground(Color.BLACK);
        setText(towerName);
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);

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

    private boolean enoughMoney() {
        return LeftHUDPanel.getMoneyPanel().getMoney() >= towerPrice;
    }
}
