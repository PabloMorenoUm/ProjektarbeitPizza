package view;

import control.ZutatenButtonListener;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {

    private ZutatenPanel zutat;
    private JTextArea currentPizzaTextArea;

    private final String preis000 = " 0,00 €";
    private final String preis059 = " 0,59 €";
    private final String preis099 = " 0,99 €";
    private final String preis139 = " 1,39 €";

    public CenterPanel() {
        GridBagLayout centerLayout = new GridBagLayout();
        this.setLayout(centerLayout);
        GridBagConstraints c = new GridBagConstraints();

        c.weighty = 0.5;
        c.weightx = 0.5;


        currentPizzaTextArea = new JTextArea();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        this.add(currentPizzaTextArea,c);

        JLabel pizzaNameLabel = new JLabel("Pizzaname");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        this.add(pizzaNameLabel,c);

        JTextField pizzaNameText = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        this.add(pizzaNameText,c);


        JButton neuePizzaButton = new JButton("Neue Pizza");
        c.fill = GridBagConstraints.HORIZONTAL;
        //b.anchor = GridBagConstraints.FIRST_LINE_END;
        c.gridx = 0;
        c.gridy = 0;
        this.add(neuePizzaButton,c);
        neuePizzaButton.addActionListener(new ZutatenButtonListener());

        /*


        JButton pizzaAbschlussButton = new JButton("Pizza abschließen");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 0;
        this.add(pizzaAbschlussButton,c);
        pizzaAbschlussButton.addActionListener(new ZutatenButtonListener());
 */

        this.addZutat("Tomatensauce", preis000, c, 0,1);
        this.addZutat("BBQ-Sauce", preis000, c, 1,1);

        this.addZutat("Gouda", preis099, c, 0,2);
        this.addZutat("Mozzarella", preis099, c, 1,2);
        this.addZutat("Salami", preis139, c, 2,2);
        this.addZutat("Schinken", preis139, c, 3,2);
        this.addZutat("Thunfisch", preis099, c, 4,2);

        this.addZutat("Peperoni", preis059, c, 0,3);
        this.addZutat("Ananas", preis059, c, 1,3);
        this.addZutat("Mais", preis059, c, 2,3);
        this.addZutat("Zwiebeln", preis059, c, 3,3);
        this.addZutat("Oliven", preis099, c, 4,3);

        this.addZutat("Ei", preis059, c, 0,4);
        this.addZutat("Paprika", preis059, c, 1,4);
        this.addZutat("Tomaten", preis059, c, 2,4);
        this.addZutat("Champignons", preis059, c, 3,4);

    }

    public void addZutat(String zutatenName, String preis, GridBagConstraints c, int xPos, int yPos){
        zutat = new ZutatenPanel(zutatenName, preis);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = xPos;
        c.gridy = yPos;
        this.add(zutat, c);
    }

    public JTextArea getCurrentPizzaTextArea() {return currentPizzaTextArea;}
}
