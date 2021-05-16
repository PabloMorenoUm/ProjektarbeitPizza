package control;

import view.ZutatenPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZutatenButtonListener implements ActionListener {

    private String zutatenName;
    //private ZutatenPanel panel;

    @Override
    public void actionPerformed(ActionEvent e) {
        // (JButton)e.getComponent()).getParent()
        try {
            JButton button = (JButton) e.getSource();
            ZutatenPanel panel = (ZutatenPanel) button.getParent();
            zutatenName = panel.getZutatenName();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Plus and Minus ButtonListener Not working like you think!");
        }



        switch (e.getActionCommand()) {

            case "   +   ":
                System.out.println("Sie haben " + zutatenName + " ausgewählt");
                break;
            case "   -   ":
                System.out.println("Sie haben " + zutatenName + " entfernt");
                break;
            default:
                System.out.println("Etwas anderes als Zutaten hinzufügen/entfernen wurde getan");

        }
    }
}
