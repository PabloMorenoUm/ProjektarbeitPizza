package de.karrieretutor.LydiaHolmPablo.Pizza;

public class Main {

    public static void main(String[] args) {
        new GUI();
        Bestellsystem bestellsystem = Bestellsystem.getInstance();
        bestellsystem.nutzeBestellsystem();
    }
}
