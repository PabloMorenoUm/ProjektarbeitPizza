package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.*;

public class PizzaTest {
    // Daten von allen Zutaten:
    private Pizza pizza;
    ArrayList<Zutat> zutaten;
    private static final AlleZutaten alleZutaten = new AlleZutaten();
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    @Before
    public void setUp() {
        System.out.println("Setting it up!");
        pizza = new Pizza();
        zutaten = new ArrayList<>();
    }

    @Test
    public void setZutaten() {
        System.out.println("Running: setZutaten");
        // Alle Zutaten auf die Pizza:
        double gesamtpreis = 4.99;
        for (Belag belag : alleZutaten.getListe()) {
            zutaten.add((Zutat) belag);
            gesamtpreis += belag.getPreis();
        }
        pizza.updateZutaten(zutaten);
        assertEquals(gesamtpreis, pizza.getPreis(), .001);
        assertArrayEquals(zutaten.toArray(), pizza.getZutaten().toArray());
        assertEquals(alleZutaten.getListe().size(), pizza.getZutaten().size());
    }

    @Test
    public void testToString() {
        System.out.println("Running: toString");
        String preis = currency.format(4.99);
        pizza.setName("Beispielpizza");
        assertEquals("Beispielpizza\r\n Grundpreis " + preis + "\n--------------------\nPreis:" + preis,
                pizza.toString());

        pizza.belegen("Tomaten");
        assertEquals("Beispielpizza\r\n Grundpreis " + preis + "\r\n Tomaten " + currency.format(0.59) +
                        "\n--------------------\nPreis:" + currency.format(4.99 + 0.59),
                pizza.toString());
    }

    @Test
    public void belegen() {
        System.out.println("Running: belegen");
        pizza.belegen("Unsinn");
        assertEquals(0, pizza.getZutaten().size());

        pizza.belegen("Salami");
        assertEquals(1, pizza.getZutaten().size());

        pizza.belegen("Salami");
        assertEquals(1, pizza.getZutaten().size());

        pizza.belegen("Schinken");
        assertEquals(2, pizza.getZutaten().size());
    }

    @Test
    public void entfernen() {
        System.out.println("Running: entfernen");
        // Alle Zutaten drauf:
        for (Belag belag : alleZutaten.getListe()) {
            zutaten.add((Zutat) belag);
        }
        pizza.updateZutaten(zutaten);

        pizza.entfernen("Unsinn");
        assertEquals(alleZutaten.getListe().size(), pizza.getZutaten().size());

        pizza.entfernen("Gouda");
        assertEquals(alleZutaten.getListe().size() - 1, pizza.getZutaten().size());

        pizza.entfernen("Gouda");
        assertEquals(alleZutaten.getListe().size() - 1, pizza.getZutaten().size());

        pizza.entfernen("Ei");
        assertEquals(alleZutaten.getListe().size() - 2, pizza.getZutaten().size());
    }

    @After
    public void tearDown() {
        System.out.println("Tearing it down!");
        pizza = null;
        zutaten = null;
        assertNull(pizza);
        assertNull(zutaten);
    }
}