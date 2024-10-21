package hud;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.*;

public class MoneyPanel extends JPanel{

    private int money = 110;

    public MoneyPanel() {
        
        setLayout(new GridBagLayout());
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(200, 100));
        setOpaque(true);
    }
    
    public void increaseMoneyBy(int amount) {
        money += amount;
    }

    public void decreaseMoneyBy(int amount) {
        money -= amount;
    }

    public int getMoney() {
        return money;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString("[|] " + money, 10, 60);
    }
}
