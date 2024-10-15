package hud;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MoneyPanel extends JPanel{

    private int money = 100;
    JLabel moneyLabel;

    public MoneyPanel() {
        
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(200, 100));
        setBackground(Color.BLUE);
        moneyLabel = new JLabel(money + " Milk buckets");
        moneyLabel.setForeground(Color.WHITE);
        add(moneyLabel);
    }
    
    public void increaseMoneyBy(int amount) {
        money += amount;
    }

    public void decreaseMoneyBy(int amount) {
        money -= amount;
    }
}
