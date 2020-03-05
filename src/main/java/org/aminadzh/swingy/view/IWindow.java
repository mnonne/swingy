package org.aminadzh.swingy.view;

import org.aminadzh.swingy.model.characters.GameCharacter;
import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.model.items.Item;

public interface IWindow {

    void startLevel(Hero hero);
    void updateMap(Hero hero);
    void updateHeroView(Hero hero);
    void addMessageToDialog(String message);
    void startBattle(Hero hero, GameCharacter enemy);
    void endBattle();
    void showDeathMessage();
    void itemDropDialog(Item item);

}
