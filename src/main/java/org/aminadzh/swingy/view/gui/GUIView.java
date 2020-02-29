package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.view.IObjectView;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUIView extends JPanel implements IObjectView {

    private BufferedImage[] bufferedImages;

    private int width;
    private int height;

    public GUIView(int width, int height, String... files) {
        bufferedImages = new BufferedImage[files.length];
        for (int i = 0; i < files.length; i++) {
            try {
                bufferedImages[i] = ImageIO.read(new File(files[i]));
            } catch (IOException e) {
                System.out.println("Failed to load file " + files[i]);
            }
        }
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < bufferedImages.length; i++) {
            g.drawImage(bufferedImages[i], 0, 0, width, height, this);
        }
    }

}
