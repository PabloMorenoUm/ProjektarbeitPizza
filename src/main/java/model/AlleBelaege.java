package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


/**
 * Elternklasse für die Saucen- und Zutatenliste.
 * Sinn dahinter sind die Methoden getListe() und toString(),
 * die ich nicht für jede Kindklasse einzeln implementieren wollte.
 */
public class AlleBelaege {

    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    protected ArrayList<Belag> liste = new ArrayList<>();

    /**
     * Getter-Methode. Gibt den Datensatz als ArrayList zurück.
     * @return ArrayList. Liste der vorhandenen Saucen/Zutaten.
     */
    public ArrayList<Belag> getListe() {
        return liste;
    }

    /**
     * Alle Beläge sollen zeilenweise ausgegeben werden.
     * @return String. Liste mit allen Saucen bzw. Zutaten
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Belag element : liste) {
            stringBuilder.append(element.getId());
            stringBuilder.append(" ");
            stringBuilder.append(element.getName());
            stringBuilder.append(" ");
            stringBuilder.append(currency.format(element.getPreis()));
            stringBuilder.append("\r\n");
        }
        return stringBuilder.toString();
    }
}
