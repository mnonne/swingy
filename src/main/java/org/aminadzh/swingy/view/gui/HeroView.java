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

    private JPanel stats;
    private JPanel items;
    private GUIView avatar;
    private GUIView sword;
    private GUIView shield;
    private GUIView armor;
    private JLabel avatarCaption;
    private JLabel specialization;
    private JLabel hpCaption;
    private JLabel swordCaption;
    private JLabel shieldCaption;
    private JLabel armorCaption;

    public HeroView(Hero hero) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        stats = new JPanel();
        stats.setLayout(new GridBagLayout());
        setHeroAvatar(hero);
//        stats.setBorder(new LineBorder(Color.BLACK));
        stats.setMaximumSize(new Dimension(GUIWindow.getWindowWidth() / 4, 100));
//        stats.setMinimumSize(new Dimension(GUIWindow.getWindowWidth() / 4, GUIWindow.getWindowHeight() / 2));
        add(stats);

        items = new JPanel();
        setSword(hero.getSword());
        items.setBorder(new LineBorder(Color.BLACK));
        items.setMaximumSize(new Dimension(GUIWindow.getWindowWidth() / 4, 200));
//        items.setMinimumSize(new Dimension(GUIWindow.getWindowWidth() / 4, GUIWindow.getWindowHeight() / 2));
        add(items);

//        setLayout(new GridBagLayout());
//
//        GridBagConstraints c = new GridBagConstraints();
//        c.anchor = GridBagConstraints.PAGE_END;
//        c.fill = GridBagConstraints.NONE;
//        c.gridwidth = 3;
//        c.gridheight = 1;
//        c.weightx = 2;
//        c.gridx = 0;
//        c.gridy = 0;
//        avatar = new GUIView(92, 92, hero.getSpriteFilePath());
//        avatar.setBorder(new LineBorder(Color.BLACK));
//        add(avatar, c);
//
//        c.gridwidth = 3;
//        c.gridheight = 1;
//        c.weightx = 1;
//        c.gridx = 0;
//        c.insets = new Insets(10,0,0,0);
//        c.gridy = 1;
//        avatarCaption = new JLabel(hero.getName());
//        avatarCaption.setFont(new Font("Arial", 1, 20));
//        add(avatarCaption, c);
//
//        c.gridwidth = 1;
//        c.gridheight = 1;
//        c.weightx = 1;
//        c.gridx = 0;
//        c.gridy = 2;
//        sword = new GUIView(46, 46, hero.getSword().getSpriteFilePath());
//        sword.setBorder(new LineBorder(Color.BLACK));
//        add(sword, c);
//
//        c.gridwidth = 1;
//        c.gridheight = 1;
//        c.weightx = 1;
//        c.gridx = 0;
//        c.gridy = 3;
//        swordCaption = new JLabel(hero.getSword().getName());
//        swordCaption.setFont(new Font("Helvetica", 1, 15));
//        add(swordCaption, c);

//        c.gridwidth = 1;
//        c.gridheight = 1;
//        c.weightx = 1;
//        c.gridx = 1;
//        c.gridy = 2;
//        shield = new GUIView(46, 46, hero.getShield().getSpriteFilePath());
//        add(shield, c);
    }

    private void setHeroAvatar(Hero hero) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridheight = 3;
        GUIView avatar = new GUIView(92, 92, hero.getSpriteFilePath());
        avatar.setBorder(new LineBorder(Color.BLACK));

        stats.add(avatar, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 7;
        c.weighty = 1;
        c.gridwidth = 2;
        c.gridheight = 1;
        avatarCaption = new JLabel("Name: " + hero.getName());
        avatarCaption.setFont(new Font("Arial", 1, 15));
        stats.add(avatarCaption, c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 7;
        c.weighty = 1;
        c.gridwidth = 2;
        c.gridheight = 1;
        specialization = new JLabel("Class: " + hero.getSpecialization());
        specialization.setFont(new Font("Arial", 1, 15));
        stats.add(specialization, c);

        c.gridy = 2;
        hpCaption = new JLabel("HP: " + hero.getHitPoints() + "/" + hero.getMaxHitPoints());
        hpCaption.setFont(new Font("Arial", 1, 15));
        stats.add(hpCaption, c);
    }

    private void setSword(Item sword) {
        GridBagConstraints c = new GridBagConstraints();

        GUIView avatar = new GUIView(46, 46, sword.getSpriteFilePath());
        items.add(avatar, c);
    }

}
