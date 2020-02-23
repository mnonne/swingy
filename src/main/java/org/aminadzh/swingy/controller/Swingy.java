package org.aminadzh.swingy.controller;

import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.model.items.shields.HolyShield;
import org.aminadzh.swingy.model.items.swords.*;
import org.aminadzh.swingy.view.IWindow;
import org.aminadzh.swingy.view.gui.GUIWindow;

import javax.swing.SwingUtilities;
import java.util.Scanner;

public class Swingy {

    private static Swingy instance; // For singleton
    private IWindow window;
    private Hero hero;

    public static final int WIN_WIDTH = 1200;
    public static final int WIN_HEIGHT = 600;

    private final int MOVE_LEFT = 37;
    private final int MOVE_UP = 38;
    private final int MOVE_RIGHT = 39;
    private final int MOVE_DOWN= 40;

    private Swingy() {

    }

    public void startGame() {
        String viewMode = null;

        while (true) {
            System.out.println("Choose game mode (\"console\" or \"gui\")");
            Scanner scanner = new Scanner(System.in);
            viewMode = scanner.nextLine();
            if (viewMode.equals("console") || viewMode.equals("gui")) {
                break;
            }
            System.out.println("No such mode as \"" + viewMode + "\"");
        }
        if (viewMode.equals("gui")) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    window = new GUIWindow("Swingy", WIN_WIDTH, WIN_HEIGHT);
                    startLevel();
                }
            });
        }
        else {
            System.out.println("Not implemented yet"); // TODO: needs implementation
        }
    }

    private void startLevel() {
        //TODO: needed normal player initialization
        hero = new Hero("Kek", 1, 1);
        hero.obtainSword(new BloodSword());
        hero.obtainShield(new HolyShield());

        window.startLevel(hero);
        updateMap();
    }

    public static Swingy getInstance() {
        if (instance == null) {
            instance = new Swingy();
        }
        return instance;
    }

    public static void main(String[] args) {
        Swingy.getInstance().startGame();
    }

    public void updateMap() {
        //TODO: model update
        window.updateMap(hero);
    }

    public void onKeyInput(int command) {
        switch (command) {
            case (MOVE_RIGHT):
                moveHeroRight();
                window.updateMap(hero);
                break;
            case (MOVE_DOWN):
               moveHeroDown();
                window.updateMap(hero);
                break;
            case (MOVE_LEFT):
                moveHeroLeft();
                window.updateMap(hero);
                break;
            case (MOVE_UP):
                moveHeroUp();
                window.updateMap(hero);
                break;
            default:
                break;
        }
    }

    private void moveHeroRight() {
        if (hero.getPosX() < (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2)) {
            hero.moveRight();
        }
    }

    private void moveHeroLeft() {
        if (hero.getPosX() > 1) {
            hero.moveLeft();
        }
    }

    private void moveHeroDown() {
        if (hero.getPosY() < (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2)) {
            hero.moveDown();
        }
    }

    private void moveHeroUp() {
        if (hero.getPosY() > 1) {
            hero.moveUp();
        }
    }

}
