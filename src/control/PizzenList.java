package control;

import de.karrieretutor.LydiaHolmPablo.Pizza.Pizza;
import de.karrieretutor.LydiaHolmPablo.Pizza.Zutat;

import javax.swing.*;
import java.util.ArrayList;

public class PizzenList extends ArrayList {

    @Override
    public String toString(){
        double gesamtPreis = 0.0;
        String gesamtString = "";
        for (int i = 0; i < this.size(); i++){
            Pizza pizza =  (Pizza) this.get(i);
            String pizzaString = pizza.toString();
            gesamtPreis = gesamtPreis + pizza.getPreis();
            gesamtString = gesamtString + "\r\n" + pizzaString  + "\n" + "-------------------- \n" + "Preis:" + String.valueOf(pizza.getPreis()) + "\n" + "-------------------- \n";
        }
        gesamtString = gesamtString + " Gesamtpreis: " + String.valueOf(gesamtPreis);
        return gesamtString;
    }

}