package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.view.Window;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIWindow extends JFrame implements Window {
    private int width = 960;
    private int height = 640;

    public GUIWindow(String name, int width, int height, GUIBoard board) {
        setTitle(name);
        setSize(width, height);
        setLocationRelativeTo(null);
        add(board);
        addKeyListener(new TAdapter());
        setVisible(true);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void draw() {
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }

    }

}
