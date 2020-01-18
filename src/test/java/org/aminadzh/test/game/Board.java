package org.aminadzh.test.game;

import org.aminadzh.test.game.sprite.Alien;
import org.aminadzh.test.game.sprite.Player;
import org.aminadzh.test.game.sprite.Shot;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Board extends JPanel {

    private Dimension d;
    private List<Alien> aliens;
    private Player player;
    private Shot shot;

    private int direction = -1;
    private int deaths = 0;

    private boolean inGame = true;
    private String explImg = "src/images/explosion.png";
    private String message = "GameOver";

    private Timer timer;

    public Board() {
//        initBoard();
//        gameInit();
    }

//    private void initBoard() {
//        addKeyListener(new TAdapter());
//    }

}
