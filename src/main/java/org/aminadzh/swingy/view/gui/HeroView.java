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

    GridBagConstraints statsLayout;
    GridBagConstraints itemsLayout;

    private JPanel stats;
    private JPanel items;
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

        statsLayout = new GridBagConstraints();
        statsLayout.fill = GridBagConstraints.HORIZONTAL;
        itemsLayout = new GridBagConstraints();

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
        statsLayout.gridx = 0;
        statsLayout.gridy = 0;
        statsLayout.weightx = 1;
        statsLayout.weighty = 1;
        statsLayout.gridwidth = 1;
        statsLayout.gridheight = 3;
        GUIView avatar = new GUIView(92, 92, hero.getSpriteFilePath());
        stats.add(avatar, statsLayout);

        statsLayout.gridx = 1;
        statsLayout.gridy = 0;
        statsLayout.weightx = 7;
        statsLayout.weighty = 1;
        statsLayout.gridwidth = 2;
        statsLayout.gridheight = 1;
        avatarCaption = new JLabel("NAME: " + hero.getName());
        avatarCaption.setFont(new Font("Arial", Font.BOLD, 15));
        stats.add(avatarCaption, statsLayout);

        statsLayout.gridx = 1;
        statsLayout.gridy = 1;
        statsLayout.weightx = 7;
        statsLayout.weighty = 1;
        statsLayout.gridwidth = 2;
        statsLayout.gridheight = 1;
        specialization = new JLabel("CLASS: " + hero.getSpecialization());
        specialization.setFont(new Font("Arial", Font.BOLD, 15));
        stats.add(specialization, statsLayout);

        statsLayout.gridx = 1;
        statsLayout.gridy = 2;
        hpCaption = new JLabel("HP: " + hero.getHitPoints() + "/" + hero.getMaxHitPoints());
        hpCaption.setFont(new Font("Arial", Font.BOLD, 15));
        stats.add(hpCaption, statsLayout);

        statsLayout.gridx = 3;
        statsLayout.gridy = 0;
        expCaption = new JLabel("EXP: " + hero.getExperience() + "/" + hero.getExpToNextLevel());
        expCaption.setFont(new Font("Arial", Font.BOLD, 15));
        stats.add(expCaption, statsLayout);

        statsLayout.gridx = 3;
        statsLayout.gridy = 1;
        attkCaption = new JLabel("ATK: " + hero.getAttack());
        attkCaption.setFont(new Font("Arial", Font.BOLD, 15));
        stats.add(attkCaption, statsLayout);

        statsLayout.gridx = 3;
        statsLayout.gridy = 2;
        defCaption = new JLabel("DEF:" + hero.getDefence());
        defCaption.setFont(new Font("Arial", Font.BOLD, 15));
        stats.add(defCaption, statsLayout);
    }

    private void setSword(Item sword) {
        GUIView avatar = new GUIView(46, 46, sword.getSpriteFilePath());
        items.add(avatar, itemsLayout);
    }

}
