package de.karrieretutor.LydiaHolmPablo.Pizza;


import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class GUI {

    private JFrame frame = new JFrame("Luigi's Pizza");
    private JPanel topPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();

    // später von woanders her?
    private String[] saucenListe= {"Tomatensauce","BBQ-Sauce"};
    private String[] zutatenListe= {"Gouda","Mozzarella","Salami","Schinken","Thunfisch","Peperoni","Ananas"};

    public GUI(){
        frame.setSize(300,800);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        ImageIcon icon = new ImageIcon("./testbild.jpg");
        JLabel background = new JLabel();
        background.setIcon(icon);

        JLabel sauceLabel = new JLabel("Sauce: ");
        JComboBox sauceCombobox = new JComboBox<String>(saucenListe);

        JLabel zutat1Label = new JLabel("Zutat 1: ");
        JLabel zutat2Label = new JLabel("Zutat 2: ");
        JLabel zutat3Label = new JLabel("Zutat 3: ");
        JLabel zutat4Label = new JLabel("Zutat 4: ");
        JLabel zutat5Label = new JLabel("Zutat 5: ");
        JLabel zutat6Label = new JLabel("Zutat 6: ");
        JLabel zutat7Label = new JLabel("Zutat 7: ");
        JLabel zutat8Label = new JLabel("Zutat 8: ");

        JComboBox zutat1Combobox = new JComboBox<String>(zutatenListe);
        JComboBox zutat2Combobox = new JComboBox<String>(zutatenListe);
        JComboBox zutat3Combobox = new JComboBox<String>(zutatenListe);
        JComboBox zutat4Combobox = new JComboBox<String>(zutatenListe);
        JComboBox zutat5Combobox = new JComboBox<String>(zutatenListe);
        JComboBox zutat6Combobox = new JComboBox<String>(zutatenListe);
        JComboBox zutat7Combobox = new JComboBox<String>(zutatenListe);
        JComboBox zutat8Combobox = new JComboBox<String>(zutatenListe);

        GroupLayout centerLayout = new GroupLayout(centerPanel);
        centerLayout.setAutoCreateGaps(true);
        centerLayout.setAutoCreateContainerGaps(true);
        centerPanel.setLayout(centerLayout);

        GroupLayout.ParallelGroup sauceGroup = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup zutat1Group = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup zutat2Group = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup zutat3Group = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup zutat4Group = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup zutat5Group = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup zutat6Group = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup zutat7Group = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup zutat8Group = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup labelGroup = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup comboboxGroup = centerLayout.createParallelGroup();

        centerLayout.setVerticalGroup(centerLayout.createSequentialGroup().
                addGroup(sauceGroup.addComponent(sauceLabel).addComponent(sauceCombobox)).
                addGroup(zutat1Group.addComponent(zutat1Label).addComponent(zutat1Combobox)).
                addGroup(zutat2Group.addComponent(zutat2Label).addComponent(zutat2Combobox)).
                addGroup(zutat3Group.addComponent(zutat3Label).addComponent(zutat3Combobox)).
                addGroup(zutat4Group.addComponent(zutat4Label).addComponent(zutat4Combobox)).
                addGroup(zutat5Group.addComponent(zutat5Label).addComponent(zutat5Combobox)).
                addGroup(zutat6Group.addComponent(zutat6Label).addComponent(zutat6Combobox)).
                addGroup(zutat7Group.addComponent(zutat7Label).addComponent(zutat7Combobox)).
                addGroup(zutat8Group.addComponent(zutat8Label).addComponent(zutat8Combobox)));

        centerLayout.setHorizontalGroup(centerLayout.createSequentialGroup().
                addGroup(labelGroup.addComponent(sauceLabel).addComponent(zutat1Label).addComponent(zutat2Label).addComponent(zutat3Label).
                        addComponent(zutat4Label).addComponent(zutat5Label).addComponent(zutat6Label).addComponent(zutat7Label).addComponent(zutat8Label)).
                addGroup(comboboxGroup.addComponent(sauceCombobox).addComponent(zutat1Combobox).addComponent(zutat2Combobox).addComponent(zutat3Combobox).
                        addComponent(zutat4Combobox).addComponent(zutat5Combobox).addComponent(zutat6Combobox).addComponent(zutat7Combobox).addComponent(zutat8Combobox)));

        // Eventuell ist das Folgende zu kompliziert .... für diese wenigen Bedienelemente
        JLabel preisLabel = new JLabel("Gesamtpreis");
        JLabel bestellLabel = new JLabel("Fertig?");
        JTextArea preisTextArea = new JTextArea("0.00 €"); // Muss immer upgedatet werden!
        JButton bestellButton = new JButton("bestellen");




        GroupLayout bottomLayout = new GroupLayout(bottomPanel);
        bottomLayout.setAutoCreateGaps(true);
        bottomLayout.setAutoCreateContainerGaps(true);
        bottomPanel.setLayout(bottomLayout);

        GroupLayout.ParallelGroup preisGroup = bottomLayout.createParallelGroup();
        GroupLayout.ParallelGroup bestellGroup = bottomLayout.createParallelGroup();
        GroupLayout.ParallelGroup labelBottomGroup = bottomLayout.createParallelGroup();
        GroupLayout.ParallelGroup inhaltsGroup = bottomLayout.createParallelGroup();

        bottomLayout.setVerticalGroup(bottomLayout.createSequentialGroup().
                addGroup(preisGroup.addComponent(preisLabel).addComponent(preisTextArea)).
                addGroup(bestellGroup.addComponent(bestellLabel).addComponent(bestellButton)));

        bottomLayout.setHorizontalGroup(bottomLayout.createSequentialGroup().
                addGroup(labelBottomGroup.addComponent(preisLabel).addComponent(bestellLabel)).
                addGroup(inhaltsGroup.addComponent(preisTextArea).addComponent(bestellButton)));
/*
        */

        frame.setVisible(true);

    }




}
