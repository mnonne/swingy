package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.controller.Swingy;
import org.aminadzh.swingy.model.characters.GameCharacter;
import org.aminadzh.swingy.model.characters.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleView extends JDialog {

    private JPanel panel;

    public BattleView(Hero hero, GameCharacter enemy, JFrame window) {
        super(window, "Battle");
        setSize(new Dimension(600, 600));
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);

        Font font = new Font("Arial", Font.BOLD, 15);

        GUIView enemyImage = new GUIView(150, 150, enemy.getSpriteFilePath());
        enemyImage.setBackground(Color.BLACK);
        enemyImage.setMinimumSize(new Dimension(150, 150));
        enemyImage.setMaximumSize(new Dimension(150, 150));
        enemyImage.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        enemyImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(enemyImage);

        JLabel enemyName = new JLabel(enemy.getName());
        enemyName.setFont(font);
        enemyName.setForeground(Color.WHITE);
        enemyName.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        enemyName.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(enemyName);

        JLabel enemyLevel = new JLabel("LVL: " + enemy.getLevel());
        enemyLevel.setFont(font);
        enemyLevel.setForeground(Color.WHITE);
        enemyLevel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        enemyLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(enemyLevel);

        JLabel enemyHP = new JLabel("HP: " + enemy.getHitPoints());
        enemyHP.setFont(font);
        enemyHP.setForeground(Color.WHITE);
        enemyHP.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        enemyHP.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(enemyHP);

        JLabel enemyAttk = new JLabel("ATK: " + enemy.getAttack());
        enemyAttk.setFont(font);
        enemyAttk.setForeground(Color.WHITE);
        enemyAttk.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        enemyAttk.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(enemyAttk);

        JLabel enemyDef = new JLabel("DEF: " + enemy.getDefence());
        enemyDef.setFont(font);
        enemyDef.setForeground(Color.WHITE);
        enemyDef.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        enemyDef.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(enemyDef);

        JButton fight = new JButton("FIGHT");
        fight.setAlignmentX(Component.CENTER_ALIGNMENT);
        fight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Swingy.getInstance().startBattle(hero, enemy);
            }
        });
        panel.add(fight);

        JButton run = new JButton("RUN");
        run.setAlignmentX(Component.CENTER_ALIGNMENT);
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Swingy.getInstance().tryToEscape(enemy);
            }
        });
        panel.add(run);

        add(panel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
