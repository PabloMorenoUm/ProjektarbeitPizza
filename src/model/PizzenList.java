package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class PizzenList extends ArrayList<Pizza> {
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    @Override
    public String toString() {
        StringBuilder gesamtString = new StringBuilder();
        for (Pizza pizza : this) {
            gesamtString
                    .append(pizza.toString())
                    .append("\n--------------------\n");
        }
        gesamtString
                .append("Gesamtpreis: ")
                .append(this.zahlen());
        return gesamtString.toString();
    }

    public String zahlen() {
        double gesamtpreis = 0.0;
        for (Pizza pizza : this) {
            gesamtpreis += pizza.getPreis();
        }
        return currency.format(gesamtpreis);
    }
}
