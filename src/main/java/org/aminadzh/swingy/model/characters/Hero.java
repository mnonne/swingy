package org.aminadzh.swingy.model.characters;

import org.aminadzh.swingy.model.GameObject;

public class Hero extends GameCharacter implements GameObject {

    public Hero(String name, int posX, int posY) {
        super(name, posX, posY);

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

}
