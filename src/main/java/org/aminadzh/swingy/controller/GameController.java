package org.aminadzh.swingy.controller;

import org.aminadzh.swingy.model.player.*;
import org.aminadzh.swingy.view.*;
import org.aminadzh.swingy.view.Window;
import org.aminadzh.swingy.view.gui.GUIBoard;
import org.aminadzh.swingy.view.gui.GUIView;

import java.awt.*;
import java.util.AbstractMap;

public class GameController {
    AbstractMap.SimpleEntry<Hero, View> player1;
    AbstractMap.SimpleEntry<Hero, View> player2;
    Window window;

    int WIN_WIDTH = 940;
    int WIN_HEIGHT = 480;

    public GameController() {
        Board board = new GUIBoard(0, 0, WIN_WIDTH * 3 / 5, WIN_HEIGHT, Color.DARK_GRAY);
        player1 = new AbstractMap.SimpleEntry<>(new Warrior("Peeves"),
                new GUIView("assets/rpg-pack/chars/sensei/sensei.png", 50, 50));
        board.addView(player1.getValue());
        window = WindowFactory.createGUIWindow("Swingy", WIN_WIDTH, WIN_HEIGHT, (GUIBoard) board);

        // Printing loop
        while(true) {
            window.draw();
        }
    }
}
