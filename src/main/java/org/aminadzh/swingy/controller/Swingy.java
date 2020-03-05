package org.aminadzh.swingy.controller;

import org.aminadzh.swingy.model.characters.GameCharacter;
import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.model.characters.Skeleton;
import org.aminadzh.swingy.model.items.armor.GlassArmor;
import org.aminadzh.swingy.model.items.armor.LetherArmor;
import org.aminadzh.swingy.model.items.shields.HolyShield;
import org.aminadzh.swingy.model.items.swords.*;
import org.aminadzh.swingy.view.IWindow;
import org.aminadzh.swingy.view.gui.GUIWindow;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.SwingUtilities;
import java.util.Random;
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

    private boolean battleMode;

    private boolean godMode = false;

    private Swingy() {

    }

    public void startGame() {
        String viewMode = null;

        window = null;

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
        battleMode = false;
        //TODO: needed normal player initialization
        hero = new Hero("Kek", "Mage", 1, 10, 3, 100);

        window.startLevel(hero);
        window.updateMap(hero);
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


    public void onKeyInput(int command) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String msg = dtf.format(now) + ">> ";
        if (!battleMode) {
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
                case (80):
                    godMode = !godMode;
                default:
                    break;
            }


            if (command >= MOVE_LEFT && command <= MOVE_DOWN) {
                window.addMessageToDialog(msg + hero.getName() + " has moved to X: " + hero.getPosX() + " Y: " + hero.getPosY());
                if (thereIsAnEnemy(hero.getPosX(), hero.getPosY())) {
                    window.addMessageToDialog(msg + hero.getName() + " has met an enemy");
                    battleMode = true;
                    window.startBattle(hero, new Skeleton(1, Skeleton.attackForLevel(1), Skeleton.defenceForLevel(1), Skeleton.hpForLevel(1)));
                }
            }
        }
    }

    public void tryToEscape(GameCharacter enemy) {
        Random rand = new Random();
        int upperbound = 100;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String msg = dtf.format(now) + ">> ";

        if (rand.nextInt(upperbound) % 2 == 0) {
            window.addMessageToDialog(msg + hero.getName() + " successfully escaped from battle");
        } else {
            window.addMessageToDialog(msg + hero.getName() + " failed to escape from battle");
            startBattle(hero, enemy);
        }
        window.endBattle();
        battleMode = false;
    }

    public void startBattle(Hero hero, GameCharacter enemy) {
        window.endBattle();
        battleMode = false;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String msg = dtf.format(now) + ">> ";
        window.addMessageToDialog(msg + hero.getName() + " starting battle with " + enemy.getName());
        int counter = 1;
        while (hero.getHitPoints() > 0 && enemy.getHitPoints() > 0) {
            if (counter % 2 == 0) {
                attack(hero, enemy);
            } else {
                if (!godMode) {
                    attack(enemy, hero);
                }
            }
            counter++;
        }

        // Hero has won
        if (hero.getHitPoints() > 0) {
            hero.takeExperience(enemy.getMaxHitPoints());
            window.addMessageToDialog(msg + hero.getName() + " has won " + enemy.getName());
            window.updateHeroView(hero);
        } else {
            window.addMessageToDialog(msg + hero.getName() + " was defeated by " + enemy.getName());
            window.showDeathMessage();
//            startGame(); //TODO: redo this
        }
    }

    private void attack(GameCharacter attacker, GameCharacter defender) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String msg = dtf.format(now) + ">> ";

        Random rand = new Random();
        int upperbound = 100;
        if (rand.nextInt(upperbound) > 70) {
            window.addMessageToDialog(msg + attacker.getName() + " misses");
            return;
        }

        defender.takeDamage(attacker.getAttack());
        window.addMessageToDialog(msg + attacker.getName() + " hits for " + attacker.getAttack());
        window.addMessageToDialog(msg + defender.getName() + "'s HP is " + defender.getHitPoints());
    }

    private boolean thereIsAnEnemy(int posX, int posY) {
        Random rand = new Random();
        int upperbound = 100;
        if (posX % 2 == 0 && posY % 2 != 0) {
            upperbound = 80;
        }

        if (rand.nextInt(upperbound) > 75) {
            return true;
        }
        return false;
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
