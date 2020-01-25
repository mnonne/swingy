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

    int WIN_WIDTH = 766;
    int WIN_HEIGHT = 460;

    public GameController() {
//        board = new GUIBoard(WIN_HEIGHT, WIN_HEIGHT, 10);
        playerModel = new Warrior("Peeves");
        playerView = new GUIView("assets/sensei.png", 0, 0, 5, 5);
//        board.addView(playerView);
        window = WindowFactory.createGUIWindow("Swingy", WIN_WIDTH, WIN_HEIGHT + 22, this); // 22 is width of window menu line
        window.setTileNum(50);
        window.addDrawable(playerView);
    }

    public void readInput(int code) {
        if (code == KeyEvent.VK_RIGHT) {
            if (playerView.getPosX() + playerView.getWidth() < WIN_HEIGHT) {
                playerView.setPosX(playerView.getPosX() + playerView.getWidth());
            }
        }
        else if (code == KeyEvent.VK_LEFT) {
            if (playerView.getPosX() > 0) {
                playerView.setPosX(playerView.getPosX() - playerView.getWidth());
            }
        }
        else if (code == KeyEvent.VK_UP) {
            if (playerView.getPosY() > 0) {
                playerView.setPosY(playerView.getPosY() - playerView.getWidth());
            }
        }
        else if (code == KeyEvent.VK_DOWN) {
            if (playerView.getPosY() + playerView.getHeight() < WIN_HEIGHT) {
                playerView.setPosY(playerView.getPosY() + playerView.getWidth());
            }
        }

        window.draw();
    }

}
