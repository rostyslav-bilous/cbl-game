package managers;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import entities.Tower;
import map.*;

public class TowerManager {
    
    private List<Tower> placedTowers;

    public TowerManager() {
        placedTowers = new ArrayList<>();
    }

    public void addTower(Tower tower) {
        placedTowers.add(tower);
    }

    public void draw(Graphics g) {
        for (Tower tower : placedTowers) {
            tower.draw(g);
        }
    }
}
