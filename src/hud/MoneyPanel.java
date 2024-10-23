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

        // Use Graphics2D for better control over rendering
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Smoother font

        // Set font and color
        Font font = new Font("Comic Sans MS", Font.BOLD, 30);
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);

        // Get font metrics to center the text
        FontMetrics fm = g2d.getFontMetrics(font);
        String text = "Milk Left:" + money;
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();

        // Calculate position to center the text horizontally and vertically
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2 - fm.getDescent();

        // Draw the string at the calculated position
        g2d.drawString(text, x, y);
    }
}

