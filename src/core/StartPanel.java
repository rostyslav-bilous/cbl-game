package core;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class StartPanel extends JPanel {

    private JButton startButton;

    public StartPanel(Game game) {

        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);

        startButton = new JButton("Start");
        startButton.setBackground(new Color(50, 50, 50));
        startButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        startButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(200, 70));
        startButton.setFocusPainted(false);
        startButton.setFont(new Font("Arial", Font.BOLD, 20));

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setBackground(new Color(75, 75, 75));
                startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setBackground(new Color(50, 50, 50));
            }
        });


        JLabel gameName = new JLabel("Cows vs Aliens");
        gameName.setForeground(Color.WHITE);
        gameName.setFont(new Font("Arial", Font.BOLD, 32));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        add(gameName, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(startButton, gbc);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.showGamePanel();
            }
        });
    }
}
