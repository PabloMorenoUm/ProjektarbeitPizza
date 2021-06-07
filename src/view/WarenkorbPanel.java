package view;

import control.ButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Bereich ganz rechts mit Warenkorbanzeige, Löschfunktion und Bezahlknopf
 */
public class WarenkorbPanel extends JPanel {
    private final JTextArea currentStatusTextArea;

    public WarenkorbPanel(ButtonListener buttonListener) {

        GridBagLayout bottomLayout = new GridBagLayout();
        this.setLayout(bottomLayout);
        GridBagConstraints b = new GridBagConstraints();
        b.fill = GridBagConstraints.HORIZONTAL; //Horizontale Anordnung der Elemente
        b.insets = new Insets(5, 1, 5, 1); //Padding Elemente 5px alle
        b.ipady = 8;      //Buttonpadding 8px * 5px
        b.ipadx = 5;

        JButton deleteButton = new JButton("Löschen"); // Bestellung löschen Button
        //b.fill = GridBagConstraints.HORIZONTAL;
        b.gridx = 0;
        b.gridy = 2;
        //b.anchor = GridBagConstraints.EAST;
        this.add(deleteButton, b);
        deleteButton.addActionListener(buttonListener);

        JLabel bestellListe = new JLabel("Warenkorb"); // Label für bestellliste
        //c.fill = GridBagConstraints.HORIZONTAL;
        b.gridx = 0;
        b.gridy = 0;
        this.add(bestellListe, b);


        currentStatusTextArea = new JTextArea(20, 20);
        JScrollPane scrollCurrentStatus = new JScrollPane(currentStatusTextArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        b.gridx = 0;
        b.gridy = 1;
        b.gridwidth = 6;
        b.weightx = 10;
        this.add(scrollCurrentStatus, b);

        JButton finishButton = new JButton("Bestellung abschicken");
        //b.fill = GridBagConstraints.HORIZONTAL;
        b.gridx = 1;
        b.gridy = 2;
        b.gridwidth = 2;
        this.add(finishButton, b);
        finishButton.addActionListener(buttonListener);


    }


    public JTextArea getCurrentStatusTextArea() {
        return currentStatusTextArea;
    }


}
