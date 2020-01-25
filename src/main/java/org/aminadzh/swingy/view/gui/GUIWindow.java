package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.controller.GameController;
import org.aminadzh.swingy.view.Window;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIWindow extends JFrame implements Window {

    public GUIWindow(String name, int width, int height, GUIBoard board, GameController controller) {
        setTitle(name);
        setSize(width, height);
        setLocationRelativeTo(null);
        add(board);
        addKeyListener(new TAdapter(controller));
        setVisible(true);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
