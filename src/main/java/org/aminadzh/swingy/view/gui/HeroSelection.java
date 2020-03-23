package org.aminadzh.swingy.view.gui;

import org.aminadzh.swingy.controller.Swingy;
import org.aminadzh.swingy.model.characters.Hero;
import org.aminadzh.swingy.model.characters.HeroFactory;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class HeroSelection extends JDialog implements ChangeListener {

    private JPanel mainPanel, createHero, west, center, east;
    private JScrollPane scrollPane;
    private JRadioButton warrior, mage, rogue;
    private Vector<JButton> oks;
    private JButton ok;
    private ButtonGroup group;
    private JTextField nameField;

    private ArrayList<Hero> heroes;

    private final  int boxHeight = 155;

    public HeroSelection(ArrayList<Hero> heroes, JFrame window) {
        super(window, "Select a hero");
        this.heroes = heroes;
        setSize(new Dimension(600, 600));
        setResizable(false);

        oks = new Vector<>();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(new Dimension(600, 600));

        scrollPane = new JScrollPane(mainPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(600, 600));
        add(scrollPane);

        initHeroCreation();

        for (Hero hero : heroes) {
            createHeroView(hero);
        }

        add(mainPanel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createHeroView(Hero hero) {
        JPanel heroView = new JPanel();
        heroView.setPreferredSize(new Dimension(getWidth(), boxHeight));
        heroView.setMaximumSize(new Dimension(getWidth(), boxHeight));
        heroView.setLayout(new BorderLayout());
        JLabel name = new JLabel(hero.getName());
        name.setFont(new Font("Arial", Font.BOLD, 15));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        heroView.add(name, BorderLayout.NORTH);

        GUIView avatar = new GUIView(120, 120, hero.getSpriteFilePath());
        heroView.add(avatar, BorderLayout.WEST);

        JPanel description = new JPanel();
        JPanel left = new JPanel();
        description.setLayout(new GridLayout(0, 2));
        Font labelFont = new Font("Arial", Font.PLAIN, 15);
        JLabel specialization = new JLabel("CLASS: " + hero.getStringSpecialization());
        specialization.setFont(labelFont);
        specialization.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        description.add(specialization);
        JLabel level = new JLabel("LVL: " + hero.getLevel());
        level.setFont(labelFont);
        level.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        description.add(level);
        JLabel hitPoints = new JLabel("HP: " + hero.getHitPoints() + "/" + hero.getMaxHitPoints());
        hitPoints.setFont(labelFont);
        hitPoints.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        description.add(hitPoints);
        JLabel exp = new JLabel("EXP: " + hero.getExperience());
        exp.setFont(labelFont);
        exp.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        description.add(exp);
        JLabel attack = new JLabel("ATK: " + hero.getAttack());
        attack.setFont(labelFont);
        attack.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        description.add(attack);
        JLabel defence = new JLabel("DEF: " + hero.getDefence());
        defence.setFont(labelFont);
        defence.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        description.add(defence);
        oks.add(new JButton("OK"));
        oks.lastElement().setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        oks.lastElement().addChangeListener(this);
        description.add(oks.lastElement());

        JPanel items = new JPanel();
        items.setPreferredSize(new Dimension(this.getWidth() / 3, this.getHeight()));
        items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));
        items.setAlignmentX(Component.CENTER_ALIGNMENT);
        if (hero.getSword() != null) {
            GUIView sword = new GUIView(30, 30, hero.getSword().getSpriteFilePath());
            sword.setMinimumSize(new Dimension(30, 30));
            sword.setMaximumSize(new Dimension(30, 30));
            sword.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            items.add(sword);
            JPanel gap = new JPanel();
            gap.setMinimumSize(new Dimension(10, 10));
            items.add(gap);
        }
        if (hero.getArmor() != null) {
            GUIView armor = new GUIView(30, 30, hero.getArmor().getSpriteFilePath());
            armor.setMinimumSize(new Dimension(30, 30));
            armor.setMaximumSize(new Dimension(30, 30));
            armor.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            items.add(armor);
            JPanel gap = new JPanel();
            gap.setMinimumSize(new Dimension(10, 10));
            items.add(gap);
        }
        if (hero.getShield() != null) {
            GUIView shield = new GUIView(30, 30, hero.getShield().getSpriteFilePath());
            shield.setMinimumSize(new Dimension(30, 30));
            shield.setMaximumSize(new Dimension(30, 30));
            shield.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            items.add(shield);
            JPanel gap = new JPanel();
            gap.setMinimumSize(new Dimension(10, 10));
            items.add(gap);
        }

        heroView.add(description, BorderLayout.CENTER);
        heroView.add(items, BorderLayout.EAST);
        mainPanel.add(heroView);
    }

    private void initHeroCreation() {
        createHero = new JPanel();
        createHero.setPreferredSize(new Dimension(this.getWidth(), boxHeight));
        createHero.setMaximumSize(new Dimension(this.getWidth(), boxHeight));
        createHero.setLayout(new BorderLayout());
        // Top label
        JLabel createHeroLabel = new JLabel("Create New Hero");
        createHeroLabel.setFont(new Font("Arial", Font.BOLD, 15));
        createHeroLabel.setHorizontalAlignment(JLabel.CENTER);
        createHeroLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        createHero.add(createHeroLabel, BorderLayout.NORTH);
        // Name text field
        east = new JPanel();
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        east.add(nameLabel);
        nameField = new JTextField(10);
        east.add(nameField);
        createHero.add(east, BorderLayout.EAST);
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

        west = new JPanel();
        GUIView avatar = new GUIView(120, 120, "./assets/mage.png");
        west.add(avatar);
        createHero.add(west, BorderLayout.WEST);
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
        } else {
            for (int i = 0; i < oks.size(); i++) {
                JButton button = oks.get(i);
                if (button.equals(aButton) && aModel.isPressed()) {
                    Swingy.getInstance().startLevel(heroes.get(i));
                    dispose();
                }
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
