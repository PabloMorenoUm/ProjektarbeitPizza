package view;

import control.ButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Bereich unter dem Titelbild mit Textfeld für die gerade erstellte Pizza (mit Belag), mit Namenstextfeld und
 * mit den Knöpfen "Neue Pizza" und "Pizza abschließen".
 */
public class AktuellePizzaPanel extends JPanel {

    private final JTextArea currentPizzaTextArea;
    private final JTextField pizzaNameTextField;
    private final JLabel ausgabefeld;

    /**
     * Konstruktor. Erstellt ein JPanel mit allen Textfeldern und Knöpfen, die die zu bearbeitende Pizza betreffen.
     * @param buttonListener ButtonListener. Dieser wird hier gebraucht, damit die Knöpfe nach Anklicken
     *                       ihren gewünschten Zweck erfüllen.
     */
    public AktuellePizzaPanel(ButtonListener buttonListener){
        GridBagLayout centerLayout = new GridBagLayout();
        this.setLayout(centerLayout);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(1, 5, 1, 5); // Abstände definieren
        c.ipadx = 5; // Button Padding
        c.ipady = 8;

        JLabel pizzaNameLabel = new JLabel("Ihre aktuelle Pizza");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(pizzaNameLabel, c);

        currentPizzaTextArea = new JTextArea(10, 1);
        JScrollPane scrollCurrentPizza = new JScrollPane(currentPizzaTextArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollCurrentPizza.setPreferredSize(new Dimension(200, 100));
        c.gridx = 0;
        c.gridy = 1;
        this.add(scrollCurrentPizza, c);

        JLabel pizzaNameTextLabel = new JLabel("Hier Pizzanamen eingeben");
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 4;
        this.add(pizzaNameTextLabel, c);

        pizzaNameTextField = new JTextField("", 1);
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 2;
        c.anchor = GridBagConstraints.NORTHWEST;
        this.add(pizzaNameTextField, c);


        JButton neuePizzaButton = new JButton("Neue Pizza");
        neuePizzaButton.setPreferredSize(new Dimension(4, 20));
        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 5;
        this.add(neuePizzaButton, c);
        neuePizzaButton.addActionListener(buttonListener);

        JButton pizzaAbschlussButton = new JButton("Pizza abschließen");
        pizzaAbschlussButton.setPreferredSize(new Dimension(4, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 1;
        c.weightx = 5;
        this.add(pizzaAbschlussButton,c);
        pizzaAbschlussButton.addActionListener(buttonListener);

        ausgabefeld = new JLabel("Herzlich Willkommen bei Luigis Pizza!");
        ausgabefeld.setPreferredSize(new Dimension(50, 20));
        ausgabefeld.setFont(new Font("Serif", Font.BOLD, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 4;
        this.add(ausgabefeld,c);
    }

    /**
     * Getter-Methode
     * @return JTextArea. Textbereich, in dem die gegenwärtige Pizza samt Sauce, Zutaten und Preis aufgelistet ist.
     */
    public JTextArea getCurrentPizzaTextArea() {
        return currentPizzaTextArea;
    }

    /**
     * Getter-Methode
     * @return JTextField. Textfeld für den gewünschten Pizzanamen, den Benutzer*innen vor Erstellung einer
     * neuen Pizza oder vor Abschluss der betreffenden Pizza eingeben können.
     */
    public JTextField getPizzaNameTextField() {
        return pizzaNameTextField;
    }

    /**
     * Getter-Methode
     * @return JLabel. Textausgabe, in dem das System mit den Benutzer*innen interagiert.
     */
    public JLabel getAusgabefeld() {
        return ausgabefeld;
    }
}
