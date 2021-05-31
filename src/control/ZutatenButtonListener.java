package control;

import model.*;
import view.BottomPanel;
import view.CenterPanel;
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

    public ZutatenButtonListener() {
        //this.meinePizza = meinePizza;
    }

    // Eigentliches Bestellsystem:
    @Override
    public void actionPerformed(ActionEvent e) {

        // Bestellsystem als großer switch-Ausdruck:
        String zutatenName;
        switch (e.getActionCommand()) {
            case "+":
                if (pizzaindex < 0) {
                    System.out.println("Erst eine neue Pizza auswählen!");
                } else {
                    JButton button = (JButton) e.getSource();
                    ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
                    zutatenName = zutatenPanel.getZutatenName();

                    meinePizza.belegen(zutatenName);
                    CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                    centerpanel.getCurrentPizzaTextArea()
                            .setText(meinePizza.toString() +
                                    "\n" +
                                    "-------------------- \n" +
                                    "Preis:" +
                                    currency.format(meinePizza.getPreis()));
                }/**/
                break;

            case "-":
                if (pizzaindex < 0) {
                    System.out.println("Erst eine neue Pizza auswählen!");
                } else {
                    JButton button = (JButton) e.getSource();
                    ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
                    zutatenName = zutatenPanel.getZutatenName();

                    meinePizza.entfernen(zutatenName);
                    CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                    centerpanel
                            .getCurrentPizzaTextArea()
                            .setText(meinePizza.toString() +
                                    "\n" +
                                    "-------------------- \n" +
                                    "Preis:" +
                                    currency.format(meinePizza.getPreis()));
                }
                break;


            case "Neue Pizza":
                System.out.println("Neue Pizza wird erstellt.");
                meinePizza = new Pizza();
                //meineZutaten = new HashSet<>();
                pizzaindex++;
                pizzaNummer++;
                meinePizza.setName("Pizza " + pizzaNummer);

                JButton button = (JButton) e.getSource();
                CenterPanel centerpanel = (CenterPanel) button.getParent();
                centerpanel.getCurrentPizzaTextArea().setText(meinePizza.getName());

                break;
            case "Pizza abschließen":
                if (pizzaindex >= 0) {
                    if (meinePizza.getZutaten().size() > Pizza.getMaxbelag()) {
                        System.out.println("Diese Pizza hat mehr als acht Zutaten!!!");
                    } else {
                        pizzen.add(meinePizza);
                        System.out.print(meinePizza.getName());
                        System.out.print(" kostet ");
                        System.out.println(currency.format(meinePizza.getPreis()));

                        JButton abschlussButton = (JButton) e.getSource();
                        BottomPanel panel = (BottomPanel) abschlussButton.getParent();
                        //JFrame frame = (JFrame)  panel.getParent();
                        //panel.getCurrentStatus().setText(pizzen.toString());

                        panel.getCurrentStatusTextArea().setText(pizzen.toString());

                        // Static ? sinnvoll?
                        initialisieren();
                        System.out.println("'Neue Pizza' oder 'Bestellung abschicken'?");
                    }

                } else {
                    System.out.println("Erst 'Neue Pizza' auswählen!");
                }
                break;
            case "Bestellung Info":
                if (pizzen.size() > 0) {
                    for (Pizza pizza : pizzen) {
                        System.out.print(pizza.getName());
                        System.out.print(": ");
                        System.out.println(currency.format(pizza.getPreis()));
                    }
                } else {
                    System.out.println("Noch keine Pizza im Warenkorb. 'Pizza abschließen' bringt die Pizza in den Warenkorb");
                }
                break;
            case "Bestellung abschicken":
                if (pizzen.size() > 0) {
                    System.out.print("Das kostet insgesamt ");
                    System.out.println(currency.format(zahlen(pizzen)));
                    // Evtl exportieren in Datei ???
                } else {
                    System.out.println("Nichts bestellt? Dann beim nächsten Mal! :-)");
                }
                System.out.println("Gehe auf 'Warenkorb löschen', um die Bestellung abzuschließen.");

                break;
            case "Warenkorb löschen":
                System.out.println("Verlauf gelöscht!");

                pizzen = new PizzenList<>();
                initialisieren();
                JButton loeschButton = (JButton) e.getSource();
                BottomPanel panel = (BottomPanel) loeschButton.getParent();
                //panel.getCurrentStatus().setText(pizzen.toString());
                panel.getCurrentStatusTextArea().setText("");
                break;
            default:
                System.out.println("Keine gültige Eingabe.");

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


}
