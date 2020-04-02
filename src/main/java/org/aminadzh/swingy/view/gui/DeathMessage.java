package org.aminadzh.swingy.view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeathMessage extends JDialog implements ActionListener {

    private JPanel panel;

    public DeathMessage(JFrame window) {
        super(window, "Potracheno");
        setSize(new Dimension(600, 600));
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);

        GUIView deathImage = new GUIView(250, 300, "./assets/death.png");
        deathImage.setMinimumSize(new Dimension(250, 300));
        deathImage.setMaximumSize(new Dimension(250, 300));
        deathImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(deathImage);

        JButton ok = new JButton("I have payed my debt");
        ok.setAlignmentX(Component.CENTER_ALIGNMENT);
        ok.addActionListener(this);
        panel.add(ok);

        add(panel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
        System.exit(0);
    }

}
