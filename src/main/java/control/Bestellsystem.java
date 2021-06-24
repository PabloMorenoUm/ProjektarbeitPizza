package control;

import model.*;

import java.util.*;

/**
 * Konsolenbasiertes Bestellsystem nach Vorlage der .docx-Datei in Form einer riesengroßen switch-case-Abfrage
 * gepackt in einer do-while-Schleife.
 */


public class Bestellsystem {

    /**
     * Konstruktor. Aufruf des konsolenbasierten Bestellsystems.
     */

    public Bestellsystem() {
        // Warenkorb:
        PizzenList pizzen = new PizzenList();
        // Einzelne Pizza:
        Pizza meinePizza = null;

        // Daten von allen Saucen:
        final AlleSaucen alleSaucen = new AlleSaucen();
        // Daten von allen Zutaten:
        final AlleZutaten alleZutaten = new AlleZutaten();

        // Konstante:
        final int zutatshift = 11;

        Scanner keyboard = new Scanner(System.in);
        String mystring;
        String belagname = "";

        // Bestellsystem als riesige do-while-Schleife mit switch-Ausdruck:
        do {
            System.out.print("Wähle aus: ");
            mystring = keyboard.nextLine().toLowerCase(Locale.ROOT).replaceAll("\\s", "");

            if (mystring.contains("zutat")) {
                try {
                    int nummer = Integer.parseInt(mystring.substring(5));
                    if (nummer > 0 && nummer <= alleSaucen.getListe().size()) {
                        belagname = alleSaucen.getListe().get(nummer - 1).getName();
                    } else if (nummer >= zutatshift &&
                            nummer < alleZutaten.getListe().size() + zutatshift) {
                        belagname = alleZutaten.getListe().get(nummer - zutatshift).getName();
                    } else {
                        System.out.println("Keine zulässige Nummer");
                    }
                    mystring = "zutat";
                } catch (Exception ignored) {
                }
            }

            switch (mystring) {
                case "zutatenliste":
                case "1":
                    System.out.println("-----------------------------");
                    System.out.println("Saucen:");
                    System.out.println(alleSaucen);
                    System.out.println("Zutaten:");
                    System.out.println(alleZutaten);
                    System.out.println("-----------------------------");
                    break;
                case "neuepizza":
                case "2":
                    System.out.println("Neue Pizza wird erstellt.");
                    meinePizza = new Pizza();
                    break;
                case "zutat":
                case "3":
                    if (Objects.isNull(meinePizza)) {
                        System.out.println("Erst eine neue Pizza auswählen!");
                        break;
                    } else {
                        System.out.println(meinePizza.belegen(belagname));
                    }
                    break;
                case "fertig":
                case "4":
                    if (Objects.isNull(meinePizza)) {
                        System.out.println("Erst eine neue Pizza auswählen!");
                    } else {
                        System.out.print("Wie soll die Pizza heißen? ");
                        String pizzaname = keyboard.nextLine();
                        meinePizza.setName(pizzaname);
                        pizzen.add(meinePizza);
                        System.out.println(meinePizza);
                        meinePizza = null;
                        System.out.println("'NEUE PIZZA' oder 'BESTELLEN'?");
                    }
                    break;
                case "bestellunginfo":
                case "5":
                    if (pizzen.size() > 0) {
                        System.out.println(pizzen);
                    } else {
                        System.out.println("Noch keine Pizza im Warenkorb.");
                    }
                    break;
                case "bestellen":
                case "6":
                    if (pizzen.size() > 0) {
                        System.out.print("Das kostet insgesamt ");
                        System.out.println(pizzen.zahlen());
                        System.out.println("Gehe auf 'Ende', um die Bestellung abzuschließen.");
                    } else {
                        System.out.println("Es ist noch keine Pizza im Warenkorb.");
                    }
                    break;
                case "ende":
                case "7":
                    System.out.println("Verlauf gelöscht!");
                    pizzen = new PizzenList();
                    break;
                case "q":
                case "8":
                    System.out.println("Programm wird beendet");
                    break;
                default:
                    System.out.println("Keine gültige Eingabe.");
            }
        } while (!mystring.equals("q"));
    }

}
