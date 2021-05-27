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
    private ImageLabel backgroundImage;
    private StatusScreen currentStatus;
    //private ImageLabel backgroundImage1;
    //private ImageLabel backgroundImage2;

    public GUI(){
        JFrame frame = new JFrame("Luigi's Pizza");
        frame.setSize(1300,1300);
        frame.setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel topPanel = new JPanel();
//        final JLabel label = new JLabel("LUIGGI'S PIZZA");
//        frame.getContentPane().add(label);
        frame.add(topPanel, BorderLayout.NORTH);
        // --------------------- top ---------------------
        backgroundImage = new ImageLabel("testbild2.jpg");
        topPanel.add(backgroundImage);

        // --------------------- center and bottom  ---------------------
        CenterPanel centerPanel = new CenterPanel();
        frame.add(centerPanel, BorderLayout.CENTER);
        BottomPanel bottomPanel = new BottomPanel();
        frame.add(bottomPanel, BorderLayout.EAST);

        // ---------------- Show ! --------------------------
        frame.pack();
        frame.repaint();
        frame.setVisible(true);

    }



}
