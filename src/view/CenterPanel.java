package view;

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

        this.addZutat("Tomatensauce", preis000, c, 0,0);
        this.addZutat("BBQ-Sauce", preis000, c, 1,0);

        currentPizzaTextArea = new JTextArea();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 0;
        this.add(currentPizzaTextArea,c);

        this.addZutat("Gouda", preis099, c, 0,1);
        this.addZutat("Mozzarella", preis099, c, 1,1);
        this.addZutat("Salami", preis139, c, 2,1);
        this.addZutat("Schinken", preis139, c, 3,1);
        this.addZutat("Thunfisch", preis099, c, 4,1);

        this.addZutat("Peperoni", preis059, c, 0,2);
        this.addZutat("Ananas", preis059, c, 1,2);
        this.addZutat("Mais", preis059, c, 2,2);
        this.addZutat("Zwiebeln", preis059, c, 3,2);
        this.addZutat("Oliven", preis099, c, 4,2);

        this.addZutat("Ei", preis059, c, 0,3);
        this.addZutat("Paprika", preis059, c, 1,3);
        this.addZutat("Tomaten", preis059, c, 2,3);
        this.addZutat("Champignons", preis059, c, 3,3);

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
