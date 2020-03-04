package org.aminadzh.swingy.model.characters;

public abstract class GameCharacter {

    private String name;
    private int level = 1; //TODO: remove initialization
    private int attack = 10;
    private int defence = 2;
    private int hitPoints = 100;
    private int maxHitPoints = 100;
    private int posX;
    private int posY;

    public GameCharacter(String name) {
        this.name = name;
    }

    public void takeDamage(int dmg) {
        if (dmg - defence > 0) {
            hitPoints -= dmg - defence;
        }
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

    abstract public String getSpriteFilePath();

}
