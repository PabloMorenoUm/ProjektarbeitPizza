package model;

/**
 * Bauplan einer Pizzasauce.
 */
public class Sauce extends Belag {
    /**
     * Konstruktor. Instanziert eine Sauce, der durch folgende Attribute definiert ist:
     * @param id int. id-Nummer des jeweiligen Belags.
     * @param name String. Name des jeweiligen Belags.
     * @param preis double. Preis des jeweiligen Belags.
     */
    public Sauce(int id, String name, double preis) {
        super(id, name, preis);
    }
}
