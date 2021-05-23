package control;

import de.karrieretutor.LydiaHolmPablo.Pizza.Pizza;
import de.karrieretutor.LydiaHolmPablo.Pizza.Zutat;

import javax.swing.*;
import java.util.ArrayList;

public class PizzenList extends ArrayList {

    @Override
    public String toString(){
        String gesamtString = "";
        for (int i = 0; i < this.size(); i++){
            Pizza pizza =  (Pizza) this.get(i);
            String pizzaString = pizza.toString();
            gesamtString = gesamtString + "\r\n" + pizzaString;
        }
        return gesamtString;
    }

}
