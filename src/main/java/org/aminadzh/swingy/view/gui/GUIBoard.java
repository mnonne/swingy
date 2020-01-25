package org.aminadzh.swingy.view.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import org.aminadzh.swingy.view.View;
import org.aminadzh.swingy.view.Board;

public class GUIBoard extends JPanel implements Board {
    private int width;
    private int height;
    private int tiles;

    private GUIView tile;

    private GUIView hero;

    private ArrayList<GUIView> drawables;

    public GUIBoard(int width, int height, int tiles) {
        this.width = width;
        this.height = height;
        this.tiles = tiles;
        setFocusable(true);

//        tile = new GUIView("assets/rpg-pack/tiles/generic-rpg-tile32.png", 0, 0, 32, 46);
        drawables = new ArrayList<>();
    }

    public void addView(View view) {
        drawables.add((GUIView) view); // TODO: this is not safe
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawings(g);
    }

    private void doDrawings(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, width, height);

        drawGround(g);

        for(GUIView drawable : drawables) {
            drawable.draw(g, height / tiles, width / tiles, this);
        }
    }

    private void drawGround(Graphics g) {
//        g.drawImage(tile.getImage(), tile.getPosX(), tile.getPosY(), this);
    }

    public int getTileWidth() {
        return width / tiles;
    }


}
