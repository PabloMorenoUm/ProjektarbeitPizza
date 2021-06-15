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

    /**
     * Konstruktor. Erstellt eine Instanz dieses Listeners, das für die Funktionalität der Knöpfe und Textfelder
     * dient und als Schnittstelle zwischen grafischer Oberfläche und Pizzabestellsystem dient.
     */
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
                meinePizza.setName("Pizza " + pizzaNummer);
                aktuellePizzaPanel.getCurrentPizzaTextArea().setText(meinePizza.toString());
                break;
            case "Pizza abschließen":
                if(Objects.isNull(meinePizza)){
                    aktuellePizzaPanel.getAusgabefeld().setText("Erst 'Neue Pizza' auswählen!");
                } else {
                    if (meinePizza.getZutaten().size() > Pizza.getMaxZutat()) {
                        aktuellePizzaPanel.getAusgabefeld().setText("Diese Pizza hat mehr als acht Zutaten!!!");
                    } else {
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
            String zutatenName = zutatenPanel.getBelagName();

            if(vorzeichen.equals("+")){
                aktuellePizzaPanel.getAusgabefeld().setText(meinePizza.belegen(zutatenName));
            } else if(vorzeichen.equals("-")){
                aktuellePizzaPanel.getAusgabefeld().setText(meinePizza.entfernen(zutatenName));
            }
            aktuellePizzaPanel.getCurrentPizzaTextArea().setText(meinePizza.toString());
        }
    }

    /**
     * Setze den GUI-Bereich, in dem sich die Textfelder und Knöpfe,
     * die die aktuell zu bearbeitende Pizza betreffen, befinden, in diese Listener-Klasse.
     * @param aktuellePizzaPanel AktuellePizzaPanel. JPanel mit den Informationen und Funktionalitäten,
     *                           die die aktuelle Pizza betreffen.
     */
    public void setAktuellePizzaPanel(AktuellePizzaPanel aktuellePizzaPanel) {
        this.aktuellePizzaPanel = aktuellePizzaPanel;
    }

    /**
     * Setze den GUI-Bereich, in dem sich die textfelder und Knöpfe,
     * die den Warenkorb betreffen, befinden, in diese Listener-Klasse.
     * @param warenkorbPanel WarenkorbPanel. JPanel mit den Informationen und Funktionalitäten,
     *                       die den Warenkorb betreffen.
     */
    public void setWarenkorbPanel(WarenkorbPanel warenkorbPanel) {
        this.warenkorbPanel = warenkorbPanel;
    }

    public Pizza getMeinePizza() {
        return meinePizza;
    }
}
