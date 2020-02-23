package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.controller.Swingy;
import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.model.items.Item;
import org.aminadzh.swingy.model.items.Sword;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class HeroView extends JPanel {

    private GUIView avatar;
    private GUIView sword;
    private GUIView shield;
    private GUIView armor;

    private JLabel avatarCaption;
    private JLabel specialization;
    private JLabel hpCaption;
    private JLabel expCaption;
    private JLabel attkCaption;
    private JLabel defCaption;

    private JLabel swordCaption;
    private JLabel shieldCaption;
    private JLabel armorCaption;

    public HeroView(Hero hero) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setHeroAvatar(hero);

        setSword(hero.getSword());
    }

    public void onUpdate(Hero hero) {
        setHeroHP(hero);
    }

    public void setHeroHP(Hero hero) {
        if (hpCaption != null) {
            hpCaption.setText("HP: " + hero.getHitPoints() + "/" + hero.getMaxHitPoints());
        }
    }

    private void setHeroAvatar(Hero hero) {
        GUIView avatar = new GUIView(92, 92, hero.getSpriteFilePath());
        avatar.setMinimumSize(new Dimension(92, 92));
        avatar.setMaximumSize(new Dimension(92, 92));
        avatar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(avatar);
        avatarCaption = new JLabel("NAME: " + hero.getName(), SwingConstants.RIGHT);
        avatarCaption.setFont(new Font("Arial", Font.BOLD, 15));
        avatarCaption.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(avatarCaption);

        specialization = new JLabel("CLASS: " + hero.getSpecialization());
        specialization.setFont(new Font("Arial", Font.BOLD, 15));
        add(specialization);

        hpCaption = new JLabel("HP: " + hero.getHitPoints() + "/" + hero.getMaxHitPoints());
        hpCaption.setFont(new Font("Arial", Font.BOLD, 15));
        add(hpCaption);

        expCaption = new JLabel("EXP: " + hero.getExperience() + "/" + hero.getExpToNextLevel());
        expCaption.setFont(new Font("Arial", Font.BOLD, 15));
        add(expCaption);

        attkCaption = new JLabel("ATK: " + hero.getAttack());
        attkCaption.setFont(new Font("Arial", Font.BOLD, 15));
        add(attkCaption);

        defCaption = new JLabel("DEF:" + hero.getDefence());
        defCaption.setFont(new Font("Arial", Font.BOLD, 15));
        add(defCaption);
    }

    private void setSword(Item sword) {
        GUIView avatar = new GUIView(46, 46, sword.getSpriteFilePath());
        avatar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(avatar);
    }

}
