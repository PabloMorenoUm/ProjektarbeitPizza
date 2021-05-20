package de.karrieretutor.LydiaHolmPablo.Pizza;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AlleBelaege {
    /*
    Elternklasse für die Saucen- und Zutatenliste.
    Sinn dahinter sind die Methoden getListe() und print(),
    die ich nicht für jede Kindklasse einzeln implementieren wollte.
     */
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    protected ArrayList<Belag> liste = new ArrayList<>();

    public ArrayList<Belag> getListe() {
        return liste;
    }

    public void print(){
        for(Belag element: liste){
            System.out.print(element.getId());
            System.out.print(" ");
            System.out.print(element.getName());
            System.out.print(" ");
            System.out.println(currency.format(element.getPreis()));
        }
    }
}
