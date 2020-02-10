package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.model.characters.Hero;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    private MapView mapView;
    private HeroView heroView;
    private DialogView dialogView;

    public GameBoard(Hero hero) {
        setLayout(new GridBagLayout());

        heroView = new HeroView(hero);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridheight = 3;
        heroView.setPreferredSize(new Dimension(GUIWindow.getWindowWidth() / 4, GUIWindow.getWindowHeight()));
        heroView.setMinimumSize(new Dimension(GUIWindow.getWindowWidth() / 4, GUIWindow.getWindowHeight()));
        heroView.setMaximumSize(new Dimension(GUIWindow.getWindowWidth() / 4, GUIWindow.getWindowHeight()));
        add(heroView, c);

        int mapSize = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
        mapView = new MapView(mapSize);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 3;
        c.weighty = 3;
        mapView.setPreferredSize(new Dimension(GUIWindow.getWindowHeight(), GUIWindow.getWindowHeight()));
        mapView.setMaximumSize(new Dimension(GUIWindow.getWindowHeight(), GUIWindow.getWindowHeight()));
        mapView.setMinimumSize(new Dimension(GUIWindow.getWindowHeight(), GUIWindow.getWindowHeight()));
        add(mapView, c);

        dialogView = new DialogView();
        c.gridx = 4;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridheight = 3;
        dialogView.setPreferredSize(new Dimension(GUIWindow.getWindowWidth() / 4, GUIWindow.getWindowHeight()));
        dialogView.setMinimumSize(new Dimension(GUIWindow.getWindowWidth() / 4, GUIWindow.getWindowHeight()));
        dialogView.setMaximumSize(new Dimension(GUIWindow.getWindowWidth() / 4, GUIWindow.getWindowHeight()));
        add(dialogView, c);
    }

    void updateMap(Hero hero) {
        mapView.onUpdate(hero);
    }

}
