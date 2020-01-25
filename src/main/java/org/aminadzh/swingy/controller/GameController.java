package org.aminadzh.swingy.controller;

import org.aminadzh.swingy.model.player.*;
import org.aminadzh.swingy.view.*;
import org.aminadzh.swingy.view.Window;
import org.aminadzh.swingy.view.gui.GUIBoard;
import org.aminadzh.swingy.view.gui.GUIView;

import java.awt.event.KeyEvent;

public class GameController {
    View playerView;
    Hero playerModel;
    Window window;
    Board board;

    int WIN_WIDTH = 766;
    int WIN_HEIGHT = 460;

    public GameController() {
        board = new GUIBoard(WIN_HEIGHT, WIN_HEIGHT, 30);
        playerModel = new Warrior("Peeves");
        playerView = new GUIView("assets/rpg-pack/chars/sensei/sensei.png", 0, 0);
        board.addView(playerView);
        window = WindowFactory.createGUIWindow("Swingy", WIN_WIDTH, WIN_HEIGHT + 22, (GUIBoard) board, this); // 22 is width of window menu line
    }

    public void readInput(int code) {
        if (code == KeyEvent.VK_RIGHT) {
            if (playerView.getPosX() + board.getTileWidth() < WIN_HEIGHT) {
                playerView.setPosX(playerView.getPosX() + board.getTileWidth());
            }
        }
        else if (code == KeyEvent.VK_LEFT) {
            if (playerView.getPosX() > 0) {
                playerView.setPosX(playerView.getPosX() - board.getTileWidth());
            }
        }
        else if (code == KeyEvent.VK_UP) {
            if (playerView.getPosY() > 0) {
                playerView.setPosY(playerView.getPosY() - board.getTileWidth());
            }
        }
        else if (code == KeyEvent.VK_DOWN) {
            if (playerView.getPosY() + board.getTileWidth() < WIN_HEIGHT) {
                playerView.setPosY(playerView.getPosY() + board.getTileWidth());
            }
        }

        window.draw();
    }

}
