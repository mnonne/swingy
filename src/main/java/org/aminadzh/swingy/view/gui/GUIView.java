package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.view.View;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.ImageObserver;

public class GUIView implements View {
    private Image image;
    private int posX;
    private int posY;
    private int width;
    private int height;

    public GUIView(String imageFile, int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;

        ImageIcon ii = new ImageIcon(imageFile);
        image = ii.getImage();
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
        System.out.println("KEK");
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(image, posX + (height - width) / 2, posY, width, height, observer);
    }
}
