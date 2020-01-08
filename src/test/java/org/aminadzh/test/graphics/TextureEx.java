package org.aminadzh.test.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class TextSurface extends JPanel {

    private BufferedImage slate;
    private TexturePaint slatetp;

    public TextSurface() {

        loadImages();
    }

    private void loadImages() {

        try {
            System.out.println(System.getProperty("user.dir"));
            slate = ImageIO.read(new File("index.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Surface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        slatetp = new TexturePaint(slate, new Rectangle(0, 0, 90, 60));

        g2d.setPaint(slatetp);
        g2d.fillRect(10, 15, 90, 60);

        g2d.dispose();

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);

    }

}

public class TextureEx extends JFrame  {

    public TextureEx() {

        initUI();

    }

    private void initUI() {

        add(new TextSurface());

        setTitle("Textures");
        setSize(360, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] Args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TextureEx ex = new TextureEx();
                ex.setVisible(true);
            }
        });

    }

}
