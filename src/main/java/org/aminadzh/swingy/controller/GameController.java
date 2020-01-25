package org.aminadzh.swingy.controller;

import org.aminadzh.swingy.model.player.*;
import org.aminadzh.swingy.view.*;
import org.aminadzh.swingy.view.Window;
import org.aminadzh.swingy.view.gui.GUIBoard;
import org.aminadzh.swingy.view.gui.GUIView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.AbstractMap;

public class GameController {
    HeroController player;
    AbstractMap.SimpleEntry<Hero, View> player2;
    Window window;
    Board board;

    int WIN_WIDTH = 766;
    int WIN_HEIGHT = 460;

    public GameController() {
        board = new GUIBoard(0, 0, WIN_WIDTH * 3 / 5, WIN_HEIGHT, Color.DARK_GRAY);
        player = new HeroController(new Warrior("Peeves"),
                new GUIView("assets/rpg-pack/chars/sensei/sensei.png", 0, 0, 32, 46));
        board.addView(player.getView());
        window = WindowFactory.createGUIWindow("Swingy", WIN_WIDTH, WIN_HEIGHT, (GUIBoard) board, this);
    }

    public void readInput(int code) {
        if (code == KeyEvent.VK_RIGHT) {
            player.moveRight();
        }

        window.draw();
    }

}
