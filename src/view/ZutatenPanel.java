package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class ZutatenPanel extends JPanel {

    private String zutatenName;
    private String preisName;
    private int buttonBreite;


    // Eventuell kann man noch ein Bild für jede Zutat hinzufügen?
    public ZutatenPanel(String zutatenName, String preisName, int Breite, int Höhe) {
        this.zutatenName = zutatenName;
        this.preisName = preisName;
        this.setPreferredSize(new Dimension(Breite, Höhe));
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel zutatenLabel = new JLabel(zutatenName);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(zutatenLabel, c);

        JLabel preisLabel = new JLabel(preisName);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        this.add(preisLabel, c);

        JButton plusButton = new JButton("   +   ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 8;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        this.add(plusButton, c);
    }

    public ZutatenPanel(String zutatenName, String preisName) {
        this.zutatenName = zutatenName;
        this.preisName = preisName;
        this.setPreferredSize(new Dimension(150, 100));
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel zutatenLabel = new JLabel(zutatenName);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(zutatenLabel, c);

        JLabel preisLabel = new JLabel(preisName);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        this.add(preisLabel, c);

        JButton plusButton = new JButton("   +   ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 8;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        this.add(plusButton, c);
    }




}
