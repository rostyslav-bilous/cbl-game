package hud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import map.GridBoard;
import map.Tile;

public class TowerButton extends JButton{
    
    String towerName;
    // GridBoard gridBoard;

    public TowerButton(String towerName) {

        // setPreferredSize(new Dimension(100, 400));
        // this.gridBoard = gridBoard;
        setBackground(Color.BLACK);
        setText(towerName);
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tile.selectedTower = towerName;
            }
        });
    }


}
