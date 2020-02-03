package org.aminadzh.swingy.model.characters;

import org.aminadzh.swingy.model.GameObject;

public class GameCharacter {

    private String name;
    private int level = 1; //TODO: remove initialization
    private long experience;
    private int attack;
    private int defence;
    private int hitPoints;
    private int posX;
    private int posY;

    //TODO: artifacts (helmet, weapon, armor)

    public GameCharacter(String name, int posX, int posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
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

    public String getSpriteFilePath() {
        return "./assets/mage.png";
    }

}
