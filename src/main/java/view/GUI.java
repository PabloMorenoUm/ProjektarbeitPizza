package view;

import control.ButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Klasse der grafischen Benutzeroberfläche.
 */
public class GUI {

    /**
     * Konstruktor. Erstellt ein eigenes Fenster, das die Benutzeroberfläche für das Bestellsystem ist.
     */
    public GUI() {

        JFrame frame = new JFrame("Luigis Pizza");

        GridBagLayout gLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        frame.setLayout(gLayout);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(300, 150));


        // --------------------- top ---------------------
        ImageLabel backgroundImage = new ImageLabel("pizzabanner.png");
        topPanel.add(backgroundImage);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(topPanel,c);

        // --------------------- center and bottom  ---------------------
        ButtonListener buttonListener = new ButtonListener();
        AktuellePizzaPanel aktuellePizzaPanel = new AktuellePizzaPanel(buttonListener);
        buttonListener.setAktuellePizzaPanel(aktuellePizzaPanel);
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 1;
        frame.add(aktuellePizzaPanel,c);
        // ------------------------------------------------------------------------
        BelaegePanel belaegePanel = new BelaegePanel(buttonListener);
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 2;
        frame.add(belaegePanel,c);
        // --------------------------------------------------------------
        WarenkorbPanel warenkorbPanel = new WarenkorbPanel(buttonListener);
        buttonListener.setWarenkorbPanel(warenkorbPanel);
        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 2;
        frame.add(warenkorbPanel,c);

        // ---------------- Show ! --------------------------
        frame.pack();
        frame.repaint();
        frame.setVisible(true);
    }
}
