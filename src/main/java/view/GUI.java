package view;

import control.ButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Klasse der grafischen Benutzeroberfläche.
 */
public class GUI {

    /**
     * Konstruktor. Erstellt ein eigenes Fenster, das die Benutzeroberfläche für das Bestellsystem ist.
     */
    public GUI() {

        JFrame frame = new JFrame("Luigis Pizza");
        //frame.setPreferredSize(new Dimension(1700, 1300));
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //frame.setSize(screenSize.width,screenSize.height);

        GridBagLayout gLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        frame.setLayout(gLayout);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel topPanel = new JPanel();
        Dimension topPanelSize = new Dimension((int)(screenSize.width/1.2),(int)(screenSize.height/6));
        System.out.println(topPanelSize.width);
        System.out.println(topPanelSize.height);
        topPanel.setPreferredSize(topPanelSize);


        // --------------------- top ---------------------
        ImageLabel backgroundImage = new ImageLabel("pizzabanner.png");
        //backgroundImage.setSize(new Dimension(150, 100));
        topPanel.add(backgroundImage);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(topPanel,c);

        // --------------------- center and bottom  ---------------------
        ButtonListener buttonListener = new ButtonListener();
        AktuellePizzaPanel aktuellePizzaPanel = new AktuellePizzaPanel(buttonListener);
        //frame.add(aktuellePizzaPanel, BorderLayout.CENTER);
        buttonListener.setAktuellePizzaPanel(aktuellePizzaPanel);
        c.weightx = 0.5;
        c.weighty = 0.5;
        //c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 1;
        frame.add(aktuellePizzaPanel,c);
        // ------------------------------------------------------------------------
        BelaegePanel belaegePanel = new BelaegePanel(buttonListener);
        //frame.add(belaegePanel, BorderLayout.SOUTH);
        c.weightx = 0.1;
        c.weighty = 0.4;
        c.gridx = 0;
        c.gridy = 2;
        frame.add(belaegePanel,c);
        // --------------------------------------------------------------
        WarenkorbPanel warenkorbPanel = new WarenkorbPanel(buttonListener);
        //frame.add(warenkorbPanel, BorderLayout.EAST);
        buttonListener.setWarenkorbPanel(warenkorbPanel);
        c.weightx = 0.6;
        c.gridx = 2;
        c.gridy = 2;
        frame.add(warenkorbPanel,c);

        // ---------------- Show ! --------------------------
        frame.pack();
        frame.setSize(screenSize.width,screenSize.height);
        frame.repaint();
        frame.setVisible(true);
    }
}
