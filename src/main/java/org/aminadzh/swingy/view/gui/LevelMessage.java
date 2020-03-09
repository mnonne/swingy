package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.model.characters.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelMessage extends JDialog implements ActionListener {

    private JPanel panel;

    public LevelMessage(Hero hero, int lvl, JFrame window) {
        super(window, "Level " + lvl);
        setSize(new Dimension(600, 300));
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);

        GUIView avatar = new GUIView(150, 150, hero.getSpriteFilePath());
        avatar.setMinimumSize(new Dimension(150, 150));
        avatar.setMaximumSize(new Dimension(150, 150));
        avatar.setAlignmentX(Component.CENTER_ALIGNMENT);
        avatar.setBackground(Color.BLACK);
        panel.add(avatar);

        JLabel label = new JLabel("Level " + lvl);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        JButton button = new JButton("OK");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(this);
        panel.add(button);

        add(panel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

}
