package org.aminadzh.swingy.model.characters;
import org.aminadzh.swingy.model.items.Item;

public class Hero extends GameCharacter {

    private long experience = 5;
    private long expToNextLevel = 100;

    private Item sword;
    private Item shield;
    private Item armor;

    private String specialization;

    public Hero(String name, String specialization) {
        super(name);
        this.specialization = specialization;
        int pos = ((getLevel() - 1) * 5 + 10 - (getLevel() % 2)) / 2 + 1;
        System.out.println(pos);
        this.setPosX(pos);
        this.setPosY(pos);
    }

    public void obtainSword(Item sword) {
        this.sword = sword;
    }

    public void obtainShield(Item shield) {
        this.shield = shield;
    }

    public void obtainArmor(Item armor) {
        this.armor = armor;
    }

    public Item getSword() {
        return sword;
    }

    public Item getShield() {
        return shield;
    }

    public Item getArmor() {
        return armor;
    }

    public int getAttack() {
        if (sword != null) {
            return super.getAttack() + sword.getBonus();
        }
        return super.getAttack();
    }

    public int getMaxHitPoints() {
        if (shield != null) {
            return super.getHitPoints() + shield.getBonus();
        }
        return super.getMaxHitPoints();
    }

    public int getDefence() {
        if (armor != null) {
            return super.getDefence() + armor.getBonus();
        }
        return super.getDefence();
    }

    public void takeDamage(int dmg) {
        if (armor != null) {
            super.takeDamage(dmg - armor.getBonus());
        } else {
            super.takeDamage(dmg);
        }
    }

    public long getExperience() {
        return experience;
    }

    public long getExpToNextLevel() {
        return expToNextLevel;
    }

    public void moveRight() {
        setPosX(getPosX() + 1);
    }

    public void moveLeft() {
        setPosX(getPosX() - 1);
    }

    public void moveUp() {
        setPosY(getPosY() - 1);
    }

    public void moveDown() {
        setPosY(getPosY() + 1);
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getSpriteFilePath() {
        return "./assets/mage.png";
    }

}
