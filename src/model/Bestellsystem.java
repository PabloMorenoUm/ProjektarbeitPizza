package model;

import java.text.NumberFormat;
import java.util.*;

public class Bestellsystem {
    /*
    Konsolenbasiertes Bestellsystem nach Vorlage der .docx-Datei.
     */

    // Währungsformat:
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    // Warenkorb:
    private ArrayList<Pizza> pizzen = new ArrayList<>();
    // Einzelne Pizza:
    private Pizza meinePizza = new Pizza();
    // Zutaten für eine einzelne Pizza:
    private HashSet<Zutat> meineZutaten = new HashSet<>();

    // Daten von allen Saucen:
    private final AlleSaucen alleSaucen = new AlleSaucen();
    // Daten von allen Zutaten:
    private final AlleZutaten alleZutaten = new AlleZutaten();

    private int belagindex = -1;
    private int pizzaindex = -1;

    // Konstanten:
    private static final int zutatshift = 11;
    private static final int maxbelag = 8;

    public void nutzeBestellsystem() {
        Scanner keyboard = new Scanner(System.in);

        // Bestellsystem als riesige do-while-Schleife mit switch-Ausdruck:
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
                case "1":
                    System.out.println("-----------------------------");
                    System.out.println("Saucen:");
                    alleSaucen.print();
                    System.out.println(" ");
                    System.out.println("Zutaten:");
                    alleZutaten.print();
                    System.out.println("-----------------------------");
                    break;
                case "neuepizza":
                case "2":
                    System.out.println("Neue Pizza wird erstellt.");
                    meinePizza = new Pizza();
                    meineZutaten = new HashSet<>();
                    pizzaindex++;
                    break;
                case "zutat":
                case "3":
                    if(pizzaindex < 0){
                        System.out.println("Erst eine neue Pizza auswählen!");
                        break;
                    } else{
                        belegePizza(belagindex);
                    }
                    break;
                case "fertig":
                case "4":
                    if(pizzaindex >= 0){
                        if(meinePizza.getZutaten().size() > maxbelag){
                            System.out.println("Diese Pizza hat mehr als acht Zutaten!!! Das ist böse.");
                        } else {
                            System.out.print("Wie soll die Pizza heißen? ");
                            String pizzaname = keyboard.nextLine();
                            meinePizza.setName(pizzaname);
                            pizzen.add(meinePizza);
                            System.out.print(meinePizza.getName());
                            System.out.print(" kostet ");
                            System.out.println(currency.format(meinePizza.getPreis()));

                            initialisieren();

                            System.out.println("'NEUE PIZZA' oder 'BESTELLEN'?");
                        }

                    } else {
                        System.out.println("Erst 'NEUE PIZZA' auswählen!");
                    }
                    break;
                case "bestellunginfo":
                case "5":
                    if(pizzen.size() > 0){
                        for (Pizza pizza : pizzen) {
                            System.out.print(pizza.getName());
                            System.out.print(": ");
                            System.out.println(currency.format(pizza.getPreis()));
                        }
                    } else {
                        System.out.println("Noch keine Pizza im Warenkorb.");
                    }
                    break;
                case "bestellen":
                case "6":
                    if(pizzen.size() > 0){
                        System.out.print("Das kostet insgesamt ");
                        System.out.println(currency.format(zahlen(pizzen)));
                        System.out.println("Gehe auf 'Ende', um die Bestellung abzuschließen.");
                    } else {
                        System.out.println("Es ist noch keine Pizza im Warenkorb.");
                    }
                    break;
                case "ende":
                case "7":
                    System.out.println("Verlauf gelöscht!");

                    pizzen = new ArrayList<>();
                    initialisieren();
                    break;
                default:
                    System.out.println("Keine gültige Eingabe.");
            }
        } while (true);
    }

    private void initialisieren(){
        meinePizza = new Pizza();
        meineZutaten = new HashSet<>();
        belagindex = -1;
        pizzaindex = -1;
    }

    private void belegePizza(int nummer){
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
            if(meineZutaten.size() < maxbelag){
                belag = alleZutaten.getListe().get(nummer - zutatshift);
                if(meineZutaten.contains((Zutat) belag)){
                    System.out.println(belag.getName() + " ist schon drauf. Andere Zutat?");
                } else{
                    System.out.println(belag.getName() + " hinzugefügt");
                }
                meineZutaten.add((Zutat) belag);
                meinePizza.setZutaten(meineZutaten);
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
