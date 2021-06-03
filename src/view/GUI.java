package view;

import control.ZutatenButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Klasse der grafischen Benutzeroberfläche.
 */
public class GUI {

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

    /*


    private final String preis000 = " 0,00 €";
    private final String preis059 = " 0,59 €";
    private final String preis099 = " 0,99 €";
    private final String preis139 = " 1,39 €";
 */

    private ZutatenPanel zutat;
    private StatusScreen currentStatus;
    //private ImageLabel backgroundImage1;
    //private ImageLabel backgroundImage2;

    public GUI() {
        JFrame frame = new JFrame("Luigi's Pizza");
        frame.setPreferredSize(new Dimension(1700, 1300));
        //frame.setLayout(new BorderLayout());

        GridBagLayout gLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        frame.setLayout(gLayout);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(200, 150));


//       final JLabel label = new JLabel("LUIGGI'S PIZZA");
//        frame.getContentPane().add(label);
        //frame.add(topPanel, BorderLayout.NORTH);
        // --------------------- top ---------------------
        ImageLabel backgroundImage = new ImageLabel("testbild2.jpg");
        backgroundImage.setSize(new Dimension(150, 100));
        topPanel.add(backgroundImage);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(topPanel,c);

        // --------------------- center and bottom  ---------------------
        ZutatenButtonListener zutatenButtonListener = new ZutatenButtonListener();
        AktuellePizzaPanel aktuellePizzaPanel = new AktuellePizzaPanel(zutatenButtonListener);
        //frame.add(aktuellePizzaPanel, BorderLayout.CENTER);
        zutatenButtonListener.setAktuellePizzaPanel(aktuellePizzaPanel);
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 1;
        frame.add(aktuellePizzaPanel,c);
        // ------------------------------------------------------------------------
        BelaegePanel belaegePanel = new BelaegePanel(zutatenButtonListener);
        //frame.add(belaegePanel, BorderLayout.SOUTH);
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 2;
        frame.add(belaegePanel,c);
        // --------------------------------------------------------------
        WarenkorbPanel warenkorbPanel = new WarenkorbPanel(zutatenButtonListener);
        //frame.add(warenkorbPanel, BorderLayout.EAST);
        zutatenButtonListener.setWarenkorbPanel(warenkorbPanel);
        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 2;
        frame.add(warenkorbPanel,c);

        // ---------------- Show ! --------------------------
        frame.pack();
        frame.repaint();
        frame.setVisible(true);

    }


}
