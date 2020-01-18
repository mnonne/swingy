package org.aminadzh.swingy.model.player;

import org.aminadzh.swingy.HeroClass;
import org.aminadzh.swingy.model.Artefact;

public abstract class Hero {
    private String name;
    private HeroClass heroClass;
    private int level;
    private long experience;
    private int attack;
    private int defence;
    private int hp;
    private Artefact helmet;
//    private Artefact armor;
//    private Artefact weapon;

    protected Hero(String name, HeroClass heroClass, int attack, int defence, int hp) {
        this.name = name;
        this.heroClass = heroClass;
        this.attack = attack;
        this.defence = defence;
        this.hp = hp;

        level = 0;
        experience = 0;
        helmet = null;
    }
}
