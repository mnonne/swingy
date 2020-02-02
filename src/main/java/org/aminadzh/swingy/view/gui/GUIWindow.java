package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.view.IWindow;

import javax.swing.JFrame;

public class GUIWindow extends JFrame implements IWindow {

    private final static int width = 1200;
    private final static int height = 600;

    GameBoard gameBoard;

    public GUIWindow(String name) {
        setSize(width, height);
        setTitle(name);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void startLevel(Hero hero) {
        gameBoard = new GameBoard(hero);
        add(gameBoard);
    }

    public static int getWindowWidth() {
        return width;
    }

    public static int getWindowHeight() {
        return height;
    }

}
