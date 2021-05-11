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


    public GUI(){
        frame.setSize(300,200);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        GroupLayout centerLayout = new GroupLayout(centerPanel);
        centerLayout.setAutoCreateGaps(true);
        centerLayout.setAutoCreateContainerGaps(true);
        //centerLayout.setHgap(4);
        //centerLayout.setVgap(4);
        centerPanel.setLayout(centerLayout);

        GroupLayout.ParallelGroup sauceGroup = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup labelGroup = centerLayout.createParallelGroup();
        GroupLayout.ParallelGroup comboboxGroup = centerLayout.createParallelGroup();
        JLabel sauceLabel = new JLabel("Sauce: ");
        JComboBox sauceCombobox = new JComboBox<String>(saucenListe);

        centerLayout.setVerticalGroup(sauceGroup.addComponent(sauceLabel).addComponent(sauceCombobox));
        centerLayout.setHorizontalGroup(centerLayout.createSequentialGroup().addGroup(labelGroup.addComponent(sauceLabel)).addGroup(comboboxGroup.addComponent(sauceCombobox)));
        //centerLayout.setVerticalGroup(centerLayout.createParallelGroup().addGroup(addComponent(sauceLabel)).addGroup();


        /*
        GroupLayout.ParallelGroup sauceGroup = centerLayout.createParallelGroup();
        JLabel sauceLabel = new JLabel("Sauce: ");
        JComboBox sauceCombobox = new JComboBox<String>(saucenListe);
        sauceGroup.addComponent(sauceLabel).addComponent(sauceCombobox);


         */




        frame.setVisible(true);

    }




}
