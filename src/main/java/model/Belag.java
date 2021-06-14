package model;

/**
 * Elternklasse für die Klassen "Sauce" und "Zutat". Selber wird diese Klasse nie verwendet.
 * (Setter sind nicht nötig, weil Attributzuweisungen durch den Konstruktor erzwungen werden.)
 */
public class Belag {
    private final int id;
    private final String name;
    private final double preis;

    /**
     * Konstruktor. Instanziert einen Belag (Sauce oder Zutat), der durch folgende Attribute definiert ist:
     * @param id int. id-Nummer des jeweiligen Belags.
     * @param name String. Name des jeweiligen Belags.
     * @param preis double. Preis des jeweiligen Belags.
     */
    public Belag(int id, String name, double preis) {
        this.id = id;
        this.name = name;
        this.preis = preis;
    }

    /**
     * Getter-Methode.
     * @return int. id-Nummer des Belags.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter-Methode.
     * @return String. Name des Belags.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter-Methode.
     * @return double. Preis des Belags.
     */
    public double getPreis() {
        return preis;
    }
}
