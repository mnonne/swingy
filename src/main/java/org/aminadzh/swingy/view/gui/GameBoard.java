package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.model.characters.Hero;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    private GridBagConstraints gridBagConstraints;

    private MapView mapView;

    public GameBoard(Hero hero) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        initMapView(hero.getLevel());
    }

    void initMapView(int heroLevel) {
        int mapSize = (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
        mapView = new MapView(mapSize);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 3;
        gridBagConstraints.weighty = 3;
        mapView.setPreferredSize(new Dimension(GUIWindow.getWindowHeight(), GUIWindow.getWindowHeight()));
        mapView.setMaximumSize(new Dimension(GUIWindow.getWindowHeight(), GUIWindow.getWindowHeight()));
        mapView.setMinimumSize(new Dimension(GUIWindow.getWindowHeight(), GUIWindow.getWindowHeight()));
        add(mapView, gridBagConstraints);
    }

}
