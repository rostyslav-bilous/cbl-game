/*
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
 */

 package utils;

 import java.awt.*;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
 import javax.swing.*;
 
 public class StyledButton extends JButton {
 
     public StyledButton(String text) {
         super(text);
 
         // Customize the button appearance
         setForeground(new Color(255, 255, 255)); // Bright text color
         setBackground(new Color(255, 69, 0)); // Vibrant background color (Orange-Red)
         setFont(new Font("Comic Sans MS", Font.BOLD, 20)); // More playful, game-like font
         setFocusPainted(false); // Disable focus ring
         setContentAreaFilled(false); // Remove default button fill
         setBorderPainted(false); // Remove default border
         setOpaque(true); // Make background opaque
         setHorizontalAlignment(SwingConstants.CENTER); // Center-align text
         setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
         setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 4, true)); // Initial border
 
         // Add hover effect with consistent border thickness
         addMouseListener(new MouseAdapter() {
             @Override
             public void mouseEntered(MouseEvent e) {
                 setBackground(new Color(255, 140, 0)); // Lighter orange on hover
                 setForeground(new Color(255, 255, 255)); // Keep white text on hover
                 //setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 6, true)); // Fixed thicker border on hover
                 //setFont(getFont().deriveFont(20f)); // Increase font size slightly on hover
             }
 
             @Override
             public void mouseExited(MouseEvent e) {
                 setBackground(new Color(255, 69, 0)); // Reset to original background color
                 setForeground(new Color(255, 255, 255)); // Keep white text
                 setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 4, true)); // Reset to original thinner border
                 setFont(getFont().deriveFont(20f)); // Reset to original font size
             }
         });
     }
 }
 