package map;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;

import utils.Constants;

public class Tile extends JButton {
    
    private boolean occupied = false;

    public Tile() {

        setPreferredSize(new Dimension(Constants.TILE_WIDTH, Constants.TILE_HEIGHT));
        setBackground(Color.GREEN);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!occupied) {
                    occupied = true;
                    setBackground(Color.RED);
                }
            }
        });
    }
}
