package org.aminadzh.swingy.view.gui;

import javax.swing.*;
import java.awt.*;

public class DialogView extends JPanel {

    private JPanel window;
    private JScrollPane scrollPane;

    public DialogView() {
        window = new JPanel();
        window.setLayout(new BoxLayout(window,BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(window);
        scrollPane.setPreferredSize(new Dimension(GUIWindow.getWindowWidth() / 4 - 14, GUIWindow.getWindowHeight() - 14));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
    }

    public void addToDialog(String msg) {
        JLabel newMessage = new JLabel(msg);
        newMessage.setFont(new Font("Arial", Font.PLAIN, 12));
        window.add(newMessage);

        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
        scrollPane.validate();
        scrollPane.repaint();
    }

}
