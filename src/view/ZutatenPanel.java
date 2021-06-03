package view;

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

    private final String zutatenName;
    private final String preisName;
    private int buttonBreite;
    private final JButton plusButton;
    private final JButton minusButton;


    public ZutatenPanel(String zutatenName, String preisName, ZutatenButtonListener zutatenButtonListener) {
        this.zutatenName = zutatenName;
        this.preisName = preisName;

        this.setPreferredSize(new Dimension(180, 100));
        this.setLayout(new GridBagLayout());


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5); //Padding Elemente 5px alle
        c.ipady = 8;      //Buttonpadding 8px * 5px
        c.ipadx = 5;

        JLabel zutatenLabel = new JLabel(zutatenName + " " + preisName);
        //zutatenLabel.setPreferredSize(new Dimension(100, 100));
        //c.fill = GridBagConstraints.HORIZONTAL;
        //c.gridwidth = 2;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;


        c.gridwidth = GridBagConstraints.REMAINDER;
        this.add(zutatenLabel, c);

        //JLabel preisLabel = new JLabel(preisName);
        //c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.2;
        //c.gridx =1;
        //c.gridy = 0;
        //this.add(preisLabel, c);
        //this.remove(getLayoutComponent(BorderLayout.CENTER));

        plusButton = new JButton("+");
        //c.fill = GridBagConstraints.HORIZONTAL;
//        c.ipady = 8;      //make this component tall
//        c.ipadx = 5;
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.weightx = 1;
        //c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        this.add(plusButton, c);
        plusButton.addActionListener(zutatenButtonListener);

        minusButton = new JButton("-");
        //c.fill = GridBagConstraints.HORIZONTAL;
//        c.ipady = 8;      //make this component tall
//        c.ipadx = 5;
        c.weightx = 1;
        //c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        this.add(minusButton, c);
        minusButton.addActionListener(zutatenButtonListener);

        this.revalidate();

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
