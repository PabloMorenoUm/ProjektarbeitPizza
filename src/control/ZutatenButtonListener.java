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

    private Existenzebene existenzebene;

    private String zutatenName;

    //private ZutatenPanel panel;

    // Währungsformat:
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    // Warenkorb:
    //private ArrayList<Pizza> pizzen = new PizzenList();
    //private ArrayList<Pizza> arbeitsPizzenListe = new ArrayList<>();
    // Einzelne Pizza:
    private Pizza meinePizza;
    // Zutaten für eine einzelne Pizza:
    private HashSet<Zutat> meineZutaten = new HashSet<>();

    // Daten von allen Saucen:
    //private static final AlleSaucen alleSaucen = new AlleSaucen();
    // Daten von allen Zutaten:
    //private static final AlleZutaten alleZutaten = new AlleZutaten();
    /*
    Index für eine Pizza im jeweiligen Bestellvorgang.
    Eigentlich ist nur entscheidend, ob dieser Index negativ ist oder nicht.
    Ein negativer Index bedeutet, dass es noch keine Pizza im Warenkorb gibt.
     */

    //private int pizzaindex = -1;
    //private int pizzaNummer = 0;

    // Konstanten:
    private static final int maxbelag = 8;

    public ZutatenButtonListener(Existenzebene existenzebene) {
        this.existenzebene = existenzebene;
    }

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
            case "+" :
                if(existenzebene.getPizzaindex() < 0){
                    System.out.println("Erst eine neue Pizza auswählen!");
                    System.out.println(existenzebene.getPizzaNummer());
                    break;
                }
                else {
                JButton button = (JButton) e.getSource();
                ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
                zutatenName = zutatenPanel.getZutatenName();

                existenzebene.getArbeitsPizza().belegen(zutatenName);

                //meinePizza = arbeitsPizzenListe.get(pizzaNummer);
                //belegePizza(zutatenName);
                //meinePizza.belegen(zutatenName);

                CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                //centerpanel.getCurrentPizzaTextArea().setText(meinePizza.toString() + "\n" + "-------------------- \n" + "Preis:" + String.valueOf(meinePizza.getPreis()));
                centerpanel.getCurrentPizzaTextArea().setText(existenzebene.toString());
                break;
                }

            case "-" :
                if(existenzebene.getPizzaindex() < 0){
                    System.out.println("Erst eine neue Pizza auswählen!");
                    break;
                }
                else {
                    JButton button = (JButton) e.getSource();
                    ZutatenPanel zutatenPanel = (ZutatenPanel) button.getParent();
                    zutatenName = zutatenPanel.getZutatenName();

                    entferneZutat(zutatenName);
                    CenterPanel centerpanel = (CenterPanel) zutatenPanel.getParent();
                    centerpanel.getCurrentPizzaTextArea().setText(existenzebene.toString());
                    break;
                }


            case "Neue Pizza":
                System.out.println("Neue Pizza wird erstellt.");
                // Diese Pizza lebt nicht lange  :(
                meinePizza = new Pizza();

                //meineZutaten = new HashSet<>();
                int pizzaindex = existenzebene.getPizzaindex();
                pizzaindex++;
                existenzebene.setPizzaindex(pizzaindex);

                int pizzaNummer = existenzebene.getPizzaNummer();
                pizzaNummer++;
                existenzebene.setPizzaNummer(pizzaNummer);
                //pizzaNummer+=1;
                meinePizza.setName("Pizza " + String.valueOf(pizzaNummer));

                existenzebene.setArbeitsPizza(meinePizza);
                //existenzebene.getArbeitsPizzenliste().add(meinePizza);


                JButton button = (JButton) e.getSource();
                CenterPanel centerpanel = (CenterPanel) button.getParent();
                centerpanel.getCurrentPizzaTextArea().setText(existenzebene.getArbeitsPizza().getName());
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
                if(existenzebene.getPizzaindex() >= 0){
                    if(existenzebene.getArbeitsPizza().getZutaten().size() > maxbelag){
                        System.out.println("Diese Pizza hat mehr als acht Zutaten!!!");
                    } else {
                        /*System.out.print("Wie soll die Pizza heißen? ");
                        String pizzaname = keyboard.nextLine();
                        meinePizza.setName(pizzaname);*/
                        //meinePizza.setName("Pizza " + String.valueOf(pizzaindex + 1));
                        existenzebene.getAllePizzenliste().add(existenzebene.getArbeitsPizza());
                        System.out.print(existenzebene.getArbeitsPizza().getName());
                        System.out.print(" kostet ");
                        //System.out.println(currency.format(meinePizza.getPreis()));

                        JButton abschlussButton = (JButton) e.getSource();
                        BottomPanel panel = (BottomPanel) abschlussButton.getParent();
                        //JFrame frame = (JFrame)  panel.getParent();
                        //panel.getCurrentStatus().setText(pizzen.toString());

                        panel.getCurrentStatusTextArea().setText(existenzebene.toString() );

                        // Static ? sinnvoll?
                        //initialisieren();
                        System.out.println("'Neue Pizza' oder 'Bestellung abschicken'?");
                    }

                } else {
                    System.out.println("Erst 'Neue Pizza' auswählen!");
                }
                break;
            case "Bestellung Info":
                if(existenzebene.getAllePizzenliste().size() > 0){
                    for (Pizza pizza : existenzebene.getAllePizzenliste()) {
                        System.out.print(pizza.getName());
                        System.out.print(": ");
                        System.out.println(currency.format(pizza.getPreis()));
                    }
                } else {
                    System.out.println("Noch keine Pizza im Warenkorb. 'Pizza abschließen' bringt die Pizza in den Warenkorb");
                }
                break;
            case "Bestellung abschicken":
                if(existenzebene.getAllePizzenliste().size() > 0){
                    System.out.print("Das kostet insgesamt ");
                    System.out.println(currency.format(zahlen(existenzebene.getAllePizzenliste())));
                    // Evtl exportieren in Datei ???
                } else {
                    System.out.println("Nichts bestellt? Dann beim nächsten Mal! :-)");
                }
                System.out.println("Gehe auf 'Warenkorb löschen', um die Bestellung abzuschließen.");

                break;
            case "Warenkorb löschen":
                System.out.println("Verlauf gelöscht!");

                existenzebene.setAllePizzenliste(new ArrayList<>());
                //initialisieren();
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
    private void initialisieren(){
        //meinePizza = new Pizza();
        meineZutaten = new HashSet<>();
        int pizzaindex = existenzebene.getPizzaindex();
        pizzaindex = -1;
        existenzebene.setPizzaindex(pizzaindex);
        existenzebene.setArbeitsPizza(new Pizza());
        //pizzaindex = -1;
    }

    /*// Sauce oder Zutat auf die Pizza setzen:
    private void belegePizza(String name){
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
    }*/


    // Sauce oder Zutat aus der Pizza entfernen:
    private void entferneZutat(String name){
        if(name.toLowerCase(Locale.ROOT).contains("sauce")){
            if(Objects.isNull(existenzebene.getArbeitsPizza().getSauce())){
                System.out.println("Es ist eh keine Sauce drauf.");
            } else{
                if(existenzebene.getArbeitsPizza().getSauce().getName().equals(name)){
                    System.out.println(existenzebene.getArbeitsPizza().getSauce().getName() + " entfernt.");
                    existenzebene.getArbeitsPizza().setSauce(null);
                } else{
                    System.out.println("Es ist " + existenzebene.getArbeitsPizza().getSauce().getName() + " drauf.");
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
                        existenzebene.getArbeitsPizza().setZutaten(meineZutaten);
                        break;
                    }
                }
            }
        }
    }

    protected double zahlen(ArrayList<Pizza> pizzaliste){
        double gesamtpreis = 0.0;
        for(Pizza pizza: pizzaliste){
            gesamtpreis += pizza.getPreis();
        }
        return gesamtpreis;
    }


 /*   public ArrayList<Pizza> getPizzen() {
        return pizzen;
    }

    public Pizza getMeinePizza() {
        return meinePizza;
    }*/

}
