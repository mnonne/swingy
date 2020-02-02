package org.aminadzh.swingy.view.gui;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapView extends JPanel {

    final private String spritePath = "./assets/ground.png";
    private int mapSize;

    private BufferedImage groundSprite;
    private JPanel grid;
    private GridBagConstraints gridBagConstraints;
    private JScrollPane scrollPane;

    public MapView(int mapSize) {
        this.mapSize = mapSize;
        try {
            groundSprite = ImageIO.read(new File(spritePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        initGrid();
    }

    void initGrid() {
        setLayout(new GridBagLayout());
        grid = new JPanel();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;

        scrollPane = new JScrollPane(grid);
        add(scrollPane, gridBagConstraints);
    }


}
