package view;

import control.ZutatenButtonListener;

import javax.swing.*;
import java.awt.*;

public class AktuellePizzaPanel extends JPanel {

    private final JTextArea currentPizzaTextArea;
    private final JTextField pizzaNameTextField;
    private final JLabel ausgabefeld;
    private JLabel pizzaNameTextLabel;

    public AktuellePizzaPanel(ZutatenButtonListener zutatenButtonListener){
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

        pizzaNameTextLabel = new JLabel("Hier Pizzanamen eingeben");
        //pizzaNameText.setPreferredSize(new Dimension(50, 15));
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 4;
        this.add(pizzaNameTextLabel, c);

        pizzaNameTextField = new JTextField("", 1);
        //pizzaNameText.setPreferredSize(new Dimension(50, 15));
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 6;
        this.add(pizzaNameTextField, c);


        JButton neuePizzaButton = new JButton("Neue Pizza");
        neuePizzaButton.setPreferredSize(new Dimension(4, 20));
        //c.fill = GridBagConstraints.HORIZONTAL;
        //b.anchor = GridBagConstraints.FIRST_LINE_END;
        c.gridx = 3;
        c.gridy = 1;
        this.add(neuePizzaButton, c);
        neuePizzaButton.addActionListener(zutatenButtonListener);

        JButton pizzaAbschlussButton = new JButton("Pizza abschließen");
        pizzaAbschlussButton.setPreferredSize(new Dimension(4, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 1;
        this.add(pizzaAbschlussButton,c);
        pizzaAbschlussButton.addActionListener(zutatenButtonListener);

        ausgabefeld = new JLabel("Herzlich Willkommen bei Luigis Pizza!");
        ausgabefeld.setPreferredSize(new Dimension(50, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        this.add(ausgabefeld,c);
    }

    public JTextArea getCurrentPizzaTextArea() {
        return currentPizzaTextArea;
    }

    public JTextField getPizzaNameTextField() {
        return pizzaNameTextField;
    }

    public JLabel getAusgabefeld() {
        return ausgabefeld;
    }
}
