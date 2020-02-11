package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.model.characters.Hero;

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
    private JLabel swordCaption;
    private JLabel shieldCaption;
    private JLabel armorCaption;

    public HeroView(Hero hero) {
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 0;
        avatar = new GUIView(92, 92, hero.getSpriteFilePath());
        avatar.setBorder(new LineBorder(Color.BLACK));
        add(avatar, c);

        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 1;
        c.gridx = 0;
        c.insets = new Insets(10,0,0,0);
        c.gridy = 1;
        avatarCaption = new JLabel(hero.getName());
        avatarCaption.setFont(new Font("Arial", 1, 20));
        add(avatarCaption, c);

        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        sword = new GUIView(46, 46, hero.getSword().getSpriteFilePath());
        sword.setBorder(new LineBorder(Color.BLACK));
        add(sword, c);

        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 3;
        swordCaption = new JLabel(hero.getSword().getName());
        swordCaption.setFont(new Font("Helvetica", 1, 15));
        add(swordCaption, c);

//        c.gridwidth = 1;
//        c.gridheight = 1;
//        c.weightx = 1;
//        c.gridx = 1;
//        c.gridy = 2;
//        shield = new GUIView(46, 46, hero.getShield().getSpriteFilePath());
//        add(shield, c);
    }

}
