package de.karrieretutor.LydiaHolmPablo.Pizza;



public class Welcome {
    //private String selection;
    public static void main(String[] args) {

        /*
        Willkommensnachricht mit Menüübersicht und konsolenbasiertem Bestellsystem.
        Als Eingabe ist die Groß- und Kleinschreibung egal, ebenso wie die Anzahl der Leerzeichen.
        Auch die Nummern anstelle der Wörter sind als Eingabe möglich.
         */

        System.out.println("""
                 Willkommen in bei Luigis Pizza:
                +++++++++++ LUIGI'S PIZZA +++++++++++
                '1) ZUTATENLISTE' - Zeigt Ihnen die Liste aller Zutaten mit ihrer ID und ihrem Preis an
                '2) NEUE PIZZA' - Startet das Erstellen einer neuen Pizza.
                '3) ZUTAT <ID>' - Fügt die ausgewählte Zutat zur aktuellen Pizza hinzu.
                '4) FERTIG' - Vollendet die aktuelle Pizza und bringt sie in den Warenkorb.
                '5) BESTELLUNG INFO' - Zeigt den aktuellen Warenkorb an.
                '6) BESTELLEN' - Schickt die Bestellung ab.
                '7) ENDE' - Löscht aktuelle Zusammensetzung.
                +++++++++++ LUIGI'S PIZZA +++++++++++\s""");

        Bestellsystem bestellsystem = new Bestellsystem();
        bestellsystem.nutzeBestellsystem();

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
    }



}
