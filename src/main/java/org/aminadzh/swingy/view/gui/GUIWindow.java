package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.controller.GameController;
import org.aminadzh.swingy.view.Window;
import org.aminadzh.swingy.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GUIWindow extends JFrame implements Window {
    private GUIBoard panel;

    public GUIWindow(String name, int width, int height, GameController controller) {
        panel = new GUIBoard();
        panel.addBackground(0, 0, height, height, Color.DARK_GRAY);
        panel.setPreferredSize(new Dimension(width, height));
        add(panel);
        setTitle(name);
        pack();
        setLocationRelativeTo(null);
        addKeyListener(new TAdapter(controller));
        setVisible(true);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setTileNum(int n) {
        panel.setTileSize(panel.getHeight() / n);
    }

    public void addDrawable(View view) {
        panel.addView(view);
    }

    public void draw() {
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        private GameController receiver;

        public TAdapter(GameController controller) {
            receiver = controller;
        }

        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
            if (receiver != null) {
                receiver.readInput(e.getKeyCode());
            }
        }

    }

}
