package managers;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
        
        Iterator<Tower> iterator = placedTowers.iterator();
        while(iterator.hasNext()) {
            Tower tower = iterator.next();
            if (!tower.isAlive()) {
                iterator.remove();
                continue;
            }
            tower.updateCooldown();
            if (tower.getActionValue() > 0) {
                tower.act();
            }
        }
    }

    public List<Tower> getTowersOnGrid() {
        return placedTowers;
    }

    public void draw(Graphics g) {
        for (Tower tower : placedTowers) {
            tower.draw(g);
        }
    }
}
