package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class PizzaTest {
    // Daten von allen Zutaten:
    private Pizza actualPizza;
    ArrayList<Zutat> expectedZutaten;
    private static final AlleZutaten alleZutaten = new AlleZutaten();
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    @Before
    public void setUp() {
        System.out.println("Setting it up!");
        actualPizza = new Pizza();
        expectedZutaten = new ArrayList<>();
    }

    @Test
    public void updateZutaten() {
        System.out.println("Running: setZutaten");
        // Alle Zutaten auf die Pizza:
        actualPizza.updateZutaten((ArrayList<Zutat>) alleZutaten
                .getListe()
                .stream()
                .map(z -> (Zutat) z)
                .collect(Collectors.toList()
                ));
        assertEquals(4.99 + alleZutaten.getListe().stream().mapToDouble(Belag::getPreis).sum(),
                actualPizza.getPreis(), .001);
        assertArrayEquals(alleZutaten.getListe().toArray(), actualPizza.getZutaten().toArray());
        assertEquals(alleZutaten.getListe().size(), actualPizza.getZutaten().size());
    }

    @Test
    public void testToString() {
        System.out.println("Running: toString");
        String preis = currency.format(4.99);
        actualPizza.setName("Beispielpizza");
        assertEquals("Beispielpizza\r\n Grundpreis " + preis + "\r\n--------------------\r\nPreis: " + preis,
                actualPizza.toString());

        actualPizza.belegen("Tomaten");
        assertEquals("Beispielpizza\r\n Grundpreis " + preis + "\r\n Tomaten " + currency.format(0.59) +
                        "\r\n--------------------\r\nPreis: " + currency.format(4.99 + 0.59),
                actualPizza.toString());
    }

    @Test
    public void belegen() {
        System.out.println("Running: belegen");
        /*actualPizza.belegen("Unsinn");
        assertEquals(0, actualPizza.getZutaten().size());*/

        actualPizza.belegen("Salami");
        assertEquals(1, actualPizza.getZutaten().size());

        actualPizza.belegen("Salami");
        assertEquals(1, actualPizza.getZutaten().size());

        actualPizza.belegen("Schinken");
        assertEquals(2, actualPizza.getZutaten().size());

        alleZutaten.getListe().forEach(z -> actualPizza.belegen(z.getName()));
        assertEquals(8, actualPizza.getZutaten().size());
    }

    @Test
    public void entfernen() {
        System.out.println("Running: entfernen");
        // Alle Zutaten drauf:
        actualPizza.updateZutaten((ArrayList<Zutat>) alleZutaten
                .getListe()
                .stream()
                .map(z -> (Zutat) z)
                .collect(Collectors.toList())
        );

        actualPizza.entfernen("Unsinn");
        assertEquals(alleZutaten.getListe().size(), actualPizza.getZutaten().size());

        actualPizza.entfernen("Gouda");
        assertEquals(alleZutaten.getListe().size() - 1, actualPizza.getZutaten().size());

        actualPizza.entfernen("Gouda");
        assertEquals(alleZutaten.getListe().size() - 1, actualPizza.getZutaten().size());

        actualPizza.entfernen("Ei");
        assertEquals(alleZutaten.getListe().size() - 2, actualPizza.getZutaten().size());
    }

    @After
    public void tearDown() {
        System.out.println("Tearing it down!");
        actualPizza = null;
        expectedZutaten = null;
        assertNull(actualPizza);
        assertNull(expectedZutaten);
    }
}