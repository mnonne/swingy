package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.controller.Swingy;
import org.aminadzh.swingy.model.characters.GameCharacter;
import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.model.items.Item;
import org.aminadzh.swingy.view.IWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIWindow extends JFrame implements IWindow {

    private static int width;
    private static int height;

    GameBoard gameBoard;
    private BattleView battleView;

    public GUIWindow(String name, int width, int height) {
        this.width = width;
        this.height = height;
        setTitle(name);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addKeyListener(new KAdapter());
        setVisible(true);
    }

    public void startLevel(Hero hero, int lvl) {
        LevelMessage lvlMessage = new LevelMessage(hero, lvl, this);
        gameBoard = new GameBoard(hero);
        gameBoard.setPreferredSize(new Dimension(width, height));
        add(gameBoard);
        pack();
    }

    public void startBattle(Hero hero, GameCharacter enemy) {
        battleView = new BattleView(hero, enemy, this);
    }

    public void endBattle() {
        if (battleView != null) {
            battleView.dispose();
            battleView = null;
        }
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

    public void updateHeroView(Hero hero) {
        gameBoard.updateHeroView(hero);
    }

    public void addMessageToDialog(String msg) {
        gameBoard.addMessageToDialog(msg);
    }

    public void showDeathMessage() {
        DeathMessage popup = new DeathMessage(this);
    }

    public void itemDropDialog(Item item) {
        ItemMessage popup = new ItemMessage(item, this);
    }


    private class KAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key="+KeyEvent.getKeyText(e.getKeyCode()));
            System.out.println(e.getKeyCode());
            Swingy.getInstance().onKeyInput(e.getKeyCode());
        }

    }

}
