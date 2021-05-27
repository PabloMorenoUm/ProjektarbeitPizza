package model;

import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;

public class Pizza {
    /*
    Pizzaklasse. Zutaten bitte niemals über pizza.getZutaten().add(), sondern über setZutaten() hinzufügen!
     */
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    private String name = "unbenannt";
    private double preis = 4.99;
    private Sauce sauce;
    private HashSet<Zutat> zutaten = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public HashSet<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(HashSet<Zutat> zutaten) {
        this.zutaten = zutaten;
        for(Zutat zutat: zutaten){
            this.preis += zutat.getPreis();
        }
    }

    public String toString(){
        StringBuilder gesamtString = new StringBuilder();
        // Name der Pizza
        gesamtString.append(name).append(" \r\n");

        // Füge zuerst die Sauce hinzu
        if (sauce != null){
            gesamtString.append(sauce.getName()).append(" ").append(currency.format(sauce.getPreis()));
            //gesamtString = String.format("%s%n%s", gesamtString, sauce.getName());
        }
        // Füge nun die Zutaten dazu
        for (int i = 0; i < zutaten.size(); i++){
            Zutat zutat =  (Zutat) zutaten.toArray()[i];
            String zutatenName = zutat.getName();
            //gesamtString = String.format("%s%n%s", gesamtString, zutat.getName());
            gesamtString.append(" \r\n ").append(zutatenName).append(" ").append(currency.format(zutat.getPreis()));
        }
        return gesamtString.toString();
    }
}
