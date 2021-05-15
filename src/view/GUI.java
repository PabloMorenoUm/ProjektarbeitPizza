package view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI {
    private JFrame frame = new JFrame("Luigi's Pizza");
    private JPanel topPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();

    // später von woanders her?
    private String[] saucenListe= {"Tomatensauce","BBQ-Sauce"};
    private String[] zutatenListe= {"Gouda","Mozzarella","Salami","Schinken","Thunfisch","Peperoni","Ananas"};

    private String preis000 = " 0,00 €";
    private String preis059 = " 0,59 €";
    private String preis099 = " 0,99 €";
    private String preis139 = " 1,39 €";

    private ZutatenPanel zutat;

    public GUI(){
        frame.setSize(1300,1300);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);




        try {
            ImageIcon icon = new ImageIcon("testbild2.jpg");
            JLabel background = new JLabel();
            background.setIcon(icon);
            //JLabel background = new JLabel(new ImageIcon("./testbild.jpg"));
            topPanel.add(background);

            //topPanel.add(background);

        } catch (Exception e){
            e.printStackTrace();
        }












        // ------------ center ------------------------
        GridBagLayout centerLayout = new GridBagLayout();
        centerPanel.setLayout(centerLayout);
        GridBagConstraints c = new GridBagConstraints();

        c.weighty = 0.5;
        c.weightx = 0.5;


        this.addZutat("Tomatensauce", preis000, c, 0,0);
        this.addZutat("BBQ-Sauce", preis000, c, 1,0);

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
        //this.addZutat("Artischocken", preis139, c, 4,3);

        frame.pack();
        frame.repaint();

        frame.setVisible(true);

    }


    public void addZutat(String zutatenName, String preis, GridBagConstraints c, int xPos, int yPos){
        zutat = new ZutatenPanel(zutatenName, preis);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = xPos;
        c.gridy = yPos;
        centerPanel.add(zutat, c);
    }
}
