package org.aminadzh.swingy.view.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DialogView extends JPanel {

    private JPanel window;
    private JScrollPane scrollPane;

    public DialogView() {
        window = new JPanel();
        window.setLayout(new GridLayout(0, 1));
        JPanel offset = new JPanel();
//        offset.setPreferredSize(new Dimension(GUIWindow.getWindowWidth() / 4 - 14, 1));
//        window.add(offset);
//        window.setPreferredSize(new Dimension(GUIWindow.getWindowWidth() / 4 - 14, 200));

//        JLabel foo1 = new JLabel("Kek");
//        foo1.setFont(new Font("Arial", Font.PLAIN, 12));
//        window.add(foo1);

        scrollPane = new JScrollPane(window);
        scrollPane.setPreferredSize(new Dimension(GUIWindow.getWindowWidth() / 4 - 14, GUIWindow.getWindowHeight()));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
    }

    public void addToDialog(String msg) {
        JLabel newMessage = new JLabel(msg);
        newMessage.setFont(new Font("Arial", Font.PLAIN, 12));
        window.add(newMessage);

        scrollPane.validate();
        scrollPane.repaint();
    }

}
