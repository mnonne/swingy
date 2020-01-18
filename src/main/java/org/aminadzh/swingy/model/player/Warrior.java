package org.aminadzh.swingy.model.player;

import org.aminadzh.swingy.HeroClass;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name, HeroClass.WARRIOR, 3, 5, 50);
    }
}
