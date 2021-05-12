package de.karrieretutor.LydiaHolmPablo.Pizza;

import java.text.NumberFormat;
import java.util.*;

public class MainPablo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

        ArrayList<Pizza> pizzen = new ArrayList<>();
        Pizza meinePizza = new Pizza();

        ArrayList<Zutat> meineZutaten = new ArrayList<>();
        Belag belag;

        AlleSaucen alleSaucen = new AlleSaucen();
        AlleZutaten alleZutaten = new AlleZutaten();

        int belagindex = -1;
        int count = -1;
        int pizzaindex = -1;

        int zutatshift = 11;
        int maxbelag = 8;

        String pizzaname;

        boolean dowhile = true;

        do {
            System.out.print("Wähle aus: ");
            String mystring = keyboard.nextLine().toLowerCase(Locale.ROOT).replaceAll("\\s", "");

            if(mystring.contains("zutat")){
                try {
                    belagindex = Integer.parseInt(mystring.substring(5));
                    mystring = "zutat";
                } catch (Exception myexception){
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
                    pizzaindex++;
                    count = 0;
                    break;
                case "zutat":
                    if(pizzaindex < 0){
                        System.out.println("Erst eine neue Pizza auswählen!");
                        break;
                    } else{
                        if(belagindex > 0 && belagindex <= alleSaucen.getListe().size()){
                            if(Objects.isNull(meinePizza.getSauce())){
                                belag = alleSaucen.getListe().get(belagindex - 1);
                                meinePizza.setSauce((Sauce) belag);
                                System.out.println(belag.getName() + " hinzugefügt");
                            } else{
                                System.out.println("Sauce ist schon vorhanden.");
                            }
                        } else if (belagindex >= zutatshift &&
                                belagindex < alleZutaten.getListe().size() + zutatshift) {
                            if(count <= maxbelag){
                                belag = alleZutaten.getListe().get(belagindex - zutatshift);
                                meineZutaten.add((Zutat) belag);
                                meinePizza.setZutaten(meineZutaten);
                                count++;
                                System.out.println(belag.getName() + " hinzugefügt");
                            } else{
                                System.out.println("Nicht mehr als " + maxbelag + " Zutaten");
                            }
                        } else {
                            System.out.println("Keine zulässige Nummer");
                        }
                    }
                    break;
                case "fertig":
                    if(pizzaindex >= 0){
                        System.out.print("Wie soll die Pizza heißen? ");
                        pizzaname = keyboard.nextLine();
                        meinePizza.setName(pizzaname);
                        pizzen.add(meinePizza);
                        System.out.print(meinePizza.getName());
                        System.out.print(" kostet ");
                        System.out.println(currency.format(meinePizza.getPreis()));

                        meinePizza = new Pizza();
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
                        double gesamtpreis = 0.0;
                        for(Pizza pizza: pizzen){
                            gesamtpreis += pizza.getPreis();
                        }
                        System.out.print("Das kostet insgesamt ");
                        System.out.println(currency.format(gesamtpreis));
                    } else {
                        System.out.println("Nichts bestellt? Dann beim nächsten Mal! :-)");
                    }
                    System.out.println("Gehe auf 'Ende', um die Bestellung abzuschließen.");
                    break;
                case "ende":
                    System.out.println("Verlauf gelöscht! Ciao!");

                    pizzen = new ArrayList<>();
                    belagindex = -1;
                    count = -1;
                    pizzaindex = -1;
                    dowhile = false;
                    break;
                default:
                    System.out.println("Keine gültige Eingabe.");
            }
        } while (dowhile);

        keyboard.close();
    }
}
