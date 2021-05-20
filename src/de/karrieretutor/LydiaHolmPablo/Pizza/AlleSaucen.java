package de.karrieretutor.LydiaHolmPablo.Pizza;

public class AlleSaucen extends AlleBelaege {
    // Daten aller Saucen (werden als "Belag" abgespeichert!!!):
    public AlleSaucen() {
        super.liste.add(new Sauce(1, "Tomatensauce", 0.0));
        super.liste.add(new Sauce(2, "BBQ-Sauce", 0.0));
    }
}
