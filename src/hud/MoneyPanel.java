package hud;

import java.awt.*;
import javax.swing.JPanel;

public class MoneyPanel extends JPanel{

    private int money = 110;

    public MoneyPanel(int hudwidth, int hudheight) {
        
        
        
        setLayout(null); // Disable the layout manager
        //setSize(hudwidth, 50); // Hardcoded size, will maintain position
        setBackground(Color.BLUE);
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

        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.WHITE);
        g.drawString("[|] " + money, 10, 60);
    }
}
