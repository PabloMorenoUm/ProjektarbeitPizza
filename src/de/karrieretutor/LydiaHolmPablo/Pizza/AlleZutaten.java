package de.karrieretutor.LydiaHolmPablo.Pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlleZutaten extends AlleBelaege {
    // Daten aller vorhandenen Zutaten:
    public AlleZutaten() {
        try {
            Scanner datei = new Scanner(new File("Zutaten.csv"));
            String[] zeile;
            while(datei.hasNextLine()) {
                zeile = datei.nextLine().split(", ");
                super.liste.add(new Sauce(Integer.parseInt(zeile[0]), zeile[1], Double.parseDouble(zeile[2])));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
