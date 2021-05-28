package control;

import de.karrieretutor.LydiaHolmPablo.Pizza.Pizza;

import java.util.ArrayList;

public class Existenzebene {
    private int pizzaindex = -1;
    private int pizzaNummer = 0;

    private ArrayList<Pizza> arbeitsPizzenliste = new ArrayList<>();
    private Pizza arbeitsPizza;

    private ArrayList<Pizza> allePizzenliste = new ArrayList<>();

    public Existenzebene(ArrayList<Pizza> arbeitsPizzenliste) {
        if (arbeitsPizzenliste != null) {
            this.arbeitsPizzenliste = arbeitsPizzenliste;
        } else {
            this.arbeitsPizzenliste = new ArrayList<Pizza>();
        }
    }

    public Existenzebene(ArrayList<Pizza> arbeitsPizzenliste, Pizza arbeitsPizza, ArrayList<Pizza> allePizzenliste) {
        this.arbeitsPizzenliste = arbeitsPizzenliste;
        this.arbeitsPizza = arbeitsPizza;
        this.allePizzenliste = allePizzenliste;
    }

    public void addPizza(Pizza currentPizza) {
        arbeitsPizzenliste.add(currentPizza);
    }

    public ArrayList<Pizza> getArbeitsPizzenliste() {
        return arbeitsPizzenliste;
    }

    public void setArbeitsPizzenliste(ArrayList<Pizza> arbeitsPizzenliste) {
        this.arbeitsPizzenliste = arbeitsPizzenliste;
    }

    public Pizza getArbeitsPizza() {
        return arbeitsPizza;
    }

    public void setArbeitsPizza(Pizza arbeitsPizza) {
        this.arbeitsPizza = arbeitsPizza;
    }

    public ArrayList<Pizza> getAllePizzenliste() {
        return allePizzenliste;
    }

    public void setAllePizzenliste(ArrayList<Pizza> allePizzenliste) {
        this.allePizzenliste = allePizzenliste;
    }

    public int getPizzaindex() {
        return pizzaindex;
    }

    public void setPizzaindex(int pizzaindex) {
        this.pizzaindex = pizzaindex;
    }

    public int getPizzaNummer() {
        return pizzaNummer;
    }

    public void setPizzaNummer(int pizzaNummer) {
        this.pizzaNummer = pizzaNummer;
    }

    @Override
    public String toString() {
        return "Existenzebene{" +
                "arbeitsPizzenliste=" + arbeitsPizzenliste +
                ", arbeitsPizza=" + arbeitsPizza +
                ", pizzenliste=" + allePizzenliste +
                '}';
    }
}
