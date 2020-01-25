package org.aminadzh.swingy.controller;

import org.aminadzh.swingy.model.player.Hero;
import org.aminadzh.swingy.view.View;

public class HeroController {
    private Hero model;
    private View view;

    public HeroController(Hero model, View view) {
        this.model = model;
        this.view = view;
    }

    public Hero getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

    public void moveRight() {
        view.setPosX(view.getPosX() + 46);
    }
}
