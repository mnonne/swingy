package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.view.View;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class GUIView implements View {
    private Image image;
    private int posX;
    private int posY;

    public GUIView(String imageFile, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;

        ImageIcon ii = new ImageIcon(imageFile);
        image = ii.getImage();
    }

    Image getImage() {
        return image;
    }

    int getPosX() {
        return posX;
    }

    int getPosY() {
        return posY;
    }
}
