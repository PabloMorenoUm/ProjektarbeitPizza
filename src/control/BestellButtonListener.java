package control;

import view.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.GUI;

public class BestellButtonListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Gesamtpreis":
                System.out.println("Sie haben den Gesamtpreis");
                break;
            case "Bestellung abschicken":
                System.out.println("Sie schicken die Bestellung ab");
                break;
            default:
                System.out.println("Etwas anderes wurde getan");

        }
    }
}
