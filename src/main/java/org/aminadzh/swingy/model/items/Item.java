package org.aminadzh.swingy.model.items;

public class Item {

    private int id;
    private String name;
    private String spriteFilePath;
    private int bonus;

    public Item() {

    }

    public Item(String name, int bonus, String spriteFilePath) {
        this.spriteFilePath = spriteFilePath;
        this.name = name;
        this.bonus = bonus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpriteFilePath(String spriteFilePath) {
        this.spriteFilePath = spriteFilePath;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getId() {
        return id;
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
