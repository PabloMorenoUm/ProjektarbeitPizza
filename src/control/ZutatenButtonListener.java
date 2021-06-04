package control;

import model.*;
import view.AktuellePizzaPanel;
import view.WarenkorbPanel;
import view.ZutatenPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import java.util.Locale;


/**
 * ActionListener für die JButtons der GUI
 */
public class ZutatenButtonListener implements ActionListener {
    /*
    Diese Klasse enthält das GUI-basierte Pizzabestellsystem.
    Hierfür notwendig ist eine Pizzainstanz, die nach Wunsch der Nutzer belegt wird.
    Diese Klasse behandelt die Funktionalitäten aller GUI-Knöpfe.
     */

    // Währungsformat:
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    // Warenkorb:
    private PizzenList<Pizza> pizzen = new PizzenList<>();
    // Einzelne Pizza:
    private Pizza meinePizza = new Pizza();
    /*
    Index für eine Pizza im jeweiligen Bestellvorgang.
    Eigentlich ist nur entscheidend, ob dieser Index negativ ist oder nicht.
    Ein negativer Index bedeutet, dass es noch keine Pizza im Warenkorb gibt.
     */
    private int pizzaindex = -1;
    private int pizzaNummer = 0;
    private AktuellePizzaPanel aktuellePizzaPanel;
    private WarenkorbPanel warenkorbPanel;

    public ZutatenButtonListener() {
        //this.meinePizza = meinePizza;
    }

    // Eigentliches Bestellsystem:
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        String pizzaNametext = aktuellePizzaPanel
                .getPizzaNameTextField()
                .getText();
        if (pizzaNametext.equals(""))
        {
            meinePizza.setName("Pizza " + pizzaNummer);
        }  else {
            meinePizza.setName(pizzaNametext);
        }


        // Bestellsystem als großer switch-Ausdruck:
        String zutatenName;
        switch (e.getActionCommand()) {
            case "+":
                if (pizzaindex < 0) {
                    aktuellePizzaPanel.getAusgabefeld().setText("Erst eine neue Pizza auswählen!");
                } else {
                    //JButton button = (JButton) e.getSource();
                    ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
                    zutatenName = zutatenPanel.getZutatenName();

                    meinePizza.belegen(zutatenName, aktuellePizzaPanel.getAusgabefeld());
                    //CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                    aktuellePizzaPanel.getCurrentPizzaTextArea()
                            .setText(meinePizza.toString() +
                                    "\n" +
                                    "-------------------- \n" +
                                    "Preis:" +
                                    currency.format(meinePizza.getPreis()));
                }/**/
                break;

            case "-":
                if (pizzaindex < 0) {
                    aktuellePizzaPanel.getAusgabefeld().setText("Erst eine neue Pizza auswählen!");
                } else {
                    //JButton button = (JButton) e.getSource();
                    ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
                    zutatenName = zutatenPanel.getZutatenName();

                    meinePizza.entfernen(zutatenName, aktuellePizzaPanel.getAusgabefeld());
                    //CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                    aktuellePizzaPanel
                            .getCurrentPizzaTextArea()
                            .setText(meinePizza.toString() +
                                    "\n" +
                                    "-------------------- \n" +
                                    "Preis:" +
                                    currency.format(meinePizza.getPreis()));
                }
                break;


            case "Neue Pizza":
                aktuellePizzaPanel.getAusgabefeld().setText("Neue Pizza wird erstellt.");
                meinePizza = new Pizza();
                //meineZutaten = new HashSet<>();
                pizzaindex++;
                pizzaNummer++;


                //JButton button = (JButton) e.getSource();
                //CenterPanel centerpanel = (CenterPanel) button.getParent();

                //meinePizza.setName(pizzaname);

                aktuellePizzaPanel.getCurrentPizzaTextArea().setText(meinePizza.getName());

                break;
            case "Pizza abschließen":
                if (pizzaindex >= 0) {
                    if (meinePizza.getZutaten().size() > Pizza.getMaxbelag()) {
                        aktuellePizzaPanel.getAusgabefeld().setText("Diese Pizza hat mehr als acht Zutaten!!!");
                    } else {
                        //JButton abschlussButton = (JButton) e.getSource();
                        //CenterPanel centerPanel = (CenterPanel) abschlussButton.getParent();
                        //meinePizza.setName(centerPanel.getPizzaNameText().getText());
                        String pizzaname = aktuellePizzaPanel
                                .getPizzaNameTextField()
                                .getText().equals("") ?
                                //.equals("Hier Pizzaname eingeben")
                                meinePizza.getName() :
                                aktuellePizzaPanel.getPizzaNameTextField().getText();
                        meinePizza.setName(pizzaname);

                        pizzen.add(meinePizza);
                        aktuellePizzaPanel.
                                getAusgabefeld().
                                setText(meinePizza.getName() + " kostet " + currency.format(meinePizza.getPreis()));

                        /*JButton abschlussButton = (JButton) e.getSource();
                        CenterPanel panel = (CenterPanel) abschlussButton.getParent();*/
                        //JFrame frame = (JFrame)  panel.getParent();
                        //panel.getCurrentStatus().setText(pizzen.toString());

                        warenkorbPanel.getCurrentStatusTextArea().setText(pizzen.toString());

                        // Static ? sinnvoll?
                        initialisieren();
                        aktuellePizzaPanel.getAusgabefeld().setText("'Neue Pizza' oder 'Bestellung abschicken'?");
                    }

                } else {
                    aktuellePizzaPanel.getAusgabefeld().setText("Erst 'Neue Pizza' auswählen!");
                }
                break;
            case "Bestellung abschicken":
                if (pizzen.size() > 0) {
                    aktuellePizzaPanel
                            .getAusgabefeld()
                            .setText("Das kostet insgesamt " + currency.format(zahlen(pizzen)));
                    // Evtl exportieren in Datei ???
                } else {
                    aktuellePizzaPanel.getAusgabefeld().setText("Es wurde noch nichts bestellt.");
                }

                break;
            case "Löschen":
                aktuellePizzaPanel.getAusgabefeld().setText("Verlauf gelöscht!");

                pizzen = new PizzenList<>();
                initialisieren();
                JButton loeschButton = (JButton) e.getSource();
                WarenkorbPanel panel = (WarenkorbPanel) loeschButton.getParent();
                //panel.getCurrentStatus().setText(pizzen.toString());
                panel.getCurrentStatusTextArea().setText("");
                break;
            default:
                aktuellePizzaPanel.getAusgabefeld().setText("Keine gültige Eingabe.");

        }
    }

    // Pizzainstanz, Zutatenkorb und Indizes resetten:
    private void initialisieren() {
        this.meinePizza = new Pizza();
        //this.meineZutaten = new HashSet<>();
        this.pizzaindex = -1;
    }

    protected double zahlen(ArrayList<Pizza> pizzaliste) {
        double gesamtpreis = 0.0;
        for (Pizza pizza : pizzaliste) {
            gesamtpreis += pizza.getPreis();
        }
        return gesamtpreis;
    }

    public void setAktuellePizzaPanel(AktuellePizzaPanel aktuellePizzaPanel) {
        this.aktuellePizzaPanel = aktuellePizzaPanel;
    }

    public void setWarenkorbPanel(WarenkorbPanel warenkorbPanel) {
        this.warenkorbPanel = warenkorbPanel;
    }
}
