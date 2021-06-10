package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Pizzaklasse. Zutaten bitte niemals über pizza.getZutaten().add(), sondern über setZutaten() hinzufügen!
 */
public class Pizza {
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    private final double pizzapreis = 4.99;
    private String name = "";
    private double preis = pizzapreis;
    private Sauce sauce;
    private ArrayList<Zutat> zutaten = new ArrayList<>();
    private static final int maxZutat = 8;

    // Daten von allen Saucen:
    private static final AlleSaucen alleSaucen = new AlleSaucen();
    // Daten von allen Zutaten:
    private static final AlleZutaten alleZutaten = new AlleZutaten();

    /**
     * Statische Getter-Methode.
     *
     * @return int. Maximale Anzahl an Zutaten auf der Pizza.
     */
    public static int getMaxZutat() {
        return maxZutat;
    }

    /**
     * Getter-Methode.
     *
     * @return String. Name der Pizza.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter-Methode.
     *
     * @param name String. Name der Pizza.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter-Methode.
     *
     * @return double. Preis der Pizza.
     */
    public double getPreis() {
        return preis;
    }

    /**
     * Getter-Methode.
     *
     * @return Sauce. Sauce der Pizza. (Es gibt ja nur eine.)
     */
    public Sauce getSauce() {
        return sauce;
    }

    /**
     * Setter-Methode.
     *
     * @param sauce Sauce. Sauce der Pizza. (Es gibt ja nur eine.)
     */
    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    /**
     * Getter-Methode.
     *
     * @return ArrayList. Alle Zutaten dieser Pizza.
     */
    public ArrayList<Zutat> getZutaten() {
        return zutaten;
    }

    /**
     * Setter-Methode.
     * @param zutaten ArrayList. Alle Zutaten dieser Pizza.
     */
    public void setZutaten(ArrayList<Zutat> zutaten) {
        this.zutaten = zutaten;
    }

    /**
     * Erweiterte Setter-Methode. Hierbei wird der Preis aktualisiert, indem der Preis jeder aufgelisteten Zutat
     * auf den Grundpreis der Pizza addiert wird
     *
     * @param meineZutaten ArrayList. liste aller Zutaten, die auf die Pizza kommen.
     */
    public void updateZutaten(ArrayList<Zutat> meineZutaten) {
        setZutaten(meineZutaten);
        this.preis = pizzapreis;
        for (Zutat zutat : meineZutaten) {
            this.preis += zutat.getPreis();
        }
    }

    /**
     * Auflistung, womit die Pizza belegt ist samt Preisübersicht.
     *
     * @return String. Textanzeige
     */
    public String toString() {
        StringBuilder gesamtString = new StringBuilder();
        // Name der Pizza
        gesamtString
                .append(name)
                .append("\r\n");
        gesamtString
                .append(" Grundpreis ")
                .append(currency.format(pizzapreis));

        // Füge zuerst die Sauce hinzu
        if (sauce != null) {
            gesamtString
                    .append("\r\n ")
                    .append(sauce.getName())
                    .append(" ")
                    .append(currency.format(sauce.getPreis()));
            //gesamtString = String.format("%s%n%s", gesamtString, sauce.getName());
        }
        // Füge nun die Zutaten dazu
        for (Zutat zutat : zutaten) {
            String zutatenName = zutat.getName();
            //gesamtString = String.format("%s%n%s", gesamtString, zutat.getName());
            gesamtString
                    .append("\r\n ")
                    .append(zutatenName)
                    .append(" ")
                    .append(currency.format(zutat.getPreis()));
        }
        gesamtString
                .append("\r\n--------------------\r\nPreis: ")
                .append(currency.format(preis));
        return gesamtString.toString();
    }

    /**
     * Füge Belag (egal ob Sauce oder Zutat) auf die Pizza hinzu.
     *
     * @param zutatenName String. Name der Sauce oder der Zutat.
     * @return String. Information, ob das Belegen geklappt hat und, wenn nein, warum nicht.
     */
    public String belegen(String zutatenName) {
        if (zutatenName.toLowerCase(Locale.ROOT).contains("sauce")) {
            if (Objects.isNull(sauce)) {
                this.setSauce(
                        (Sauce) alleSaucen
                                .getListe()
                                .stream()
                                .filter(s -> s.getName().equals(zutatenName))
                                .collect(Collectors.toList())
                                .get(0)
                );
                return zutatenName + " hinzugefügt";
            } else {
                return "Sauce ist schon vorhanden.";
            }
        } else {
            if (zutaten.size() < maxZutat) {
                Zutat zutat = (Zutat) alleZutaten
                        .getListe()
                        .stream()
                        .filter(z -> z.getName().equals(zutatenName))
                        .collect(Collectors.toList())
                        .get(0);
                if (zutaten.contains(zutat)) {
                    return zutat.getName() + " ist schon auf der Pizza. Andere Zutat?";
                } else {
                    zutaten.add(zutat);
                    updateZutaten(zutaten);
                    return zutat.getName() + " hinzugefügt";
                }
            } else {
                return "Nicht mehr als " + maxZutat + " Zutaten";
            }
        }
    }

    /**
     * Entferne eine Sauce oder eine Zutat von der Pizza.
     *
     * @param zutatenName String. Name der Sauce oder der Zutat.
     * @return String. Information, ob das Entfernen geklappt hat und, wenn nein, warum nicht.
     */
    public String entfernen(String zutatenName) {
        if (zutatenName.toLowerCase(Locale.ROOT).contains("sauce")) {
            if (Objects.isNull(sauce)) {
                return "Es ist bisher keine Sauce auf der Pizza.";
            } else {
                if (sauce.getName().equals(zutatenName)) {
                    setSauce(null);
                    return zutatenName + " entfernt.";
                } else {
                    return "Es ist " + sauce.getName() + " auf der Pizza.";
                }
            }
        } else {
            if (zutaten.size() == 0) {
                return "Es wurden bisher keine Zutaten ausgewählt.";
            } else {
                updateZutaten((ArrayList<Zutat>) zutaten
                        .stream()
                        .filter(z -> !z.getName().equals(zutatenName))
                        .collect(Collectors.toList()));
                return zutaten
                        .stream().anyMatch(z -> z.getName().equals(zutatenName)) ?
                        zutatenName + " entfernt.":
                        zutatenName + " ist gar nicht auf der Pizza.";
            }
        }
    }
}
