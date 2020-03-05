package org.aminadzh.swingy.model.characters;

public abstract class GameCharacter {

    private String name;
    private int level;
    private int attack;
    private int defence;
    private int hitPoints;
    private int maxHitPoints;
    private int posX;
    private int posY;

    public GameCharacter(String name) {
        this.name = name;
    }

    public GameCharacter(String name, int level, int attack, int defence, int maxHitPoints) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.maxHitPoints = maxHitPoints;
        hitPoints = maxHitPoints;
    }

    public void takeDamage(int dmg) {
        dmg = dmg - dmg / 100 * defence;
        if (dmg - defence > 0) {
            hitPoints -= dmg;
            hitPoints = hitPoints < 0 ? 0 : hitPoints;
        }
    }

    public void takePureDamage(int dmg) {
        hitPoints -= dmg;
        hitPoints = hitPoints < 0 ? 0 : hitPoints;
    }

    protected void levelUp() {
        level++;
    }

    protected void increaseHp(int amount) {
        hitPoints += amount;
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

    protected void setAttack(int val) {
        attack = val;
    }

    protected void setDefence(int val) {
        defence = val;
    }

    protected void setHitPoints(int val) {
        hitPoints = val;
    }

    protected void setMaxHitPoints(int val) {
        maxHitPoints = val;
    }

}
