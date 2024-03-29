package org.aminadzh.swingy.model.characters;
import org.aminadzh.swingy.model.items.Armor;
import org.aminadzh.swingy.model.items.Item;
import org.aminadzh.swingy.model.items.Shield;
import org.aminadzh.swingy.model.items.Sword;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "hero")
public class Hero extends GameCharacter {

    private long experience = 0;
    private long expToNextLevel = 0;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    private Item sword;
    @OneToOne(cascade = CascadeType.ALL, optional = true)
    private Item shield;
    @OneToOne(cascade = CascadeType.ALL, optional = true)
    private Item armor;
    @Column(name = "specialization")
    private int specialization;

    static public final int WARRIOR = 0;
    static public final int MAGE = 1;
    static public final int ROGUE = 2;

    public Hero() {
        super();
    }

    public Hero(String name, int specialization, int level, int attack, int defence, int maxHitPoints) {
        super(name, level, attack, defence, maxHitPoints);
        this.specialization = specialization;
        expToNextLevel = getLevel() * 1000 + (getLevel() - 1) * (getLevel() - 1) * 450;
    }

    public void resetPosition() {
        int pos = ((getLevel() - 1) * 5 + 10 - (getLevel() % 2)) / 2 + 1;
        this.setPosX(pos);
        this.setPosY(pos);
    }

    private void setSword(Item sword) {
        this.sword = sword;
    }

    private void setShield(Item shield) {
        this.shield = shield;
    }

    private void setArmor(Item armor) {
        this.armor = armor;
    }

    public void obtainItem(Item item) {
        if (item instanceof Armor) {
            setArmor(item);
        } else if (item instanceof Sword) {
            setSword(item);
        } else if (item instanceof Shield) {
            setShield(item);
        }
    }

    public void takeDamage(int dmg) {
        if (armor != null) {
            float defence = (float)dmg / 100 * getDefence();
            dmg = dmg - (int)Math.ceil(defence);
            super.takePureDamage(dmg);
        } else {
            super.takeDamage(dmg);
        }
    }

    public void takeExperience(int amount) {
        experience += amount;
        if (experience >= expToNextLevel) {
            levelUp();
            experience = 0;
            calcNextLevel();
        }
    }

    public void heal() {
        if (getHitPoints() < getMaxHitPoints()) {
            increaseHp(1);
        }
    }

    public int getSpecialization() {
        return specialization;
    }

    public void setSpecialization(int specialization) {
        this.specialization = specialization;
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
            return super.getMaxHitPoints() + shield.getBonus();
        }
        return super.getMaxHitPoints();
    }

    public int getDefence() {
        if (armor != null) {
            return super.getDefence() + armor.getBonus();
        }
        return super.getDefence();
    }

    protected void levelUp() {
        int lvl = getLevel();
        super.levelUp();

        if (lvl < getLevel()) {
            setAttack(getAttack() + 3);
            setDefence(getDefence() + 3);
            setMaxHitPoints(getMaxHitPoints() + 3);
            setHitPoints(getMaxHitPoints());
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

    public String getStringSpecialization() {
        switch (specialization) {
            case WARRIOR:
                return "Warrior";
            case MAGE:
                return "Mage";
            case ROGUE:
                return "Rogue";
            default:
                return "";
        }
    }

    public String getSpriteFilePath() {
        return "./assets/mage.png";
    }

    private void calcNextLevel() {
        expToNextLevel = getLevel() * 1000 + (getLevel() - 1) * (getLevel() - 1) * 450;
    }

}
