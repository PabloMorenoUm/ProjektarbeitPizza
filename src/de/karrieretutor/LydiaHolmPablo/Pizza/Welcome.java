package de.karrieretutor.LydiaHolmPablo.Pizza;

<<<<<<< HEAD
import java.util.Scanner;

public class Welcome() {
=======


public class Welcome {
    //private String selection;
>>>>>>> origin/master
    public static void main(String[] args) {



<<<<<<< HEAD

    System.out.println(" Willkommen in bei Luigis Pizza:\n" +
            "+++++++++++ LUIGI'S PIZZA +++++++++++\n" +
            "'1) ZUTATENLISTE' - Zeigt Inen die Liste aller Zutaten mit ihrer ID und ihrem Preis an\n" +
            "'2) NEUE PIZZA' - Startet das erstellen einer neuen Pizza.\n" +
            "'3) ZUTAT <ID>' - Fügt die ausgewählte Zutat zur aktuellen Pizza hinzu.\n" +
            "'4) FERTIG' - Vollendet die aktuelle Pizza.\n" +
            "'5) BESTELLUNG INFO' - Zeigt den aktuellen Warenkorb an.\n" +
            "'6) BESTELLEN' - Schickt die Bestellung ab.\n" +
            "+++++++++++ LUIGI'S PIZZA +++++++++++ ");
    do    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Geben Sie Ihre Auswahl ein: ");
        String sc = scan.next();
        String selection = sc.next().toLowerCase();


        switch (selection)
        {
            case "1":
                System.out.println("Zutaten gewählt.");
                Bestellsystem();
                break;
            case "2":
                System.out.println("Neue Pizza erstellen:");
                Zutat();
                break;
            case "3":
                System.out.println("Zutat wählen:");
                Zutat();
                break;
            case "4":
                System.out.println("Pizza wird fertig gestellt.");
                Zutat();
                break;
            case "5":
                System.out.println("Bestellung ensehen");
                Zutat();
                break;
            case "6":
                System.out.println("Bestellung absenden.");
                Zutat();
                break;

        }
        while (true) ;
=======
        System.out.println("""
                 Willkommen in bei Luigis Pizza:
                +++++++++++ LUIGI'S PIZZA +++++++++++
                '1) ZUTATENLISTE' - Zeigt Inen die Liste aller Zutaten mit ihrer ID und ihrem Preis an
                '2) NEUE PIZZA' - Startet das erstellen einer neuen Pizza.
                '3) ZUTAT <ID>' - Fügt die ausgewählte Zutat zur aktuellen Pizza hinzu.
                '4) FERTIG' - Vollendet die aktuelle Pizza.
                '5) BESTELLUNG INFO' - Zeigt den aktuellen Warenkorb an.
                '6) BESTELLEN' - Schickt die Bestellung ab.
                '7) ENDE' - Löscht aktuelle Zusammensetzung.
                +++++++++++ LUIGI'S PIZZA +++++++++++\s""");

        Bestellsystem.nutzeBestellsystem();

        /*

        do {
            Scanner scan = new Scanner(System.in);
            System.out.print("Ihre Auswahl bitte: ");
            String selection = scan.next().toLowerCase();


            switch (selection) {
                case "1":
                case "zutatenliste" :
                    System.out.println("Zutaten gewählt.");
                    Bestellsystem();
                    break;
                case "2":
                case "neue pizza":
                    System.out.println("Neue Pizza erstellen:");
                    Zutat();
                    break;
                case "3":
                case "zutat":
                    System.out.println("Zutat wählen:");
                    Zutat();
                    break;
                case "4":
                case "fertig":
                    System.out.println("Pizza wird fertig gestellt.");
                    Zutat();
                    break;
                case "5":
                case "bestellung":
                    System.out.println("Bestellung ensehen");
                    Zutat();
                    break;
                case "6":
                case "bestellung":
                    System.out.println("Bestellung absenden.");
                    Zutat();
                    break;

            }
            while (true) ;
        }
        */
>>>>>>> origin/master
    }



}
