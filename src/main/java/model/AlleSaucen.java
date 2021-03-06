package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Daten aller Saucen, eingelesen aus einer .csv-Datei.
 */
public class AlleSaucen extends AlleBelaege {
    /**
     * Konstruktor. Instanziert den Datensatz, der alle vorliegenden Saucen enthält.
     */
    public AlleSaucen() {
        try {
            Scanner datei = new Scanner(new File("Saucen.csv"));
            String[] zeile;
            while (datei.hasNextLine()) {
                zeile = datei.nextLine().split(", ");
                super.liste.add(new Sauce(Integer.parseInt(zeile[0]), zeile[1], Double.parseDouble(zeile[2])));
            }
            datei.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
