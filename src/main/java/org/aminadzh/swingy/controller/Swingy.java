package org.aminadzh.swingy.controller;

import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.model.items.swords.RustySword;
import org.aminadzh.swingy.view.IWindow;
import org.aminadzh.swingy.view.gui.GUIWindow;
import org.aminadzh.swingy.model.characters.Hero; //TODO: this is temporary. Factory is needed

import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.util.AbstractMap;
import java.util.Scanner;

public class Swingy {

    private static Swingy instance; // For singleton
    private IWindow window;
    private Hero hero;

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
                    window = new GUIWindow("Swingy", 1200, 600);
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
        hero.obtainSword(new RustySword());

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
                break;
            case (MOVE_DOWN):
               moveHeroDown();
                break;
            case (MOVE_LEFT):
                moveHeroLeft();
                break;
            case (MOVE_UP):
                moveHeroUp();
                break;
            default:
                break;
        }

        updateMap();
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
