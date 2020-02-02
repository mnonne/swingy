package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.view.IObjectView;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUIView extends JPanel implements IObjectView {

    private BufferedImage bufferedImage;

    private int width;
    private int height;

    public GUIView(String filePath, int width, int height) {
        try {
            bufferedImage = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bufferedImage,0, 0, width, height, this);
    }

}
