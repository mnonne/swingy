package org.aminadzh.swingy.model.characters;

public class HeroFactory {

    static final int attack = 10;
    static final int defence = 5;
    static final int hitpoints = 100;

    static public Hero createHero(String name, int specialization) {
        switch (specialization) {
            case Hero.WARRIOR:
                return new Hero(name, Hero.WARRIOR, 1, attack, defence + 1, hitpoints);
            case Hero.MAGE:
                return new Hero(name, Hero.MAGE, 1, attack, defence, hitpoints + 10);
            case Hero.ROGUE:
                return new Hero(name, Hero.ROGUE, 1, attack + 2, defence, hitpoints);
        }
        return null;
    }

}
