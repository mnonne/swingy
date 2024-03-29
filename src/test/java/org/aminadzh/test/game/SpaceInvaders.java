package org.aminadzh.test.game;

import javax.swing.*;
import java.awt.EventQueue;

public class SpaceInvaders extends JFrame {

    public SpaceInvaders() {
        initUI();
    }

    private void initUI() {
        add(new Board());

        setTitle("Space Invaders");
        setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SpaceInvaders ex = new SpaceInvaders();
            ex.setVisible(true);
        });
    }

}
