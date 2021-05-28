package view;

import control.Existenzebene;
import control.ZutatenButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Jede Zutat wird in der Klasse GUI durch ein ZutatenPanel repräsentiert.
 * Ein ZutatenPanel besteht stets aus den gleichen Unterkomponenten:
 * JLabel das den Namen der Zutat anzeigt, JLabel das den Preis anzeigt,
 * JButton mit der Aufschrift "+" mit dem sich die Zutat zur Pizza hinzufügen lässt,
 * JButton mit er Aufschrift "-" mit dem sich die Zutat von der Pizza entfernen lässt.
 */
public class ZutatenPanel extends JPanel {

    private String zutatenName;
    private String preisName;
    private int buttonBreite;
    private JButton plusButton;
    private JButton minusButton;

    private Existenzebene existenzebene;




    public ZutatenPanel(String zutatenName, String preisName, Existenzebene existenzebene) {
        this.zutatenName = zutatenName;
        this.preisName = preisName;
        this.existenzebene = existenzebene;
        this.setPreferredSize(new Dimension(160, 100));
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5); //Padding Elemente 5px alle
        c.ipady = 8;      //Buttonpadding 8px * 5px
        c.ipadx = 5;

        JLabel zutatenLabel = new JLabel(zutatenName);
        //zutatenLabel.setPreferredSize(new Dimension(100, 100));
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(zutatenLabel, c);

        JLabel preisLabel = new JLabel(preisName);
        //c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        this.add(preisLabel, c);

        plusButton = new JButton("+");
        //c.fill = GridBagConstraints.HORIZONTAL;
//        c.ipady = 8;      //make this component tall
//        c.ipadx = 5;
        //c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        this.add(plusButton, c);
        plusButton.addActionListener(new ZutatenButtonListener(existenzebene));

        minusButton = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
//        c.ipady = 8;      //make this component tall
//        c.ipadx = 5;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        this.add(minusButton, c);
        minusButton.addActionListener(new ZutatenButtonListener(existenzebene));

    }

    public String getZutatenName() {
        return zutatenName;
    }

    public String getPreisName() {
        return preisName;
    }

    public JButton getPlusButton() {
        return plusButton;
    }

    public JButton getMinusButton() {
        return minusButton;
    }
}
