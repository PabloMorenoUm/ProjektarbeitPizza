package view;

import control.ButtonListener;
import model.Pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

/**
 * Bereich unter dem Titelbild mit Textfeld für die gerade erstellte Pizza (mit Belag), mit Namenstextfeld und
 * mit den Knöpfen "Neue Pizza" und "In den Warenkorb".
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

        JLabel pizzaNameTextLabel = new JLabel("Hier Pizzanamen eingeben und danach Enter drücken");
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 2;
        this.add(pizzaNameTextLabel, c);

        pizzaNameTextField = new JTextField("", 1);
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 2;
        c.anchor = GridBagConstraints.NORTHWEST;
        pizzaNameTextField.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza pizza = buttonListener.getMeinePizza();
                if(Objects.isNull(pizza)){
                    ausgabefeld.setText("Erst 'Neue Pizza' auswählen!");
                } else{
                    pizza.setName(pizzaNameTextField.getText());
                    currentPizzaTextArea.setText(pizza.toString());
                }
            }
        });
        this.add(pizzaNameTextField, c);


        JButton neuePizzaButton = new JButton("Neue Pizza");
        neuePizzaButton.setPreferredSize(new Dimension(4, 20));
        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 5;
        this.add(neuePizzaButton, c);
        neuePizzaButton.addActionListener(buttonListener);

        JButton pizzaAbschlussButton = new JButton("In den Warenkorb");
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
     * @return JLabel. Textausgabe, in dem das System mit den Benutzer*innen interagiert.
     */
    public JLabel getAusgabefeld() {
        return ausgabefeld;
    }
}
