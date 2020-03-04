package org.aminadzh.swingy.model.characters;

public class Skeleton extends GameCharacter {

    public Skeleton(int level) {
        super("Skeleton");
    }

    public String getSpriteFilePath() {
        return "./assets/Skeleton.png";
    }

}
