package control;

import model.*;
import view.AktuellePizzaPanel;
import view.WarenkorbPanel;
import view.ZutatenPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * ActionListener für die JButtons der GUI
 */
public class ButtonListener implements ActionListener {
    /*
    Diese Klasse enthält das GUI-basierte Pizzabestellsystem.
    Hierfür notwendig ist eine Pizzainstanz, die nach Wunsch der Nutzer belegt wird.
    Diese Klasse behandelt die Funktionalitäten aller GUI-Knöpfe.
     */

    // Warenkorb:
    private PizzenList pizzen = new PizzenList();
    // Einzelne Pizza:
    private Pizza meinePizza;
    private int pizzaNummer = 0;
    private AktuellePizzaPanel aktuellePizzaPanel;
    private WarenkorbPanel warenkorbPanel;

    public ButtonListener() {
        //this.meinePizza = meinePizza;
    }

    /**
     * Eigentliches Bestellsystem als große switch-case-Abfrage.
     * @param e ActionEvent. Informationen zum angeklickten Knopf.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        // Bestellsystem als großer switch-Ausdruck:
        switch (e.getActionCommand()) {
            case "+":
            case "-":
                clickPlusMinus(button, e.getActionCommand());
                break;
            case "Neue Pizza":
                aktuellePizzaPanel.getAusgabefeld().setText("Neue Pizza wird erstellt.");
                meinePizza = new Pizza();
                pizzaNummer++;
                pizzaname(meinePizza);
                aktuellePizzaPanel.getCurrentPizzaTextArea().setText(meinePizza.toString());
                break;
            case "Pizza abschließen":
                if(Objects.isNull(meinePizza)){
                    aktuellePizzaPanel.getAusgabefeld().setText("Erst 'Neue Pizza' auswählen!");
                } else {
                    if (meinePizza.getZutaten().size() > Pizza.getMaxbelag()) {
                        aktuellePizzaPanel.getAusgabefeld().setText("Diese Pizza hat mehr als acht Zutaten!!!");
                    } else {
                        pizzaname(meinePizza);
                        pizzen.add(meinePizza);
                        warenkorbPanel.getCurrentStatusTextArea().setText(pizzen.toString());
                        meinePizza = null;
                        aktuellePizzaPanel.getCurrentPizzaTextArea().setText("");
                        aktuellePizzaPanel.getAusgabefeld().setText("'Neue Pizza' oder 'Bestellung abschicken'?");
                    }
                }
                break;
            case "Bestellung abschicken":
                if (pizzen.size() > 0) {
                    aktuellePizzaPanel
                            .getAusgabefeld()
                            .setText("Das kostet insgesamt " + pizzen.zahlen());
                    // Evtl exportieren in Datei ???
                } else {
                    aktuellePizzaPanel.getAusgabefeld().setText("Es wurde noch nichts bestellt.");
                }
                break;
            case "Löschen":
                aktuellePizzaPanel.getAusgabefeld().setText("Verlauf gelöscht!");
                pizzen = new PizzenList();
                warenkorbPanel.getCurrentStatusTextArea().setText("");
                break;
            default:
                aktuellePizzaPanel.getAusgabefeld().setText("Keine gültige Eingabe.");
        }
    }

    /**
     * Hilfsmethode, um die Funktionalität der '+' und '-' Knöpfe zusammenzufassen und somit Redundanzen zu vermeiden.
     * @param button JButton. Angeklickter Knopf.
     * @param vorzeichen String. Schriftzug auf dem angeklicken Knopf (in diesem Falle '+' oder '-').
     */
    private void clickPlusMinus(JButton button, String vorzeichen){
        if (Objects.isNull(meinePizza)) {
            aktuellePizzaPanel.getAusgabefeld().setText("Erst 'Neue Pizza' auswählen!");
        } else {
            ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
            String zutatenName = zutatenPanel.getZutatenName();

            if(vorzeichen.equals("+")){
                aktuellePizzaPanel.getAusgabefeld().setText(meinePizza.belegen(zutatenName));
            } else if(vorzeichen.equals("-")){
                aktuellePizzaPanel.getAusgabefeld().setText(meinePizza.entfernen(zutatenName));
            }
            aktuellePizzaPanel.getCurrentPizzaTextArea().setText(meinePizza.toString());
        }
    }

    /**
     * Übertragung des Schriftzugs im Textfeld auf die Pizza als Name.
     * @param pizza Pizza. Aktuelle Pizza, die umzubenennen ist.
     */
    private void pizzaname(Pizza pizza){
        String name = aktuellePizzaPanel
                .getPizzaNameTextField()
                .getText().equals("") ?
                "Pizza " + pizzaNummer :
                aktuellePizzaPanel.getPizzaNameTextField().getText();
        pizza.setName(name);
    }

    public void setAktuellePizzaPanel(AktuellePizzaPanel aktuellePizzaPanel) {
        this.aktuellePizzaPanel = aktuellePizzaPanel;
    }

    public void setWarenkorbPanel(WarenkorbPanel warenkorbPanel) {
        this.warenkorbPanel = warenkorbPanel;
    }
}
