package model;

/**
 * Bauplan einer Pizzazutat. Darunter zählen KEINE Saucen!
 */
public class Zutat extends Belag {
    /**
     * Konstruktor. Instanziert eine Zutat, der durch folgende Attribute definiert ist:
     * @param id int. id-Nummer des jeweiligen Belags.
     * @param name String. Name des jeweiligen Belags.
     * @param preis double. Preis des jeweiligen Belags.
     */
    public Zutat(int id, String name, double preis) {
        super(id, name, preis);
    }


}
