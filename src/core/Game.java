package core;

import javax.swing.JFrame;

class Game extends JFrame {

    private GamePanel gamePanel;

    public Game() {

        setTitle("Cows vs Aliens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new GamePanel();
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}