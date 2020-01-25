package org.aminadzh.swingy.view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import org.aminadzh.swingy.view.View;
import org.aminadzh.swingy.view.Board;

public class GUIBoard extends JPanel implements Board {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private Color bgColor;

    private GUIView tile;

    private ArrayList<GUIView> drawables;

    public GUIBoard(int posX, int posY, int width, int height, Color bgColor) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.bgColor = bgColor;
        setFocusable(true);

        tile = new GUIView("assets/rpg-pack/tiles/generic-rpg-tile32.png", 0, 0, 32, 46);
        drawables = new ArrayList<>();
    }

    public void addView(View view) {
        drawables.add((GUIView) view); // TODO: this is not safe
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        System.out.println("KEK");
        doDrawings(g);
    }

    private void doDrawings(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(posX, posY, width, height);

        drawGround(g);

        for(GUIView drawable : drawables) {
            drawable.draw(g, this);
        }
    }

    private void drawGround(Graphics g) {
//        g.drawImage(tile.getImage(), tile.getPosX(), tile.getPosY(), this);
    }

}
