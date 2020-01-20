package org.aminadzh.swingy.view.gui;

import javax.swing.*;
import java.awt.EventQueue;

public class GUIBoard {
    JFrame frame;
    String name;
    int width;
    int height;

    public GUIBoard(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JFrame();
                frame.setTitle(name);
                frame.setSize(width, height);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public void addView(JPanel panel) {
        frame.add(panel);
    }
}
