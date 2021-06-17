package view;

import control.ButtonListener;
import control.MusicListener;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Enthält die ZutatenPanel, wobei jedes ZutatenPanel eine Zutat beziehungsweise Sauce repräsentiert.
 */
public class BelaegePanel extends JPanel {

    private final ButtonListener buttonListener;

    /**
     * Konstruktor. Erstellt ein JPanel, das alle Saucen und Zutaten umfasst.
     * Mit den Knöpfen lassen sich wahlweise Saucen und Zutaten hinzufügen oder entfernen.
     * @param buttonListener ButtonListener. Dieser wird hier gebraucht, damit die Knöpfe nach Anklicken
     *                       ihren gewünschten Zweck erfüllen.
     */
    public BelaegePanel(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
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

        JButton play = new JButton("Play/Stop");
        play.addActionListener(new MusicListener());
        //c.gridx = 3;
        //c.gridy = 3;
        this.add(play);
    }

    /**
     * Fügt ein ZutatenPanel hier in dieses Panel ein.
     * @param zutatenName String. Name der jeweiligen Sauce oder Zutat.
     * @param preis String. Preis für die jeweilige Sauce oder Zutat.
     * @param xPos int. x-Koordinate für das Panel
     * @param yPos int. y-Koordinate für das Panel
     * @param c GridBagConstraints. Constraints für das ZutatenPanel.
     */
    public void addZutat(String zutatenName, String preis, GridBagConstraints c, int xPos, int yPos) {
        ZutatenPanel zutat = new ZutatenPanel(zutatenName, preis, buttonListener);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = xPos;
        c.gridy = yPos;
        this.add(zutat, c);
    }
}
