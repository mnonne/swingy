package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.model.characters.Hero;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class HeroView extends JPanel {

    private GUIView avatar;
    private JLabel avatarCaption;
    private GUIView swordItem;


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

        c.gridheight = 3;
        c.gridheight = 1;
        c.weightx = 1;
        c.gridx = 0;
        c.insets = new Insets(10,0,0,0);
        c.gridy = 1;
        avatarCaption = new JLabel(hero.getName());
        avatarCaption.setFont(new Font("Arial", 1, 20));
        add(avatarCaption, c);
    }

}
