package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.model.characters.Hero;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapView extends JPanel {

    final private String groundSpritePath = "./assets/ground.png";
    private int mapSize;

    private JPanel grid;
    private GridBagConstraints gridBagConstraints;
    private JScrollPane scrollPane;

    public MapView(int mapSize) {
        this.mapSize = mapSize;


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

        grid.setLayout(new GridLayout(mapSize, mapSize, 0, 0));
        grid.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.BLACK));
    }

    public void onUpdate(Hero hero) {
        grid.removeAll();
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                GUIView ground;
                if (hero.getPosX() - 1 == x && hero.getPosY() - 1 == y) {
                    ground = new GUIView(Math.max(getWidth() / mapSize, 23),
                            Math.max(getHeight() / mapSize, 23), groundSpritePath, hero.getSpriteFilePath());
                } else {
                    ground = new GUIView(Math.max(getWidth() / mapSize, 23),
                            Math.max(getHeight() / mapSize, 23), groundSpritePath);
                }
                ground.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
                grid.add(ground);
            }
        }

        scrollPane.validate();
        scrollPane.repaint();
    }

    public int getGridSize() {
        return Math.max(getWidth() / mapSize, 23);
    }

}
