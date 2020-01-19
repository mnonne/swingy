package org.aminadzh.swingy.controller;

import org.aminadzh.swingy.model.player.*;
import org.aminadzh.swingy.view.*;
import org.aminadzh.swingy.view.gui.GUIView;

import java.util.AbstractMap;

public class GameController {
    AbstractMap.SimpleEntry<Hero, View> player1;
    AbstractMap.SimpleEntry<Hero, View> player2;

    public GameController() {
        player1 = new AbstractMap.SimpleEntry<>(new Warrior("Peeves"),
                new GUIView(50, 50, "assets/rpg-pack/chars/sensei/sensei.png"));
//        player2 = new AbstractMap.SimpleEntry<>(new Warrior("Peeves"), new GUIView(100, 50, "bar"));
    }
}
