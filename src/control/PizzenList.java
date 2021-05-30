package control;

import model.Pizza;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class PizzenList<T> extends ArrayList<T> {
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    @Override
    public String toString(){
        double gesamtPreis = 0.0;
        StringBuilder gesamtString = new StringBuilder();
        for (Object o : this) {
            Pizza pizza = (Pizza) o;
            String pizzaString = pizza.toString();
            gesamtPreis = gesamtPreis + pizza.getPreis();
            gesamtString.append("\r\n").append(pizzaString).append("\n").append("-------------------- \n").append("Preis:").append(currency.format(pizza.getPreis())).append("\n").append("-------------------- \n");
        }
        gesamtString.append(" Gesamtpreis: ").append(currency.format(gesamtPreis));
        return gesamtString.toString();
    }

}
