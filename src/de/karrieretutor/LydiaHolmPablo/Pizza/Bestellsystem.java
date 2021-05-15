package de.karrieretutor.LydiaHolmPablo.Pizza;

import java.text.NumberFormat;
import java.util.*;

public class Bestellsystem {
    // Währungsformat:
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    // Warenkorb:
    private static ArrayList<Pizza> pizzen = new ArrayList<>();
    // Einzelne Pizza:
    private static Pizza meinePizza = new Pizza();
    // Zutaten für eine einzelne Pizza:
    private static ArrayList<Zutat> meineZutaten = new ArrayList<>();

    // Daten von allen Saucen:
    private static final AlleSaucen alleSaucen = new AlleSaucen();
    // Daten von allen Zutaten:
    private static final AlleZutaten alleZutaten = new AlleZutaten();

    private static int belagindex = -1;
    private static int anzahlBelaegeProPizza = -1;
    private static int pizzaindex = -1;

    // Konstanten:
    private static final int zutatshift = 11;
    private static final int maxbelag = 8;

    private Bestellsystem() {
    }

    public static void nutzeBestellsystem() {
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.print("Wähle aus: ");
            String mystring = keyboard.nextLine().toLowerCase(Locale.ROOT).replaceAll("\\s", "");

            if(mystring.contains("zutat")){
                try {
                    belagindex = Integer.parseInt(mystring.substring(5));
                    mystring = "zutat";
                } catch (Exception ignored){
                }
            }

            switch (mystring) {
                case "zutatenliste":
                    System.out.println("-----------------------------");
                    System.out.println("Saucen:");
                    alleSaucen.print();
                    System.out.println(" ");
                    System.out.println("Zutaten:");
                    alleZutaten.print();
                    System.out.println("-----------------------------");
                    break;
                case "neuepizza":
                    System.out.println("Neue Pizza wird erstellt.");
                    meinePizza = new Pizza();
                    meineZutaten = new ArrayList<>();
                    pizzaindex++;
                    anzahlBelaegeProPizza = 0;
                    break;
                case "zutat":
                    if(pizzaindex < 0){
                        System.out.println("Erst eine neue Pizza auswählen!");
                        break;
                    } else{
                        belegePizza(belagindex);
                    }
                    break;
                case "fertig":
                    if(pizzaindex >= 0){
                        System.out.print("Wie soll die Pizza heißen? ");
                        String pizzaname = keyboard.nextLine();
                        meinePizza.setName(pizzaname);
                        pizzen.add(meinePizza);
                        System.out.print(meinePizza.getName());
                        System.out.print(" kostet ");
                        System.out.println(currency.format(meinePizza.getPreis()));

                        initialisieren();

                        System.out.println("'Neue Pizza' oder 'Bestellen'?");
                    } else {
                        System.out.println("Erst 'Neue Pizza' auswählen!");
                    }
                    break;
                case "bestellunginfo":
                    if(pizzen.size() > 0){
                        for (Pizza pizza : pizzen) {
                            System.out.print(pizza.getName());
                            System.out.print(": ");
                            System.out.println(currency.format(pizza.getPreis()));
                        }
                    } else {
                        System.out.println("Noch keine Pizza im Warenkorb. 'Fertig' bringt die Pizza in den Warenkorb");
                    }
                    break;
                case "bestellen":
                    if(pizzen.size() > 0){
                        System.out.print("Das kostet insgesamt ");
                        System.out.println(currency.format(zahlen(pizzen)));
                    } else {
                        System.out.println("Nichts bestellt? Dann beim nächsten Mal! :-)");
                    }
                    System.out.println("Gehe auf 'Ende', um die Bestellung abzuschließen.");
                    break;
                case "ende":
                    System.out.println("Verlauf gelöscht!");

                    pizzen = new ArrayList<>();
                    initialisieren();
                    break;
                default:
                    System.out.println("Keine gültige Eingabe.");
            }
        } while (true);
    }

    private static void initialisieren(){
        meinePizza = new Pizza();
        meineZutaten = new ArrayList<>();
        belagindex = -1;
        anzahlBelaegeProPizza = -1;
        pizzaindex = -1;
    }

    private static void belegePizza(int nummer){
        Belag belag;

        if(nummer > 0 && nummer <= alleSaucen.getListe().size()){
            if(Objects.isNull(meinePizza.getSauce())){
                belag = alleSaucen.getListe().get(nummer - 1);
                meinePizza.setSauce((Sauce) belag);
                System.out.println(belag.getName() + " hinzugefügt");
            } else{
                System.out.println("Sauce ist schon vorhanden.");
            }
        } else if (nummer >= zutatshift &&
                nummer < alleZutaten.getListe().size() + zutatshift) {
            if(anzahlBelaegeProPizza <= maxbelag){
                belag = alleZutaten.getListe().get(nummer - zutatshift);
                meineZutaten.add((Zutat) belag);
                meinePizza.setZutaten(meineZutaten);
                anzahlBelaegeProPizza++;
                System.out.println(belag.getName() + " hinzugefügt");
            } else{
                System.out.println("Nicht mehr als " + maxbelag + " Zutaten");
            }
        } else {
            System.out.println("Keine zulässige Nummer");
        }
    }

    protected static double zahlen(ArrayList<Pizza> pizzaliste){
        double gesamtpreis = 0.0;
        for(Pizza pizza: pizzaliste){
            gesamtpreis += pizza.getPreis();
        }
        return gesamtpreis;
    }
}
