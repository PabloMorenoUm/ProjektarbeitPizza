package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Abwandlung einer Arraylist für den Warenkorb mit eigener Textausgabe und Preiskalkulation.
 */
public class PizzenList extends ArrayList<Pizza> {
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    /**
     * Überschreibung der Textausgabe derart, dass alle Pizzen samt Belägen untereinander aufgelistet sind.
     * @return String. Warenkorbbeschreibung
     */
    @Override
    public String toString() {
        StringBuilder gesamtString = new StringBuilder();
        for (Pizza pizza : this) {
            gesamtString
                    .append(pizza.toString())
                    .append("\n--------------------\n\n");
        }
        gesamtString
                .append("Gesamtpreis: ")
                .append(this.zahlen());
        return gesamtString.toString();
    }

    /**
     * Berechnung des Gesamtpreises (d.h. alle Pizzen zusammenaddiert) für den Warenkorb.
     * @return String. Preisangabe im Java-typischen Währungsformat umgewandelt.
     */
    public String zahlen() {
        double gesamtpreis = 0.0;
        for (Pizza pizza : this) {
            gesamtpreis += pizza.getPreis();
        }
        return currency.format(gesamtpreis);
    }
}
