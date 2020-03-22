package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.controller.Swingy;
import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.model.characters.HeroFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class HeroSelection extends JDialog implements ChangeListener {

    private JPanel mainPanel, createHero, west, center, east;
    private JRadioButton warrior, mage, rogue;
    private JButton ok;
    private ButtonGroup group;
    private JTextField nameField;

    private final  int boxHeight = 155;

    public HeroSelection(ArrayList<Hero> heroes, JFrame window) {
        super(window, "Select a hero");
        setSize(new Dimension(600, 600));
        setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        initHeroCreation();

        JPanel chooseHero = new JPanel();
        chooseHero.setPreferredSize(new Dimension(300, 300));
        mainPanel.add(chooseHero);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initHeroCreation() {
        createHero = new JPanel();
        createHero.setPreferredSize(new Dimension(this.getWidth(), boxHeight));
        createHero.setMaximumSize(new Dimension(this.getWidth(), boxHeight));
        createHero.setLayout(new BorderLayout());
        createHero.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        // Top label
        JLabel createHeroLabel = new JLabel("Create New Hero");
        createHeroLabel.setFont(new Font("Arial", Font.BOLD, 15));
        createHeroLabel.setHorizontalAlignment(JLabel.CENTER);
        createHeroLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        createHero.add(createHeroLabel, BorderLayout.NORTH);
        // Name text field
        west = new JPanel();
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        west.add(nameLabel);
        nameField = new JTextField(10);
        west.add(nameField);
        createHero.add(west, BorderLayout.WEST);
        // Class selection
        center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        JLabel selectClassLabel = new JLabel("Select Class");
        selectClassLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        warrior = new JRadioButton();
        warrior.setText("Warrior");
        warrior.addChangeListener(this);
        mage = new JRadioButton();
        mage.setText("Mage");
        mage.addChangeListener(this);
        warrior.setSelected(true);
        rogue= new JRadioButton();
        rogue.setText("Rogue");
        rogue.addChangeListener(this);
        group = new ButtonGroup();
        group.add(warrior);
        group.add(mage);
        group.add(rogue);
        center.add(selectClassLabel);
        center.add(warrior);
        center.add(rogue);
        center.add(mage);
        ok = new JButton("OK");
        ok.addChangeListener(this);
        center.add(ok);

        createHero.add(center, BorderLayout.CENTER);

        east = new JPanel();
        GUIView avatar = new GUIView(120, 120, "./assets/mage.png");
        east.add(avatar);
        createHero.add(east, BorderLayout.EAST);
        mainPanel.add(createHero);
    }

    public void stateChanged(ChangeEvent event) {
        AbstractButton aButton = (AbstractButton)event.getSource();
        ButtonModel aModel = aButton.getModel();
        if (aModel.isSelected() && aModel.isArmed() && aModel.isPressed()) {
            if (warrior.isSelected()) {
                System.out.println("Warrior");
                //TODO: selection of warrior image
            } else if (mage.isSelected()) {
                System.out.println("Mage");
                //TODO: selection of mage image
            } else if (rogue.isSelected()) {
                System.out.println("Rogue");
                //TODO: selection of rogue image
            }
        } else if (aModel.isPressed() && aButton.equals(ok)) {
            if (onHeroCreation()) {
                dispose();
            }
        }
    }

    private boolean onHeroCreation() {
        String nameText = nameField.getText();
        if (nameText.isEmpty()) {
            return false;
        }
        int specialization = 1;
        if (warrior.isSelected()) {
            specialization = Hero.WARRIOR;
        } else if (mage.isSelected()) {
            specialization = Hero.MAGE;
        } else if (rogue.isSelected()) {
            specialization = Hero.ROGUE;
        }
        if (nameText.length() > 10) nameText = nameText.substring(0, 10);
        Hero hero = HeroFactory.createHero(nameText, specialization);
        Swingy.getInstance().startLevel(hero);
        return true;
    }

}
