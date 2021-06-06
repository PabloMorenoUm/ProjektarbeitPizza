package view;

import control.ZutatenButtonListener;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Bereich mit Plus-Minus-Knöpfen für alle Saucen und Zutaten.
 */
public class BelaegePanel extends JPanel {

    private final ZutatenButtonListener zutatenButtonListener;

    public BelaegePanel(ZutatenButtonListener zutatenButtonListener) {
        this.zutatenButtonListener = zutatenButtonListener;
        GridBagLayout centerLayout = new GridBagLayout();
        this.setLayout(centerLayout);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5); // Abstände definieren
        c.ipadx = 5; // Button Padding
        c.ipady = 8;
        c.weighty = 0.5;
        c.weightx = 0.5;


        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        String preis000 = currency.format(0.0);
        String preis099 = currency.format(0.99);
        String preis139 = currency.format(1.39);
        String preis059 = currency.format(0.59);

        this.addZutat("Tomatensauce", preis000, c, 0, 3);
        this.addZutat("BBQ-Sauce", preis000, c, 1, 3);

        this.addZutat("Gouda", preis099, c, 0, 4);
        this.addZutat("Mozzarella", preis099, c, 1, 4);
        this.addZutat("Salami", preis139, c, 2, 4);
        this.addZutat("Schinken", preis139, c, 3, 4);
        this.addZutat("Thunfisch", preis099, c, 4, 4);
        this.addZutat("Peperoni", preis059, c, 0, 5);
        this.addZutat("Ananas", preis059, c, 1, 5);
        this.addZutat("Mais", preis059, c, 2, 5);
        this.addZutat("Zwiebeln", preis059, c, 3, 5);
        this.addZutat("Oliven", preis099, c, 4, 5);
        this.addZutat("Ei", preis059, c, 0, 6);
        this.addZutat("Paprika", preis059, c, 1, 6);
        this.addZutat("Tomaten", preis059, c, 2, 6);
        this.addZutat("Champignons", preis059, c, 3, 6);

    }

    public void addZutat(String zutatenName, String preis, GridBagConstraints c, int xPos, int yPos) {
        ZutatenPanel zutat = new ZutatenPanel(zutatenName, preis, zutatenButtonListener);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = xPos;
        c.gridy = yPos;
        this.add(zutat, c);
    }
}
