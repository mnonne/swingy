package org.aminadzh.swingy.model.characters;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public abstract class GameCharacter {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private int level;
    @Column(name = "attack")
    private int attack;
    @Column(name = "defence")
    private int defence;
    @Column(name = "hitPoints")
    private int hitPoints;
    private int posX;
    @Column(name = "maxHitPoints")
    private int maxHitPoints;
    private int posY;

    public GameCharacter() {}

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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    protected void setMaxHitPoints(int val) {
        maxHitPoints = val;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    protected void setHitPoints(int val) {
        hitPoints = val;
    }

    public int getAttack() {
        return attack;
    }

    protected void setAttack(int val) {
        attack = val;
    }

    public int getDefence() {
        return defence;
    }

    protected void setDefence(int val) {
        defence = val;
    }

    abstract public String getSpriteFilePath();

}
