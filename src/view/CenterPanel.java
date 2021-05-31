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
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(1,2,1,2); // Abstände definieren
        c.ipadx = 5; // Button Padding
        c.ipady = 8;

       // Container thisContainer = new this.getContentPane();

        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setLayout(centerLayout);

        JLabel pizzaNameLabel = new JLabel("Pizzaname");
        c.gridx = 0;
        c.gridy = 0;
        // c.weightx = 1;
        this.add(pizzaNameLabel,c);


        JTextField pizzaNameText = new JTextField(); // Pizzaname
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(pizzaNameText,c);

        currentPizzaTextArea = new JTextArea(); // Pizzaerstellung transparent gesetzt.
        currentPizzaTextArea.setOpaque(false);
        currentPizzaTextArea.setBackground(new Color(0,0,0,0));
        JScrollPane scrollPane = new JScrollPane(currentPizzaTextArea);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(currentPizzaTextArea,c);

        JButton neuePizzaButton = new JButton("Neue Pizza");
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(neuePizzaButton,c);
        neuePizzaButton.addActionListener(new ZutatenButtonListener());

        JButton pizzaAbschlussButton = new JButton("Pizza abschließen");
        c.gridx = 3;
        c.gridy = 2;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(pizzaAbschlussButton,c);
        pizzaAbschlussButton.addActionListener(new ZutatenButtonListener());


        /*


        JButton pizzaAbschlussButton = new JButton("Pizza abschließen");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 0;
        this.add(pizzaAbschlussButton,c);
        pizzaAbschlussButton.addActionListener(new ZutatenButtonListener());
 */

        this.addZutat("Tomatensauce", preis000, c, 0,4);
        this.addZutat("BBQ-Sauce", preis000, c, 1,4);

        this.addZutat("Gouda", preis099, c, 0,5);
        this.addZutat("Mozzarella", preis099, c, 1,5);
        this.addZutat("Salami", preis139, c, 2,5);
        this.addZutat("Schinken", preis139, c, 3,5);
        this.addZutat("Thunfisch", preis099, c, 4,5);

        this.addZutat("Peperoni", preis059, c, 0,6);
        this.addZutat("Ananas", preis059, c, 1,6);
        this.addZutat("Mais", preis059, c, 2,6);
        this.addZutat("Zwiebeln", preis059, c, 3,6);
        this.addZutat("Oliven", preis099, c, 4,6);

        this.addZutat("Ei", preis059, c, 0,7);
        this.addZutat("Paprika", preis059, c, 1,7);
        this.addZutat("Tomaten", preis059, c, 2,7);
        this.addZutat("Champignons", preis059, c, 3,7);

    }

    public void addZutat(String zutatenName, String preis, GridBagConstraints c, int xPos, int yPos){
        zutat = new ZutatenPanel(zutatenName, preis);
        //c.fill = GridBagConstraints.BASELINE_LEADING;
        c.gridx = xPos;
        c.gridy = yPos;
        c.weighty = 0.5;
        c.weightx = 0.5;
        this.add(zutat, c);
    }

    public JTextArea getCurrentPizzaTextArea() {return currentPizzaTextArea;}
}
