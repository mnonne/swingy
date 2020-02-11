package org.aminadzh.swingy.model.items;

public class Sword implements Item {

    private String name;
    private String spriteFilePath;
    private int bonus;

    public Sword(String name, int bonus, String spriteFile) {
        spriteFilePath = spriteFile;
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public String getSpriteFilePath() {
        return spriteFilePath;
    }

    public int getBonus() {
        return bonus;
    }

}
