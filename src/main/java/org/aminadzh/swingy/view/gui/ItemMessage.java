package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.controller.Swingy;
import org.aminadzh.swingy.model.items.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemMessage extends JDialog implements ActionListener {

    private JPanel panel;

    public ItemMessage(Item item, JFrame window) {
        super(window, "You have new item");
        setSize(new Dimension(600, 300));
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);

        GUIView avatar = new GUIView(150, 150, item.getSpriteFilePath());
        avatar.setMinimumSize(new Dimension(150, 150));
        avatar.setMaximumSize(new Dimension(150, 150));
        avatar.setAlignmentX(Component.CENTER_ALIGNMENT);
        avatar.setBackground(Color.BLACK);
        panel.add(avatar);

        JButton take = new JButton("Take");
        take.setAlignmentX(Component.CENTER_ALIGNMENT);
        take.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Swingy.getInstance().userAgreedItem(item);
                dispose();
            }
        });
        panel.add(take);

        JButton dispose = new JButton("Dispose");
        dispose.setAlignmentX(Component.CENTER_ALIGNMENT);
        dispose.addActionListener(this);
        panel.add(dispose);

        add(panel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

}
