package org.aminadzh.swingy.model.items;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "bonus")
    private int bonus;
    @Column(name = "sprite")
    private String spriteFilePath;

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
