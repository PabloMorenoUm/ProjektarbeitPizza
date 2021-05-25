package control;

import de.karrieretutor.LydiaHolmPablo.Pizza.*;
import view.BottomPanel;
import view.CenterPanel;
import view.ZutatenPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;

/**
 * ActionListener für die JButtons der GUI
 */
public class ZutatenButtonListener implements ActionListener {
    /*
    Diese Klasse enthält das GUI-basierte Pizzabestellsystem.
    Hierfür notwendig ist eine Pizzainstanz, die nach Wunsch der Nutzer belegt wird.
    Diese Klasse behandelt die Funktionalitäten aller GUI-Knöpfe.
     */

    private String zutatenName;
    //private ZutatenPanel panel;

    // Währungsformat:
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    // Warenkorb:
    private static ArrayList<Pizza> pizzen = new PizzenList();
    private static ArrayList<Pizza> pizzen1 = new ArrayList<>();
    // Einzelne Pizza:
    private static Pizza meinePizza = new Pizza();
    // Zutaten für eine einzelne Pizza:
    private static HashSet<Zutat> meineZutaten = new HashSet<>();

    // Daten von allen Saucen:
    private static final AlleSaucen alleSaucen = new AlleSaucen();
    // Daten von allen Zutaten:
    private static final AlleZutaten alleZutaten = new AlleZutaten();
    /*
    Index für eine Pizza im jeweiligen Bestellvorgang.
    Eigentlich ist nur entscheidend, ob dieser Index negativ ist oder nicht.
    Ein negativer Index bedeutet, dass es noch keine Pizza im Warenkorb gibt.
     */
    private static int pizzaindex = -1;
    private static int pizzaNummer = 0;

    // Konstanten:
    private static final int maxbelag = 8;

    // Eigentliches Bestellsystem:
    @Override
    public void actionPerformed(ActionEvent e) {

        /*
        //Extrahiere den Belagnamen, falls + oder - angeklickt wurde:
        if(e.getActionCommand().equals("   +   ") || e.getActionCommand().equals("   -   ")){
            JButton button = (JButton) e.getSource();
            ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
            zutatenName = zutatenPanel.getZutatenName();

            if(pizzaindex < 0){
                System.out.println("Erst eine neue Pizza auswählen!");
                //reak;
                 }
            else {
                if (e.getActionCommand().equals("   +   ")) {
                    belegePizza(zutatenName);
                }
                else {
                    entferneZutat(zutatenName);
                }
            }
            CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
            centerpanel.getCurrentPizzaTextArea().setText(meinePizza.toString());
            //break;
        }
*/

        // Bestellsystem als großer switch-Ausdruck:
        switch (e.getActionCommand()) {
            case "   +   " :
                if(pizzaindex < 0){
                    System.out.println("Erst eine neue Pizza auswählen!");
                    break;
                }
                else {
                JButton button = (JButton) e.getSource();
                ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
                zutatenName = zutatenPanel.getZutatenName();

                belegePizza(zutatenName);
                CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                centerpanel.getCurrentPizzaTextArea().setText(meinePizza.toString() + "\n" + "-------------------- \n" + "Preis:" + String.valueOf(meinePizza.getPreis()));
                break;
                }

            case "   -   " :
                if(pizzaindex < 0){
                    System.out.println("Erst eine neue Pizza auswählen!");
                    break;
                }
                else {
                    JButton button = (JButton) e.getSource();
                    ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
                    zutatenName = zutatenPanel.getZutatenName();

                    entferneZutat(zutatenName);
                    CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                    centerpanel.getCurrentPizzaTextArea().setText(meinePizza.toString()  + "\n" + "-------------------- \n" + "Preis:" + String.valueOf(meinePizza.getPreis()));
                    break;
                }


            case "Neue Pizza":
                System.out.println("Neue Pizza wird erstellt.");
                meinePizza = new Pizza();
                meineZutaten = new HashSet<>();
                pizzaindex++;
                pizzaNummer++;
                meinePizza.setName("Pizza " + String.valueOf(pizzaNummer));

                JButton button = (JButton) e.getSource();
                CenterPanel centerpanel = (CenterPanel) button.getParent();
                centerpanel.getCurrentPizzaTextArea().setText(meinePizza.getName());

                break;
                /*


            case "   +   ":
                if(pizzaindex < 0){
                    System.out.println("Erst eine neue Pizza auswählen!");
                    break;
                } else{
                    belegePizza(zutatenName);

                    JButton button = (JButton) e.getSource();
                    ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
                    zutatenName = zutatenPanel.getZutatenName();

                    CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                    centerpanel.getCurrentPizzaTextArea().setText(meinePizza.toString());
                    //JButton abschlussButton = (JButton) e.getSource();
                    //CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                    //centerpanel.getCurrentPizzaTextArea().setText(pizza.toString());
                    //centerpanel.getCurrentPizzaTextArea().setText(meinePizza.toString());
                }
                break;
            case "   -   ":
                if(pizzaindex < 0){
                    System.out.println("Erst eine neue Pizza auswählen!");
                    break;
                } else{
                    JButton button = (JButton) e.getSource();
                    ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
                    zutatenName = zutatenPanel.getZutatenName();

                    CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                    centerpanel.getCurrentPizzaTextArea().setText(meinePizza.toString());

                    entferneZutat(zutatenName);
                    //JButton abschlussButton = (JButton) e.getSource();
                    //CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                    //centerpanel.getCurrentPizzaTextArea().setText(pizza.toString());
                }
                break;

                 */
            case "Pizza abschließen":
                if(pizzaindex >= 0){
                    if(meinePizza.getZutaten().size() > maxbelag){
                        System.out.println("Diese Pizza hat mehr als acht Zutaten!!!");
                    } else {
                        /*System.out.print("Wie soll die Pizza heißen? ");
                        String pizzaname = keyboard.nextLine();
                        meinePizza.setName(pizzaname);*/
                        //meinePizza.setName("Pizza " + String.valueOf(pizzaindex + 1));
                        pizzen.add(meinePizza);
                        System.out.print(meinePizza.getName());
                        System.out.print(" kostet ");
                        System.out.println(currency.format(meinePizza.getPreis()));

                        JButton abschlussButton = (JButton) e.getSource();
                        BottomPanel panel = (BottomPanel) abschlussButton.getParent();
                        //JFrame frame = (JFrame)  panel.getParent();
                        //panel.getCurrentStatus().setText(pizzen.toString());

                        panel.getCurrentStatusTextArea().setText(pizzen.toString() );

                        // Static ? sinnvoll?
                        initialisieren();
                        System.out.println("'Neue Pizza' oder 'Bestellung abschicken'?");
                    }

                } else {
                    System.out.println("Erst 'Neue Pizza' auswählen!");
                }
                break;
            case "Bestellung Info":
                if(pizzen.size() > 0){
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
                if(pizzen.size() > 0){
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

                pizzen = new ArrayList<>();
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
    private static void initialisieren(){
        meinePizza = new Pizza();
        meineZutaten = new HashSet<>();
        pizzaindex = -1;
    }

    // Sauce oder Zutat auf die Pizza setzen:
    private static void belegePizza(String name){
        if(name.toLowerCase(Locale.ROOT).contains("sauce")){
            if(Objects.isNull(meinePizza.getSauce())){
                for(Belag sauce: alleSaucen.getListe()){
                    if(sauce.getName().equals(name)){
                        meinePizza.setSauce((Sauce) sauce);
                        System.out.println(sauce.getName() + " hinzugefügt");
                        break;
                    }
                }
            } else{
                System.out.println("Sauce ist schon vorhanden.");
            }
        } else{
            if(meineZutaten.size() < maxbelag){
                for(Belag zutat: alleZutaten.getListe()){
                    if(zutat.getName().equals(name)){
                        if(meineZutaten.contains((Zutat) zutat)){
                            System.out.println(zutat.getName() + " ist schon drauf. Andere Zutat?");
                        } else{
                            System.out.println(zutat.getName() + " hinzugefügt");
                        }
                        meineZutaten.add((Zutat) zutat);
                        meinePizza.setZutaten(meineZutaten);
                        break;
                    }
                }
            } else{
                System.out.println("Nicht mehr als " + maxbelag + " Zutaten");
            }
        }
    }

    // Sauce oder Zutat aus der Pizza entfernen:
    private static void entferneZutat(String name){
        if(name.toLowerCase(Locale.ROOT).contains("sauce")){
            if(Objects.isNull(meinePizza.getSauce())){
                System.out.println("Es ist eh keine Sauce drauf.");
            } else{
                if(meinePizza.getSauce().getName().equals(name)){
                    System.out.println(meinePizza.getSauce().getName() + " entfernt.");
                    meinePizza.setSauce(null);
                } else{
                    System.out.println("Es ist " + meinePizza.getSauce().getName() + " drauf.");
                }
            }
        } else{
            if(meineZutaten.size() == 0){
                System.out.println("Es wurden bisher keine Zutaten ausgewählt.");
            } else{
                for(Belag belagBisher: meineZutaten){
                    if(belagBisher.getName().equals(name)){
                        System.out.println(belagBisher.getName() + " entfernt.");
                        meineZutaten.remove(belagBisher);
                        meinePizza.setZutaten(meineZutaten);
                        break;
                    }
                }
            }
        }
    }

    protected static double zahlen(ArrayList<Pizza> pizzaliste){
        double gesamtpreis = 0.0;
        for(Pizza pizza: pizzaliste){
            gesamtpreis += pizza.getPreis();
        }
        return gesamtpreis;
    }

    public static ArrayList<Pizza> getPizzen() {
        return pizzen;
    }

    public static Pizza getMeinePizza() {
        return meinePizza;
    }



}
