package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.view.View;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;


public class GUIView extends JPanel implements View {
    static GUIBoard board;
    private ImageIcon imageIcon;

    private static final int width = 40;
    private static final int height = 40;

    private int posX;
    private int posY;

    public GUIView(int posX, int posY, String image) {
        initUI(posX, posY,image);
    }

    private void initUI(int posX, int posY, String image) {
        if (board == null) {
            board = new GUIBoard("Window", 900, 720); //TODO: size should not be set this way
//            board.setSize(900, 720);
//            board.setLocationRelativeTo(null);
//            board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            board.setVisible(true);
        }

        this.posX = posX;
        this.posY = posY;

        imageIcon = new ImageIcon(image);
        board.addView(this);
//        panel.getContentPane().add(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawImage(imageIcon.getImage(), posX, posY, this);
    }

    public void print() {

    }
}
