package control;

/**
 * Klasse mit dem Hauptprogramm, die die Konsolenanwendung ausführt.
 */
public class MainKonsole {
    /**
     * main-Funktion. Führt die konsolenbasierte Applikation aus.
     * Am Anfang steht eine Willkommensnachricht mit Menüübersicht und konsolenbasiertem Bestellsystem.
     * Als Eingabe ist die Groß- und Kleinschreibung egal ebenso wie die Anzahl der Leerzeichen.
     * Auch die Nummern anstelle der Wörter sind als Eingabe möglich.
     * @param args String[]. Argumente - können hier ignoriert werden.
     */
    public static void main(String[] args) {

        System.out.println("""
                 Willkommen in bei Luigis Pizza:
                +++++++++++ LUIGI'S PIZZA +++++++++++
                '1) ZUTATENLISTE' - Zeigt Ihnen die Liste aller Zutaten mit ihrer ID und ihrem Preis an.
                '2) NEUE PIZZA' - Startet das Erstellen einer neuen Pizza.
                '3) ZUTAT <ID>' - Fügt die ausgewählte Zutat zur aktuellen Pizza hinzu.
                '4) FERTIG' - Vollendet die aktuelle Pizza und bringt sie in den Warenkorb.
                '5) BESTELLUNG INFO' - Zeigt den aktuellen Warenkorb an.
                '6) BESTELLEN' - Schickt die Bestellung ab.
                '7) ENDE' - Löscht aktuelle Zusammensetzung.
                '8) Q' - Beendet das Programm.
                +++++++++++ LUIGI'S PIZZA +++++++++++\s""");

        new Bestellsystem();
    }
}
