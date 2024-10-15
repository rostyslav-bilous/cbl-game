package hud;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.*;

public class MoneyPanel extends JPanel{

    private int money = 100;

    public MoneyPanel() {
        
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(200, 100));
        setOpaque(false);
    }
    
    public void increaseMoneyBy(int amount) {
        money += amount;
    }

    public void decreaseMoneyBy(int amount) {
        money -= amount;
    }

    public void draw(Graphics g) {

        g.setFont(new Font("Times New Roman", Font.BOLD, 20)); 
        g.setColor(Color.BLACK); // Example: Blue color
        g.drawString("Milk // " + money, 10, 60);
    }
}
