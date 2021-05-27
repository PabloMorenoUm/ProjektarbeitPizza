package de.karrieretutor.LydiaHolmPablo.Pizza;

import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;

public class Pizza {
    /*
    Pizzaklasse. Zutaten bitte niemals über pizza.getZutaten().add(), sondern über setZutaten() hinzufügen!
     */
    private int maxbelag = 8;
    private String name = "unbenannt";
    private double preis = 4.99;
    private Sauce sauce;
    // Generell erlaubte Zutaten?
    private  HashSet<Zutat> zutaten = new HashSet<>();
    // Die tatsächlich auf der Pizza liegenden Zutaten
    private HashSet<Zutat> meineZutaten = new HashSet<>();

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

    public HashSet<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(HashSet<Zutat> zutaten) {
        this.zutaten = zutaten;
        for(Zutat zutat: zutaten){
            this.preis += zutat.getPreis();
        }
    }

    public String toString(){
        String gesamtString = "";
        // Name der Pizza
        gesamtString = gesamtString + name + " \r\n";

        // Füge zuerst die Sauce hinzu
        if (sauce != null){
            gesamtString = gesamtString + sauce.getName() + " " + String.valueOf(sauce.getPreis()) + " €";
            //gesamtString = String.format("%s%n%s", gesamtString, sauce.getName());
        }
        // Füge nun die Zutaten dazu
        for (int i = 0; i < zutaten.size(); i++){
            Zutat zutat =  (Zutat) zutaten.toArray()[i];
            String zutatenName = zutat.getName();
            //gesamtString = String.format("%s%n%s", gesamtString, zutat.getName());
            gesamtString = gesamtString + " \r\n "
                    + zutatenName + " " + String.valueOf(zutat.getPreis()) + " €";
        }
        return gesamtString;
    }

    public void belegen(String name){
        if(name.toLowerCase(Locale.ROOT).contains("sauce")){
            if(Objects.isNull(this.getSauce())){
                for(Belag sauce: alleSaucen.getListe()){
                    if(sauce.getName().equals(name)){
                        this.setSauce((Sauce) sauce);
                        System.out.println(sauce.getName() + " hinzugefügt");
                        break;
                    }
                }
            } else{
                System.out.println("Sauce ist schon vorhanden.");
            }
        } else{
            if(meineZutaten.size() < maxbelag){
                for(Belag zutat: alleZutaten.getListe()){
                    if(zutat.getName().equals(name)){
                        if(meineZutaten.contains((Zutat) zutat)){
                            System.out.println(zutat.getName() + " ist schon drauf. Andere Zutat?");
                        } else{
                            System.out.println(zutat.getName() + " hinzugefügt");
                        }
                        meineZutaten.add((Zutat) zutat);
                        this.setZutaten(meineZutaten);
                        break;
                    }
                }
            } else{
                System.out.println("Nicht mehr als " + maxbelag + " Zutaten");
            }
        }
    }
}
