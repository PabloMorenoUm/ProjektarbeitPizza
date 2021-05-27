package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StatusScreen extends JLabel {
    private double gesamtpreis;
    private String pizzaName;
    private ArrayList<String> aktuelleBelaege;

    public StatusScreen() {
        this.pizzaName = "No Name";
        this.gesamtpreis = 0.00;
        this.aktuelleBelaege = new ArrayList<String>();
        this.setText(String.valueOf(gesamtpreis));
        }


        /*
    public void updateStatusScreen(){

    }

    public void updateStatusScreen(double zutatenPreis, String zutatenName){
        //this.aktuelleBelaege.add(zutatenName);
        //this.gesamtpreis += zutatenPreis; // kann auch negativ sein, wenn Zutat entfernt wird

    }
*/



}
