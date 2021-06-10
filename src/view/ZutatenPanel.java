package view;

import control.ButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 *
 * Enthält JButtons, mit denen eine Sauce oder Zutat zur Pizza hinzugefügt und entfernt werden kann.
 * Jede Sauce und Zutat wird im Panel BelaegePanel durch ein ZutatenPanel repräsentiert.
 * Ein ZutatenPanel besteht stets aus den gleichen Unterkomponenten:
 * JLabel, das den Namen der Zutat anzeigt, JLabel, das den Preis anzeigt,
 * JButton mit der Aufschrift '+' (mit dem sich die Zutat zur Pizza hinzufügen lässt) und
 * JButton mit er Aufschrift '-' (mit dem sich die Zutat von der Pizza entfernen lässt).
 */
public class ZutatenPanel extends JPanel {

    private final String belagName;

    /**
     * Konstruktor. Erstellt ein JPanel pro Sauce/Zutat.
     * Mit den Knöpfen lassen sich die entsprechende Sauce/Zutat hinzufügen oder entfernen.
     * @param belagName String. Name der Sauce/Zutat.
     * @param preisName String. Preis der Sauce/Zutat.
     * @param buttonListener ButtonListener. Dieser wird hier gebraucht, damit die Knöpfe nach Anklicken
     *                       ihren gewünschten Zweck erfüllen.
     */
    public ZutatenPanel(String belagName, String preisName, ButtonListener buttonListener) {
        this.belagName = belagName;

        this.setPreferredSize(new Dimension(180, 100));
        this.setLayout(new GridBagLayout());


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5); //Padding Elemente 5px alle
        c.ipady = 8;      //Buttonpadding 8px * 5px
        c.ipadx = 5;

        JLabel zutatenLabel = new JLabel(belagName + " " + preisName);
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;


        c.gridwidth = GridBagConstraints.REMAINDER;
        this.add(zutatenLabel, c);

        JButton plusButton = new JButton("+");
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.weightx = 1;
        //c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        this.add(plusButton, c);
        plusButton.addActionListener(buttonListener);

        JButton minusButton = new JButton("-");
        c.weightx = 1;
        //c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        this.add(minusButton, c);
        minusButton.addActionListener(buttonListener);

        this.revalidate();

    }

    /**
     * Getter-Methode
     * @return String. Name der Sauce oder Zutat.
     */
    public String getBelagName() {
        return belagName;
    }
}
