package de.karrieretutor.LydiaHolmPablo.Pizza;

import java.util.ArrayList;

public class Pizza {
    /*
    Pizzaklasse. Zutaten bitte niemals über pizza.getZutaten().add(), sondern über setZutaten() hinzufügen!
     */
    private String name = "unbenannt";
    private double preis = 4.99;
    private Sauce sauce;
    private ArrayList<Zutat> zutaten = new ArrayList<>();

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

    public ArrayList<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(ArrayList<Zutat> zutaten) {
        this.zutaten = zutaten;
        for(Zutat zutat: zutaten){
            this.preis += zutat.getPreis();
        }
    }

    public String toString(){

        String gesamtString = "";
        // Füge zuerst die Sauce hinzu
        if (sauce != null){
            gesamtString = gesamtString + sauce.getName();
        }
        // Füge nun die Zutaten dazu
        for (int i = 0; i < zutaten.size(); i++){
            Zutat zutat =  (Zutat) zutaten.get(i);
            String zutatenName = zutat.getName();
            gesamtString = gesamtString + "\n"
                    + zutatenName;
        }
        return gesamtString;
    }
}
