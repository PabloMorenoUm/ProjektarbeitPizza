package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/**
 * Pizzaklasse. Zutaten bitte niemals über pizza.getZutaten().add(), sondern über setZutaten() hinzufügen!
 */
@SuppressWarnings("SuspiciousMethodCalls")
public class Pizza {
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    private String name = "";
    private double preis = 4.99;
    private Sauce sauce;
    private ArrayList<Zutat> zutaten = new ArrayList<>();
    private static final int maxbelag = 8;

    // Daten von allen Saucen:
    private static final AlleSaucen alleSaucen = new AlleSaucen();
    // Daten von allen Zutaten:
    private static final AlleZutaten alleZutaten = new AlleZutaten();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public ArrayList<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(ArrayList<Zutat> zutaten) {
        this.zutaten = zutaten;
    }

    public void updateZutaten(ArrayList<Zutat> meineZutaten) {
        setZutaten(meineZutaten);
        this.preis = 4.99;
        for (Zutat zutat : meineZutaten) {
            this.preis += zutat.getPreis();
        }
    }

    /**
     * Auflistung, womit die Pizza belegt ist samt Preisübersicht.
     * @return String. Textanzeige
     */
    public String toString() {
        double grundpreis = 4.99;
        StringBuilder gesamtString = new StringBuilder();
        // Name der Pizza
        gesamtString
                .append(name)
                .append("\r\n");
        gesamtString
                .append(" Grundpreis ")
                .append(currency.format(grundpreis));

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
     * @param zutatenName String. Name der Sauce oder der Zutat.
     * @return String. Information, ob das Belegen geklappt hat und, wenn nein, warum nicht.
     */
    public String belegen(String zutatenName) {
        if (zutatenName.toLowerCase(Locale.ROOT).contains("sauce")) {
            if (Objects.isNull(sauce)) {
                for (Belag meineSauce : alleSaucen.getListe()) {
                    if (meineSauce.getName().equals(zutatenName)) {
                        this.setSauce((Sauce) meineSauce);
                        return meineSauce.getName() + " hinzugefügt";
                    }
                }
            } else {
                return "Sauce ist schon vorhanden.";
            }
        } else {
            if (zutaten.size() < maxbelag) {
                for (Belag zutat : alleZutaten.getListe()) {
                    if (zutat.getName().equals(zutatenName)) {
                        if (zutaten.contains((Zutat) zutat)) {
                            return zutat.getName() + " ist schon auf der Pizza. Andere Zutat?";
                        } else {
                            zutaten.add((Zutat) zutat);
                            updateZutaten(zutaten);
                            return zutat.getName() + " hinzugefügt";
                        }
                    }
                }
            } else {
                return "Nicht mehr als " + maxbelag + " Zutaten";
            }
        }
        return "";
    }

    /**
     * Entferne eine Sauce oder eine Zutat von der Pizza.
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
                for (Belag belagBisher : zutaten) {
                    if (belagBisher.getName().equals(zutatenName)) {
                        zutaten.remove(belagBisher);
                        updateZutaten(zutaten);
                        return belagBisher.getName() + " entfernt.";
                    }
                }
            }
        }
        return zutatenName + " ist gar nicht auf der Pizza.";
    }

    public static int getMaxbelag() {
        return maxbelag;
    }
}
