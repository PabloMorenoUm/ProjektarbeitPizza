package de.karrieretutor.LydiaHolmPablo.Pizza;

public class Belag {
    /*
    Elternklasse für die Klassen "Sauce" und "Zutat".
    Setter sind nicht nötig, weil Attributzuweisungen durch den Konstruktor erzwungen werden.
     */
    private final int id;
    private final String name;
    private final double preis;

    public Belag(int id, String name, double preis) {
        this.id = id;
        this.name = name;
        this.preis = preis;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

}
