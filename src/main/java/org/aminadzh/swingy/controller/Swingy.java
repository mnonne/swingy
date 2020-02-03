package org.aminadzh.swingy.controller;

import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.view.IWindow;
import org.aminadzh.swingy.view.gui.GUIWindow;
import org.aminadzh.swingy.model.characters.Hero; //TODO: this is temporary. Factory is needed

import javax.swing.SwingUtilities;
import java.util.AbstractMap;
import java.util.Scanner;

public class Swingy {

    private static Swingy instance; // For singleton

    private IWindow window;

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
        Hero hero = new Hero("kek", 1, 1);

        window.startLevel(hero);
        updateMap(hero);
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

    public void updateMap(Hero hero) {
        //TODO: model update
        window.updateMap(hero);
    }

}
