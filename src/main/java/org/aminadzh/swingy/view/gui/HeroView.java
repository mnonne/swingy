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
    private JLabel lvlCaption;

    private JLabel swordCaption;
    private JLabel shieldCaption;
    private JLabel armorCaption;

    public HeroView(Hero hero) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        updateAll(hero);
    }

    public void onUpdate(Hero hero) {
        removeAll();
        updateAll(hero);
        revalidate();
        repaint();
    }

    private void updateAll(Hero hero) {
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

    private void setHeroAvatar(Hero hero) {
        Font font = new Font("Arial", Font.BOLD, 15);
        avatar = new GUIView(150, 150, hero.getSpriteFilePath());
        avatar.setMinimumSize(new Dimension(150, 150));
        avatar.setMaximumSize(new Dimension(150, 150));
        avatar.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        add(avatar);
        avatarCaption = new JLabel("NAME: " + hero.getName());
        avatarCaption.setFont(font);
        avatarCaption.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        avatarCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(avatarCaption);

        specialization = new JLabel("CLASS: " + hero.getSpecialization());
        specialization.setFont(font);
        specialization.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        specialization.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(specialization);

        lvlCaption = new JLabel("LVL: " + hero.getLevel());
        lvlCaption.setFont(font);
        lvlCaption.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        lvlCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lvlCaption);

        hpCaption = new JLabel("HP: " + hero.getHitPoints() + "/" + hero.getMaxHitPoints());
        hpCaption.setFont(font);
        hpCaption.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        hpCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(hpCaption);

        expCaption = new JLabel("EXP: " + hero.getExperience() + "/" + hero.getExpToNextLevel());
        expCaption.setFont(font);
        expCaption.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        expCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(expCaption);

        attkCaption = new JLabel("ATK: " + hero.getAttack());
        attkCaption.setFont(font);
        attkCaption.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        attkCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(attkCaption);

        defCaption = new JLabel("DEF: " + hero.getDefence());
        defCaption.setFont(font);
        defCaption.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
        defCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(defCaption);
    }

    private void setSword(Item sword) {
        this.sword = new GUIView(46, 46, sword.getSpriteFilePath());
        this.sword.setMinimumSize(new Dimension(46, 46));
        this.sword.setMaximumSize(new Dimension(46, 46));
        this.sword.setBorder(BorderFactory.createRaisedBevelBorder());
        this.sword.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(this.sword);

        swordCaption = new JLabel(sword.getName());
        swordCaption.setFont(new Font("Arial", Font.ITALIC, 12));
        swordCaption.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        swordCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(swordCaption);
    }

    private void setShield(Item shield) {
        this.shield = new GUIView(46, 46, shield.getSpriteFilePath());
        this.shield.setMinimumSize(new Dimension(46, 46));
        this.shield.setMaximumSize(new Dimension(46, 46));
        this.shield.setBorder(BorderFactory.createRaisedBevelBorder());
        this.shield.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(this.shield);

        shieldCaption = new JLabel(shield.getName());
        shieldCaption.setFont(new Font("Arial", Font.ITALIC, 12));
        shieldCaption.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        shieldCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(shieldCaption);
    }

    private void setArmor(Item armor) {
        this.armor = new GUIView(46, 46, armor.getSpriteFilePath());
        this.armor.setMinimumSize(new Dimension(46, 46));
        this.armor.setMaximumSize(new Dimension(46, 46));
        this.armor.setBorder(BorderFactory.createRaisedBevelBorder());
        this.armor.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(this.armor);

        armorCaption = new JLabel(armor.getName());
        armorCaption.setFont(new Font("Arial", Font.ITALIC, 12));
        armorCaption.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        armorCaption.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(armorCaption);
    }

}
