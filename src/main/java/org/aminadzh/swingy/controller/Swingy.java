package org.aminadzh.swingy.controller;

import org.aminadzh.swingy.model.characters.GameCharacter;
import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.model.characters.Skeleton;
import org.aminadzh.swingy.model.items.Item;
import org.aminadzh.swingy.model.items.armor.GlassArmor;
import org.aminadzh.swingy.model.items.armor.LetherArmor;
import org.aminadzh.swingy.model.items.armor.SteelArmor;
import org.aminadzh.swingy.model.items.shields.DragonShield;
import org.aminadzh.swingy.model.items.shields.HolyShield;
import org.aminadzh.swingy.model.items.shields.WoodenShield;
import org.aminadzh.swingy.model.items.swords.*;
import org.aminadzh.swingy.view.IWindow;
import org.aminadzh.swingy.view.gui.GUIWindow;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Swingy {

    private SaveManager saveManager;

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

    private int level = 1;

    private Swingy() {
        saveManager = new SaveManager();
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
                    hero = chooseHero();
                    startLevel(hero);
                }
            });
        }
        else {
            System.out.println("Not implemented yet"); // TODO: needs implementation
        }
    }

    private Hero chooseHero() {
        ArrayList<Hero> heroes;

        heroes = saveManager.loadSaves();

        if (heroes.size() > 0) {
//            try {
            for (Hero h : heroes)
                System.out.println("Hero: " + h.getName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }

        return new Hero("Kek", "Mage", 1, 10, 3, 100);
    }

    private void startLevel(Hero hero) {
        battleMode = false;
        this.hero = hero;
        this.hero.resetPosition();

        window.startLevel(hero, level);
        window.updateMap(hero);
    }

    private void nextLevel(Hero hero) {
        saveManager.save(hero);
        startLevel(hero);
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
                if (hero.getHitPoints() < hero.getMaxHitPoints()) {
                    hero.heal();
                    window.updateHeroView(hero);
                }
                if (outOfMap(hero)) {
                    level++;
                    nextLevel(hero);
                    return;
                }
                window.addMessageToDialog(msg + hero.getName() + " has moved to X: " + hero.getPosX() + " Y: " + hero.getPosY());
                if (thereIsAnEnemy(hero.getPosX(), hero.getPosY())) {
                    window.addMessageToDialog(msg + hero.getName() + " has met an enemy");
                    battleMode = true;
                    window.startBattle(hero, generateEnemy());
                }
            }
        }
    }

    private GameCharacter generateEnemy() {
        Random rand = new Random();
        int nb = rand.nextInt(level) + 1;

        return new Skeleton(nb, Skeleton.attackForLevel(nb), Skeleton.defenceForLevel(nb), Skeleton.hpForLevel(nb));
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

            Item item = checkDropp(enemy);
            if (item != null) {
                window.itemDropDialog(item);
            }

            window.updateHeroView(hero);
        } else {
            window.addMessageToDialog(msg + hero.getName() + " was defeated by " + enemy.getName());
            window.updateHeroView(hero);
            window.showDeathMessage();
//            startGame(); //TODO: redo this
        }
    }

    private Item checkDropp(GameCharacter enemy) {
        Random rand = new Random();
        int upperbound = 3; // Rate of dropping is 1/3
        if (rand.nextInt(upperbound) == 2) {
            int random = rand.nextInt(upperbound);
            switch (random) {
                case 0:
                    return generateArmor(enemy.getLevel());
                case 1:
                    return generateWeapon(enemy.getLevel());
                case 2:
                    return generateShield(enemy.getLevel());
            }
        }

        return null;
    }

    public void userAgreedItem(Item item) {
        hero.obtainItem(item);
        window.updateHeroView(hero);
    }

    private Item generateArmor(int lvl) {
        if (lvl < 4) {
            return new LetherArmor();
        } else if (lvl < 7) {
            return new SteelArmor();
        }
        return new GlassArmor();
    }

    private Item generateWeapon(int lvl) {
        if (lvl < 4) {
            return new RustySword();
        } else if (lvl < 7) {
            return new SteelSword();
        } else if (lvl < 11) {
            return new GrassSword();
        }
        return new BloodSword();
    }

    private Item generateShield(int lvl) {
        if (lvl < 4) {
            return new WoodenShield();
        } else if (lvl < 7) {
            return new DragonShield();
        }
        return new HolyShield();
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
            hero.moveRight();
    }

    private void moveHeroLeft() {
            hero.moveLeft();
    }

    private void moveHeroDown() {
            hero.moveDown();
    }

    private void moveHeroUp() {
            hero.moveUp();
    }

    private boolean outOfMap(Hero hero) {
        int mapSize = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
        int posX = hero.getPosX();
        int posY = hero.getPosY();
        if (posX > mapSize || posX <= 0 || posY > mapSize || posY <= 0 ) {
            return true;
        }
        return false;
    }

}
