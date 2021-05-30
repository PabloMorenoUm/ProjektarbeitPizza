package model;

import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;

public class Pizza {
    /*
    Pizzaklasse. Zutaten bitte niemals über pizza.getZutaten().add(), sondern über setZutaten() hinzufügen!
     */
    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    private String name = "unbenannt";
    private double preis = 4.99;
    private Sauce sauce;
    //private HashSet<Zutat> zutaten;
    private HashSet<Zutat> meineZutaten = new HashSet<>();
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

    public HashSet<Zutat> getZutaten() {
        return meineZutaten;
    }

    public void setZutaten(HashSet<Zutat> meineZutaten) {
        this.meineZutaten = meineZutaten;
        for(Zutat zutat: meineZutaten){
            this.preis += zutat.getPreis();
        }
    }

    public String toString(){
        StringBuilder gesamtString = new StringBuilder();
        // Name der Pizza
        gesamtString.append(name).append(" \r\n");

        // Füge zuerst die Sauce hinzu
        if (sauce != null){
            gesamtString.append(sauce.getName()).append(" ").append(currency.format(sauce.getPreis()));
            //gesamtString = String.format("%s%n%s", gesamtString, sauce.getName());
        }
        // Füge nun die Zutaten dazu
        for (int i = 0; i < meineZutaten.size(); i++){
            Zutat zutat =  (Zutat) meineZutaten.toArray()[i];
            String zutatenName = zutat.getName();
            //gesamtString = String.format("%s%n%s", gesamtString, zutat.getName());
            gesamtString.append(" \r\n ").append(zutatenName).append(" ").append(currency.format(zutat.getPreis()));
        }
        return gesamtString.toString();
    }

    public void belegen(String ZutatenName){
        if(ZutatenName.toLowerCase(Locale.ROOT).contains("sauce")){
            if(Objects.isNull(this.getSauce())){
                for(Belag sauce: alleSaucen.getListe()){
                    if(sauce.getName().equals(ZutatenName)){
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
                    if(zutat.getName().equals(ZutatenName)){
                        if(meineZutaten.contains((Zutat) zutat)){
                            System.out.println(zutat.getName() + " ist schon drauf. Andere Zutat?");
                        } else{
                            System.out.println(zutat.getName() + " hinzugefügt");
                            meineZutaten.add((Zutat) zutat);
                            this.setZutaten(meineZutaten);
                        }
                        //meineZutaten.add((Zutat) zutat);
                        //meinePizza.setZutaten(meineZutaten);
                        break;
                    }
                }
            } else{
                System.out.println("Nicht mehr als " + maxbelag + " Zutaten");
            }
        }
    }


    public void entfernen(String ZutatenName){
        if(ZutatenName.toLowerCase(Locale.ROOT).contains("sauce")){
            if(Objects.isNull(this.getSauce())){
                System.out.println("Es ist eh keine Sauce drauf.");
            } else{
                if(this.getSauce().getName().equals(ZutatenName)){
                    System.out.println(this.getSauce().getName() + " entfernt.");
                    this.setSauce(null);
                } else{
                    System.out.println("Es ist " + this.getSauce().getName() + " drauf.");
                }
            }
        } else{
            if(meineZutaten.size() == 0){
                System.out.println("Es wurden bisher keine Zutaten ausgewählt.");
            } else{
                for(Belag belagBisher: meineZutaten){
                    if(belagBisher.getName().equals(ZutatenName)){
                        System.out.println(belagBisher.getName() + " entfernt.");
                        meineZutaten.remove(belagBisher);
                        this.setZutaten(meineZutaten);
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
