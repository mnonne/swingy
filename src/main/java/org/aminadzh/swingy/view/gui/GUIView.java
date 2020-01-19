package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.view.View;

import javax.swing.*;
import java.awt.Graphics;


public class GUIView extends JPanel implements View {
    static JFrame panel;
    private ImageIcon imageIcon;

    private static final int width = 40;
    private static final int height = 40;

    private int posX;
    private int posY;

    public GUIView(int posX, int posY, String image) {
        initUI(posX, posY,image);
    }

    private void initUI(int posX, int posY, String image) {
        if (panel == null) {
            panel = new JFrame("Window");
            panel.setSize(900, 720); //TODO: size should not be set this way
            panel.setLocationRelativeTo(null);
            panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel.setVisible(true);
        }

        this.posX = posX;
        this.posY = posY;

        imageIcon = new ImageIcon(image);
//        panel.getContentPane().add(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(), posX, posY, this);
    }

    public void print() {

    }
}
