package org.aminadzh.swingy.model.characters;

import org.aminadzh.swingy.model.GameObject;

public class GameCharacter {

    private String name;
    private int level = 1; //TODO: remove initialization
    private int attack = 1;
    private int defence = 2;
    private int hitPoints = 100;
    private int maxHitPoints = 100;
    private int posX;
    private int posY;

    //TODO: artifacts (helmet, weapon, armor)

    public GameCharacter(String name, int posX, int posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
    }

    public void takeDamage(int dmg) {
        hitPoints -= dmg; // TODO: set dead
    }

    public int getLevel() {
        return level;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getName() {
        return name;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public String getSpriteFilePath() {
        return "./assets/mage.png";
    }

}
