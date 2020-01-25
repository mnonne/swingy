package org.aminadzh.swingy.view.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import org.aminadzh.swingy.view.View;

public class GUIBoard extends JPanel {
    private ArrayList<GUIView> drawables;
    private ArrayList<Background> backgrounds;

    int tileSize;

    GUIBoard() {
        setFocusable(true);
        setFocusable(true);
        drawables = new ArrayList<>();
        backgrounds = new ArrayList<>();
    }

    public void setTileSize(int size) {
        this.tileSize = size;

        for (GUIView drawable : drawables) {
            drawable.setWidth(size);
            drawable.setHeight(size);
        }
    }

    public void addView(View view) {
        drawables.add((GUIView) view); // TODO: this is not safe
        if (tileSize > 0) {
            drawables.get(drawables.size() - 1).setHeight(tileSize);
            drawables.get(drawables.size() - 1).setWidth(tileSize);
        }
    }

    public void addBackground(int posX, int posY, int width, int height, Color color) {
        backgrounds.add(new Background(posX, posY, width, height, color));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawings(g);
    }

    private void doDrawings(Graphics g) {
        for (Background bg : backgrounds) {
            g.setColor(bg.getColor());
            g.fillRect(bg.getPosX(), bg.getPosY(), bg.getWidth(), bg.getHeight());
        }

        for(GUIView drawable : drawables) {
            drawable.draw(g,  this);
        }
    }

    private void drawGround(Graphics g) {
//        g.drawImage(tile.getImage(), tile.getPosX(), tile.getPosY(), this);
    }

    private class Background {
        private int posX;
        private int posY;
        private int width;
        private int height;
        private Color bg;

        Background(int posX, int posY, int width, int height, Color bg) {
            this.posX = posX;
            this.posY = posY;
            this.width = width;
            this.height = height;
            this.bg = bg;
        }

        int getPosX() {
            return posX;
        }

        int getPosY() {
            return posY;
        }

        int getWidth() {
            return width;
        }

        int getHeight() {
            return height;
        }

        Color getColor() {
            return bg;
        }
    }

}
