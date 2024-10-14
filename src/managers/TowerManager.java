package managers;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import entities.Tower;
import entities.towers.MooCop;
import map.*;

public class TowerManager {
    
    private List<Tower> placedTowers;

    public TowerManager() {
        placedTowers = new ArrayList<>();
    }

    public void addTower(Tower tower) {
        placedTowers.add(tower);
    }

    public void update() {
        for (Tower tower : placedTowers) {
            tower.updateCooldown();
            if (tower.getActionValue() > 0) {
                tower.act();
            }
        }
    }

    public void draw(Graphics g) {
        for (Tower tower : placedTowers) {
            tower.draw(g);
        }
    }
}
