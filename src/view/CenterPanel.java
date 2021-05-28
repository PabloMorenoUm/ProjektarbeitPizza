package view;

import control.Existenzebene;
import control.ZutatenButtonListener;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {

    private ZutatenPanel zutat;
    private JTextArea currentPizzaTextArea;
    private Existenzebene existenzebene;

    private final String preis000 = " 0,00 €";
    private final String preis059 = " 0,59 €";
    private final String preis099 = " 0,99 €";
    private final String preis139 = " 1,39 €";

    public CenterPanel(Existenzebene existenzebene) {
        this.existenzebene = existenzebene;
        GridBagLayout centerLayout = new GridBagLayout();
        this.setLayout(centerLayout);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5); // Abstände definieren
        c.ipadx = 5; // Button Padding
        c.ipady = 8;
        c.weighty = 0.5;
        c.weightx = 0.5;

        JLabel pizzaNameLabel = new JLabel("Pizzaname");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(pizzaNameLabel,c);

        currentPizzaTextArea = new JTextArea();
        c.gridx = 0;
        c.gridy = 1;
        this.add(currentPizzaTextArea,c);

        JTextField pizzaNameText = new JTextField();
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 4;
        this.add(pizzaNameText,c);


        JButton neuePizzaButton = new JButton("Neue Pizza");
        //c.fill = GridBagConstraints.HORIZONTAL;
        //b.anchor = GridBagConstraints.FIRST_LINE_END;
        c.gridx = 3;
        c.gridy = 1;
        this.add(neuePizzaButton,c);
        neuePizzaButton.addActionListener(new ZutatenButtonListener(existenzebene));

        /*


        JButton pizzaAbschlussButton = new JButton("Pizza abschließen");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 0;
        this.add(pizzaAbschlussButton,c);
        pizzaAbschlussButton.addActionListener(new ZutatenButtonListener());
 */

        this.addZutat("Tomatensauce", preis000, c, 0,3);
        this.addZutat("BBQ-Sauce", preis000, c, 1,3);

        this.addZutat("Gouda", preis099, c, 0,4);
        this.addZutat("Mozzarella", preis099, c, 1,4);
        this.addZutat("Salami", preis139, c, 2,4);
        this.addZutat("Schinken", preis139, c, 3,4);
        this.addZutat("Thunfisch", preis099, c, 4,4);

        this.addZutat("Peperoni", preis059, c, 0,5);
        this.addZutat("Ananas", preis059, c, 1,5);
        this.addZutat("Mais", preis059, c, 2,5);
        this.addZutat("Zwiebeln", preis059, c, 3,5);
        this.addZutat("Oliven", preis099, c, 4,5);

        this.addZutat("Ei", preis059, c, 0,6);
        this.addZutat("Paprika", preis059, c, 1,6);
        this.addZutat("Tomaten", preis059, c, 2,6);
        this.addZutat("Champignons", preis059, c, 3,6);

    }

    public void addZutat(String zutatenName, String preis, GridBagConstraints c, int xPos, int yPos){
        zutat = new ZutatenPanel(zutatenName, preis, existenzebene);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = xPos;
        c.gridy = yPos;
        this.add(zutat, c);
    }

    public JTextArea getCurrentPizzaTextArea() {return currentPizzaTextArea;}
}
