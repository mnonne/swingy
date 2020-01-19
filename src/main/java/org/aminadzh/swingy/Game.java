package org.aminadzh.swingy;

import org.aminadzh.swingy.controller.GameController;

public class Game {
    public static GameController gameController;

    public static void main(String[] args) {
        gameController = new GameController();
    }
}
