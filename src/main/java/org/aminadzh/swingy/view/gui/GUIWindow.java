package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.controller.Swingy;
import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.view.IWindow;

import javax.swing.JFrame;
import java.awt.*;

public class GUIWindow extends JFrame implements IWindow {

    private static int width;
    private static int height;

    GameBoard gameBoard;

    public GUIWindow(String name, int width, int height) {
        this.width = width;
        this.height = height;
        setTitle(name);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void startLevel(Hero hero) {
        gameBoard = new GameBoard(hero);
        gameBoard.setPreferredSize(new Dimension(width, height));
        add(gameBoard);
        pack();
    }

    public static int getWindowWidth() {
        return width;
    }

    public static int getWindowHeight() {
        return height;
    }

    public void updateMap(Hero hero) {
        gameBoard.updateMap(hero);
    }

}
