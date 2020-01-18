package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.view.View;

import javax.swing.*;
import java.awt.*;

public class GUIView extends JPanel implements View {
    static JFrame panel;

    private static final int width = 40;
    private static final int height = 40;

    private int posX;
    private int posY;

    public GUIView(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;

        initUI();
    }

    private void initUI() {
        if (panel == null) {
            panel = new JFrame("Square");
            panel.setSize(360, 120); //TODO: size should not be set this way
            panel.setLocationRelativeTo(null);
            panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel.setVisible(true);
        }
        panel.getContentPane().add(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(posX, posY, width, height);
    }

    public void print() {

    }
}
