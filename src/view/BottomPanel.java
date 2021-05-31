package view;

import control.ZutatenButtonListener;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {

    private StatusScreen currentStatus;
    private JTextArea currentStatusTextArea;

    public BottomPanel(){

    GridBagLayout bottomLayout = new GridBagLayout();
    this.setLayout(bottomLayout);
    GridBagConstraints b = new GridBagConstraints();
    super.setBackground(new Color(255, 249, 201)); // Hintergrundfarbe einstellen auf Hellgelb
    b.fill = GridBagConstraints.HORIZONTAL; //Horizontale Anordnung der Elemente
    b.insets = new Insets(2,5,2,5); //Padding Elemente 5px alle
    b.ipady = 8;      //Buttonpadding 8px * 5px
    b.ipadx = 5;

    JButton deleteButton = new JButton("Löschen"); // Bestellung löschen Button
    //b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 1;
    b.gridy = 0;
    this.add(deleteButton,b);
    deleteButton.addActionListener(new ZutatenButtonListener());

    JLabel bestellListe = new JLabel("Bestellung"); // Label für bestellliste
    //c.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 0;
    b.gridy = 1;
    this.add(bestellListe,b);

    // Textaera transparent setzen - super geil
    currentStatusTextArea = new JTextArea(30,20);
        currentStatusTextArea.setOpaque(false);
        currentStatusTextArea.setBackground(new Color(0,0,0,0));
        JScrollPane scrollPane = new JScrollPane(currentStatusTextArea);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
    b.gridx = 0;
    b.gridy = 2;
    b.gridwidth = 2;
    this.add(currentStatusTextArea,b);




    JButton finishButton = new JButton("Bestellung abschicken");
    //b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 0;
    b.gridy = 6;
    b.gridwidth = 2;
    this.add(finishButton,b);
    finishButton.addActionListener(new ZutatenButtonListener());


    }


    public StatusScreen getCurrentStatus() {
        return currentStatus;
    }

    public JTextArea getCurrentStatusTextArea() {return currentStatusTextArea;}



}
