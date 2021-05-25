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

    JButton pizzaAbschlussButton = new JButton("Pizza abschließen");
    b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 1;
    b.gridy = 3;
        this.add(pizzaAbschlussButton,b);
        pizzaAbschlussButton.addActionListener(new ZutatenButtonListener());

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
    JButton deleteButton = new JButton("Warenkorb löschen");
    b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 1;
    b.gridy = 6;
        this.add(deleteButton,b);
        deleteButton.addActionListener(new ZutatenButtonListener());

    JButton finishButton = new JButton("Bestellung abschicken");
    b.fill = GridBagConstraints.HORIZONTAL;
    b.gridx = 0;
    b.gridy = 6;
        this.add(finishButton,b);
        finishButton.addActionListener(new ZutatenButtonListener());

        currentStatusTextArea = new JTextArea(10,20);
        b.fill = GridBagConstraints.HORIZONTAL;
        b.gridx = 1;
        b.gridy = 5;
        this.add(currentStatusTextArea,b);
    }

    public StatusScreen getCurrentStatus() {
        return currentStatus;
    }

    public JTextArea getCurrentStatusTextArea() {return currentStatusTextArea;}



}
