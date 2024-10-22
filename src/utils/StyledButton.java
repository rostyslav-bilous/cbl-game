package utils;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StyledButton extends JButton {

    public StyledButton(String text) {
        
        // Call the superclass constructor to set the button text
        super("| " + text);

        // Customize the button appearance
        setForeground(new Color(150, 150, 150));
        setBackground(Color.RED);
        setFont(new Font("Times New Roman", Font.ITALIC, 17));
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setHorizontalAlignment(SwingConstants.LEFT);
        setMargin(new Insets(0, 0, 0, 0));

        // Add hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(new Color(150, 150, 150));
            }
        });
    }
}
