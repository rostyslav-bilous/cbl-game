package core;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import hud.TopHUDPanel;
import utils.StyledButton;

public class LossPanel extends JPanel{

    StyledButton tryAgainButton;
    StyledButton menuButton;
    
    public LossPanel(Game game) {

        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);

        JLabel lossLabel = new JLabel("Game Over");
        lossLabel.setForeground(new Color(255, 255, 255));
        lossLabel.setFont(new Font("Helvetica", Font.BOLD, 40));

        tryAgainButton = new StyledButton("Try Again");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.resetGamePanel();
                TopHUDPanel.resetCowCounter();  // Cow counter is static, don't want to change it now
                TopHUDPanel.resetCurrenWave();
                game.showGamePanel();
            }
        });


        menuButton = new StyledButton("Back to Menu");
        menuButton.addActionListener(e -> game.showStartPanel());

        // Layout setup
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 10, 3, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        add(lossLabel, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(tryAgainButton, gbc);

        gbc.gridy = 2;
        add(menuButton, gbc);
    }
}
