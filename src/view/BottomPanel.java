package view;

import control.Existenzebene;
import control.ZutatenButtonListener;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {

    private StatusScreen currentStatus;
    private JTextArea currentStatusTextArea;
    private Existenzebene existenzebene;

    public BottomPanel(ZutatenButtonListener zutatenButtonListener){

    GridBagLayout bottomLayout = new GridBagLayout();
    this.setLayout(bottomLayout);
    GridBagConstraints b = new GridBagConstraints();
    b.fill = GridBagConstraints.HORIZONTAL; //Horizontale Anordnung der Elemente
    b.insets = new Insets(5,5,5,5); //Padding Elemente 5px alle
    b.ipady = 8;      //Buttonpadding 8px * 5px
    b.ipadx = 5;

    /*
    JButton neuePizzaButton = new JButton("Neue Pizza");
    b.fill = GridBagConstraints.HORIZONTAL;
    //b.anchor = GridBagConstraints.FIRST_LINE_END;
    b.gridx = 0;
    b.gridy = 0;
    this.add(neuePizzaButton,b);
    neuePizzaButton.addActionListener(new ZutatenButtonListener());



    JLabel pizzaNameLabel = new JLabel("Pizzaname");
    b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 1;
    b.gridy = 0;
        this.add(pizzaNameLabel,b);

    JTextField pizzaNameText = new JTextField(10);
    b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 1;
    b.gridy = 2;
        this.add(pizzaNameText,b);
*/



        /*


    JLabel gesamtPreisLabel = new JLabel("Gesamtpreis");
    b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 0;
    b.gridy = 2;
        this.add(gesamtPreisLabel,b);

    currentStatus = new StatusScreen();
    b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 1;
    b.gridy = 2;
        this.add(currentStatus,b);

    JButton orderedButton = new JButton("Bestellung Info");
    b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 0;
    b.gridy = 4;
        this.add(orderedButton,b);
        orderedButton.addActionListener(new ZutatenButtonListener());


*/

    JButton deleteButton = new JButton("Löschen"); // Bestellung löschen Button
    //b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 2;
    b.gridy = 0;
    this.add(deleteButton,b);
    deleteButton.addActionListener(zutatenButtonListener);

    JLabel bestellListe = new JLabel("Bestellung"); // Label für bestellliste
    //c.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 1;
    b.gridy = 1;
    this.add(bestellListe,b);

    currentStatusTextArea = new JTextArea(30,20);
    //b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 1;
    b.gridy = 2;
    b.gridwidth = 2;
    this.add(currentStatusTextArea,b);



    JButton pizzaAbschlussButton = new JButton("Pizza abschließen");

    b.gridx = 1;
    b.gridy = 5;
    b.gridwidth = 2;
    this.add(pizzaAbschlussButton,b);
    pizzaAbschlussButton.addActionListener(zutatenButtonListener);

    JButton finishButton = new JButton("Bestellung abschicken");
    //b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 1;
    b.gridy = 6;
    b.gridwidth = 2;
    this.add(finishButton,b);
    finishButton.addActionListener(zutatenButtonListener);


    }

    public StatusScreen getCurrentStatus() {
        return currentStatus;
    }

    public JTextArea getCurrentStatusTextArea() {return currentStatusTextArea;}



}
