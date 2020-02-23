package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.controller.Swingy;
import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.model.items.Item;
import org.aminadzh.swingy.model.items.Sword;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
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

        if (hero.getSword() != null) {
            setSword(hero.getSword());
        }

        if (hero.getShield() != null) {
            setShield(hero.getShield());
        }

        if (hero.getArmor() != null) {
            setArmor(hero.getArmor());
        }
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
        GUIView avatar = new GUIView(150, 150, hero.getSpriteFilePath());
        avatar.setMinimumSize(new Dimension(150, 150));
        avatar.setMaximumSize(new Dimension(150, 150));
        avatar.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        add(avatar);
        avatarCaption = new JLabel("NAME: " + hero.getName());
        avatarCaption.setFont(new Font("Arial", Font.BOLD, 15));
        avatarCaption.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        avatarCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(avatarCaption);

        specialization = new JLabel("CLASS: " + hero.getSpecialization());
        specialization.setFont(new Font("Arial", Font.BOLD, 15));
        specialization.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        specialization.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(specialization);

        hpCaption = new JLabel("HP: " + hero.getHitPoints() + "/" + hero.getMaxHitPoints());
        hpCaption.setFont(new Font("Arial", Font.BOLD, 15));
        hpCaption.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        hpCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(hpCaption);

        expCaption = new JLabel("EXP: " + hero.getExperience() + "/" + hero.getExpToNextLevel());
        expCaption.setFont(new Font("Arial", Font.BOLD, 15));
        expCaption.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        expCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(expCaption);

        attkCaption = new JLabel("ATK: " + hero.getAttack());
        attkCaption.setFont(new Font("Arial", Font.BOLD, 15));
        attkCaption.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        attkCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(attkCaption);

        defCaption = new JLabel("DEF: " + hero.getDefence());
        defCaption.setFont(new Font("Arial", Font.BOLD, 15));
        defCaption.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
        defCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(defCaption);
    }

    private void setSword(Item sword) {
        GUIView avatar = new GUIView(46, 46, sword.getSpriteFilePath());
        avatar.setMinimumSize(new Dimension(46, 46));
        avatar.setMaximumSize(new Dimension(46, 46));
        avatar.setBorder(BorderFactory.createRaisedBevelBorder());
        avatar.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(avatar);

        swordCaption = new JLabel(sword.getName());
        swordCaption.setFont(new Font("Arial", Font.ITALIC, 12));
        swordCaption.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        swordCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(swordCaption);
    }

    private void setShield(Item shield) {
        GUIView avatar = new GUIView(46, 46, shield.getSpriteFilePath());
        avatar.setMinimumSize(new Dimension(46, 46));
        avatar.setMaximumSize(new Dimension(46, 46));
        avatar.setBorder(BorderFactory.createRaisedBevelBorder());
        avatar.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(avatar);

        shieldCaption = new JLabel(shield.getName());
        shieldCaption.setFont(new Font("Arial", Font.ITALIC, 12));
        shieldCaption.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        shieldCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(shieldCaption);
    }

    private void setArmor(Item armor) {
        GUIView avatar = new GUIView(46, 46, armor.getSpriteFilePath());
        avatar.setMinimumSize(new Dimension(46, 46));
        avatar.setMaximumSize(new Dimension(46, 46));
        avatar.setBorder(BorderFactory.createRaisedBevelBorder());
        avatar.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(avatar);

        armorCaption = new JLabel(armor.getName());
        armorCaption.setFont(new Font("Arial", Font.ITALIC, 12));
        armorCaption.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        armorCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(armorCaption);
    }

}
