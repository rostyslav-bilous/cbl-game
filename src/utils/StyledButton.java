

 package utils;

 import java.awt.*;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
 import javax.swing.*;
 
 public class StyledButton extends JButton {
 
     public StyledButton(String text) {
         super(text);
 
         // Customize the button appearance
         setForeground(new Color(92, 64, 51)); // Bright text color
         setBackground(new Color(245,245,245)); //off white
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
                 setBackground(new Color(255, 253, 208)); // cream
                 setForeground(new Color(92, 64, 51)); // 
                 
             }
 
             @Override
             public void mouseExited(MouseEvent e) {
                 setBackground(new Color(245,245,245)); // Reset to original background color
                 setForeground(new Color(92, 64, 51)); // brown
                 setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 4, true)); // Reset to original thinner border
                 setFont(getFont().deriveFont(20f)); // Reset to original font size
             }
         });
     }
 }
 