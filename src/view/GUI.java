package view;

import control.ZutatenButtonListener;

import javax.swing.*;
import java.awt.*;


public class GUI {
    private final JPanel centerPanel = new JPanel();

    private JButton finishButton;
    private JButton neuePizzaButton;

    public JButton getFinishButton() {
        return finishButton;
    }

    public JButton getNeuePizzaButton() {
        return neuePizzaButton;
    }

    // später von woanders her?
    //private String[] saucenListe= {"Tomatensauce","BBQ-Sauce"};
    //private String[] zutatenListe= {"Gouda","Mozzarella","Salami","Schinken","Thunfisch","Peperoni","Ananas"};

    private final String preis000 = " 0,00 €";
    private final String preis059 = " 0,59 €";
    private final String preis099 = " 0,99 €";
    private final String preis139 = " 1,39 €";

    private ZutatenPanel zutat;
    private ImageLabel backgroundImage;
    //private ImageLabel backgroundImage1;
    //private ImageLabel backgroundImage2;

    public GUI(){
        JFrame frame = new JFrame("Luigi's Pizza");
        frame.setSize(1300,1300);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        frame.add(bottomPanel, BorderLayout.EAST);

        // --------------------- top ---------------------
        backgroundImage = new ImageLabel("testbild2.jpg");



        topPanel.add(backgroundImage);
        /*
        try {
            ImageIcon icon = new ImageIcon("testbild2.jpg");
            JLabel background = new JLabel();
            background.setIcon(icon);
            topPanel.add(background);

        } catch (Exception e){
            e.printStackTrace();
        }
        */


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


        /*ZutatenPanel zutat17 = new ZutatenPanel("Artischocken", preis139);
        this.addZutat(zutat17, c, 5, 3);*/

        // ------------------- bottom -----------------------
        JButton neuePizzaButton = new JButton("Neue Pizza");
        bottomPanel.add(neuePizzaButton);
        neuePizzaButton.addActionListener(new ZutatenButtonListener());

        JLabel pizzaNameLabel = new JLabel("Pizzaname");
        bottomPanel.add(pizzaNameLabel);

        JTextField pizzaNameText = new JTextField(10);
        bottomPanel.add(pizzaNameText);

        /*JButton pizzaFertig = new JButton("Pizza abschließen");
        bottomPanel.add(pizzaFertig);
        pizzaFertig.addActionListener(new ZutatenButtonListener());


        GridBagLayout bottomLayout = new GridBagLayout();
        bottomPanel.setLayout(bottomLayout);

        JLabel gesamtPreisLabel = new JLabel("Gesamtpreis");
        bottomPanel.add(gesamtPreisLabel);

        StatusScreen currentStatus = new StatusScreen();
        bottomPanel.add(currentStatus);

        JButton orderedButton = new JButton("Bestellung Info");
        bottomPanel.add(orderedButton);
        orderedButton.addActionListener(new ZutatenButtonListener());

        JButton finishButton = new JButton("Bestellung abschicken");
        bottomPanel.add(finishButton);
        finishButton.addActionListener(new ZutatenButtonListener());

        JButton deleteButton = new JButton("Warenkorb löschen");
        bottomPanel.add(deleteButton);
        deleteButton.addActionListener(new ZutatenButtonListener());
*/
        // ---------------- Show ! --------------------------
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

    public void addZutat(ZutatenPanel zutat, GridBagConstraints c, int xPos, int yPos){
        //zutat = new ZutatenPanel(zutatenName, preis);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = xPos;
        c.gridy = yPos;
        centerPanel.add(zutat, c);
    }




}
