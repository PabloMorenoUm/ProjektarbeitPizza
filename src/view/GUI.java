package view;

import control.ButtonListener;

import javax.swing.*;
import java.awt.*;



/**
 * Klasse der grafischen Benutzeroberfläche.
 */
public class GUI {



    public GUI() {

        JFrame frame = new JFrame("Luigis Pizza");
        frame.setPreferredSize(new Dimension(1700, 1300));


        GridBagLayout gLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        frame.setLayout(gLayout);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(200, 150));

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
        ButtonListener buttonListener = new ButtonListener();
        AktuellePizzaPanel aktuellePizzaPanel = new AktuellePizzaPanel(buttonListener);
        //frame.add(aktuellePizzaPanel, BorderLayout.CENTER);
        buttonListener.setAktuellePizzaPanel(aktuellePizzaPanel);
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 1;
        frame.add(aktuellePizzaPanel,c);
        // ------------------------------------------------------------------------
        BelaegePanel belaegePanel = new BelaegePanel(buttonListener);
        //frame.add(belaegePanel, BorderLayout.SOUTH);
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 2;
        frame.add(belaegePanel,c);
        // --------------------------------------------------------------
        WarenkorbPanel warenkorbPanel = new WarenkorbPanel(buttonListener);
        //frame.add(warenkorbPanel, BorderLayout.EAST);
        buttonListener.setWarenkorbPanel(warenkorbPanel);
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
