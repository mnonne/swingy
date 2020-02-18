package org.aminadzh.swingy.view;

import org.aminadzh.swingy.model.characters.Hero;

public interface IWindow {

    void startLevel(Hero hero);
    void updateMap(Hero hero);
    void updateHeroView(Hero hero);

}
