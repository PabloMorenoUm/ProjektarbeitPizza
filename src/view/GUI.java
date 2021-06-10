package view;

import control.ButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Klasse der grafischen Benutzeroberfläche. Die GUI unterteilt sich in 4 Unterbereiche, die jeweils in ein eigenes Panel gegliedert sind.
 * Im oberen Bereich wird ein Bild dargestellt. Darunter befindet sich mit AktuellePizzaPanel der Bereich, in dem die vom Benutzer
 * aktuell bearbeitete Pizza behandelt und dargestellt wird. Ebenso kann hier eine neue Pizza erstellt oder die aktuelle Pizza dem
 * Warenkorb hinzugefügt werden. Darunter befindet sich mit dem BelaegePanel der Bereich in dem die Buttons liegen,
 * mit denen die einzelnen Zutaten und Saucen der aktuellen Pizza hinzugefügt oder von dieser entfernt werden können.
 * Ganz rechts befindet sich mit dem WarenkorbPanel der Bereich, in dem der vollständige Warenkorb mit ggf. mehreren Pizzen dargestellt ist.
 * Hier kann ebenfalls der Warenkorb gelöscht oder die Bestellung abgeschickt werden.
 */
public class GUI {

    /**
     * Konstruktor von GUI. Die den 4 thematischen Bereichen: Bild, aktuelle Pizza, Zutaten und Warenkorb zugeordneten JPanel sind in einem
     * GridBagLayout angeordnet.
     */
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
        ImageLabel backgroundImage = new ImageLabel("titel.jpg");
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
