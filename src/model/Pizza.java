package model;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

@SuppressWarnings("SuspiciousMethodCalls")
public class Pizza {
    /*
    Pizzaklasse. Zutaten bitte niemals über pizza.getZutaten().add(), sondern über setZutaten() hinzufügen!
     */
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    private String name = "";
    private double preis = 4.99;
    private Sauce sauce;
    private ArrayList<Zutat> meineZutaten = new ArrayList<>();
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
        return meineZutaten;
    }

    public void updateZutaten(ArrayList<Zutat> meineZutaten) {
        this.setMeineZutaten(meineZutaten);
        this.preis = 4.99;
        for (Zutat zutat : meineZutaten) {
            this.preis += zutat.getPreis();
        }
    }

    private void setMeineZutaten(ArrayList<Zutat> meineZutaten) {
        this.meineZutaten = meineZutaten;
    }

    public String toString() {
        double grundpreis = 4.99;
        StringBuilder gesamtString = new StringBuilder();
        // Name der Pizza
        gesamtString.append(name).append("\r\n");
        gesamtString.append(" Grundpreis ").append(currency.format(grundpreis));

        // Füge zuerst die Sauce hinzu
        if (sauce != null) {
            gesamtString.append("\r\n ").append(sauce.getName()).append(" ").append(currency.format(sauce.getPreis()));
            //gesamtString = String.format("%s%n%s", gesamtString, sauce.getName());
        }
        // Füge nun die Zutaten dazu
        for (Zutat zutat : meineZutaten) {
            String zutatenName = zutat.getName();
            //gesamtString = String.format("%s%n%s", gesamtString, zutat.getName());
            gesamtString.append("\r\n ").append(zutatenName).append(" ").append(currency.format(zutat.getPreis()));
        }
        gesamtString.append("\n--------------------\nPreis:").append(currency.format(preis));
        return gesamtString.toString();
    }

    public void belegen(String ZutatenName, JLabel feld) {
        if (ZutatenName.toLowerCase(Locale.ROOT).contains("sauce")) {
            if (Objects.isNull(this.getSauce())) {
                for (Belag sauce : alleSaucen.getListe()) {
                    if (sauce.getName().equals(ZutatenName)) {
                        this.setSauce((Sauce) sauce);
                        feld.setText(sauce.getName() + " hinzugefügt");
                        break;
                    }
                }
            } else {
                feld.setText("Sauce ist schon vorhanden.");
            }
        } else {
            if (meineZutaten.size() < maxbelag) {
                for (Belag zutat : alleZutaten.getListe()) {
                    if (zutat.getName().equals(ZutatenName)) {
                        if (meineZutaten.contains((Zutat) zutat)) {
                            feld.setText(zutat.getName() + " ist schon drauf. Andere Zutat?");
                        } else {
                            feld.setText(zutat.getName() + " hinzugefügt");
                            meineZutaten.add((Zutat) zutat);
                            this.updateZutaten(meineZutaten);
                        }
                        break;
                    }
                }
            } else {
                feld.setText("Nicht mehr als " + maxbelag + " Zutaten");
            }
        }
    }


    public void entfernen(String ZutatenName, JLabel feld) {
        if (ZutatenName.toLowerCase(Locale.ROOT).contains("sauce")) {
            if (Objects.isNull(this.getSauce())) {
                feld.setText("Es ist eh keine Sauce drauf.");
            } else {
                if (this.getSauce().getName().equals(ZutatenName)) {
                    feld.setText(this.getSauce().getName() + " entfernt.");
                    this.setSauce(null);
                } else {
                    feld.setText("Es ist " + this.getSauce().getName() + " drauf.");
                }
            }
        } else {
            if (meineZutaten.size() == 0) {
                feld.setText("Es wurden bisher keine Zutaten ausgewählt.");
            } else {
                for (Belag belagBisher : meineZutaten) {
                    if (belagBisher.getName().equals(ZutatenName)) {
                        feld.setText(belagBisher.getName() + " entfernt.");
                        meineZutaten.remove(belagBisher);
                        this.updateZutaten(meineZutaten);
                        break;
                    }
                }
            }
        }
    }

    public static int getMaxbelag() {
        return maxbelag;
    }
}
