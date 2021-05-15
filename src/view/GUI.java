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

        ZutatenPanel neueZutat1 = new ZutatenPanel("Tomatensauce", preis000);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        centerPanel.add(neueZutat1, c);


        ZutatenPanel neueZutat2 = new ZutatenPanel("BBQ-Sauce", preis000);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        centerPanel.add(neueZutat2, c);


        ZutatenPanel neueZutat3 = new ZutatenPanel("Gouda ", preis099);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        centerPanel.add(neueZutat3, c);

        ZutatenPanel neueZutat4 = new ZutatenPanel("Mozzarella", preis099);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        centerPanel.add(neueZutat4, c);

        ZutatenPanel neueZutat5 = new ZutatenPanel("Salami ", preis139);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        centerPanel.add(neueZutat5, c);

        ZutatenPanel neueZutat6 = new ZutatenPanel("Schinken", preis099);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        centerPanel.add(neueZutat6, c);

        ZutatenPanel neueZutat7 = new ZutatenPanel("Thunfisch", preis099);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 1;
        centerPanel.add(neueZutat7, c);

        ZutatenPanel neueZutat8 = new ZutatenPanel("Peperoni", preis099);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        centerPanel.add(neueZutat8, c);


        ZutatenPanel neueZutat9 = new ZutatenPanel("Ananas", preis000);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        centerPanel.add(neueZutat9, c);


        ZutatenPanel neueZutat10 = new ZutatenPanel("Mais", preis000);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        centerPanel.add(neueZutat10, c);

        ZutatenPanel neueZutat11 = new ZutatenPanel("Zwiebeln", preis000);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        centerPanel.add(neueZutat11, c);

        ZutatenPanel neueZutat12 = new ZutatenPanel("Oliven", preis000);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 2;
        centerPanel.add(neueZutat12, c);

        ZutatenPanel neueZutat13 = new ZutatenPanel("Ei", preis000);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        centerPanel.add(neueZutat13, c);

        ZutatenPanel neueZutat14 = new ZutatenPanel("Paprika", preis000);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        centerPanel.add(neueZutat14, c);

        ZutatenPanel neueZutat15 = new ZutatenPanel("Tomaten", preis000);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 3;
        centerPanel.add(neueZutat15, c);

        ZutatenPanel neueZutat16 = new ZutatenPanel("Champignons", preis000);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 3;
        centerPanel.add(neueZutat16, c);

        frame.pack();
        frame.repaint();

        frame.setVisible(true);

    }
}
