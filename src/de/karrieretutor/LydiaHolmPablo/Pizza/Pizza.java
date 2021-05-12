package de.karrieretutor.LydiaHolmPablo.Pizza;

import java.util.ArrayList;

public class Pizza {
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
}
