package org.aminadzh.swingy.model.characters;

public class Skeleton extends GameCharacter {

    public Skeleton(int level, int attack, int defence, int hp) {
        super("Skeleton", level, attack, defence, hp);
    }

    public String getSpriteFilePath() {
        return "./assets/Skeleton.png";
    }

    public static int attackForLevel(int level) {
        return level * 10 - level * 10 / 2;
    }

    public static int defenceForLevel(int level) {
        return level * 10 - level * 10 / 6 * 5;
    }

    public static int hpForLevel(int level) {
        return level * 100 - level * 100 / 4 * 3;
    }

}
