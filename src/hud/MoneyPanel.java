package hud;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoneyPanel extends JPanel{

    private int money = 100;
    JLabel moneyLabel;

    public MoneyPanel(int hudwidth, int hudheight) {
        
        //setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(hudwidth, hudheight/5));
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
